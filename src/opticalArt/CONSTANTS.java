package opticalArt; 

import java.awt.BasicStroke;
import java.awt.Color;

public class CONSTANTS {

	public final static boolean DEBUG = false;
	
	// Defaults for simplePath
	public static final String DEAULT_FILENAME = "opticalArt.shapes.formular.windrose.class";
	public static final BasicStroke DEFAULT_BASICSTROKE = new BasicStroke(0.0001f);
	public static final Color DEFAULT_PAINTCOLOR = new Color(0,0,0);
	public static final boolean DEAULT_TRANSLATE = false;
	public static final boolean DEAULT_ROTATE = false;
	public static final boolean DEAULT_SCALE = false;
	public static final boolean DEAULT_SHEAR = false;
	// Scaling for MouseActions during Animation
	public static final double MOUSE_SCALE_X = 0.5;
	public static final double MOUSE_SCALE_Y = 0.5;
	// Organisation of stacked Pathes
	public static final int NUMBER_OF_STACKED_PATHES = 2;
	
	// Colors for selected and normal JPanels
	public final static Color SELECTED_COLOR = Color.GRAY;
	public final static Color BACKGROUND_COLOR = Color.WHITE;	
	
	//-------Panels-------------------------------------------------------//
	public static final Color COLOR_WARNING = Color.red;
	public static final Color COLOR_NO_WARNING = Color.white;
	
	public static final int NO_COLOR = -1;
	
	public static final int STARTUP_LINES = 3;
	public static final int STARTUP_COLUMNS = 3;
	// Strings to select Animations 
	public static final String BOOLEAN_ALL_TRUE_STRING = "1";  
	public static final String BOOLEAN_ALL_FALSE_STRING = "-1";
	public static final String BOOLEAN_ALL_DIFFERENT_STRING = "0";
	
	// Button Label Strings
	public static String LOAD_FILE_BUTTON = "Load File";
	public static String SHOW_SELECTED_BUTTON = "select";
	public static String SHOW_SELECTMODE_BUTTON = "select Mode";
	public static String GRID_LABEL_STRING = "Grid";
	public static String NEW_GRID_LABEL_STRING = "new";
	public static String SELECT_ALL_LABEL_STRING = "select ALL";
	public static String UPDATE_LABEL_STRING = "update All";
	public static String SHOW_SIMPLE_PATH_PARAMS_STRING = "Options";
	public static String RESET_LABEL_STRING = "reset ALL";
	
	public static String STACK_LEVEL_LABEL_STRING = "Number of Levels";
	public static String LEVEL_LABEL_STRING = "Levels";
	public static String LEVEL_STRING = "Level ";
	public static String LEVEL_POPUP_STRING = "Steuerung der Parameter f�r Level ";
	
	// Label Strings
	public static String MOUSE_CONTROL_LABEL_STRING = "Mouse - Actions";
	public static String TRANSFORMATIONS_CONTROL_LABEL_STRING = "Start - Transformationen";

	public static String LINES_LABEL_STRING = "Lines ";
	public static String COLUMNS_LABEL_STRING = "Columns ";
	
	public static String TRANSLATE_LABEL_STRING = " translate";
	public static String ROTATE_LABEL_STRING = " rotate";
	public static String SCALE_LABEL_STRING = " scale";
	public static String SCALE_X_LABEL_STRING = " scaleX";
	public static String SCALE_Y_LABEL_STRING = " scaleY";
	public static String SHEAR_X_LABEL_STRING = " shearX";
	public static String SHEAR_Y_LABEL_STRING = " shearY";
	public static String SHEAR_LABEL_STRING = " shear";	
	public static String COLOR_LABEL_STRING = "Color";
	public static String COLOR_RED_STRING = " Red";
	public static String COLOR_GREEN_STRING = " Green";
	public static String COLOR_BLUE_STRING = " Blue";
	
}
