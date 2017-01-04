package opticalArt.shapes.formular;

import java.awt.geom.*;

public class cubic implements formularShape {
// dann File unter hierEigenenNamenEingeben.java abspeichen
// mit javac hierEigenenNamenEingeben.java auf der Console übersetzten
	
	public GeneralPath getPath() { 
		GeneralPath path = new GeneralPath();
		path.append(new CubicCurve2D.Float(-0.5f,0f,-0.5f,-1f,0.5f,1f,0.5f,0f),false);
		return path;
	}
}
