package com.app.towerDefense.models;
/**
 * 
 */

import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;

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
	protected int[] counter = new int[100];
	protected Strategy strategy;
	protected int isBusy = -1;
	protected String specialEffect;

	public double xt, yt, dt;

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
	 * @param strategy
	 *            object
	 */
	public abstract void setStrategy(Strategy strategy);

	/**
	 * Method that executes a different strategy depending on what strategy was
	 * plugged in upon instantiation.
	 */
	public abstract void executeStrategy();

	/**
	 * update method that called when observable called its function notify
	 * updates the location between tower and critter
	 * if it in range of tower, get shot
	 */
	public void update(Observable critter, Object x) {

		int bW = ApplicationStatics.BLOCK_WIDTH;
		int bH = ApplicationStatics.BLOCK_HEIGHT;

		// tower coord
		int xpix = (this.getY() * bW) - bW;// +ApplicationStatics.BLOCK_HEIGHT;
		int ypix = (this.getX() * bH) - bH;// +ApplicationStatics.BLOCK_WIDTH;

		int xCr = ((CritterType) critter).getX() + bW / 3;
		int yCr = ((CritterType) critter).getY() + bH / 3;

		// double d = Math.sqrt((bW+bW/2)*(bW+bW/2)+(bH+bH/2)*(bH+bH/2))+5;

		// xpix -= (bW);
		// ypix -= (bH);

		xt = xpix;
		yt = ypix;
		// dt = d;
		// dt = 144;

		// System.out.println(this.getTowerName()+" xpix="+ xpix + "
		// ypix="+ypix+ " d="+d);

		Ellipse2D ellipse = new Ellipse2D.Double((double) xpix, (double) ypix, bW * 3, bH * 3);
		if (isBusy == -1 || isBusy == ((CritterType) critter).getCritterId()) {
			// Enterss
			if (ellipse.contains(xCr, yCr)) {

				if(this.getSpecialEffect() == "Freeze"){
					((CritterType) critter).setCritterImage(ApplicationStatics.IMAGE_PATH_CRITTER_FROZEN);
				}else if(this.getSpecialEffect() == "Burn"){
					((CritterType) critter).setCritterImage(ApplicationStatics.IMAGE_PATH_CRITTER_BURN);
				}else if(this.getSpecialEffect() == "Splash"){
					((CritterType) critter).setCritterImage(ApplicationStatics.IMAGE_PATH_CRITTER_SPLASH);
				}else{
					((CritterType) critter).setCritterImage(ApplicationStatics.IMAGE_PATH_CRITTER);
				}
				
				isBusy = ((CritterType) critter).getCritterId();
				// Criter Hit Counter
				if (counter[((CritterType) critter).getCritterId()] == 0) {
					boolean isdied = ((CritterType) critter).decreaseLife(this.getTowerPower());
					if (!isdied) {
						ApplicationStatics.PLAYERMODEL.addSunCurrency(((CritterType) critter).getValue());
						isBusy = -1;
					}
					MapPanel.drawLines(this.getY() * bW, this.getX() * bH, xCr, yCr, this.getTowerName(), isdied,
							((CritterType) critter).getCritterId());

					System.out.println("bW=" + bW + " bH=" + bH + " Tower " + this.getTowerName() + " shoots critter "
							+ ((CritterType) critter).getCritterId());
				}
				counter[((CritterType) critter).getCritterId()]++;
				if (counter[((CritterType) critter).getCritterId()] == 30) {
					counter[((CritterType) critter).getCritterId()] = 0;
				}
			}else{
				isBusy = -1;
			}
		
		}

	}

	/*
	 * This method returns the tower x coordinate
	 * @return x coordinate
	 */
	public double getXT() {
		return xt;
	}
	
	/*
	 * This method returns the tower y coordinate
	 * @return y coordinate
	 */
	public double getYT() {
		return yt;
	}

	/*
	 * This method returns the tower maximum distance for tower range
	 * @return tower range distance
	 */
	public double getDT() {
		return dt;
	}
	
	/**
	 * This method returns the special effect name
	 * @return special effect name
	 */
	public String getSpecialEffect(){
		return specialEffect;
	}
	
	/**
	 * This method sets the special effect for the tower
	 * @param new_str gets special effect name
	 */
	public void setSpecialEffect(String new_str){
		specialEffect = new_str;
	}

}
