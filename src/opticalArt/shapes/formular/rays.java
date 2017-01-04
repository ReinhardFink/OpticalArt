// idee von Thomas Riess
package opticalArt.shapes.formular;

import java.awt.geom.*;

public class rays implements formularShape {
// dann File unter hierEigenenNamenEingeben.java abspeichen
// mit javac hierEigenenNamenEingeben.java auf der Console übersetzten
	
	private final int numberOfLines = 30;

	public GeneralPath getPath() { 
		GeneralPath path = new GeneralPath();
		float y = 1f;
		float step = 2.0f / numberOfLines;
		for(int i = 0; i < numberOfLines; i++) {
			path.moveTo(1f,1f);
			path.lineTo(-1f,y);
			y -= step;
		}
		float x = -1f;
		for(int i = 0; i < numberOfLines; i++) {
			path.moveTo(1f,1f);
			path.lineTo(x,-1f);
			x += step;
		}
		return path;
	}
}
