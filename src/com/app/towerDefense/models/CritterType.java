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
	 * @return X
	 */
	public int getX();

	/**
	 * getter method for Y
	 * @return Y
	 */
	public int getY();

	/**
	 * Getter method for actualhealth
	 * @return critter actual Health
	 */
	public int getActualHealth();

	/**
	 * Getter method for currenthealth
	 * @return critter Health
	 */
	public int getCurrentHealth();

	/**
	 * Getter method for CritterId
	 * @return critter id
	 */
	public int getCritterId();

	/**
	 * Calculates the path on which the critter would move.
	 * @return true if the path is eligible
	 */
	public boolean calculatePath();

	/**
	 * Returns the image for the critter
	 * 
	 * @return critter image
	 */
	public Image getCritterImage();
	
	/**
	 * set the image for the critter
	 * @param new_path image path
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
	 * 
	 */

	public void setXYExit(int new_xExit, int new_yExit);
	
	/**
	 * sets the id of the critter
	 * @param new_id critter id
	 */
	public void setID(int new_id);

	
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
	
	/**
	 * This method returns the speed value of the critter
	 * @return speed value
	 */
	public int getSpeed();
	
	/**
	 * This method decreases the speed value of the critter
	 */
	public void slowSpeed();
	
	/**
	 * This method burns the critter for amount after being hit by burning tower
	 * @param new_amount amount to burn
	 */
	public void burnHealth(int new_amount);

	/**
	 * This method kills critter if health reached zero and deletes the object
	 * @return true if critter is killed
	 */
	public boolean killCritter();
	
	/**
	 * This method splashes the damage around the critter to near by critters
	 * @param new_amount amount of damage to be splashed
	 */
	public void splashDamage(int new_amount);
	
	/**
	 * This method returns the critter health bar object
	 * @return critter health bar object
	 */
	public CritterHealthBar getHealthBar();
	
	/**
	 * This method returns the boolean when we can draw the splash area circle
	 * @return true if splash effect has occurred
	 */
	public boolean getShowSplashArea();
}
