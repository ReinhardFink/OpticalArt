package opticalArt.shapes.formular.p5a;

import java.awt.geom.*;

import opticalArt.shapes.formular.formularShape;

public class evi2 implements formularShape {

	private final int anzahlDerMaschen = 30;

	public GeneralPath getPath() { 
		GeneralPath path = new GeneralPath();
		float steps = 0.1f;//1f / anzahlDerMaschen; 
		float x = 0.3f;
		float y = 1f;
		for(int i = 0; i < anzahlDerMaschen; i++) {
			path.moveTo(x,y);
			path.lineTo(-x,-y);      
			path.lineTo(-y,-x);      
			path.lineTo(y,x);        
			path.lineTo(x,y); 
			path.moveTo(-x,y);
			path.lineTo(x,-y);
			path.lineTo(y,-x);
			path.lineTo(-y,x);
			path.lineTo(-x,y);
			y -= steps;
		}   
		return path;
		/*
		path.moveTo(-0.2f,0.8f);
		path.lineTo(0.2f,-0.8f);      
		path.lineTo(0.8f,-0.2f);      
		path.lineTo(-0.8f,0.2f);        
		path.lineTo(-0.2f,0.8f);   
		path.moveTo(0.2f,0.8f); 
		path.lineTo(-0.2f,-0.8f);     
		path.lineTo(-0.8f,-0.2f);    
		path.lineTo(0.8f,0.2f);    
		path.lineTo(0.2f,0.8f); 
		*/ 
	}
}
