package opticalArt.pathes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.Observable;

import javax.swing.JPanel;

import opticalArt.CONSTANTS;

@SuppressWarnings("serial")
public class stackedPathes extends JPanel implements gridElementInterface {

	private boolean selected;
	private int levelMax;
	private simplePath simplePathVector[]; 
	private Point translationsVektor;
	
	public stackedPathes(int levelMax) {
		this.setBackground(CONSTANTS.BACKGROUND_COLOR);
		this.levelMax = levelMax;
		this.translationsVektor = new Point(0,0);
		this.selected = false;
		this.simplePathVector = new simplePath[levelMax];
		for(int level = 0; level < levelMax; level++) simplePathVector[level] = new simplePath();
		for(int level = 1; level < levelMax; level++) simplePathVector[level].setRotate(true);
	}
	// overrides paintComponent(Graphics g) in JPanel
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if(selected == false) setBackground(CONSTANTS.BACKGROUND_COLOR); else setBackground(CONSTANTS.SELECTED_COLOR);
		centerAndSize(g2);
		for(int level = 0; level < levelMax; level++) paintPath(g2,level);
	}
	// implements Observer
	public void update(Observable observable, Object translationsVektor) {
		this.translationsVektor = (Point)translationsVektor; 
		repaint();
	}
	// implements gridElementInterface	
	public gridElementInterface getGridElementUnderPoint(Point point) { return this; }
	public gridElementVector getGridElementVector() { return null; };
	public void setSelected(boolean selected) { this.selected = selected; repaint(); }
	public boolean isSelected() { return selected; }
	public JPanel getJPanel() { return this; }
	
	public void setStackLevel(int levelMax) {
		int savedOldLevel = this.levelMax;
		simplePath newSimplePathVector[] = new simplePath[levelMax];
		for(int level = 0; level < Math.min(savedOldLevel, levelMax); level++)
			newSimplePathVector[level] = simplePathVector[level];
		for(int level = Math.min(savedOldLevel, levelMax); level < levelMax; level++) 
			newSimplePathVector[level] = (simplePath)simplePathVector[savedOldLevel - 1].clone(); //clone last for new
		this.simplePathVector = newSimplePathVector;
		this.levelMax = levelMax;
	}
	
	// public Methods ----------------------------------------------------------------------------------------//
	public simplePath getSimplePath(int level) { return simplePathVector[level]; }
	
	// private Methods ----------------------------------------------------------------------------------------//
	private void centerAndSize(Graphics2D g2) {
		// Skalierung: Ausgangsquadrat mit Seitenl�nge 2 auf width bzw. height ausdehnen
		// und umdrehen d.h. y-Werte spiegeln (=> - in der y - Komponente)
		g2.scale(g2.getClipBounds().width/2,-g2.getClipBounds().height/2);
		 // Translation: bezieht sich bereits auf neue Gr��e! -1 wegen Spiegelung sonst translate(1/1)
		g2.translate(1,-1);
	}
		
	private void paintPath(Graphics2D g2, int level) {
		AffineTransform savedTransform = g2.getTransform();
		g2.setStroke(simplePathVector[level].getStroke());
		g2.setColor(simplePathVector[level].getColor());
		Point2D.Double scaledVektor = getScaledVektor(g2); 
		if(simplePathVector[level].isTranslate()) g2.translate(scaledVektor.x,scaledVektor.y);
		if(simplePathVector[level].isRotate()) g2.rotate(Math.atan(-translationsVektor.getY()/(translationsVektor.getX()+1)));
		if(simplePathVector[level].isShear()) g2.shear(scaledVektor.x,scaledVektor.y);
		if(simplePathVector[level].isScale()) g2.scale(1 + scaledVektor.x,1 + scaledVektor.y);
		g2.draw(simplePathVector[level].getTransformedPath());
		g2.setTransform(savedTransform);
	}
	
	private Point2D.Double getScaledVektor(Graphics2D g2) {
		return new Point2D.Double(translationsVektor.getX()/g2.getTransform().getScaleX()*CONSTANTS.MOUSE_SCALE_X,
															translationsVektor.getY()/g2.getTransform().getScaleY()*CONSTANTS.MOUSE_SCALE_Y);
	}
}
