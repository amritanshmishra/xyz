package com.app.towerDefense.guisystem;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;


public class MapWindow extends Canvas{

	private static final long serialVersionUID = 5864132585204978587L;

// MAP WINDOW Constructor
	public MapWindow(int width, int height){
		
		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));
		
		this.setBackground(Color.GREEN);
			
	}
	
	
	
// END	
}
