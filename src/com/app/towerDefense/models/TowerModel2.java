package com.app.towerDefense.models;

import com.app.towerDefense.staticContent.ApplicationStatics;
/**
 * This class creates Peashooter tower which extends  TowerModel class 
 * 
 * @see TowerModel
 * @author George Ekow-Daniels
 *
 */
public class TowerModel2 extends TowerModel
{
	
	public TowerModel2()
	{
		setTowerName("Peashooter");
		setTowerlevel(1);
		setTowerPower(4);
		setTowerRange(4);
		setTowerImagePath(ApplicationStatics.IMAGE_PATH_MAP_Tower2);
		setTowerImage();
		setTowerFireRate(3);
		setTowerCost(40);
		setTowerFireRateUpgrade(2);
		setTowerlevelUpgrade(1);
		setTowerPowerUpgrade(2);
		setTowerUpgradeCost(20);
		setTowerFireRangeUpgrade(2);
	
	}
	

}
