package com.app.towerDefense.guiComponents;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MapPanel extends JPanel{

	private static final long serialVersionUID = -9082005090002375868L;
	
	@Override
	protected void paintComponent(Graphics g){
		
		System.out.println("inside paintComponent in MapPanel Class");
		super.paintComponent(g);
		g.setColor(Color.RED);  
        g.fillRect(0,10,40,40);
		
	}
}
