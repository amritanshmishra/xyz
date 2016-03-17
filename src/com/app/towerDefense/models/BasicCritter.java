package com.app.towerDefense.models;

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
	private int critterId;
	int xNext;
	int yNext;

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
		image = new ImageIcon(ApplicationStatics.IMAGE_PATH_CRITTER).getImage();
		actualHealth = 10;
		currentHealth = actualHealth;
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

		return actualHealth;
	}

	/**
	 * Returns the current health of the critter
	 */
	@Override
	public int getCurrentHealth() {

		return currentHealth;
	}

	/**
	 * Returns critter id
	 */
	@Override
	public int getCritterId() {

		return critterId;
	}

	/**
	 * Calculates the path on which the critter would move
	 */
	@Override
	public void calculatePath() {

		xNext = ApplicationStatics.PATH_ARRAY1.get(i + 1).y * blockW;
		yNext = ApplicationStatics.PATH_ARRAY1.get(i + 1).x * blockH;
		directionY = ApplicationStatics.PATH_ARRAY1.get(i + 1).x - ApplicationStatics.PATH_ARRAY1.get(i).x;
		directionX = ApplicationStatics.PATH_ARRAY1.get(i + 1).y - ApplicationStatics.PATH_ARRAY1.get(i).y;

		if (directionX == 1 || directionX == -1) {
			if (x == xNext) {
				System.out.println("inside 1 :" + (i++));
			}
		} else if (directionX == 0) {
			if (directionY == 1 || directionY == -1) {
				if (y == yNext) {
					System.out.println("inside 2" + (i++));
				}
			}
		}
		x += directionX;
		y += directionY;

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

		return image;
	}

	/**
	 * This method sets the x and y co-ordinate for the critter
	 */
	@Override
	public void setXY(int new_x, int new_y) {

		x = new_x;
		y = new_y;
	}

	/**
	 * This method sets the id for the basic critter
	 */
	@Override
	public void setID(int new_id) {

		critterId = new_id;
	}

	/**
	 * @return the blockW
	 */
	public int getBlockW() {
		return blockW;
	}

	/**
	 * @return the blockH
	 */
	public int getBlockH() {
		return blockH;
	}
	
	

}
