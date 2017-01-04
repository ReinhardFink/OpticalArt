//idee von Jasmin Niedermayr
package opticalArt.shapes.formular;

import java.awt.geom.*;

public class achteck implements formularShape {
// dann File unter hierEigenenNamenEingeben.java abspeichen
// mit javac hierEigenenNamenEingeben.java auf der Console übersetzten
	
	private final int numberOfOctogons = 30;

	public GeneralPath getPath() { 
		GeneralPath path = new GeneralPath();
		float step = 0.7f / numberOfOctogons;
		float x = 0.6f;
		float y = 1f;
		for(int i = 0; i < numberOfOctogons; i++) {
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

