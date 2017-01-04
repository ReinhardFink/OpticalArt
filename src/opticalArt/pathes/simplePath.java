package opticalArt.pathes;

import java.awt.*;
import java.awt.geom.*;

import opticalArt.CONSTANTS;

public class simplePath implements Cloneable {

	private BasicStroke stroke;
	private GeneralPath path;
	private AffineTransform initTransform;
	private Color color;
	private String fileName;
	private boolean translate;
	private boolean rotate;
	private boolean shear;
	private boolean scale;
	
	public simplePath() {
		this(CONSTANTS.DEFAULT_BASICSTROKE,
				 CONSTANTS.DEAULT_FILENAME,
				 new AffineTransform(), // Identity
				 CONSTANTS.DEFAULT_PAINTCOLOR,
				 CONSTANTS.DEAULT_TRANSLATE, CONSTANTS.DEAULT_ROTATE,
				 CONSTANTS.DEAULT_SCALE, CONSTANTS.DEAULT_SHEAR);
	}
	
	public simplePath(BasicStroke stroke, String fileName, AffineTransform initTransform, Color color,
										boolean translate, boolean rotate, boolean scale, boolean shear) {
		this.stroke = stroke;
		setPath(fileName);
		this.initTransform = new AffineTransform(initTransform);
		setColor(color);
		this.translate = translate; 
		this.rotate = rotate;
		this.scale = scale; 
		this.shear = shear;
	}
	
	public Object clone() {
		simplePath aSimplePath = null;
		try { 
			aSimplePath = (simplePath)super.clone(); 
			//this.stroke = stroke;
			setPath(fileName);
			this.initTransform = new AffineTransform(initTransform);
			setColor(color);
		}
		catch(CloneNotSupportedException e) { System.out.println("Could not clone simplePath Object! + " + e);}
		return aSimplePath;
	}
	
	// get- and set- Method for private Properties
	public void setPath(String fileName) {
		this.fileName = fileName; 
		this.path = opticalArt.utils.FileUtils.getPathFromFile(fileName); 
	}
	public void setInitTransformRotate(double angle) { initTransform.rotate((float)(Math.PI/180f*angle)); }
	public void setInitTransformScale(double dx,double dy) { initTransform.scale(dx, dy); }
	public void setInitTransformShear(double dx,double dy) { initTransform.shear(dx, dy); }
	
	public void setColor(Color color) { this.color = new Color(color.getRed(),color.getGreen(),color.getBlue()); }
	
	public BasicStroke getStroke() { return stroke; }
	public Shape getPath() { return new GeneralPath(path); }
	public Shape getTransformedPath() { return path.createTransformedShape(initTransform); }
	//public AffineTransform getInitTransform() { return initTransform; }
	public Color getColor() { return new Color(color.getRed(),color.getGreen(),color.getBlue()); }
	public String getFileName() { return fileName; }
	// set and get Animationtype for Mouseactions
	public void setTranslate(boolean translate) { this.translate = translate; };
	public boolean isTranslate() { return translate; }
	
	public void setScale(boolean scale) { this.scale = scale; };
	public boolean isScale() { return scale; }
	
	public void setShear(boolean shear) { this.shear = shear; };
	public boolean isShear() { return shear; }
	
	public void setRotate(boolean rotate) { this.rotate = rotate; };
	public boolean isRotate() { return rotate; }
}

