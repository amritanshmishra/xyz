package com.app.towerDefense.critterFactory;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class BasicCritter extends Rectangle implements CritterType {

	/**
	 * Size of critter
	 */
	public int critterSize = 40;
	/**
	 * Critter path on map
	 */
	public static LinkedList<Point> critterPath;
	/**
	 * Cloned path on map
	 */
	public LinkedList<Point> critterPathClone;
	/**
	 * Critter start position
	 */
	public Point startPoint;
	/**
	 * Critter next position
	 */
	public Point nextPoint;
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
	/**
	 * Actual Speed of critter
	 */
	public int critterActualSpeed = 1;
	/**
	 * Current Speed of critter
	 */
	public int critterCurrentSpeed = 1;

	public boolean isSpeedSlow = false;

	public int slowCounter = 0;

	public boolean isBurning = false;

	public BasicCritter() {
	}

	public BasicCritter(int critterId, LinkedList<Point> critterPath, int movePoint, int actualHealth,
			int currentHealth, int value, int critterActualSpeed, int critterCurrentSpeed) {
		this.critterId = critterId;
		this.critterPath = critterPath;
		this.critterPathClone = cloneCritterPath(critterPath);
		this.startPoint = critterPathClone.pollFirst();
		this.movePoint = movePoint;
		this.y = startPoint.y;
		this.x = startPoint.x;
		this.nextPoint = critterPathClone.pollFirst();
		this.actualHealth = actualHealth;
		this.currentHealth = currentHealth;
		this.value = value;
		this.critterActualSpeed = critterActualSpeed;
		this.critterCurrentSpeed = critterCurrentSpeed;
	}

	@Override
	public void move(Graphics graphics) {

	}

	@Override
	public void update(Graphics g) {

	}

	@Override
	public LinkedList<Point> cloneCritterPath(LinkedList<Point> critterPath) {

		return null;
	}

	@Override
	public void draw(Graphics g) {

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

	@Override
	public int getCritterCurrentSpeed() {

		return 0;
	}

	@Override
	public boolean isSpeedSlow() {

		return false;
	}

	@Override
	public void setSpeedSlow(boolean isSpeedSlow) {

	}

	@Override
	public void setCritterCurrentSpeed(int critterCurrentSpeed) {

	}

	@Override
	public void setCritterId(int critterId) {

	}

	@Override
	public void setBurning(boolean isBurning) {

	}

	@Override
	public boolean isBurning() {

		return false;
	}

}
