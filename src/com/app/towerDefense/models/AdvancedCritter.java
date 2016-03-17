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
	 * This method sets the id for the advanced critter
	 */
	@Override
	public void setID(int new_id) {
		// TODO Auto-generated method stub

	}

	/**
	 * Returns block width
	 */
	@Override
	public int getBlockW() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Returns block height
	 */
	@Override
	public int getBlockH() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * This method adds a listner
	 */
	@Override
	public void addListener(InvalidationListener new_listener) {
		// TODO Auto-generated method stub

	}

	/**
	 * This method removes the listner
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
}
