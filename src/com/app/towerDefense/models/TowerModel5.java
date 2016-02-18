package com.app.towerDefense.models;

import com.app.towerDefense.staticContent.ApplicationStatics;
/**
 * This class create a <b>Cabbage<b/> tower which extends the TowerModel Class.
 * @see TowerModel
 * @author IMS
 *
 */
public class TowerModel5 extends TowerModel{

	public TowerModel5()
	{
		setTowerName("Cabbage");
		setTowerlevel(1);
		setTowerPower(8);
		setTowerRange(6);
		setTowerImagePath(ApplicationStatics.IMAGE_PATH_MAP_Tower5);
		setTowerImage();
		setTowerFireRate(3);
		setTowerCost(100);
		setTowerFireRateUpgrade(2);
		setTowerlevelUpgrade(1);
		setTowerPowerUpgrade(3);
		setTowerUpgradeCost(50);
		setTowerFireRangeUpgrade(1);
	
	}
	
}