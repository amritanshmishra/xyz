package com.app.towerDefense.guiComponents;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

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

	int x = 0;
	int y = 0;
	Graphics g;

	int a = 0, b = 0;

	public MapPanel() {

		i = 0;

		// this.setBackground(new Color(205, 183, 158));
	}

	@Override
	protected void paintComponent(Graphics g) {

		if (ApplicationStatics.START_WAVE) {
			// System.out.println("inside paintComponent in MapPanel Class x : "
			// + x + " , y : " + y);

			if (firstTime) {
				width = this.getWidth();
				height = this.getHeight();
				blockW = width / n;
				blockH = height / m;

				a = ApplicationStatics.PATH_ARRAY.get(i);
				b = ApplicationStatics.PATH_ARRAY.get(i+1);
				x = a * blockW;// + blockW / 3;
				y = b * blockH;// + blockH / 3;

				firstTime = false;

				System.out.println("blockW : " + blockW + " , blockH : " + blockH);

				for (int k = 0; k < ApplicationStatics.PATH_ARRAY.size(); k+=2) {
					System.out.println(k + " : x=" + ApplicationStatics.PATH_ARRAY.get(k) + " , y="
							+ ApplicationStatics.PATH_ARRAY.get(i+1));
				}

			}

			calculatePath();

			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillRect(x, y, 30, 30);
			// g.dispose();
			// System.out.println("w : " + this.getWidth() + " , h : " +
			// this.getHeight());
		}
	}

	public void calculatePath() {

		
		directionY = ApplicationStatics.PATH_ARRAY.get(i + 2) - ApplicationStatics.PATH_ARRAY.get(i);
		directionX = ApplicationStatics.PATH_ARRAY.get(i + 3) - ApplicationStatics.PATH_ARRAY.get(i+1);

		x += directionX;
		y += directionY;
		
		if (i < array.length) {
	//		System.out.println("x : " + x + " , y : " + y + " , blockW : " + ((array[i + 1][1]) * blockW) + " , blockH : "+ ((array[i + 1][0]) * blockH));
			
			if (x >= ApplicationStatics.PATH_ARRAY.get(i+3)* blockW && y >= ApplicationStatics.PATH_ARRAY.get(i+2) * blockH) {
				i+=2;
			}
		}

	}

}
