package opticalArt.pathes;

import java.awt.*;
//import opticalArt.CONSTANTS;

public class simplePathParameterObject {

	public String fileName;
	public Integer colorRed;
	public Integer colorGreen;
	public Integer colorBlue;
	public Double tRotate;
	public Double tScaleX;	
	public Double tScaleY;	
	public Double tShearX;
	public Double tShearY;
	public Boolean translate;
	public Boolean rotate;
	public Boolean shear;
	public Boolean scale;	
	
	public void fillFromSimplePath(simplePath aSimplePath) {
		this.fileName = aSimplePath.getFileName();
		colorRed = new Integer(aSimplePath.getColor().getRed());
		colorGreen = new Integer(aSimplePath.getColor().getGreen());
		colorBlue = new Integer(aSimplePath.getColor().getBlue());
		translate = new Boolean(aSimplePath.isTranslate());
		rotate = new Boolean(aSimplePath.isRotate());
		scale = new Boolean(aSimplePath.isScale());	
		shear = new Boolean(aSimplePath.isShear());
	}
	
	public void intersectWithSimplePath(simplePath aSimplePath) {
		simplePathParameterObject temp = new simplePathParameterObject();
		temp.fillFromSimplePath(aSimplePath);
		if(this.fileName != null && !this.fileName.equals(temp.fileName)) this.fileName = null;
		if(this.colorRed != null && !this.colorRed.equals(temp.colorRed)) this.colorRed = null;
		if(this.colorGreen != null && !this.colorGreen.equals(temp.colorGreen)) this.colorGreen = null;
		if(this.colorBlue != null && !this.colorBlue.equals(temp.colorBlue)) this.colorBlue = null;
		if(this.translate != null && !this.translate.equals(temp.translate)) this.translate = null;
		if(this.rotate != null && !this.rotate.equals(temp.rotate)) this.rotate = null;
		if(this.scale != null && !this.scale.equals(temp.scale)) this.scale = null;
		if(this.shear != null && !this.shear.equals(temp.shear)) this.shear = null;
	}
	// fill a simplePath
	public void setSimplePath(simplePath aSimplePath) {
		// fileName
		if(this.fileName != null) aSimplePath.setPath(fileName);
		// color
		Color tempColor = aSimplePath.getColor();
		int red = tempColor.getRed();
		int green = tempColor.getGreen();
		int blue = tempColor.getBlue();
		if(this.colorRed != null) red = colorRed.intValue();
		if(this.colorGreen != null) green = colorGreen.intValue();
		if(this.colorBlue != null) blue = colorBlue.intValue();
		aSimplePath.setColor(new Color(red,green,blue));
		// initTransform
		if(this.tRotate != null) aSimplePath.setInitTransformRotate(tRotate.doubleValue());
		if(this.tScaleX != null) aSimplePath.setInitTransformScale(tScaleX.doubleValue(),1);
		if(this.tScaleY != null) aSimplePath.setInitTransformScale(1,tScaleY.doubleValue());
		if(this.tShearX != null) aSimplePath.setInitTransformShear(tShearX.doubleValue(),0);
		if(this.tShearY != null) aSimplePath.setInitTransformShear(0,tShearY.doubleValue());
		// MouseActions
		if(this.translate != null) aSimplePath.setTranslate(translate.booleanValue());
		if(this.rotate != null) aSimplePath.setRotate(rotate.booleanValue());
		if(this.scale != null) aSimplePath.setScale(scale.booleanValue());
		if(this.shear != null) aSimplePath.setShear(shear.booleanValue());
	}

	// setters from String from Swing uu‰‰‰H!!!
	/** fileName */
	public boolean setFileNameFromString(String fileName) {
		if(fileName.equals("")) return true;
		if(opticalArt.utils.FileUtils.getPathFromFile(fileName) == null) return false;
		this.fileName = fileName;
		return true;
	}
	/** colorRed */
	public boolean setColorRedFromString(String color) {
		boolean ok = true;
		if(color.equals("")) { colorRed = null; return ok; }
		try { 
			colorRed = new Integer(color);
			ok = checkColorValue(colorRed);
		} catch(NumberFormatException e) { ok = false; } 
		return ok;
	}
	/** colorGreen */
	public boolean setColorGreenFromString(String color) {
		boolean ok = true;
		if(color.equals("")) { colorGreen = null; return ok; }
		try { 
			colorGreen = new Integer(color);
			ok = checkColorValue(colorGreen);
		} catch(NumberFormatException e) { ok = false; } 
		return ok;
	}
	/** colorBlue */
	public boolean setColorBlueFromString(String color) {
		boolean ok = true;
		if(color.equals("")) { colorBlue = null; return ok; }
		try { 
			colorBlue = new Integer(color);
			ok = checkColorValue(colorBlue);
		} catch(NumberFormatException e) { ok = false; } 
		return ok;
	}

	private boolean checkColorValue(Integer colorValue) {
		int color = colorValue.intValue();
		if(color < 0 || color > 255) return false;
		return true;
	}
	/** init Trasform */
	public boolean settRotateFromString(String var) {
		boolean ok = true;
		if(var.equals("")) { tRotate = null; return ok; }
		try { 
			tRotate = new Double(var);
		} catch(NumberFormatException e) { ok = false; } 
		return ok;
	}
	
	public boolean settScaleXFromString(String var) {
		boolean ok = true;
		if(var.equals("")) { tScaleX = null; return ok; }
		try { 
			tScaleX = new Double(var);
		} catch(NumberFormatException e) { ok = false; } 
		return ok;
	}
	
	public boolean settScaleYFromString(String var) {
		boolean ok = true;
		if(var.equals("")) { tScaleY = null; return ok; }
		try { 
			tScaleY = new Double(var);
		} catch(NumberFormatException e) { ok = false; } 
		return ok;
	}

	public boolean settShearXFromString(String var) {
		boolean ok = true;
		if(var.equals("")) { tShearX = null; return ok; }
		try { 
			tShearX = new Double(var);
		} catch(NumberFormatException e) { ok = false; } 
		return ok;
	}
	
	public boolean settShearYFromString(String var) {
		boolean ok = true;
		if(var.equals("")) { tShearY = null; return ok; }
		try { 
			tShearY = new Double(var);
		} catch(NumberFormatException e) { ok = false; } 
		return ok;
	}
	/** Mouse Actions */
	public boolean setTranslateFromString(String bool) {
		boolean ok = true;
		if(bool.equals("")) { translate = null; return ok; }
		if(bool.equals("1")) bool = "true";
		translate = new Boolean(bool);
		return ok;
	}
	
	public boolean setRotateFromString(String bool) {
		boolean ok = true;
		if(bool.equals("")) { rotate = null; return ok; }
		if(bool.equals("1")) bool = "true";
		rotate = new Boolean(bool);
		return ok;
	}
	
	public boolean setScaleFromString(String bool) {
		boolean ok = true;
		if(bool.equals("")) { scale = null; return ok; }
		if(bool.equals("1")) bool = "true";
		scale = new Boolean(bool);
		return ok;
	}

	public boolean setShearFromString(String bool) {
		boolean ok = true;
		if(bool.equals("")) { shear = null; return ok; }
		if(bool.equals("1")) bool = "true";
		shear = new Boolean(bool);
		return ok;
	}
}

