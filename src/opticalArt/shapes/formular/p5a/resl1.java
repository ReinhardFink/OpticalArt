package opticalArt.shapes.formular.p5a;

import java.awt.geom.*;

import opticalArt.shapes.formular.formularShape;

public class resl1 implements formularShape {
// dann File unter hierEigenenNamenEingeben.java abspeichen
// mit javac hierEigenenNamenEingeben.java auf der Console übersetzten
	private final int numberOfStars = 10;
	
	public GeneralPath getPath() { 
		float startX = 0.5f;
		float step = startX / numberOfStars;
		
		float x = -startX;
		float y = 0.5f;
		float z = -1f;
		
		GeneralPath path = new GeneralPath();
		for(int i = 0; i < numberOfStars; i++) {
			path.moveTo(x,y);
			path.lineTo(-x,y);
			path.lineTo(0,z);
			path.lineTo(x,y);
			x += step;
			y -= step;
			z += step;
		}
		x =  0.5f;
		y = -0.5f;
		z = 1f;
		
		for(int i = 0; i < numberOfStars; i++) {
			path.moveTo(x,y);
			path.lineTo(-x,y);
			path.lineTo(0,z);
			path.lineTo(x,y);
			x -= step;
			y += step;
			z -= step;
		}
		return path;
		
	}
}
