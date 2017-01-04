//hergestellt von Bianca Winderl
package opticalArt.shapes.formular;

import java.awt.geom.*;

public class stern2 implements formularShape {
	private final int numberOfSterne = 20;

	public GeneralPath getPath() {
		float step = 1f / numberOfSterne; 
		GeneralPath path = new GeneralPath();
		float x = 0.5f;
		float y = 1f;
		for(int i = 0; i < numberOfSterne; i++) {
			path.moveTo(0f,x);  
			path.lineTo(y,y); 
			path.lineTo(x,0f);
			path.lineTo(y,-y);
			path.lineTo(0f,-x);
			path.lineTo(-y,-y);
			path.lineTo(-x,0f);
			path.lineTo(-y,y);
			path.lineTo(0f,x);
			x -= step;
			y -= step;
		}
		return path;
	}       
}	
