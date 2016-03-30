package com.app.towerDefense.models;
/**
 * 
 */

import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.app.towerDefense.guiComponents.MapPanel;
import com.app.towerDefense.staticContent.ApplicationStatics;

import javafx.scene.shape.Circle;

/**
 * Tower abstract class is the super-typer of all types of objects produced by
 * the TowerFactory.
 * 
 * @author George Ekow-Daniels
 *
 */
public abstract class Tower implements Observer {

	public int towerID;
	protected String towerName;
	protected int towerRange;
	protected int towerPower;
	protected int towerFireRate;
	protected int towerCost;
	protected int towerlevel;
	protected Icon towerImage;
	protected String towerImagePath;
	protected Dimension TowerCordinate;
	protected int towerUpgradeCost;
	protected int towerlevelUpgrade;
	protected int towerPowerUpgrade;
	protected int towerFireRateUpgrade;
	protected int towerFireRangeUpgrade;
	protected int x, y;
	protected Strategy strategy;
	protected int isBusy = -1; // if not -1, then tower has a target
	protected String specialEffect;

	protected double xt, yt, dtw, dth; // x,y coordinates of range circle and
										// diameters

	protected Timer timer; // timer for shooting
	protected boolean shoot = true; // shoots when value is true

	/**
	 * Constructor
	 */
	public Tower() {
		timer = new Timer();
	}

	/**
	 * This method gets the name of the tower
	 * 
	 * @return the tower name
	 */
	public abstract String getTowerName();

	/**
	 * This method sets the Tower name
	 * 
	 */
	public abstract void setTowerName();

	/**
	 * This method gets the value the value for range upgrade
	 * 
	 * @return the tower fire range upgrade value
	 */
	public abstract int getTowerFireRangeUpgrade();

	/**
	 * This method sets the tower fire range upgrade value
	 * 
	 */
	public abstract void setTowerFireRangeUpgrade();

	/**
	 * This method gets the
	 * 
	 * @return the tower range
	 */
	public abstract int getTowerRange();

	/**
	 * This is the method for setting the tower range
	 * 
	 */
	public abstract void setTowerRange();

	/**
	 * This method gets tower power
	 * 
	 * @return the tower power
	 */
	public abstract int getTowerPower();

	/**
	 * The method sets the <b>power</b> of the tower
	 * 
	 */
	public abstract void setTowerPower();

	/**
	 * This set the firing rate of a tower
	 * 
	 * @return the fire rate of a tower
	 */
	public abstract int getTowerFireRate();

	/**
	 * This method sets the firing rate of a tower
	 * 
	 */
	public abstract void setTowerFireRate();

	/**
	 * This method gets the current cost of towers
	 * 
	 * @return the cost of tower
	 */
	public abstract int getTowerCost();

	/**
	 * This method sets the cost of the tower
	 * 
	 */
	public abstract void setTowerCost();

	/**
	 * This method gets the tower level
	 * 
	 * @return the current tower level
	 */
	public abstract int getTowerlevel();

	/**
	 * This method sets the tower level
	 *
	 */
	public abstract void setTowerlevel();

	/**
	 * This method sets the tower image
	 * 
	 * @return the tower image
	 */
	public abstract Icon getTowerImage();

	/**
	 * This method sets the image of the tower
	 */
	public abstract void setTowerImage();

	/**
	 * This method gets the tower coordinates
	 * 
	 * @return the tower coordinate
	 */
	public abstract Dimension getTowerCordinate();

	/**
	 * This method sets the tower coordinate
	 *
	 */
	public abstract void setTowerCordinate();

	/**
	 * This method gets upgrade cost of a tower
	 * 
	 * @return the tower upgrade cost
	 */
	public abstract int getTowerUpgradeCost();

	/**
	 * This method sets the tower upgrade cost
	 * 
	 */
	public abstract void setTowerUpgradeCost();

	/**
	 * This method gets tower upgrade level
	 * 
	 * @return the tower level upgrade
	 */
	public abstract int getTowerlevelUpgrade();

	/**
	 * This method sets level upgrade of a tower
	 *
	 */
	public abstract void setTowerlevelUpgrade();

	/**
	 * This method gets power upgrade of a tower
	 * 
	 * @return the tower power upgrade
	 */
	public abstract int getTowerPowerUpgrade();

	/**
	 * This method sets tower power upgrade
	 * 
	 */
	public abstract void setTowerPowerUpgrade();

	/**
	 * This method gets the fire rate update of a tower
	 * 
	 * @return the tower fire rate update
	 */
	public abstract int getTowerFireRateUpgrade();

	/**
	 * This method sets the tower firing rate upgrade
	 * 
	 */
	public abstract void setTowerFireRateUpgrade();

	/**
	 * This method get the tower model's X coordinate
	 * 
	 * @return x coordinate of tower model
	 */
	public abstract int getX();

	/**
	 * This method get the tower model's Y coordinate
	 * 
	 * @return y coordinate of tower model
	 */
	public abstract int getY();

	/**
	 * This method sets the X and Y coordinates of the tower model
	 * 
	 * @param new_x
	 *            x axis
	 * @param new_y
	 *            y axis
	 */
	public abstract void setXY(int new_x, int new_y);

