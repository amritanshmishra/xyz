package com.app.towerDefense.critterFactory;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.app.towerDefense.staticContent.ApplicationStatics;

@SuppressWarnings("serial")
public class BasicCritter implements CritterType {

	
	/**
	 * current X and Y position of critter
	 */
	public int x, y;
	public int directionX;
	public int directionY;
	public static int moveStandard = 0;
	private int i = 0;
	private int blockW, blockH;
	public Image image;
	
	/**
	 * Id of critter
	 */
	public int critterId;
	/**
	 * value of critter
	 */
	public int value;
	/**
	 * Actual Health of critter
	 */
	public int actualHealth;
	/**
	 * Current Health of critter
	 */
	public int currentHealth;



	public BasicCritter() {
		image = new ImageIcon("images/critter1.gif").getImage();
	}


	@Override
	public int getX() {

		return x;
	}

	@Override
	public int getY() {

		return y;
	}

	@Override
	public int getActualHealth() {

		return 0;
	}

	@Override
	public int getCurrentHealth() {

		return 0;
	}

	@Override
	public void setActualHealth(int actualHealth) {

	}

	@Override
	public void setCurrentHealth(int currentHealth) {

	}

	@Override
	public int getCritterId() {

		return 0;
	}
	
	@Override
	public void calculatePath() {

		
		directionY = ApplicationStatics.PATH_ARRAY1.get(i + 1).x - ApplicationStatics.PATH_ARRAY1.get(i).x;
		directionX = ApplicationStatics.PATH_ARRAY1.get(i + 1).y- ApplicationStatics.PATH_ARRAY1.get(i).y;

		x += directionX;
		y += directionY;
		
		if (x >= ApplicationStatics.PATH_ARRAY1.get(i+1).y* blockW && y >= ApplicationStatics.PATH_ARRAY1.get(i+1).x * blockH) {
				i++;
		}
		System.out.println("inside critter   x : "+x+" , y : "+y);

	}
	
	/**
	 * This method sets the button(blocks) parameters
	 */
	public void setBlocksParams(int new_w, int new_h){
		blockW = new_w;
		blockH = new_h;
	}


	@Override
	public Image getCritterImage() {
		// TODO Auto-generated method stub
		return image;
	}


	@Override
	public void setXY(int new_x, int new_y) {
		// TODO Auto-generated method stub
		x = new_x;
		y = new_y;
	}

}
