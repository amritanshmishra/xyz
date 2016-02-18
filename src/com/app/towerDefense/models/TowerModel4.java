package com.app.towerDefense.models;

import com.app.towerDefense.staticContent.ApplicationStatics;
/**
 * This class creates <b>Machine Gun<b/> tower which extends from TowerModel Class
 * 
 * @see TowerModel
 * 
 * @author IMS
 *
 */
public class TowerModel4 extends TowerModel{

	public TowerModel4()
	{
		setTowerName("Machine Gun");
		setTowerlevel(1);
		setTowerPower(8);
		setTowerRange(6);
		setTowerImagePath(ApplicationStatics.IMAGE_PATH_MAP_Tower4);
		setTowerImage();
		setTowerFireRate(2);
		setTowerCost(80);
		setTowerFireRateUpgrade(1);
		setTowerlevelUpgrade(1);
		setTowerPowerUpgrade(3);
		setTowerUpgradeCost(40);
		setTowerFireRangeUpgrade(1);
	
	}
	
}