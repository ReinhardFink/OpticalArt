package opticalArt.pathes.workers;

import opticalArt.pathes.gridElementInterface;
import opticalArt.pathes.simplePathParameterObject;
import opticalArt.pathes.stackedPathes;

public class setParameterWorker implements workerInterface {

	private int level;
	private simplePathParameterObject aO;

	public setParameterWorker(int level, simplePathParameterObject aO) {
		this.level = level;
		this.aO = aO;
	}
	
	public void doWork(gridElementInterface gridElement) {
		if(gridElement.getGridElementVector() != null) return; // for leaves only
		if(gridElement.isSelected()) aO.setSimplePath(((stackedPathes)gridElement).getSimplePath(level));
	}
}
