package com.app.towerDefense.critterFactory;

import java.awt.Image;

/**
 * This class is the advanced critter that would move on the map Contains
 * different methhods to create and move a critter on the map selected by player
 * 
 * @author Amritansh Mishra
 *
 */
public class AdvancedCritter implements CritterType {

	/**
	 * current X and Y position of critter
	 */
	private int x, y;
	public int movePoint;

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
	 * Getter method for x co-ordinate of critter
	 */
	public int getX() {
		return x;
	}

	/**
	 * Getter method for y co-ordinate of critter
	 */
	public int getY() {
		return y;
	}

	/**
	 * Default constructor for advanced critter
	 */
	public AdvancedCritter() {
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
		// TODO Auto-generated method stub

	}

	/**
	 * This method sets the button(blocks) parameters
	 */
	@Override
	public void setBlocksParams(int new_w, int new_h) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method returns the image used for the critter
	 */
	@Override
	public Image getCritterImage() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method sets the x and y co-ordinate for the critter
	 */
	@Override
	public void setXY(int new_x, int new_y) {
		// TODO Auto-generated method stub

	}
}