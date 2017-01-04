package opticalArt.pathes;

import java.awt.Point;
import java.util.Observer;

import javax.swing.JPanel;

public interface gridElementInterface extends Observer {

	public gridElementInterface getGridElementUnderPoint(Point point);
	public gridElementVector getGridElementVector();
	public boolean isSelected();
	public void setSelected(boolean selected);
	public void setStackLevel(int levelMax);
	public JPanel getJPanel();
}
