package com.app.towerDefense.critterFactory;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class AdvancedCritter extends Rectangle implements CritterType {

	/**
	 * current X and Y position of critter
	 */
	public int x, y;
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



	public AdvancedCritter() {
	}


	@Override
	public int Xvalue() {

		return 0;
	}

	@Override
	public int Yvalue() {

		return 0;
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
}
