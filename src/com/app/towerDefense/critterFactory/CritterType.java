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
	 * This method move critters on the map
	 * 
	 * @param graphics
	 */
	public void move(Graphics graphics);

	/**
	 * This method updates critter movement
	 * 
	 * @param g
	 */
	public void update(Graphics g);

	/**
	 * This method clone critter movement
	 * 
	 * @param critterPath
	 * @return
	 */
	public LinkedList<Point> cloneCritterPath(LinkedList<Point> critterPath);

	/**
	 * Draw critters on map
	 * 
	 * @param g
	 */
	public void draw(Graphics g);

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

	/**
	 * getter method for CurrentSpeed()
	 */
	public int getCritterCurrentSpeed();

	/**
	 * getter method for isSpeedSlow
	 */
	public boolean isSpeedSlow();

	/**
	 * getter method for CritterId
	 */
	public void setSpeedSlow(boolean isSpeedSlow);

	/**
	 * getter method for CritterCurrentSpeed
	 */
	public void setCritterCurrentSpeed(int critterCurrentSpeed);

	/**
	 * setter method for CritterId
	 */
	public void setCritterId(int critterId);

	public void setBurning(boolean isBurning);

	public boolean isBurning();
}
