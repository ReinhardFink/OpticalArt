package opticalArt.shapes.formular.p5a;

import java.awt.geom.*;

import opticalArt.shapes.formular.formularShape;


public class jassi implements formularShape {
// dann File unter hierEigenenNamenEingeben.java abspeichen
// mit javac hierEigenenNamenEingeben.java auf der Console übersetzten
	
	public GeneralPath getPath() { 
		GeneralPath path = new GeneralPath();
		path.moveTo(-0.5f,0.7f);
		path.lineTo(0.5f,0.7f);
		path.lineTo(-0.5f,-0.7f);
		path.lineTo(0.5f,-0.7f);
		path.lineTo(-0.5f,0.7f);
		path.moveTo(-0.4f,-0.6f);
		path.lineTo(-0.4f,0.6f);
		path.lineTo(0.4f,-0.6f);
		path.lineTo(0.4f,0.6f);
		path.lineTo(-0.4f,-0.6f);
		return path;
	}
}
