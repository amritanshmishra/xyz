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

				a = array[i][0];
				b = array[i][1];
				x = a * blockW + blockW / 3;
				y = b * blockH + blockH / 3;

				firstTime = false;

				for(int k = 0; k<6; k++){
					System.out.println(k+" : x="+ApplicationStatics.PATH_ARRAY[k][0]+" , y="+ApplicationStatics.PATH_ARRAY[k][1] );
				}
				
			}

			calculatePath(ApplicationStatics.PATH_ARRAY);

			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillRect(x, y, 30, 30);
			// g.dispose();
			// System.out.println("w : " + this.getWidth() + " , h : " +
			// this.getHeight());
		}
	}

	public void calculatePath(int[][] array) {

		if (i < array.length) {
			if (y > (array[i + 1][1]+1) * blockH) {
				System.out.println("here y i++");
				i++;
			}else if (x > (array[i + 1][0]+1) * blockW) {
				i++;
				System.out.println("here x i++");
				
			}
			System.out.println("x : " + x + " , y : " + y + " , blockW : " + ((array[i + 1][0]+1) * blockW) + " , blockH : "+ ((array[i + 1][1]+1) * blockH));
		}
		
		directionY = array[i + 1][0] - array[i][0];
		directionX = array[i + 1][1] - array[i][1];

		x += directionX;
		y += directionY;

		

	}

}
