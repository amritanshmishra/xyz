package com.app.towerDefense.models;

import java.awt.*;

import javax.swing.*;

/**
 * This class creates a generic class for Towers to make the other Towers.
 * 
 * @author George Ekow-Daniels
 *
 */
public class TowerModel {

	private int towerID;
	private String towerName;
	private int towerRange;
	private int towerPower;
	private int towerFireRate;
	private int towerCost;
	private int towerlevel;
	private Icon towerImage;
	private String towerImagePath;
	private Dimension TowerCordinate;
	private int towerUpgradeCost;
	private int towerlevelUpgrade;
	private int towerPowerUpgrade;
	private int towerFireRateUpgrade;
	private int towerFireRangeUpgrade;
	private int x, y;
	

	/**
	 * This method gets the name of the tower
	 * 
	 * @return the tower name
	 */
	public String getTowerName() {
		return towerName;
	}

	/**
	 * This method sets the Tower name
	 * 
	 * @param towerName
	 *            the name of the tower
	 */
	public void setTowerName(String towerName) {
		this.towerName = towerName;
	}

	/**
	 * This method gets the value the value for range upgrade
	 * 
	 * @return the tower fire range upgrade value
	 */
	public int getTowerFireRangeUpgrade() {
		return towerFireRangeUpgrade;
	}

	/**
	 * This method sets the tower fire range upgrade value
	 * 
	 * @param towerFireRangeUpgrade
	 *            is the new upgrade fire range
	 */
	public void setTowerFireRangeUpgrade(int towerFireRangeUpgrade) {
		this.towerFireRangeUpgrade = towerFireRangeUpgrade;
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
	public Icon getTowerImage() {
		this.towerImage = new ImageIcon(getTowerImagePath());
		return towerImage;
	}

	/**
	 * This method sets the image of the tower
	 */
	public void setTowerImage() {
		this.towerImage = new ImageIcon(getTowerImagePath());
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
	public int getTowerUpgradeCost() {
		return towerUpgradeCost;
	}

	/**
	 * This method sets the tower upgrade cost
	 * 
	 * @param newtowerUpgradeCost amount value of next tower upgrade
	 */
	public void setTowerUpgradeCost(int newtowerUpgradeCost) {
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

	/**
	 * This method get the tower image icon path
	 * 
	 * @return the path to the image
	 */
	public String getTowerImagePath() {
		return towerImagePath;
	}

	/**
	 * This method sets the image path of the tower
	 * 
	 * @param newimagePath
	 *            image path
	 */
	public void setTowerImagePath(String newimagePath) {
		this.towerImagePath = newimagePath;
	}
	
	/**
	 * This method get the tower model's X coordinate
	 * 
	 * @return x coordinate of tower model
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * This method get the tower model's Y coordinate
	 * 
	 * @return y coordinate of tower model
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * This method sets the X and Y coordinates of the tower model
	 * 
	 * @param new_x x coordinate of the tower model
	 * @param new_y y coordinate of the tower model
	 */
	public void setXY(int new_x, int new_y){
		x = new_x;
		y = new_y;
	}
	/**
	 * This method upgrades Tower
	 */
	public void upgradeTower()
	{
		setTowerFireRate(getTowerFireRate() + getTowerFireRateUpgrade());
		setTowerCost(getTowerCost()+getTowerUpgradeCost());
		setTowerRange(getTowerRange()+getTowerFireRangeUpgrade());
		setTowerlevel(getTowerlevel()+getTowerlevelUpgrade());
		setTowerPower(getTowerPower()+getTowerPowerUpgrade());
		
	}
	
	/**
	 * This method calculates the amount for refund after a sell of a tower
	 * @return the value of the tower
	 */
	 public int getRefund()
	 {
		 return getTowerCost()/2;
	 }
	 

}
