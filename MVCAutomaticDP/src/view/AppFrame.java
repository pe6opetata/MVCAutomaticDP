package view;

import java.awt.Dimension;

import javax.swing.JFrame;

import controller.Controller;

@SuppressWarnings("serial")
public class AppFrame extends JFrame {
	
	private AppPanel basePanel;
	
	public AppFrame(Controller baseController) {
		basePanel = new AppPanel(baseController);
		
		setupFrame();
		
	}
	
	public AppPanel getAppPanel() {
		return this.basePanel;
	}

	private void setupFrame(){
		this.getContentPane().add(basePanel);
		this.setTitle("AutomaticDP");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(400, 200));
		this.setVisible(true);
	}
}
