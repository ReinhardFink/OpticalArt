package opticalArt.shapes.formular.p5a;

import java.awt.geom.*;

import opticalArt.shapes.formular.formularShape;

public class winderlb implements formularShape {
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
		
		// Ende der eignen Zeichenbefehle
		return path;
		/*
		path.moveTo(-0.5f,1f);
		path.lineTo(-1f,0f);
		path.lineTo(-0.5f,-1f);
		path.lineTo(0.5f,-1f);
		path.lineTo(1f,0f);
		path.lineTo(0.5f,1f);
		path.lineTo(-0.5f,1f);
		path.moveTo(-0.5f,-1f);
		path.lineTo(0.5f,-1f);
		*/
	}
}
