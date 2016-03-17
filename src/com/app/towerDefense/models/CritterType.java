package com.app.towerDefense.models;

import java.awt.Image;

import javafx.beans.Observable;

/**
 * This interface is defined as per factory pattern. In this interface we define
 * the critter type and the basic methods associated with it which would be
 * later used for creating different types of critters.
 * 
 * @author Amritansh Mishra
 *
 */
public interface CritterType extends Observable {

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
	 * 
	 * @return true if the path is eligible
	 */
	public boolean calculatePath();

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
	 * This method sets critters entry and exit points parameters
	 * 
	 * @param new_xEntry
	 *            x coordinate of entry point
	 * @param new_yEntry
	 *            y coordinate of entry point
	 * @param new_xExit
	 *            x coordinate of exit point
	 * @param new_yExit
	 *            y coordinate of exit point
	 */
	public void setXY(int new_xEntry, int new_yEntry);

	public void setXYExit(int new_xExit, int new_yExit);

	/**
	 * This method sets the critter id
	 * 
	 * @param new_id
	 */
	public void setID(int new_id);

	/**
	 * This method returns the block width
	 * 
	 * @return
	 */
	public int getBlockW();

	/**
	 * This method returns the block height
	 * 
	 * @return
	 */
	public int getBlockH();

}
