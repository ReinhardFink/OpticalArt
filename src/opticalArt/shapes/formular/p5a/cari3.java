package opticalArt.shapes.formular.p5a;

import java.awt.geom.*;

import opticalArt.shapes.formular.formularShape;

public class cari3 implements formularShape {
// dann File unter hierEigenenNamenEingeben.java abspeichen
// mit javac hierEigenenNamenEingeben.java auf der Console übersetzten
	
	public GeneralPath getPath() { 
		GeneralPath path = new GeneralPath();
		path.moveTo(0f,1f);
		path.lineTo(0.2f,0f);
		path.moveTo(0f,-1f);
		path.lineTo(0.2f,0f);
		path.moveTo(0f,0.8f);
		path.lineTo(0.4f,0f);
		path.moveTo(0f,-0.8f);
		path.lineTo(0.4f,0f);
		path.moveTo(0f,0.6f);
		path.lineTo(0.6f,0f);
		path.moveTo(0f,-0.6f);
		path.lineTo(0.6f,0f);
		path.moveTo(0f,0.4f);
		path.lineTo(0.8f,0f);
		path.moveTo(0f,-0.4f);
		path.lineTo(0.8f,0f);
		path.moveTo(0f,0.2f);
		path.lineTo(1f,0f);
		path.moveTo(0f,-0.2f);
		path.lineTo(1f,0f);
		path.moveTo(0f,1f);
		path.lineTo(0f,-1f);
		path.moveTo(1f,0f);
		path.lineTo(-1f,0f);
		path.moveTo(0f,1f);
		path.lineTo(-0.2f,0f);
		path.moveTo(0f,-1f);
		path.lineTo(-0.2f,0f);
		path.moveTo(0f,0.8f);
		path.lineTo(-0.4f,0f);
		path.moveTo(0f,-0.8f);
		path.lineTo(-0.4f,0);
		path.moveTo(0f,0.6f);
		path.lineTo(-0.6f,0f);
		path.moveTo(0f,-0.6f);
		path.lineTo(-0.6f,0f);
		path.moveTo(0f,0.4f);
		path.lineTo(-0.8f,0f);
		path.moveTo(0f,-0.4f);
		path.lineTo(-0.8f,0f);
		path.moveTo(0f,0.2f);
		path.lineTo(-1f,0f);
		path.moveTo(0f,-0.2f);
		path.lineTo(-1f,0f);
		
		
		return path;
	}
}
