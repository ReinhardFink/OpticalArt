package opticalArt.shapes.formular.p5a;

import java.awt.geom.*;

import opticalArt.shapes.formular.*;

public class evi1 implements formularShape {
// dann File unter hierEigenenNamenEingeben.java abspeichen
// mit javac hierEigenenNamenEingeben.java auf der Console übersetzten
	
	public GeneralPath getPath() { 
		GeneralPath path = new GeneralPath();
		path.moveTo(-0.5f,0.5f);
		path.lineTo(0.5f,0.5f);
		path.lineTo(0.5f,-0.5f);
		path.lineTo(-0.5f,-0.5f);
		path.lineTo(-0.5f,0.5f);
		path.moveTo(-0.5f,0.5f);
		path.moveTo(-0.7f,0.7f);
		path.lineTo(0.7f,0.7f);
		path.lineTo(0.7f,-0.7f);
		path.lineTo(-0.7f,-0.7f);
		path.lineTo(-0.7f,0.7f);
		path.moveTo(-0.3f,0.3f);
		path.lineTo(0.3f,0.3f);
		path.lineTo(0.3f,-0.3f);
		path.lineTo(-0.3f,-0.3f);
		path.lineTo(-0.3f,0.3f);
		path.moveTo(-0.3f,0.3f);
		path.moveTo(-0.5f,0f);
		path.lineTo(0f,0.5f);
		path.lineTo(0.5f,0f);
		path.lineTo(0f,-0.5f);
		path.lineTo(-0.5f,0f);
		path.moveTo(-0.7f,0f);
		path.lineTo(0f,0.7f);
		path.lineTo(0.7f,0f);
		path.lineTo(0f,-0.7f);
		path.lineTo(-0.7f,0f);
		path.moveTo(-0.9f,0f);
		path.lineTo(0f,0.9f);
		path.lineTo(0.9f,0f);
		path.lineTo(0f,-0.9f);
		path.lineTo(-0.9f,0f);
		path.moveTo(-1f,1f);
		path.lineTo(1f,-1f);
		path.moveTo(-1f,-1f);
		path.lineTo(1f,1f);
		path.lineTo(-1f,-1f);
		return path;
	}
}	

