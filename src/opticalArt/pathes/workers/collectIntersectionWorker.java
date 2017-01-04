package opticalArt.pathes.workers;

import opticalArt.pathes.gridElementInterface;
import opticalArt.pathes.simplePathParameterObject;
import opticalArt.pathes.stackedPathes;

public class collectIntersectionWorker implements workerInterface {

	private int level;
	private simplePathParameterObject aO;
	private boolean firstSelectedFound;

	public collectIntersectionWorker(int level) {
		this.level = level;
		firstSelectedFound = false;
		aO = new simplePathParameterObject();
	}
	
	/* (non-Javadoc)
	 * @see opticalArt.pathes.workers.workerInterface#doWork(opticalArt.pathes.gridElementInterface)
	 */
	public void doWork(gridElementInterface aStackedPath) {
		if(aStackedPath.getGridElementVector() != null) return; // for leaves only
		stackedPathes gridElement = (stackedPathes)aStackedPath;
		if(!gridElement.isSelected()) return;
		if(gridElement.isSelected() && !firstSelectedFound) { // 1. selectierte gefunden
			firstSelectedFound = true;
			aO.fillFromSimplePath(gridElement.getSimplePath(level));
		}
		else aO.intersectWithSimplePath(gridElement.getSimplePath(level));
	}
	
	public simplePathParameterObject getSimplePathParameterObject() { return aO; }
}
