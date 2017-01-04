package opticalArt.shapes.formular;

import java.awt.geom.*;
//import java.lang.*;

public class speichen implements formularShape {

	private final static int defaultNumberOfSpokes = 180;

	private int numberOfSpokes;
	
	public speichen() {
		this.numberOfSpokes = defaultNumberOfSpokes;
	}
	
	public void setNumberOfSpokes(int numberOfSpokes) { this.numberOfSpokes = numberOfSpokes; }

	public GeneralPath getPath() { 
		double alpha = 2 * Math.PI / numberOfSpokes;
		GeneralPath path = new GeneralPath();
		for (int i = 0; i < numberOfSpokes/2; i++) {
			path.moveTo((float)(Math.cos(i * alpha)),(float)(Math.sin(i * alpha)));
			path.lineTo(-(float)(Math.cos(i * alpha)),-(float)(Math.sin(i * alpha)));
		}
		return path;
	}
}
