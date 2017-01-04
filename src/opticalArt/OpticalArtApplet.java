package opticalArt; 

//import java.applet.*;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JApplet;
import javax.swing.JFrame;

import opticalArt.pathes.gridPanel;

@SuppressWarnings("serial")
public class OpticalArtApplet extends JApplet {

	public static gridPanel oaViewer;

	public static void main(String args[]) {
		JFrame aFrame = new JFrame();
		aFrame.addWindowListener(
						new WindowAdapter() {
							public void windowClosing( WindowEvent e ) { Runtime.getRuntime().exit(0); }
						}
		);
		//opticalArtViewer oaViewer  = new opticalArtViewer();
		//boolean withSelectionPanel = false;
		//System.out.println(args.length + " " + withSelectionPanel);
		//if(args.length != 0 && args[0].equals("select")) withSelectionPanel = true;
		//System.out.println(args[0] + " " + withSelectionPanel);
		//oaViewer  = new gridJPanel(withSelectionPanel);
		oaViewer  = new gridPanel(3,3);
		aFrame.setContentPane(oaViewer);
		aFrame.setSize(new Dimension(650,650));
		aFrame.setLocation(130,30);
		aFrame.setVisible(true);
	};

	public void init() {
		//opticalArtViewer oaViewer  = new opticalArtViewer();
		//oaViewer = new gridJPanel(true);
		oaViewer  = new gridPanel(3,3);
		setContentPane(oaViewer);
	}
	
	public void destroy() {}
}

