package com.app.towerDefense.critterFactory;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.app.towerDefense.staticContent.ApplicationStatics;

/**
 * This class is the basic critter that would move on the map Contains different
 * methhods to create and move a critter on the map selected by player
 * 
 * @author Amritansh Mishra
 *
 */
public class BasicCritter implements CritterType {

	/**
	 * current X and Y position of critter
	 */
	public int x, y;
	public int directionX;
	public int directionY;
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

	/**
	 * Constructor to initialize the critter with image
	 */
	public BasicCritter() {
		image = new ImageIcon("images/critter1.gif").getImage();
	}

	/**
	 * Gets the x co-ordinate for critter
	 */
	@Override
	public int getX() {

		return x;
	}

	/**
	 * Gets the y co-ordinate for critter
	 */
	@Override
	public int getY() {

		return y;
	}

	/**
	 * Get actual health of the critter
	 */
	@Override
	public int getActualHealth() {

		return 0;
	}

	/**
	 * Returns the current health of the critter
	 */
	@Override
	public int getCurrentHealth() {

		return 0;
	}

	/**
	 * Setter method for actual critter health
	 */
	@Override
	public void setActualHealth(int actualHealth) {

	}

	/**
	 * Setter method for current critter health
	 */
	@Override
	public void setCurrentHealth(int currentHealth) {

	}

	/**
	 * Returns critter id
	 */
	@Override
	public int getCritterId() {

		return 0;
	}

	/**
	 * Calculates the path on which the critter would move
	 */
	@Override
	public void calculatePath() {

		directionY = ApplicationStatics.PATH_ARRAY1.get(i + 1).x - ApplicationStatics.PATH_ARRAY1.get(i).x;
		directionX = ApplicationStatics.PATH_ARRAY1.get(i + 1).y - ApplicationStatics.PATH_ARRAY1.get(i).y;

		
		
		if (x >= ApplicationStatics.PATH_ARRAY1.get(i + 1).y * blockW
				&& y >= ApplicationStatics.PATH_ARRAY1.get(i + 1).x * blockH) {
			i++;
			x += directionX;
			y += directionY;
		}
		else if(x >= ApplicationStatics.PATH_ARRAY1.get(i + 1).y * blockW
				&& y >= ApplicationStatics.PATH_ARRAY1.get(i + 1).x * blockH)
		
		System.out.println("inside critter   x : " + x + " , y : " + y);

	}

	/**
	 * This method sets the button(blocks) parameters
	 */
	public void setBlocksParams(int new_w, int new_h) {
		blockW = new_w;
		blockH = new_h;
	}

	/**
	 * This method returns the image used for the critter
	 */
	@Override
	public Image getCritterImage() {
		// TODO Auto-generated method stub
		return image;
	}

	/**
	 * This method sets the x and y co-ordinate for the critter
	 */
	@Override
	public void setXY(int new_x, int new_y) {
		// TODO Auto-generated method stub
		x = new_x;
		y = new_y;
	}

}
