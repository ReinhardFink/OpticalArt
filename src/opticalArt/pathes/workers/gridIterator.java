package opticalArt.pathes.workers;

import opticalArt.pathes.gridElementInterface;

public class gridIterator {

	public void iterateGrid(gridElementInterface gridElement, workerInterface worker) {
		worker.doWork(gridElement);
		if(gridElement.getGridElementVector() != null)
			for(int i = 0; i < gridElement.getGridElementVector().size(); i++) 
				iterateGrid(gridElement.getGridElementVector().get(i), worker); 
	}
}
