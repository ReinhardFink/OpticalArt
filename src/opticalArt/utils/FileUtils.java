package opticalArt.utils;

import java.awt.geom.GeneralPath;
import java.util.StringTokenizer;

import opticalArt.shapes.formular.formularShape;

public class FileUtils {

	final static boolean DEBUG = true;
	
	public static boolean hasXmlEnding(String fileName) {
		return(fileName.substring(fileName.length()-1-2).toLowerCase().equals("xml"));
	}
	
	public static boolean hasClassEnding(String fileName) {
		return(fileName.substring(fileName.length()-1-4).toLowerCase().equals("class"));
	}
	
	public static String getFileNameFromPath(String fileName) {
		String token =  getLastToken(fileName, "/");
		StringTokenizer pathParser = new StringTokenizer(token,".");
		token = pathParser.nextToken();
		return token;
	}
	
	public static String getFileEndingFromPath(String fileName) {
		return getLastToken(fileName, ".");
	}
	
	public static GeneralPath getPathFromFile(String fileName) {
		GeneralPath path = null;
		if(hasXmlEnding(fileName)) path = createPathFromFormula(fileName);
		if(hasClassEnding(fileName)) path = createPathFromFormula(fileName);
		return path;
	}

	private static GeneralPath createPathFromFormula(String fileName) {
		formularShape pathClassObject = null;
		try {
			pathClassObject = (formularShape)Class.forName(makeJavaClassPath(fileName)).newInstance();
			//pathClassObject = (formularShape)Class.forName("opticalArt.formularShapes.speichen").newInstance();
		} catch (ClassNotFoundException e) { System.out.println("Could not find Class: " + fileName); }
			catch (IllegalAccessException e) { System.out.println("Could create Object from Class: " + fileName); }
			catch (InstantiationException e) { System.out.println("Could create Object from Class: " + fileName); }
		if(pathClassObject == null) return null;
		else return pathClassObject.getPath();
	}

	private static String getLastToken(String fileName, String delimiter) {
		StringTokenizer pathParser = new StringTokenizer(fileName,delimiter);
		String token = "";
		while(pathParser.hasMoreTokens()) token = pathParser.nextToken();
		return new String(token);
	}
	
	private static String makeJavaClassPath(String fileName) {
		fileName = fileName.substring(0,fileName.length()-1-5);
		return fileName.replace('/','.');
	}
}

