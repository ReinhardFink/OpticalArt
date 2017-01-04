package opticalArt.shapes.formular.p5a;

import java.awt.geom.*;

import opticalArt.shapes.formular.formularShape;

public class tom implements formularShape {
// dann File unter hierEigenenNamenEingeben.java abspeichen
// mit javac hierEigenenNamenEingeben.java auf der Console übersetzten
	
	private final int numberOfLines = 30;

	public GeneralPath getPath() { 
		GeneralPath path = new GeneralPath();
		float y = 1f;
		float step = 2.0f / numberOfLines;
		for(int i = 0; i < numberOfLines; i++) {
			path.moveTo(0f,0f);
			path.lineTo(-1,y);
			y -= step;
		}
		float x = -1f;
		for(int i = 0; i < numberOfLines; i++) {
			path.moveTo(0f,0f);
			path.lineTo(x,-1f);
			x += step;
		}
		x = -1f;
		y = 1f;
		step = 2.0f / numberOfLines;
		for(int i = 0; i < numberOfLines; i++) {
			path.moveTo(1f,1f);
			path.lineTo(x,y);
			x += step;
			y -= step;
		}
		/*
		y = 1f;
		for(int i = 0; i < numberOfLines; i++) {
			path.moveTo(1f,1f);
			path.lineTo(0f,x);
			x -= step;
		}
		*/
		return path;
	}
}
