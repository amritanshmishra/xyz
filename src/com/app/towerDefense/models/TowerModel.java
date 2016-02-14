package com.app.towerDefense.models;

import java.awt.Dimension;
import java.awt.Image;

/**
 * This class creates a generic class for Towers to make the other Towers.
 * 
 * @author George Ekow-Daniels
 *
 */
public class TowerModel {

	private int towerID;
	String towerName;
	int towerRange;
	int towerPower;
	int towerFireRate;
	int towerCost;
	int towerlevel;
	Image towerImage;
	String towerImagePath;
	Dimension TowerCordinate;

	float towerUpgradeCost;
	int towerlevelUpgrade;
	int towerPowerUpgrade;
	int towerFireRateUpgrade;

	/**
	 * Constructor, builds the Tower Object with initial values assigned
	 */
	public TowerModel(int new_towerID) {
		towerID = new_towerID;
		if (towerID == 0) {
			towerlevel = 1;
			towerName = "Sunflower";
			towerPower = 5;
			towerRange = 1;
			towerFireRate = 5;
			towerCost = 50;
		} else if (towerID == 1) {
			towerlevel = 1;
			towerName = "Peashooter";
			towerPower = 10;
			towerRange = 1;
			towerFireRate = 5;
			towerCost = 100;
		} else if (towerID == 2) {
			towerlevel = 1;
			towerName = "Soldier";
			towerPower = 7;
			towerRange = 2;
			towerFireRate = 5;
			towerCost = 150;
		} else if (towerID == 3) {
			towerlevel = 1;
			towerName = "Machine Gun";
			towerPower = 10;
			towerRange = 5;
			towerFireRate = 10;
			towerCost = 200;
		} else if (towerID == 4) {
			towerlevel = 1;
			towerName = "Cabbage";
			towerPower = 20;
			towerRange = 1;
			towerFireRate = 10;
			towerCost = 250;
		}
		towerImagePath = "images/tower" + Integer.toString(towerID+1) + ".png";
		towerUpgradeCost = 0.5f;

	}

	/**
	 * This method gets the
	 * 
	 * @return the tower range
	 */
	public int getTowerRange() {
		return towerRange;
	}

	/**
	 * This is the method for setting the tower range
	 * 
	 * @param newtowerRange
	 *            the new tower range
	 */
	public void setTowerRange(int newtowerRange) {
		this.towerRange = newtowerRange;
	}

	/**
	 * This method gets tower power
	 * 
	 * @return the tower power
	 */
	public int getTowerPower() {
		return towerPower;
	}

	/**
	 * The method sets the <b>power</b> of the tower
	 * 
	 * @param newtowerPower
	 *            the new power value
	 */
	public void setTowerPower(int newtowerPower) {
		this.towerPower = newtowerPower;
	}

	/**
	 * This set the firing rate of a tower
	 * 
	 * @return the fire rate of a tower
	 */
	public int getTowerFireRate() {
		return towerFireRate;
	}

	/**
	 * This method sets the firing rate of a tower
	 * 
	 * @param newtowerFireRate
	 *            is the new firing rate
	 */
	public void setTowerFireRate(int newtowerFireRate) {
		this.towerFireRate = newtowerFireRate;
	}

	/**
	 * This method gets the current cost of towers
	 * 
	 * @return the cost of tower
	 */
	public int getTowerCost() {
		return towerCost;
	}

	/**
	 * This method sets the cost of the tower
	 * 
	 * @param newtowerCost
	 *            is the new cost of a tower
	 */
	public void setTowerCost(int newtowerCost) {
		this.towerCost = newtowerCost;
	}

	/**
	 * This method gets the tower level
	 * 
	 * @return the current tower level
	 */
	public int getTowerlevel() {
		return towerlevel;
	}

	/**
	 * This method sets the tower level
	 * 
	 * @param newtowerlevel
	 *            is new level of tower
	 */
	public void setTowerlevel(int newtowerlevel) {
		this.towerlevel = newtowerlevel;
	}

	/**
	 * This method sets the tower image
	 * 
	 * @return the tower image
	 */
	public Image getTowerImage() {
		return towerImage;
	}

	/**
	 * This method sets the image of the tower
	 * 
	 * @param newtowerImage
	 *            is new tower image
	 */
	public void setTowerImage(Image newtowerImage) {
		this.towerImage = newtowerImage;
	}

	/**
	 * This method gets the tower coordinates
	 * 
	 * @return the tower coordinate
	 */
	public Dimension getTowerCordinate() {
		return TowerCordinate;
	}

	/**
	 * This method sets the tower coordinate
	 * 
	 * @param newtowerCordinate
	 *            the new tower coordinates
	 */
	public void setTowerCordinate(Dimension newtowerCordinate) {
		TowerCordinate = newtowerCordinate;
	}

	/**
	 * This method gets upgrade cost of a tower
	 * 
	 * @return the tower upgrade cost
	 */
	public float getTowerUpgradeCost() {
		return towerUpgradeCost;
	}

	/**
	 * This method sets the tower upgrade cost
	 * 
	 * @param newtowerUpgradeCost
	 */
	public void setTowerUpgradeCost(float newtowerUpgradeCost) {
		this.towerUpgradeCost = newtowerUpgradeCost;
	}

	/**
	 * This method gets tower upgrade level
	 * 
	 * @return the tower level upgrade
	 */
	public int getTowerlevelUpgrade() {
		return towerlevelUpgrade;
	}

	/**
	 * This method sets level upgrade of a tower
	 * 
	 * @param newtowerlevelUpgrade
	 *            the new value of upgrade level
	 */
	public void setTowerlevelUpgrade(int newtowerlevelUpgrade) {
		this.towerlevelUpgrade = newtowerlevelUpgrade;
	}

	/**
	 * This method gets power upgrade of a tower
	 * 
	 * @return the tower power upgrade
	 */
	public int getTowerPowerUpgrade() {
		return towerPowerUpgrade;
	}

	/**
	 * This method sets tower power upgrade
	 * 
	 * @param newtowerPowerUpgrade
	 *            new power power upgrade
	 */
	public void setTowerPowerUpgrade(int newtowerPowerUpgrade) {
		this.towerPowerUpgrade = newtowerPowerUpgrade;
	}

	/**
	 * This method gets the fire rate update of a tower
	 * 
	 * @return the tower fire rate update
	 */
	public int getTowerFireRateUpgrade() {
		return towerFireRateUpgrade;
	}

	/**
	 * This method sets the tower firing rate upgrade
	 * 
	 * @param newtowerFireRateUpgrade
	 *            new tower firing rate upgrade
	 */
	public void setTowerFireRateUpgrade(int newtowerFireRateUpgrade) {
		this.towerFireRateUpgrade = newtowerFireRateUpgrade;
	}
	
	public String getTowerImagePath(){
		return towerImagePath;
	}
	
	public String getTowerName(){
		return towerName;
	}

}
