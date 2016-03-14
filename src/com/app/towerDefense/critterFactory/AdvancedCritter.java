package com.app.towerDefense.critterFactory;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class AdvancedCritter extends Rectangle implements CritterType {

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

	/**
	 * Variable set when critter speed is to be slowed
	 */
	public boolean isSpeedSlow = false;
	/**
	 * counter to set critter slow speed
	 */
	public int slowCounter = 0;

	public boolean isBurning = false;

	public AdvancedCritter() {
	}

	/**
	 * @param critterId
	 * @param critterPath
	 * @param movePoint
	 * @param actualHealth
	 * @param currentHealth
	 * @param value
	 * @param critterActualSpeed
	 * @param critterCurrentSpeed
	 */
	public AdvancedCritter(int critterId, LinkedList<Point> critterPath, int movePoint, int actualHealth,
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
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public LinkedList<Point> cloneCritterPath(LinkedList<Point> critterPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public int Xvalue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Yvalue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getActualHealth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCurrentHealth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setActualHealth(int actualHealth) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCurrentHealth(int currentHealth) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getCritterId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCritterCurrentSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isSpeedSlow() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSpeedSlow(boolean isSpeedSlow) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCritterCurrentSpeed(int critterCurrentSpeed) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCritterId(int critterId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBurning(boolean isBurning) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isBurning() {
		// TODO Auto-generated method stub
		return false;
	}

}
