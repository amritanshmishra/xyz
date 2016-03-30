package com.app.towerDefense.models;

import java.awt.Image;

import javafx.beans.InvalidationListener;

/**
 * This class will be implemented as part of the final build. This class is the
 * advanced critter that would move on the map Contains different methhods to
 * create and move a critter on the map selected by player
 * 
 * @author Amritansh Mishra
 *
 */
public class AdvancedCritter extends java.util.Observable implements CritterType {

	/**
	 * current X and Y position of critter
	 */
	private int x, y;

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
	public boolean calculatePath() {
		// TODO Auto-generated method stub
		return true;
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
	 * This method sets the id for the advanced critter
	 */
	@Override
	public void setID(int new_id) {
		// TODO Auto-generated method stub

	}


	/**
	 * This method adds a listener
	 */
	@Override
	public void addListener(InvalidationListener new_listener) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method removes the listener
	 */
	@Override
	public void removeListener(InvalidationListener new_listener) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method sets the entry point for the advanced critter
	 */
	@Override
	public void setXY(int new_xEntry, int new_yEntry) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method sets the exit point for the advanced critter
	 */
	@Override
	public void setXYExit(int new_xExit, int new_yExit) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * This method decreases life a critter by a given number
	 */
	@Override
	public boolean decreaseLife(int new_power) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * This method returns the currency value of the critter
	 */
	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * This method sets the critter image path to new one
	 */
	@Override
	public void setCritterImage(String new_path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void slowSpeed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void burnHealth(int new_amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean killCritter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void splashDamage(int new_amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CritterHealthBar getHealthBar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getShowSplashArea() {
		// TODO Auto-generated method stub
		return false;
	}
}
