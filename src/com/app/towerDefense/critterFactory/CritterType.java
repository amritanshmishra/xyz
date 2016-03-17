package com.app.towerDefense.critterFactory;

import java.awt.Image;

/**
 * This interface is defined as per factory pattern. In this interface we define
 * the critter type and the basic methods associated with it which would be
 * later used for creating different types of critters.
 * 
 * @author Amritansh Mishra
 *
 */
public interface CritterType {

	/**
	 * Getter method for X
	 */
	public int getX();

	/**
	 * getter method for Y
	 */
	public int getY();

	/**
	 * Getter method for actualhealth
	 */
	public int getActualHealth();

	/**
	 * Getter method for currenthealth
	 */
	public int getCurrentHealth();

	/**
	 * Getter method for CritterId
	 */
	public int getCritterId();

	/**
	 * Calculates the path on which the critter would move.
	 */
	public void calculatePath();

	/**
	 * Sets blocks parameters. Blocks are buttons on the map This method allows
	 * us to set the block width and height
	 * 
	 * @param new_w
	 *            width
	 * @param new_h
	 *            height
	 */
	public void setBlocksParams(int new_w, int new_h);

	/**
	 * Returns the image for the critter
	 * 
	 * @return
	 */
	public Image getCritterImage();

	/**
	 * Set the x and y co-ordinate for critter
	 * 
	 * @param new_x
	 * @param new_y
	 */
	public void setXY(int new_x, int new_y);
	
	public void setID(int new_id);

}
