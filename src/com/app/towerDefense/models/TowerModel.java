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
	 * @param new_towerName
	 *            the name of the tower
	 */
	public void setTowerName(String new_towerName) {
		this.towerName = new_towerName;
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
	 * @param new_towerFireRangeUpgrade
	 *            is the new upgrade fire range
	 */
	public void setTowerFireRangeUpgrade(int new_towerFireRangeUpgrade) {
		this.towerFireRangeUpgrade = new_towerFireRangeUpgrade;
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
	 * @param new_towerRange
	 *            the new tower range
	 */
	public void setTowerRange(int new_towerRange) {
		this.towerRange = new_towerRange;
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
	 * @param new_towerPower
	 *            the new power value
	 */
	public void setTowerPower(int new_towerPower) {
		this.towerPower = new_towerPower;
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
	 * @param new_towerFireRate
	 *            is the new firing rate
	 */
	public void setTowerFireRate(int new_towerFireRate) {
		this.towerFireRate = new_towerFireRate;
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
	 * @param new_towerCost
	 *            is the new cost of a tower
	 */
	public void setTowerCost(int new_towerCost) {
		this.towerCost = new_towerCost;
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
	 * @param new_towerlevel
	 *            is new level of tower
	 */
	public void setTowerlevel(int new_towerlevel) {
		this.towerlevel = new_towerlevel;
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
	 * @param new_towerCordinate
	 *            the new tower coordinates
	 */
	public void setTowerCordinate(Dimension new_towerCordinate) {
		TowerCordinate = new_towerCordinate;
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
	 * @param new_towerUpgradeCost amount value of next tower upgrade
	 */
	public void setTowerUpgradeCost(int new_towerUpgradeCost) {
		this.towerUpgradeCost = new_towerUpgradeCost;
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
	 * @param new_towerlevelUpgrade
	 *            the new value of upgrade level
	 */
	public void setTowerlevelUpgrade(int new_towerlevelUpgrade) {
		this.towerlevelUpgrade = new_towerlevelUpgrade;
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
	 * @param new_towerPowerUpgrade
	 *            new power power upgrade
	 */
	public void setTowerPowerUpgrade(int new_towerPowerUpgrade) {
		this.towerPowerUpgrade = new_towerPowerUpgrade;
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
	 * @param new_towerFireRateUpgrade
	 *            new tower firing rate upgrade
	 */
	public void setTowerFireRateUpgrade(int new_towerFireRateUpgrade) {
		this.towerFireRateUpgrade = new_towerFireRateUpgrade;
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
	 * @param new_imagePath
	 *            image path
	 */
	public void setTowerImagePath(String new_imagePath) {
		this.towerImagePath = new_imagePath;
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