	/**
	 * This method upgrades Tower
	 */
	public abstract void upgradeTower();

	/**
	 * This method calculates the amount for refund after a sell of a tower
	 * 
	 * @return the value of the tower
	 */
	public abstract int getRefund();

	/**
	 * Plugs in a specific strategy to be used
	 * 
	 * @param new_strategy
	 *            Strategy object
	 */
	public abstract void setStrategy(Strategy new_strategy);

	/**
	 * Method that executes a different strategy depending on what strategy was
	 * plugged in upon instantiation.
	 */
	public abstract void executeStrategy();

	/**
	 * update method that called when observable called its function notify
	 * updates the location between tower and critter if it in range of tower,
	 * get shot
	 * 
	 * @param new_critter
	 *            observable critter
	 * @param new_x
	 *            the object
	 */
	public void update(Observable new_critter, Object new_x) {
		if (((BasicCritter) new_critter).isDead == true) {
			isBusy = -1;
			shoot = true;
			// System.out.println("critter null");
		} else {

			int bW = ApplicationStatics.BLOCK_WIDTH;
			int bH = ApplicationStatics.BLOCK_HEIGHT;

			int xCr = ((CritterType) new_critter).getX() + bW / 3;
			int yCr = ((CritterType) new_critter).getY() + bH / 3;

			Ellipse2D ellipse = new Ellipse2D.Double(xt, yt, dtw, dth);
			if (isBusy == -1 || isBusy == ((CritterType) new_critter).getCritterId()) {
				// critter is in range of tower
				if (ellipse.contains(xCr, yCr)) {
					if (shoot) {

						isBusy = ((CritterType) new_critter).getCritterId();

						if (((CritterType) new_critter).decreaseLife(getTowerPower())) {
							System.out.println("Tower " + getTowerName() + " id:" + towerID + " shoots critter id:"
									+ ((CritterType) new_critter).getCritterId() + " damage:" + getTowerPower());

							MapPanel.drawLines(getY() * bW + bW / 2, getX() * bH + bH / 2, xCr, yCr, getTowerName(),
									((CritterType) new_critter).getCritterId());
								
							if (getSpecialEffect() == "Freeze") {
								((CritterType) new_critter).setCritterImage(ApplicationStatics.IMAGE_PATH_CRITTER_FROZEN);
								((CritterType) new_critter).slowSpeed();
							} else if (getSpecialEffect() == "Burn") {
								((CritterType) new_critter).setCritterImage(ApplicationStatics.IMAGE_PATH_CRITTER_BURN);
								((CritterType) new_critter).burnHealth(getTowerPower());
							} else if (getSpecialEffect() == "Splash") {
						//		((CritterType) new_critter).setCritterImage(ApplicationStatics.IMAGE_PATH_CRITTER_SPLASH);
								((CritterType) new_critter).splashDamage(getTowerPower());
							}
							
						}

						if (((CritterType) new_critter).killCritter()) {
							isBusy = -1;
						}

						

						shoot = false;
						timer.schedule(new TimerTask() {
							@Override
							public void run() {
								// Your database code here
								shoot = true;
							}
						}, 1500);
					}

				} else {
					isBusy = -1;

				}

			}
		}

	}

	/*
	 * This method returns the tower x coordinate
	 * 
	 * @return x coordinate
	 */
	public double getXT() {
		return xt;
	}

	/*
	 * This method returns the tower y coordinate
	 * 
	 * @return y coordinate
	 */
	public double getYT() {
		return yt;
	}

	/**
	 * This method returns the special effect name
	 * 
	 * @return special effect name
	 */
	public String getSpecialEffect() {
		return specialEffect;
	}

	/**
	 * This method sets the special effect for the tower
	 * 
	 * @param new_str
	 *            gets special effect name
	 */
	public void setSpecialEffect(String new_str) {
		specialEffect = new_str;
	}

	/**
	 * This method calculates the tower range circle area, top left x and y
	 * coordinates
	 */
	public void calculateRangeCircleCoordinates() {

		int bW = ApplicationStatics.BLOCK_WIDTH;
		int bH = ApplicationStatics.BLOCK_HEIGHT;
		// System.out.println("BWBH "+bW+" "+bH);

		double rangeT = (double) getTowerRange() / 100 - 1;
		if (rangeT == -1) {
			rangeT = 0;
		}

		xt = y * bW - bW - bW * rangeT;
		yt = x * bH - bH - bH * rangeT;

		// calculation the range circle diameter
		rangeT *= 2;
		dtw = ApplicationStatics.BLOCK_WIDTH * 3 + ApplicationStatics.BLOCK_WIDTH * rangeT;
		dth = ApplicationStatics.BLOCK_HEIGHT * 3 + ApplicationStatics.BLOCK_HEIGHT * rangeT;
	}

	/**
	 * This method returns the diameter in width of range circle of the tower
	 * 
	 * @return diameter value width
	 */
	public double getDTW() {
		return dtw;
	}

	/**
	 * This method returns the diameter in height of range circle of the tower
	 * 
	 * @return diameter value height
	 */
	public double getDTH() {
		return dth;
	}

}
