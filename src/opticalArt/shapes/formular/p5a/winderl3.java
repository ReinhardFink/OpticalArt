package opticalArt.shapes.formular.p5a;

import java.awt.geom.*;

import opticalArt.shapes.formular.formularShape;

public class winderl3 implements formularShape {

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
		// Ende der eignen Zeichenbefehle
		return path;
	}
}
