package opticalArt.pathes;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import opticalArt.CONSTANTS;
import opticalArt.optionPanels.*;
import opticalArt.pathes.workers.*;

@SuppressWarnings("serial")
public class gridPanel extends JPanel implements KeyEventDispatcher {

	private boolean controlPressed, panelsVisible;
	private int lines, columns;
	private int levelMax;
	private Point firstPoint;
	private eventObserver aEventObserver;
	private gridElementInterface theGrid;
	private selectorPanel aSelectorPanel;
	private simplePathTabbedPanel aSimplePathTabbedPanel; 
	private updatePanel aUpdatePanel;

	/** Constructor */	
	public gridPanel(int lines, int columns) {
		this.lines = lines;
		this.columns = columns;
		this.levelMax = CONSTANTS.NUMBER_OF_STACKED_PATHES;
		this.controlPressed = false;
		this.panelsVisible = false;
		this.aEventObserver = new eventObserver();
		addFirstGrid();
		addAlwaysVisiblePanels();
		addParameterPanels();
		addKeyBordEvents();
		addEventReaktions();
	}
	
	/** implements KeyEvent Dispatcher */
	public boolean dispatchKeyEvent(KeyEvent e) {
		return controlPressed = (e.getKeyCode() == KeyEvent.VK_CONTROL && e.getID() == KeyEvent.KEY_PRESSED);
	}
	
	public gridElementInterface getStackedPathesGrid() { return theGrid; }
	
	public void setStackLevel(int levelMax) { 
		this.levelMax = levelMax; 
		theGrid.setStackLevel(levelMax);
		organizeSimplePathTabbedPanel();
	}
	
	public int getStackLevel() { return levelMax; }
	
	public void setControlPressed(boolean controlPressed) { this.controlPressed = controlPressed; }
	
	public boolean isControlPressed() { return controlPressed; }
	
	public boolean sendParametersToGrid() {
		return aSimplePathTabbedPanel.sendParametersToGrid();
	}
	
	public void modifiyGrid(int lines, int columns) {
		//System.out.println("modify Grid");
		modifyGridWorker aModifyGridWorker = new modifyGridWorker(lines, columns, levelMax, aEventObserver);
		if(theGrid.isSelected()) {
			this.remove(theGrid.getJPanel());
			theGrid = aModifyGridWorker.createNewGridElement(lines, columns, levelMax, aEventObserver);
			this.add(theGrid.getJPanel(),BorderLayout.CENTER);
		} else {
			gridIterator iterator = new gridIterator();
			iterator.iterateGrid(theGrid,aModifyGridWorker);
		}
		validate();
	}
	
	public void showPanels() {
		panelsVisible = true;
		aSimplePathTabbedPanel.fillParametersFromGrid();
		this.add(aSimplePathTabbedPanel,BorderLayout.NORTH);
		aUpdatePanel.fillParametersFromGrid();
		this.add(aUpdatePanel,BorderLayout.EAST);
		validate();
	}
	
	public void hidePanels() {
		this.panelsVisible = false;
		this.controlPressed = false;
		this.aSelectorPanel.resetRadioButton();
		this.remove(aSimplePathTabbedPanel);
		this.remove(aUpdatePanel);
		this.validate();
	}
	
	public boolean isPanelsVisible() { return panelsVisible; }
	
	public void reset() {
		this.lines = CONSTANTS.STARTUP_LINES;
		this.columns = CONSTANTS.STARTUP_COLUMNS;
		this.levelMax = CONSTANTS.NUMBER_OF_STACKED_PATHES;
		this.controlPressed = false;
		this.panelsVisible = false;
		theGrid.setSelected(true);
		modifiyGrid(lines, columns);
		organizeSimplePathTabbedPanel();
	}

	// ------ private Methods --------------------------------------------------------------------------
	private void addFirstGrid() {
		this.setLayout(new BorderLayout());
		stackedPathesGrid aStackedPathesGrid = new stackedPathesGrid(lines, columns, levelMax, aEventObserver);
		this.add(aStackedPathesGrid.getJPanel(),BorderLayout.CENTER);
		this.theGrid = aStackedPathesGrid;
	}
	
	private void addAlwaysVisiblePanels() {
		this.aSelectorPanel = new selectorPanel(this);
		this.add(aSelectorPanel,BorderLayout.SOUTH);
	}
	
	private void addParameterPanels() {
		this.aSimplePathTabbedPanel = new simplePathTabbedPanel(this); 
		this.aUpdatePanel = new updatePanel(this) ;
	}
	
	private void addKeyBordEvents() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
	}
	
	/** create all Listener in one place */
	private void addEventReaktions() {
		firstPoint = new Point(0,0);
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				firstPoint.setLocation(e.getX(),e.getY());
				if(!panelsVisible) {
					if(controlPressed) makeSelection(e);
					else {
						if(e.getButton() == MouseEvent.BUTTON3
							 && (theGrid.getGridElementUnderPoint(new Point(e.getX(),e.getY()))).isSelected()) showPanels();
						else unSelectAll(); 
					}
				} 
				else { 
					hidePanels(); 
					unSelectAll(); 
					aSelectorPanel.resetRadioButton();
					return; 
				}
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				aEventObserver.setMouseDraggedEvent(e.getX() - firstPoint.x,e.getY() - firstPoint.y);
			}
		});
	}

	private void makeSelection(MouseEvent e) {
		gridElementInterface sP = theGrid.getGridElementUnderPoint(new Point(e.getX(),e.getY()));
		sP.setSelected(!sP.isSelected());
	}
		
	private void unSelectAll() { theGrid.setSelected(false); }
	
	private void organizeSimplePathTabbedPanel() {
		hidePanels();
		this.aSimplePathTabbedPanel = new simplePathTabbedPanel(this);
		showPanels();
	}
}
