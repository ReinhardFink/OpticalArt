package opticalArt.shapes.formular.p5a;

import java.awt.geom.*;

import opticalArt.shapes.formular.formularShape;


public class jassi3 implements formularShape {
// dann File unter hierEigenenNamenEingeben.java abspeichen
// mit javac hierEigenenNamenEingeben.java auf der Console übersetzten
	
	private final int numberOfEights = 30;

	public GeneralPath getPath() { 
		GeneralPath path = new GeneralPath();
		float step = 0.7f / numberOfEights;
		float x = 0.6f;
		float y = 1f;
		for(int i = 0; i < numberOfEights; i++) {
			path.moveTo(x,y);
			path.lineTo(y,x); 
			path.lineTo(y,-x);
			path.lineTo(x,-y); 
			path.lineTo(-x,-y);
			path.lineTo(-y,-x);
			path.lineTo(-y,x);
			path.lineTo(-x,y);
			path.lineTo(x,y);
			x -= step;
			y -= step;
		}
		return path;
	}
}

