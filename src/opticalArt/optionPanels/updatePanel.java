package opticalArt.optionPanels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import opticalArt.CONSTANTS;
import opticalArt.pathes.gridPanel;

@SuppressWarnings("serial")
public class updatePanel extends JPanel {

	private gridPanel theGridPanel;

	//private mouseControlPanel aMouseControlPanel;
	//private JPanel controlPanel;
	private int levels;
	private JTextField jtLines, jtColumns;
	private JTextField jtLevels;
	
	/** Konstruktoren */
	public updatePanel(gridPanel GridPanel) {
		this.theGridPanel = GridPanel;
		this.setLayout(new BorderLayout());
		JPanel parameterPanel = new JPanel();
		parameterPanel.setLayout(new BoxLayout(parameterPanel,BoxLayout.Y_AXIS));
			JPanel gridControlPanel = new JPanel();
			gridControlPanel.setLayout(new BoxLayout(gridControlPanel,BoxLayout.Y_AXIS));
			gridControlPanel.setBorder(BorderFactory.createTitledBorder(CONSTANTS.GRID_LABEL_STRING));
				JPanel linesAndColumnsPanel = new JPanel(new GridLayout(2,2));
				linesAndColumnsPanel.add(new JLabel(CONSTANTS.LINES_LABEL_STRING));
				jtLines = new JTextField();
				linesAndColumnsPanel.add(jtLines);
				linesAndColumnsPanel.add(new JLabel(CONSTANTS.COLUMNS_LABEL_STRING));
				jtColumns = new JTextField();
				linesAndColumnsPanel.add(jtColumns);
			gridControlPanel.add(linesAndColumnsPanel);
		parameterPanel.add(gridControlPanel);
			JPanel stackLevelPanel = new JPanel(new GridLayout(1,2));
			stackLevelPanel.setBorder(BorderFactory.createTitledBorder(CONSTANTS.STACK_LEVEL_LABEL_STRING));
			stackLevelPanel.add(new JLabel(CONSTANTS.LEVEL_LABEL_STRING));
			jtLevels = new JTextField();
			stackLevelPanel.add(jtLevels);
		parameterPanel.add(stackLevelPanel);
		this.add(parameterPanel,BorderLayout.NORTH);
		//this.add(Box.createVerticalGlue());
		JPanel buttonPanel = new JPanel(new GridLayout(2,1));
		//buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
			JButton updateButton = new JButton(CONSTANTS.UPDATE_LABEL_STRING);
				updateButton.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) { updateButtonPressed(); }
				});
			buttonPanel.add(updateButton);
			JButton resetButton = new JButton(CONSTANTS.RESET_LABEL_STRING);
				resetButton.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) { theGridPanel.reset(); }
				});
		buttonPanel.add(resetButton);
		this.add(buttonPanel,BorderLayout.SOUTH);
	}
	
	public void fillParametersFromGrid() {
		jtLines.setBackground(CONSTANTS.COLOR_NO_WARNING);
		jtLines.setText("");
		jtColumns.setBackground(CONSTANTS.COLOR_NO_WARNING);
		jtColumns.setText("");
		jtLevels.setBackground(CONSTANTS.COLOR_NO_WARNING);
		levels = theGridPanel.getStackLevel();
		jtLevels.setText(new Integer(levels).toString());
	}
	
	private void updateButtonPressed() {
		boolean ok = true;
		boolean gridModified = false;
		boolean levelsModified = false;
		int lines = 0;
		int columns = 0;
	
		// create lines
		try {
			jtLines.setBackground(CONSTANTS.COLOR_NO_WARNING);
			if(!jtLines.getText().equals("")) {
				lines = new Integer(jtLines.getText()).intValue();
				if(lines < 1) throw new NumberFormatException();
				gridModified = true;
			}
		} catch(NumberFormatException exc) { jtLines.setBackground(CONSTANTS.COLOR_WARNING); ok = false; }
		// create columns
		try {
			jtColumns.setBackground(CONSTANTS.COLOR_NO_WARNING);
			if(!jtColumns.getText().equals("")) {
				columns = new Integer(jtColumns.getText()).intValue();
				if(columns < 1) throw new NumberFormatException();
				gridModified = true;
			}
		} catch(NumberFormatException exc) { jtColumns.setBackground(CONSTANTS.COLOR_WARNING); ok = false; }
		// check if both have values (7x0 is no good grid)
		if(gridModified && lines * columns < 1) {
			if(lines == 0) jtLines.setBackground(CONSTANTS.COLOR_WARNING);
			if(columns == 0) jtColumns.setBackground(CONSTANTS.COLOR_WARNING);
			ok = false;
		}
		// create levels
		try {
			int newLevels = 0;
			jtLevels.setBackground(CONSTANTS.COLOR_NO_WARNING);
			newLevels = new Integer(jtLevels.getText()).intValue(); 
			if(newLevels < 1) throw new NumberFormatException();
			if(newLevels != levels) {System.out.println("levelsModified " + levelsModified + levels + newLevels); levelsModified = true;}
			levels = newLevels;
		} catch(NumberFormatException exc) { jtLevels.setBackground(CONSTANTS.COLOR_WARNING); ok = false; }
		// check ok
		if(ok) { 
			if(theGridPanel.sendParametersToGrid()) {
				if(gridModified) theGridPanel.modifiyGrid(lines, columns);
				if(levelsModified) theGridPanel.setStackLevel(levels); 
			} else fillParametersFromGrid();
		}
	}
}

