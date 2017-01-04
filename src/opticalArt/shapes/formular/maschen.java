//idee von Evrim Tuncel
package opticalArt.shapes.formular;

import java.awt.geom.*;

public class maschen implements formularShape {

	private final int anzahlDerMaschen = 30;

	public GeneralPath getPath() { 
		GeneralPath path = new GeneralPath();
		float steps = 0.1f;//1f / anzahlDerMaschen; 
		float x = 0.3f;
		float y = 1f;
		for(int i = 0; i < anzahlDerMaschen; i++) {
			path.moveTo(x,y);
			path.lineTo(-x,-y);      
			path.lineTo(-y,-x);      
			path.lineTo(y,x);        
			path.lineTo(x,y); 
			path.moveTo(-x,y);
			path.lineTo(x,-y);
			path.lineTo(y,-x);
			path.lineTo(-y,x);
			path.lineTo(-x,y);
			y -= steps;
		}   
		return path;
	}
}
