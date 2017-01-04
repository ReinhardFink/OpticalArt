package opticalArt.shapes.formular;

import java.awt.geom.*;
//import java.lang.*;

public class ladder implements formularShape {

	private final static int defaultNumberOfSpokes = 100;

	private int numberOfSpokes;
	
	public ladder() {
		this.numberOfSpokes = defaultNumberOfSpokes;
	}
	
	public void setNumberOfSpokes(int numberOfSpokes) { this.numberOfSpokes = numberOfSpokes; }

	public GeneralPath getPath() { 
		float step = 2.0f / numberOfSpokes;
		float y = -1;
		GeneralPath path = new GeneralPath();
		path.moveTo(-1f,y);
		for (int i = 0; i < numberOfSpokes; i++) {
			path.lineTo(1f,y);
			y += step;
			path.moveTo(-1f,y);
		}
		return path;
	}
}
