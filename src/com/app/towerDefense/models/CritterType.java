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
	 * set the image for the critter
	 * 
	 *
	 */
	public void setCritterImage(String new_path);

	/**
	 * This method sets critters entry points parameters
	 * @param new_xEntry x coordinate of entry point
	 * @param new_yEntry y coordinate of entry point
	 */
	public void setXY(int new_xEntry, int new_yEntry);
	
	/**
	 * This method sets critters exit points parameters
	 * @param new_xExit x coordinate of exit point
	 * @param new_yExit y coordinate of exit point
	 */
	public void setXYExit(int new_xExit, int new_yExit);
	
	/**
	 * sets the id of the critter
	 * @param new_id critter id
	 */
	public void setID(int new_id);

	/**
	 * this method gets the block width on map panel
	 * @return block width
	 */
	public int getBlockW();
	
	/**
	 * this method gets the block height on map panel
	 * @return block height
	 */
	public int getBlockH();
	
	/**
	 * This method decrease the critter life by amount given
	 * @param new_power amount of hp to be substracted
	 * @return true if the critter is stayed alive , false if critter died
	 */
	public boolean decreaseLife(int new_power);
	
	/**
	 * gets the currency amount for critter that is killed
	 * @return amount of currency
	 */
	public int getValue();
	

}
