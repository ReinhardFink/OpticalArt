package opticalArt.pathes;

import java.util.Vector;
 
public class gridElementVector {

	private Vector<gridElementInterface> internalGridElementVector;
	
	public gridElementVector(int number) { internalGridElementVector = new Vector<gridElementInterface>(number); }
	
	public void add(gridElementInterface gridElement) { internalGridElementVector.add(gridElement); }
	
	public void add(int index, gridElementInterface gridElement) { internalGridElementVector.add(index, gridElement); }
	
	public gridElementInterface get(int index) { return internalGridElementVector.get(index); }	
	
	public gridElementInterface remove(int index) { return internalGridElementVector.remove(index); }	
	
	public int size() { 
		internalGridElementVector.trimToSize();
		return internalGridElementVector.size();
	}
}
