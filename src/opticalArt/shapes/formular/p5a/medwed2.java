
package opticalArt.shapes.formular.p5a;

import java.awt.geom.*;

import opticalArt.shapes.formular.*;

public class medwed2 implements formularShape {
// dann File unter hierEigenenNamenEingeben.java abspeichen
// mit javac hierEigenenNamenEingeben.java auf der Console übersetzten
	
	public GeneralPath getPath() { 
		GeneralPath path = new GeneralPath();
		path.moveTo(0f,0.5f);
		path.lineTo(1f,1f);
		path.lineTo(0.5f,0f);
		path.lineTo(1f,-1f);
		path.lineTo(0f,-0.5f);
		path.lineTo(-1f,-1f);
		path.lineTo(-0.5f,0f);
		path.lineTo(-1f,1f);
		path.lineTo(0f,0.5f);     
		path.moveTo(0f,0.4f);
		path.lineTo(1f,1f);
		path.lineTo(0.4f,0f);
		path.lineTo(1f,-1f);
		path.lineTo(0f,-0.4f);
		path.lineTo(-1f,-1f);
		path.lineTo(-0.4f,0f);
		path.lineTo(-1f,1f);
		path.lineTo(0f,0.4f); 
		path.moveTo(0f,0.3f);
		path.lineTo(1f,1f);
		path.lineTo(0.3f,0f);
		path.lineTo(1f,-1f);
		path.lineTo(0f,-0.3f);
		path.lineTo(-1f,-1f);
		path.lineTo(-0.3f,0f);
		path.lineTo(-1f,1f);
		path.lineTo(0f,0.3f);    
		path.moveTo(0f,0.2f);
		path.lineTo(1f,1f);
		path.lineTo(0.2f,0f);
		path.lineTo(1f,-1f);
		path.lineTo(0f,-0.2f);
		path.lineTo(-1f,-1f);
		path.lineTo(-0.2f,0f);
		path.lineTo(-1f,1f);
		path.lineTo(0f,0.2f);  
		path.moveTo(0f,0.1f);
		path.lineTo(1f,1f);
		path.lineTo(0.1f,0f);
		path.lineTo(1f,-1f);
		path.lineTo(0f,-0.1f);
		path.lineTo(-1f,-1f);
		path.lineTo(-0.1f,0f);
		path.lineTo(-1f,1f);
		path.lineTo(0f,0.1f);               
		return path;                        
	}
}
