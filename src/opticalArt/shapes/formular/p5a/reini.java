package opticalArt.shapes.formular.p5a;

import java.awt.geom.*;

import opticalArt.shapes.formular.formularShape;

public class reini implements formularShape {
// dann File unter hierEigenenNamenEingeben.java abspeichen
// mit javac hierEigenenNamenEingeben.java auf der Console übersetzten
	
	public GeneralPath getPath() { 
		GeneralPath path = new GeneralPath();
		// Beginn der eigenen Zeichenbefehle
		path.moveTo(1f,1f); // bewegt den Zeichencursor von (0/0) nach (1/1) 
		path.lineTo(-1f,-1f); 
		path.lineTo(1f,1f);  
		// Ende der eignen Zeichenbefehle
		return path;
	}
}
