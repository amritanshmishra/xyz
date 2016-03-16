package com.app.towerDefense.guiComponents;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.app.towerDefense.critterFactory.CritterFactory;
import com.app.towerDefense.critterFactory.CritterType;
import com.app.towerDefense.models.MapModel;
import com.app.towerDefense.staticContent.ApplicationStatics;

public class MapPanel extends JPanel {

	private static final long serialVersionUID = -9082005090002375868L;
	int[][] array = new int[8][2];
	int n = 10;
	int m = 10;
	int width;
	int height;
	int blockW;
	int blockH;
	int i;
	int directionX;
	int directionY;

	boolean firstTime = true;
	boolean firstTime2 = true;

	int xStart = 0;
	int yStart = 0;
	
	int a = 0, b = 0;
	
	CritterType critter1;
	CritterType critter2;
	long count = 0;
	
	MapModel mapModel;

	public MapPanel(MapModel new_mapModel) {

		i = 0;
		mapModel = new_mapModel;

		// this.setBackground(new Color(205, 183, 158));
	}

	@Override
	protected void paintComponent(Graphics g) {

		if (ApplicationStatics.START_WAVE) {
		
			if (firstTime) {
				width = this.getWidth();
				height = this.getHeight();
				blockW = width / n;
				blockH = height / m;

				xStart = ApplicationStatics.PATH_ARRAY.get(i) * blockW;// + blockW / 3;
				yStart = ApplicationStatics.PATH_ARRAY.get(i+1) * blockH;// + blockH / 3;

				firstTime = false;

				System.out.println("blockW : " + blockW + " , blockH : " + blockH);

				for (int k = 0; k < ApplicationStatics.PATH_ARRAY.size(); k+=2) {
					System.out.println(k + " : x=" + ApplicationStatics.PATH_ARRAY.get(k) + " , y="
							+ ApplicationStatics.PATH_ARRAY.get(i+1));
				}
				
				critter1 = CritterFactory.getCritterfromFactory("BasicCritter");
				critter1.setBlocksParams(blockW, blockH);
				critter1.setXY(xStart, yStart);
				
				
				
				
			}
			
			if(firstTime2 && count > 50){
				critter2 = CritterFactory.getCritterfromFactory("BasicCritter");
				critter2.setBlocksParams(blockW, blockH);
				critter2.setXY(xStart, yStart);
				firstTime2 = false;
			}
			
			
			System.out.println("count : "+count);
			super.paintComponent(g);
			
			critter1.calculatePath();
			g.drawImage(critter1.getImage(), critter1.getX(), critter1.getY(), 30, 30, null);
			
			if(count > 60){
			critter2.calculatePath();
			g.drawImage(critter2.getImage(), critter2.getX(), critter2.getY(), 30, 30, null);
			}
			count++;
			
		}
	}

	

}
