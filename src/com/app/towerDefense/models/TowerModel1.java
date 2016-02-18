package com.app.towerDefense.models;
import com.app.towerDefense.staticContent.ApplicationStatics;
/**
 * This class creates <b>Sunflower tower</b> which extends <b> TowerModel class <b/>
 * 
 * @see TowerModel
 * @author IMS
 *
 */
public class TowerModel1 extends TowerModel {
	
	
	public TowerModel1()
	{
		setTowerName("Sunflower");
		setTowerlevel(1);
		setTowerPower(2);
		setTowerRange(2);
		setTowerImagePath(ApplicationStatics.IMAGE_PATH_MAP_Tower1);
		setTowerFireRate(2);
		setTowerCost(20);
		setTowerFireRateUpgrade(1);
		setTowerlevelUpgrade(1);
		setTowerPowerUpgrade(1);
		setTowerUpgradeCost(10);
		setTowerFireRangeUpgrade(1);
	
	}
	
	
	
	

}
