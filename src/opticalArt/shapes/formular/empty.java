package opticalArt.shapes.formular;

import java.awt.geom.*;

public class empty implements formularShape {
	
	public GeneralPath getPath() { 
		GeneralPath path = new GeneralPath();
		return path;
	}
}
