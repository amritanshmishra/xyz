package com.app.towerDefense.guisystem;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel{

	private static final long serialVersionUID = -359613517625613037L;

	
// MAP WINDOW Constructor
	public GamePanel(int width, int height){
			
		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));
			
		this.setBackground(Color.CYAN);
				
	}
		
		
		
	// END	
}
