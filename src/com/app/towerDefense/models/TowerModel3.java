package com.app.towerDefense.models;

import com.app.towerDefense.staticContent.ApplicationStatics;
/**
 * This class creates <b>Soldier</b> tower which extends <b> TowerModel class <b/>
 * 
 *  @see TowerModel
 * @author IMS
 *
 */
public class TowerModel3 extends TowerModel{

	public TowerModel3()
	{
		setTowerName("Soldier");
		setTowerlevel(1);
		setTowerPower(6);
		setTowerRange(4);
		setTowerImagePath(ApplicationStatics.IMAGE_PATH_MAP_Tower3);
		setTowerImage();
		setTowerFireRate(2);
		setTowerCost(60);
		setTowerFireRateUpgrade(1);
		setTowerlevelUpgrade(1);
		setTowerPowerUpgrade(4);
		setTowerUpgradeCost(30);
		setTowerFireRangeUpgrade(1);
	
	}
	
}
