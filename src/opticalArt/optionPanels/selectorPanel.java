package opticalArt.optionPanels;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import opticalArt.CONSTANTS;
import opticalArt.pathes.gridPanel;

@SuppressWarnings("serial")
public class selectorPanel extends JPanel {

	private gridPanel theGridPanel;
	JRadioButton selectModeButton;

	public selectorPanel(gridPanel GridPanel) {
		this.theGridPanel = GridPanel;
		//this.setLayout(new GridLayout(1,2));
		/*
		JTextField SelectionInput = new JTextField();
		this.add(SelectionInput);
		*/
		this.add(new JLabel());
		JPanel buttonPanel = new JPanel(new GridLayout(1,3));
			selectModeButton = new JRadioButton(CONSTANTS.SHOW_SELECTMODE_BUTTON);
			selectModeButton.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					theGridPanel.setControlPressed(!theGridPanel.isControlPressed());
				}
			});
			buttonPanel.add(selectModeButton);
			
			JButton selectAll = new JButton(CONSTANTS.SELECT_ALL_LABEL_STRING);
			selectAll.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) { 
					theGridPanel.getStackedPathesGrid().setSelected(true); 
					if(theGridPanel.isPanelsVisible()) {
						theGridPanel.hidePanels();
						theGridPanel.showPanels();
					}
				}
			});
			buttonPanel.add(selectAll);
			
			JButton showOptions = new JButton(CONSTANTS.SHOW_SIMPLE_PATH_PARAMS_STRING);
			showOptions.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					theGridPanel.showPanels();
				}
			});
		buttonPanel.add(showOptions);
		this.add(buttonPanel);
	}
	
	public void resetRadioButton() {
		selectModeButton.setSelected(false);
	}
}
