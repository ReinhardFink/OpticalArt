//idee von Bianca Winderl
package opticalArt.shapes.formular;

import java.awt.geom.*;

public class sechseck implements formularShape {
// dann File unter hierEigenenNamenEingeben.java abspeichen
// mit javac hierEigenenNamenEingeben.java auf der Console übersetzten
	
	private final int numberOfSechsecke = 30;

	public GeneralPath getPath() {
		float step = 1f / numberOfSechsecke; 
		GeneralPath path = new GeneralPath();
		float x = 0.5f;
		float y = 1f;
		for(int i = 0; i < numberOfSechsecke; i++) {
			path.moveTo(x,y);
			path.lineTo(y,0f);
			path.lineTo(x,-y);
			path.lineTo(-x,-y);
			path.lineTo(-y,0f);
			path.lineTo(-x,y);
			path.lineTo(x,y);
			x -= step;
			y -= step;
			
		}
		return path;
	}
}
