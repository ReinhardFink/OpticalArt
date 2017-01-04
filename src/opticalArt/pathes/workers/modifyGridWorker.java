package opticalArt.pathes.workers;

import opticalArt.pathes.eventObserver;
import opticalArt.pathes.gridElementInterface;
import opticalArt.pathes.stackedPathes;
import opticalArt.pathes.stackedPathesGrid;

public class modifyGridWorker implements workerInterface {

	private int lines, columns, level;
	private eventObserver aEventObserver;

	public modifyGridWorker(int lines, int columns, int level, eventObserver aEventObserver) {
		this.lines = lines;
		this.columns = columns;
		this.level = level;
		this.aEventObserver = aEventObserver;
	}
	
	public void doWork(gridElementInterface gridElement) {
		if(gridElement.getGridElementVector() == null) return; 											// for nodes only
		stackedPathesGrid aStackedPathesGrid = (stackedPathesGrid)gridElement;			// cast
		// work on stackedPathesVector
		for(int i = 0; i < aStackedPathesGrid.getGridElementVector().size(); i++)
			if(aStackedPathesGrid.getGridElementVector().get(i).isSelected()) 
				addGridElement(i, aStackedPathesGrid, createNewGridElement(lines, columns, level, aEventObserver));
	}
	
	public gridElementInterface createNewGridElement(int lines, int columns, int levelMax, eventObserver aEventObserver) {
		if(lines * columns == 1) {
			gridElementInterface aStackedPath = new stackedPathes(levelMax);
			aEventObserver.addObserver(aStackedPath);
			return aStackedPath;
		}
		else return new stackedPathesGrid(lines, columns, levelMax, aEventObserver);
	}
	
	public void addGridElement(int index, stackedPathesGrid aStackedPathesGrid, gridElementInterface gridElement) {
		// remove 
		aStackedPathesGrid.getGridElementVector().remove(index);
		aStackedPathesGrid.getJPanel().remove(index);
		// add
		aStackedPathesGrid.getGridElementVector().add(index,gridElement);
		aStackedPathesGrid.getJPanel().add(gridElement.getJPanel(), index);
	}
}
