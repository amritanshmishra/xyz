package com.app.towerDefense.models;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.app.towerDefense.staticContent.ApplicationStatics;

import javafx.beans.InvalidationListener;

/**
 * This class is the basic critter that would move on the map Contains different
 * methhods to create and move a critter on the map selected by player
 * 
 * @author Amritansh Mishra
 *
 */
public class BasicCritter extends java.util.Observable implements CritterType {

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
	int xExit;
	int yExit;

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
	public boolean calculatePath() {

		// System.out.println("i : "+i+" , arraysize : "+
		// (ApplicationStatics.PATH_ARRAY1.size()-1));

		if (i == ApplicationStatics.PATH_ARRAY1.size() - 1) {
			return false;
		}

		// && x == xExit && y == yExit

		xNext = ApplicationStatics.PATH_ARRAY1.get(i + 1).y * blockW;
		yNext = ApplicationStatics.PATH_ARRAY1.get(i + 1).x * blockH;
		directionY = ApplicationStatics.PATH_ARRAY1.get(i + 1).x - ApplicationStatics.PATH_ARRAY1.get(i).x;
		directionX = ApplicationStatics.PATH_ARRAY1.get(i + 1).y - ApplicationStatics.PATH_ARRAY1.get(i).y;
		// System.out.println("Inside calculate path");

		if (directionX == 1 || directionX == -1) {
			if (x == xNext) {
				System.out.println("inside 1 :" + (i++));
				// i++;
			}
		} else if (directionX == 0) {
			if (directionY == 1 || directionY == -1) {
				if (y == yNext) {
					System.out.println("inside 2" + (i++));
					// i++;
				}
			}
		}
		x += directionX;
		y += directionY;

		setChanged();
		notifyObservers();
		// System.out.println("inside critter x : " + x + " , y : " + y);

		return true;

	}

	/**
	 * This method sets the button(blocks) parameters
	 */
	public void setBlocksParams(int new_w, int new_h) {
		blockW = new_w;
		blockH = new_h;
		System.out.println("blockW:" + blockW + " blockH:" + blockH);
	}

	/**
	 * This method returns the image used for the critter
	 */
	@Override
	public Image getCritterImage() {

		return image;
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

	/**
	 * Add a listner
	 */
	@Override
	public void addListener(InvalidationListener new_listner) {
		// TODO Auto-generated method stub

	}

	/**
	 * Remove the listner
	 */
	@Override
	public void removeListener(InvalidationListener new_listner) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method sets the initial x and y coordinates for the critter
	 */
	@Override
	public void setXY(int new_xEntry, int new_yEntry) {
		// TODO Auto-generated method stub
		x = new_xEntry;
		y = new_yEntry;
		System.out.println("myX : " + x + " , myY : " + y);

	}

	/**
	 * This method sets the exit x and y coordinates for the critter
	 */
	@Override
	public void setXYExit(int new_xExit, int new_yExit) {
		// TODO Auto-generated method stub
		xExit = new_xExit;
		yExit = new_yExit;
	}

}
