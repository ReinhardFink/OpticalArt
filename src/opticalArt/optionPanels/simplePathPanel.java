package opticalArt.optionPanels;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import opticalArt.CONSTANTS;
import opticalArt.pathes.gridPanel;
import opticalArt.pathes.simplePathParameterObject;
import opticalArt.pathes.workers.collectIntersectionWorker;
import opticalArt.pathes.workers.gridIterator;
import opticalArt.pathes.workers.setParameterWorker;

@SuppressWarnings("serial")
public class simplePathPanel extends JPanel {

	private int level;
	private gridPanel theGridPanel;
	private gridIterator iterator;
	private simplePathParameterObject aO;
	private JTextField tfParamsFileName;
	private JTextField tfParamsRed, tfParamsGreen, tfParamsBlue;
	private JTextField tfParamsRotate, tfParamsScaleX, tfParamsScaleY,
			tfParamsShearX, tfParamsShearY;
	private JTextField jtMouseTranslate, jtMouseRotate, jtMouseScale,
			jtMouseShear;

	public simplePathPanel(int level, gridPanel theGridPanel) {
		this.level = level;
		this.theGridPanel = theGridPanel;
		this.iterator = new gridIterator();
		this.setLayout(new BorderLayout());
		this.add(createFileNamePanel(), BorderLayout.NORTH);
		JPanel parameterContainer = new JPanel();
		parameterContainer.setLayout(new BoxLayout(parameterContainer,
				BoxLayout.X_AXIS));
		// JPanel for Color
		JPanel colorPalettePanel = new JPanel(new GridLayout(3, 2));
		// colorPalettePanel.setAlignmentY(Component.TOP_ALIGNMENT);
		colorPalettePanel.setBorder(BorderFactory
				.createTitledBorder(CONSTANTS.COLOR_LABEL_STRING));
		colorPalettePanel.add(new JLabel(CONSTANTS.COLOR_RED_STRING));
		tfParamsRed = new JTextField();
		colorPalettePanel.add(tfParamsRed);
		colorPalettePanel.add(new JLabel(CONSTANTS.COLOR_GREEN_STRING));
		tfParamsGreen = new JTextField();
		colorPalettePanel.add(tfParamsGreen);
		colorPalettePanel.add(new JLabel(CONSTANTS.COLOR_BLUE_STRING));
		tfParamsBlue = new JTextField();
		colorPalettePanel.add(tfParamsBlue);
		parameterContainer.add(colorPalettePanel);
		// JPanel for init Transform
		JPanel initAffinTransformPanel = new JPanel(new GridLayout(3, 5));
		// initAffinTransformPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		initAffinTransformPanel
				.setBorder(BorderFactory
						.createTitledBorder(CONSTANTS.TRANSFORMATIONS_CONTROL_LABEL_STRING));
		initAffinTransformPanel.add(new JLabel(CONSTANTS.ROTATE_LABEL_STRING));
		tfParamsRotate = new JTextField();
		initAffinTransformPanel.add(tfParamsRotate);
		initAffinTransformPanel.add(new JLabel(" "));
		initAffinTransformPanel.add(new JLabel(" "));

		initAffinTransformPanel.add(new JLabel(CONSTANTS.SCALE_X_LABEL_STRING));
		tfParamsScaleX = new JTextField();
		initAffinTransformPanel.add(tfParamsScaleX);
		initAffinTransformPanel.add(new JLabel(CONSTANTS.SCALE_Y_LABEL_STRING));
		tfParamsScaleY = new JTextField();
		initAffinTransformPanel.add(tfParamsScaleY);

		initAffinTransformPanel.add(new JLabel(CONSTANTS.SHEAR_X_LABEL_STRING));
		tfParamsShearX = new JTextField();
		initAffinTransformPanel.add(tfParamsShearX);
		initAffinTransformPanel.add(new JLabel(CONSTANTS.SHEAR_Y_LABEL_STRING));
		tfParamsShearY = new JTextField();
		initAffinTransformPanel.add(tfParamsShearY);
		parameterContainer.add(initAffinTransformPanel);
		// JPanel for Mouse Actions
		JPanel mouseControlGridPanel = new JPanel(new GridLayout(3, 4));
		// mouseControlGridPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		mouseControlGridPanel.setBorder(BorderFactory
				.createTitledBorder(CONSTANTS.MOUSE_CONTROL_LABEL_STRING));
		mouseControlGridPanel.add(new JLabel(CONSTANTS.TRANSLATE_LABEL_STRING));
		jtMouseTranslate = new JTextField();
		mouseControlGridPanel.add(jtMouseTranslate);
		mouseControlGridPanel.add(new JLabel(CONSTANTS.ROTATE_LABEL_STRING));
		jtMouseRotate = new JTextField();
		mouseControlGridPanel.add(jtMouseRotate);
		mouseControlGridPanel.add(new JLabel(CONSTANTS.SCALE_LABEL_STRING));
		jtMouseScale = new JTextField();
		mouseControlGridPanel.add(jtMouseScale);
		mouseControlGridPanel.add(new JLabel(CONSTANTS.SHEAR_LABEL_STRING));
		jtMouseShear = new JTextField();
		mouseControlGridPanel.add(jtMouseShear);
		mouseControlGridPanel.add(new JLabel(" "));
		mouseControlGridPanel.add(new JLabel(" "));
		mouseControlGridPanel.add(new JLabel(" "));
		mouseControlGridPanel.add(new JLabel(" "));
		parameterContainer.add(mouseControlGridPanel);
		this.add(parameterContainer, BorderLayout.CENTER);
	}

	public void fillParametersFromGrid() {
		resetTextFields();
		resetTextFieldsColor();
		collectIntersectionWorker worker = new collectIntersectionWorker(level);
		iterator.iterateGrid(theGridPanel.getStackedPathesGrid(), worker);
		simplePathParameterObject aO = worker.getSimplePathParameterObject();
		// fileName
		if (aO.fileName != null)
			tfParamsFileName.setText(aO.fileName);
		// color
		if (aO.colorRed != null)
			tfParamsRed.setText(aO.colorRed.toString());
		if (aO.colorGreen != null)
			tfParamsGreen.setText(aO.colorGreen.toString());
		if (aO.colorBlue != null)
			tfParamsBlue.setText(aO.colorBlue.toString());
		// MouseActions
		if (aO.translate != null)
			jtMouseTranslate.setText(aO.translate.toString());
		if (aO.rotate != null)
			jtMouseRotate.setText(aO.rotate.toString());
		if (aO.scale != null)
			jtMouseScale.setText(aO.scale.toString());
		if (aO.shear != null)
			jtMouseShear.setText(aO.shear.toString());
	}

	public boolean sendTextToParameterObject() {
		aO = new simplePathParameterObject();
		boolean ok = true;
		resetTextFieldsColor();
		// fileName
		if (!aO.setFileNameFromString(tfParamsFileName.getText())) {
			tfParamsFileName.setBackground(CONSTANTS.COLOR_WARNING);
			ok = false;
		}
		// color
		if (!aO.setColorRedFromString(tfParamsRed.getText())) {
			tfParamsRed.setBackground(CONSTANTS.COLOR_WARNING);
			ok = false;
		}
		if (!aO.setColorGreenFromString(tfParamsGreen.getText())) {
			tfParamsGreen.setBackground(CONSTANTS.COLOR_WARNING);
			ok = false;
		}
		if (!aO.setColorBlueFromString(tfParamsBlue.getText())) {
			tfParamsBlue.setBackground(CONSTANTS.COLOR_WARNING);
			ok = false;
		}
		// init Transform
		if (!aO.settRotateFromString(tfParamsRotate.getText())) {
			tfParamsRotate.setBackground(CONSTANTS.COLOR_WARNING);
			ok = false;
		}
		if (!aO.settScaleXFromString(tfParamsScaleX.getText())) {
			tfParamsScaleX.setBackground(CONSTANTS.COLOR_WARNING);
			ok = false;
		}
		if (!aO.settScaleYFromString(tfParamsScaleY.getText())) {
			tfParamsScaleY.setBackground(CONSTANTS.COLOR_WARNING);
			ok = false;
		}
		if (!aO.settShearXFromString(tfParamsShearX.getText())) {
			tfParamsShearX.setBackground(CONSTANTS.COLOR_WARNING);
			ok = false;
		}
		if (!aO.settShearYFromString(tfParamsShearY.getText())) {
			tfParamsShearY.setBackground(CONSTANTS.COLOR_WARNING);
			ok = false;
		}
		// MouseActions
		if (!aO.setTranslateFromString(jtMouseTranslate.getText())) {
			jtMouseTranslate.setBackground(CONSTANTS.COLOR_WARNING);
			ok = false;
		}
		if (!aO.setRotateFromString(jtMouseRotate.getText())) {
			jtMouseRotate.setBackground(CONSTANTS.COLOR_WARNING);
			ok = false;
		}
		if (!aO.setScaleFromString(jtMouseScale.getText())) {
			jtMouseScale.setBackground(CONSTANTS.COLOR_WARNING);
			ok = false;
		}
		if (!aO.setShearFromString(jtMouseShear.getText())) {
			jtMouseShear.setBackground(CONSTANTS.COLOR_WARNING);
			ok = false;
		}
		return ok;
	}

	public void sendParameterObjectToGrid() {
		setParameterWorker worker = new setParameterWorker(level, aO);
		iterator.iterateGrid(theGridPanel.getStackedPathesGrid(), worker);
	}

	public void resetTextFields() {
		tfParamsFileName.setText("");
		tfParamsRed.setText("");
		tfParamsGreen.setText("");
		tfParamsBlue.setText("");
		tfParamsRotate.setText("");
		tfParamsScaleX.setText("");
		tfParamsScaleY.setText("");
		tfParamsShearX.setText("");
		tfParamsShearY.setText("");
		jtMouseTranslate.setText("");
		jtMouseRotate.setText("");
		jtMouseScale.setText("");
		jtMouseShear.setText("");
	}

	public void resetTextFieldsColor() {
		tfParamsFileName.setBackground(CONSTANTS.COLOR_NO_WARNING);
		tfParamsRed.setBackground(CONSTANTS.COLOR_NO_WARNING);
		tfParamsGreen.setBackground(CONSTANTS.COLOR_NO_WARNING);
		tfParamsBlue.setBackground(CONSTANTS.COLOR_NO_WARNING);
		tfParamsRotate.setBackground(CONSTANTS.COLOR_NO_WARNING);
		tfParamsScaleX.setBackground(CONSTANTS.COLOR_NO_WARNING);
		tfParamsScaleY.setBackground(CONSTANTS.COLOR_NO_WARNING);
		tfParamsShearX.setBackground(CONSTANTS.COLOR_NO_WARNING);
		tfParamsShearY.setBackground(CONSTANTS.COLOR_NO_WARNING);
		jtMouseTranslate.setBackground(CONSTANTS.COLOR_NO_WARNING);
		jtMouseRotate.setBackground(CONSTANTS.COLOR_NO_WARNING);
		jtMouseScale.setBackground(CONSTANTS.COLOR_NO_WARNING);
		jtMouseShear.setBackground(CONSTANTS.COLOR_NO_WARNING);
	}
	
	private JPanel createFileNamePanel() {
		JPanel fileNamePanel = new JPanel();
		fileNamePanel.setLayout(new BorderLayout());
		tfParamsFileName = new JTextField();
		fileNamePanel.add(tfParamsFileName,BorderLayout.CENTER);
		JButton loadFileButton = new JButton(CONSTANTS.LOAD_FILE_BUTTON);
		loadFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnVal = fileChooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					System.out.println(file.getName());
					String filePath = fileChooser.getSelectedFile().getPath();
					simplePathPanel.this.tfParamsFileName.setText(filePath.replace('/', '.'));
				}
			}
		});
		fileNamePanel.add(loadFileButton,BorderLayout.EAST);
		return fileNamePanel;
	}
}
