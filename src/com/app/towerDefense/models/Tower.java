package com.app.towerDefense.models;
/**
 * 
 */


import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Tower abstract class is the super-typer of all types of objects produced by the TowerFactory. 
 * @author George Ekow-Daniels
 *
 */
public abstract class Tower {
	
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
	

	/**
	 * This method gets the name of the tower
	 * 
	 * @return the tower name
	 */
	abstract String getTowerName();

	/**
	 * This method sets the Tower name
	 * 
	 */
	abstract void setTowerName();

	/**
	 * This method gets the value the value for range upgrade
	 * 
	 * @return the tower fire range upgrade value
	 */
	abstract int getTowerFireRangeUpgrade();
	

	/**
	 * This method sets the tower fire range upgrade value
	 * 
	 */
	abstract void setTowerFireRangeUpgrade();

	/**
	 * This method gets the
	 * 
	 * @return the tower range
	 */
	abstract int getTowerRange();

	/**
	 * This is the method for setting the tower range
	 * 
	 */
	abstract void setTowerRange();

	/**
	 * This method gets tower power
	 * 
	 * @return the tower power
	 */
	abstract int getTowerPower();

	/**
	 * The method sets the <b>power</b> of the tower
	 * 
	 */
	abstract void setTowerPower();

	/**
	 * This set the firing rate of a tower
	 * 
	 * @return the fire rate of a tower
	 */
	abstract int getTowerFireRate();

	/**
	 * This method sets the firing rate of a tower
	 * 
	 */
	abstract void setTowerFireRate();

	/**
	 * This method gets the current cost of towers
	 * 
	 * @return the cost of tower
	 */
	abstract int getTowerCost();

	/**
	 * This method sets the cost of the tower
	 * 
	 */
	abstract void setTowerCost();

	/**
	 * This method gets the tower level
	 * 
	 * @return the current tower level
	 */
	abstract int getTowerlevel();

	/**
	 * This method sets the tower level
	 *
	 */
	abstract void setTowerlevel();

	/**
	 * This method sets the tower image
	 * 
	 * @return the tower image
	 */
	abstract Icon getTowerImage();

	/**
	 * This method sets the image of the tower
	 */
	abstract void setTowerImage();

	/**
	 * This method gets the tower coordinates
	 * 
	 * @return the tower coordinate
	 */
	abstract Dimension getTowerCordinate();

	/**
	 * This method sets the tower coordinate
	 *
	 */
	abstract void setTowerCordinate();

	/**
	 * This method gets upgrade cost of a tower
	 * 
	 * @return the tower upgrade cost
	 */
	abstract int getTowerUpgradeCost();

	/**
	 * This method sets the tower upgrade cost
	 * 
	 */
	abstract void setTowerUpgradeCost();

	/**
	 * This method gets tower upgrade level
	 * 
	 * @return the tower level upgrade
	 */
	abstract int getTowerlevelUpgrade();

	/**
	 * This method sets level upgrade of a tower
	 *
	 */
	abstract void setTowerlevelUpgrade();

	/**
	 * This method gets power upgrade of a tower
	 * 
	 * @return the tower power upgrade
	 */
	abstract int getTowerPowerUpgrade();

	/**
	 * This method sets tower power upgrade
	 * 
	 */
	abstract void setTowerPowerUpgrade();

	/**
	 * This method gets the fire rate update of a tower
	 * 
	 * @return the tower fire rate update
	 */
	abstract int getTowerFireRateUpgrade() ;

	/**
	 * This method sets the tower firing rate upgrade
	 * 
	 */
	abstract void setTowerFireRateUpgrade();

	
	/**
	 * This method get the tower model's X coordinate
	 * 
	 * @return x coordinate of tower model
	 */
	abstract int getX();
	
	/**
	 * This method get the tower model's Y coordinate
	 * 
	 * @return y coordinate of tower model
	 */
	abstract int getY();
	
	/**
	 * This method sets the X and Y coordinates of the tower model
	 * 
	 */
	abstract void setXY();
	
	/**
	 * This method upgrades Tower
	 */
	abstract void upgradeTower();
	
	/**
	 * This method calculates the amount for refund after a sell of a tower
	 * @return the value of the tower
	 */
	abstract int getRefund();
	 

}
