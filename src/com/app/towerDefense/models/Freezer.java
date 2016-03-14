package com.app.towerDefense.models;


import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.app.towerDefense.staticContent.ApplicationStatics;

/**
 * {@inheritDoc}
 * This class create a Freezer tower.
 * @author George Ekow-Daniels
 * @see Tower
 *
 */
public class Freezer extends Tower {
	
	public Freezer()
	{
		setTowerName();
		setTowerImage();
		setTowerCost();
		setTowerlevel();
		setTowerPower();
		setTowerRange();
		setTowerFireRate();
		
		setTowerUpgradeCost();
		setTowerlevelUpgrade();
		setTowerFireRangeUpgrade();
		setTowerFireRateUpgrade();
		setTowerPowerUpgrade();
	}
	
		@Override
		public String getTowerName() {
		
			return super.towerName;
		}

		@Override
		public void setTowerName() {
			
			super.towerName="Freezer";
			
		}

		@Override
		public int getTowerFireRangeUpgrade() {
			
			return super.towerFireRangeUpgrade;
		}

		@Override
		public void setTowerFireRangeUpgrade() {
			super.towerFireRangeUpgrade=1;
			
		}

		@Override
		public int getTowerRange() {
			
			return super.towerRange;
		}

		@Override
		public void setTowerRange() {
			super.towerRange=1;
		}

		@Override
		public int getTowerPower() {
			return super.towerPower;
		}

		@Override
		public void setTowerPower() {
			super.towerPower=2;
			
		}

		@Override
		public int getTowerFireRate() {
			
			return super.towerFireRate;
		}

		@Override
		public void setTowerFireRate() {
			super.towerFireRate=2;
		}

		@Override
		public int getTowerCost() {
			return super.towerCost;
		}

		@Override
		public void setTowerCost() {
			super.towerCost=40;
			
		}

		@Override
		public int getTowerlevel() {
			
			return super.towerlevel;
		}

		@Override
		public void setTowerlevel() {
			
			super.towerlevel = 1;
		}

		@Override
		public Icon getTowerImage() {
			return super.towerImage;
		}

		@Override
		public void setTowerImage() {
		 super.towerImage=	new ImageIcon(ApplicationStatics.IMAGE_PATH_MAP_Tower2);
						
			
		}

		@Override
		public Dimension getTowerCordinate() {
			return null;
		}

		@Override
		public void setTowerCordinate() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public int getTowerUpgradeCost() {
			return super.towerUpgradeCost;
		}

		@Override
		public void setTowerUpgradeCost() {
			super.towerUpgradeCost=20;
			
		}

		@Override
		public int getTowerlevelUpgrade() {
			
			return super.towerlevelUpgrade;
		}

		@Override
		public void setTowerlevelUpgrade() {
			super.towerlevelUpgrade=1;
			
		}

		@Override
		public int getTowerPowerUpgrade() {
			
			return super.towerPowerUpgrade;
		}

		@Override
		public void setTowerPowerUpgrade() {
		super.towerPowerUpgrade=2;
			
		}

		@Override
		public int getTowerFireRateUpgrade() {
			
			return super.towerFireRangeUpgrade;
		}

		@Override
		public void setTowerFireRateUpgrade() {
			super.towerFireRateUpgrade=2;
			
		}


		@Override
		public int getX() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getY() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setXY() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void upgradeTower() {
			super.towerFireRate=getTowerFireRate() + getTowerFireRateUpgrade();
			super.towerCost=getTowerCost()+getTowerUpgradeCost();
			super.towerRange=getTowerRange()+getTowerFireRangeUpgrade();
			super.towerlevel= getTowerlevel()+getTowerlevelUpgrade();
			super.towerPower=getTowerPower()+getTowerPowerUpgrade();
			
		
		}

		@Override
		public int getRefund() {
			
			return getTowerCost()/2;
		}

	

}
