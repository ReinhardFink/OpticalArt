package opticalArt.shapes.formular.p5a;

import java.awt.geom.*;
import opticalArt.shapes.formular.*;

public class Veronica implements formularShape {
// dann File unter hierEigenenNamenEingeben.java abspeichen
// mit javac hierEigenenNamenEingeben.java auf der Console übersetzten
	private final int numberOfRectangles = 40;
		
	public GeneralPath getPath() { 
		float step = 1.0f / numberOfRectangles;
		float x = -1;
		float y = -1;
		GeneralPath path = new GeneralPath();
		for(int i = 0; i < numberOfRectangles; i++) {
			path.moveTo(x,y);
		 	path.lineTo(-x,y);
			path.lineTo(-x,-y);
			path.lineTo(x,-y);
			path.lineTo(x,y);
			x += step;
			y += step;
		}
		//path.moveTo(-0.9f,0.9f);
		return path;
	}
}
