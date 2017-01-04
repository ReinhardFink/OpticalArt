package opticalArt.pathes;

import java.util.*;
import java.awt.*;
import javax.swing.*;

import opticalArt.CONSTANTS;

public class stackedPathesGrid implements gridElementInterface {

	private int lines, columns;
	private JPanel theJPanel;
	private gridElementVector aGridElementVector;
	@SuppressWarnings("unused")
	private eventObserver aEventObserver;

	/** Konstruktor */	
	public stackedPathesGrid(int lines, int columns, int level, eventObserver aEventObserver) {
		this.lines = lines;
		this.columns = columns;
		this.aEventObserver = aEventObserver;
		this.aGridElementVector = new gridElementVector(lines*columns);
		this.theJPanel = new JPanel(new GridLayout(lines,columns));
		this.theJPanel.setBackground(CONSTANTS.BACKGROUND_COLOR);
		for(int i = 0; i < lines*columns; i++) { 
			stackedPathes gridElement = new stackedPathes(level);
			theJPanel.add(gridElement);
			aEventObserver.addObserver(gridElement);
			aGridElementVector.add(gridElement); 
		};
	}
// implements Observer, but has nothing to do!
	public void update(Observable observable, Object translationsVektor) {}
	
	// implements gridElementInterface
	
	public gridElementInterface getGridElementUnderPoint(Point point) {
		Dimension oaPathDimension = new Dimension(theJPanel.getBounds(null).width/columns,
																							theJPanel.getBounds(null).height/lines);
		int selectedColumn = point.x/oaPathDimension.width;
		if(selectedColumn == columns) selectedColumn--; 
		int selectedLine = point.y/oaPathDimension.height;
		if(selectedLine == columns) selectedLine--; 
		int selectedNumber = selectedLine*columns + selectedColumn;
		Point PointInSelectedPanel = new Point(point.x % oaPathDimension.width, point.y % oaPathDimension.height);
		return aGridElementVector.get(selectedNumber).getGridElementUnderPoint(PointInSelectedPanel);
	}
	
	public gridElementVector getGridElementVector() { return aGridElementVector; };
	
	public JPanel getJPanel() { return theJPanel; }
	
	public boolean isSelected() { 
		boolean selected = true;
		for(int i = 0; i < aGridElementVector.size(); i++) selected = selected && aGridElementVector.get(i).isSelected();
		return selected;
	};
	
	public void setSelected(boolean selected) {
		for(int i = 0; i < aGridElementVector.size(); i++) aGridElementVector.get(i).setSelected(selected);
	}
	
	public void setStackLevel(int levelMax) {
	 for(int i = 0; i < aGridElementVector.size(); i++) aGridElementVector.get(i).setStackLevel(levelMax); 
	}
}
