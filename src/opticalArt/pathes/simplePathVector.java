package opticalArt.pathes;

import java.util.Vector;
 
public class simplePathVector {

	private Vector<simplePath> internalSimplePathVector;
	
	public simplePathVector(int number) { internalSimplePathVector = new Vector<simplePath>(number); }
	
	public simplePathVector(simplePath aSimplePath) { 
		internalSimplePathVector = new Vector<simplePath>(1);
		internalSimplePathVector.add(aSimplePath); 
	}
	
	public void add(simplePath aSimplePath) { internalSimplePathVector.add(aSimplePath); }
	
	public simplePath get(int index) { return (internalSimplePathVector.get(index)); }
	
	public int size() { return internalSimplePathVector.size(); }
}
