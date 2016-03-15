package com.app.towerDefense.guiComponents;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.app.towerDefense.staticContent.ApplicationStatics;

public class MapPanel extends JPanel{

	private static final long serialVersionUID = -9082005090002375868L;
	int[][] array = new int[8][2];
	int n=10;
	int m = 10;
	int width = this.getWidth();
	int height = this.getHeight();
	int blockW = width/n;
	int blockH = height/m;
	

	int x = 0;
	int y = 0;
	Graphics g;
	
	
	public MapPanel(){
	array[0][0] = 0;
	array[0][1] = 0;
	
	array[1][0] = 1;
	array[1][1] = 0;
	
	array[2][0] = 2;
	array[2][1] = 0;
	
	array[3][0] = 3;
	array[3][1] = 0;
	
	array[4][0] = 3;
	array[4][1] = 1;
	
	array[5][0] = 3;
	array[5][1] = 2;
	
	array[6][0] = 3;
	array[6][1] = 3;
	
	array[7][0] = 3;
	array[7][1] = 4;
	
//	this.setBackground(new Color(205, 183, 158));
	}
	
	@Override
	protected void paintComponent(Graphics g){
		
	//	calculatePath(array);

		
		System.out.println("inside paintComponent in MapPanel Class x : "+x+" , y : "+y);
		
		if(ApplicationStatics.START_WAVE){
			incY();
		}
		
		
		super.paintComponent(g);
		g.setColor(Color.RED);  
		g.fillRect(x,y,40,40);
    //  g.dispose();
		System.out.println("w : "+ this.getWidth() + " , h : "+ this.getHeight());
	}
	
	public void incY(){
		y++;
	}
	
	public void calculatePath(int[][] array){
		
		int a = array[0][0];
		int b = array[0][1];
		
		x = a*blockW+blockW/3;
		y = b*blockH+blockH/3;
		
	}
	
	
}
