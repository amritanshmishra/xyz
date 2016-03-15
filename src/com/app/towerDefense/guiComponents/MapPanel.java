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

		array[0][0] = 0;
		array[0][1] = 0;

		array[1][0] = 0;
		array[1][1] = 1;

		array[2][0] = 0;
		array[2][1] = 2;

		array[3][0] = 0;
		array[3][1] = 3;

		array[4][0] = 1;
		array[4][1] = 3;

		array[5][0] = 2;
		array[5][1] = 3;

		array[6][0] = 3;
		array[6][1] = 3;

		array[7][0] = 4;
		array[7][1] = 3;

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

			}

			calculatePath(array);

			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillRect(x, y, 30, 30);
			// g.dispose();
			// System.out.println("w : " + this.getWidth() + " , h : " +
			// this.getHeight());
		}
	}

	public void calculatePath(int[][] array) {

		directionX = array[i + 1][0] - array[i][0];
		directionY = array[i + 1][1] - array[i][1];

		x += directionY;
		y += directionX;

		if (i < array.length) {
			if (y > array[i + 1][1] * blockH) {
				i++;
			}else if (x > array[i + 1][0] * blockW) {
				i++;
			}
			System.out.println("x : " + x + " , y : " + y + " , blockW : " + array[i + 1][0] * blockW + " , blockH : "
					+ array[i + 1][1] * blockH);
		}

	}

}
