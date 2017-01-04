package opticalArt.pathes;

import java.util.*; //Observable
import java.awt.*;

/** MouseObservable notifies MouseMoveVector to all Subpanels */
public class eventObserver extends Observable {

		/** Method calls all stackedPathes to update their Graphics */
	public void setMouseDraggedEvent(int x, int y) {
		setChanged();
		notifyObservers(new Point(x,y));
	}
}
