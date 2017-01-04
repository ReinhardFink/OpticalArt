package opticalArt.optionPanels;

import javax.swing.JTabbedPane;

import opticalArt.CONSTANTS;
import opticalArt.pathes.gridPanel;
;

@SuppressWarnings("serial")
public class simplePathTabbedPanel extends JTabbedPane {

	gridPanel theGridPanel;
	simplePathPanel[] simplePathPanelVector;
	
	public simplePathTabbedPanel(gridPanel theGridPanel) {
		this.theGridPanel = theGridPanel;
		simplePathPanelVector = new simplePathPanel[theGridPanel.getStackLevel()];
		for(int i = 0;i < theGridPanel.getStackLevel(); i++) {
			simplePathPanelVector[i] = new simplePathPanel(i, theGridPanel);
			this.addTab(CONSTANTS.LEVEL_STRING + i, null, simplePathPanelVector[i],CONSTANTS.LEVEL_POPUP_STRING + i);
		}
	}
	
	public void fillParametersFromGrid() {
		for(int i = 0;i < theGridPanel.getStackLevel(); i++) simplePathPanelVector[i].fillParametersFromGrid();
	}
	
	public boolean sendParametersToGrid() {
		boolean ok = true;
		for(int i = 0;i < theGridPanel.getStackLevel(); i++) 
			ok = simplePathPanelVector[i].sendTextToParameterObject() && ok;
		if(ok) {
			for(int i = 0;i < theGridPanel.getStackLevel(); i++) 
			simplePathPanelVector[i].sendParameterObjectToGrid();
			theGridPanel.repaint();
		}
		return ok;
	}
}
