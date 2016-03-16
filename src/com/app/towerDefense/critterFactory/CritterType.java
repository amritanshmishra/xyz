package com.app.towerDefense.critterFactory;

import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

/**
 * This interface is defined as per factory pattern In this interface we define
 * the critter type and the basic methods associated with it which would be
 * latter used for creating different types of critters.
 * 
 * @author Amritansh Mishra
 *
 */
public interface CritterType {

	
	/**
	 * getter method for X
	 */
	public int Xvalue();

	/**
	 * getter method for Y
	 */
	public int Yvalue();

	/**
	 * getter method for actualhealth
	 */
	public int getActualHealth();

	/**
	 * getter method for currenthealth
	 */
	public int getCurrentHealth();

	/**
	 * Setter method for actualhealth
	 */
	public void setActualHealth(int actualHealth);

	/**
	 * setter method for currenthealth
	 */
	public void setCurrentHealth(int currentHealth);

	/**
	 * getter method for CritterId
	 */
	public int getCritterId();


}
