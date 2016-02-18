package com.app.towerDefense.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.towerDefense.models.TowerModel2;

/**
 * The class <code>TowerModel2Test</code> contains tests for the class
 * <code>{@link TowerModel2}</code>.
 *
 *
 * @author Amritansh Mishra
 * @version 1.0 
 */
public class TowerModel2Test {

	TowerModel2 towerModel2;

	@Before
	public void towerModel2TestCase() {
		System.out.println("@BeforeClass - oneTimeSetUp-Creating object of class TowerModel2");
		towerModel2 = new TowerModel2();
	}
	
	/**
	 * Test case for setter methods in class TowerModel2
	 */
	@Test
	public void test() {
		
		int towerLevel = 1;
		int towerPower = 4;
		int towerRange = 4;
		int towerFireRate = 3;
		int towerCost = 40;
		int towerFireRateUpgrade = 2;
		int towerLevelUpgrade = 1;
		int towerUpgradeCost = 20;
		int towerFireRangeUpgrade = 2;
		int towerPowerUpgrade=2;
		String towerName = "Peashooter";
		String towerImagePath = "images/tower2.png";
		//Change towerImagePath

		assertNotNull(towerModel2);

		assertEquals(towerModel2.getTowerName(), towerName);

		assertEquals(towerModel2.getTowerlevel(), towerLevel);

		assertEquals(towerModel2.getTowerPower(), towerPower);

		assertEquals(towerModel2.getTowerRange(), towerRange);

		assertEquals(towerModel2.getTowerFireRate(), towerFireRate);

		assertEquals(towerModel2.getTowerCost(), towerCost);

		assertEquals(towerModel2.getTowerImagePath(), towerImagePath);

		assertEquals(towerModel2.getTowerFireRangeUpgrade(), towerFireRangeUpgrade);

		assertEquals(towerModel2.getTowerFireRateUpgrade(), towerFireRateUpgrade);

		assertEquals(towerModel2.getTowerlevelUpgrade(), towerLevelUpgrade);
		
		assertEquals(towerModel2.getTowerPowerUpgrade(), towerPowerUpgrade);

		assertEquals(towerModel2.getTowerUpgradeCost(), towerUpgradeCost);

	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 *
	 *
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
		System.out.println("@AfterClass - oneTimeTearDown");
		towerModel2=null;
		assertNull(towerModel2);
		
	}

}

