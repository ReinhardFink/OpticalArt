package opticalArt.shapes.formular.p5a;

import java.awt.geom.*;

import opticalArt.shapes.formular.*;

public class raute implements formularShape {
// dann File unter hierEigenenNamenEingeben.java abspeichen
// mit javac hierEigenenNamenEingeben.java auf der Console übersetzten
	
	public GeneralPath getPath() { 
		GeneralPath path = new GeneralPath();
		path.moveTo(-1f,0f);
		path.lineTo(0f,1f);
		path.lineTo(1f,0f);
		path.lineTo(0f,-1f);
		path.lineTo(-1f,0f);
		return path;
	}
}
