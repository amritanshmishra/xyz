package com.app.towerDefense.critterFactory;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.ImageIcon;

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
	public int getX();

	/**
	 * getter method for Y
	 */
	public int getY();

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
	 * calculates the x and y for critter
	 */
	public void calculatePath();
	
	/**
	 * sets blocks parameters
	 * @param new_w width
	 * @param new_h height
	 */
	public void setBlocksParams(int new_w, int new_h);
	
	public Image getImage();
	
	public void setXY(int new_x, int new_y);

}
