package com.app.towerDefense.critterFactory;

import java.awt.Image;

@SuppressWarnings("serial")
public class AdvancedCritter implements CritterType {

	/**
	 * current X and Y position of critter
	 */
	private int x, y;
	public int movePoint;
	public static int moveStandard = 0;
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
	 * 
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * 
	 */
	public int getY(){
		return y;
	}

	
	public AdvancedCritter() {
	}


	@Override
	public int getActualHealth() {

		return 0;
	}

	@Override
	public int getCurrentHealth() {

		return 0;
	}

	@Override
	public void setActualHealth(int actualHealth) {

	}

	@Override
	public void setCurrentHealth(int currentHealth) {

	}

	@Override
	public int getCritterId() {

		return 0;
	}


	@Override
	public void calculatePath() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setBlocksParams(int new_w, int new_h) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Image getCritterImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setXY(int new_x, int new_y) {
		// TODO Auto-generated method stub
		
	}
}
