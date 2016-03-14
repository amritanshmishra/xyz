package com.app.towerDefense.guiComponents;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MapPanel extends JPanel{

	private static final long serialVersionUID = -9082005090002375868L;
	
	int x = 0;
	int y = 0;
	Graphics g;
	public MapPanel(){
//		this.setBackground(new Color(205, 183, 158));
	}
	@Override
	protected void paintComponent(Graphics g){
		
		System.out.println("inside paintComponent in MapPanel Class x : "+x+" , y : "+y);
		this.g = g;
		super.paintComponent(g);
		g.setColor(Color.RED);  
        g.fillRect(x,y,40,40);
    //  g.dispose();
		
	}
	
	public void incY(){
		y++;
	}
	
}
