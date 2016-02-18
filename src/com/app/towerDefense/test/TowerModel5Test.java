package com.app.towerDefense.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.towerDefense.models.TowerModel5;

/**
 * The class <code>TowerModel5Test</code> contains tests for the class
 * <code>{@link TowerModel5}</code>.
 *
 *
 * @author Amritansh Mishra
 * @version 1.0
 */
public class TowerModel5Test {

	TowerModel5 towerModel5;

	@Before
	public void towerModel5TestCase() {
		System.out.println("@BeforeClass - oneTimeSetUp-Creating object of class towerModel5");
		towerModel5 = new TowerModel5();
	}

	/**
	 * Test case for setter methods in class towerModel5
	 */
	@Test
	public void test() {

		int towerLevel = 1;
		int towerPower = 8;
		int towerRange = 6;
		int towerFireRate = 3;
		int towerCost = 100;
		int towerFireRateUpgrade = 2;
		int towerLevelUpgrade = 1;
		int towerUpgradeCost = 50;
		int towerFireRangeUpgrade = 1;
		int towerPowerUpgrade = 3;
		String towerName = "Cabbage";
		String towerImagePath = "images/tower5.png";
		// Change towerImagePath

		assertNotNull(towerModel5);

		assertEquals(towerModel5.getTowerName(), towerName);

		assertEquals(towerModel5.getTowerlevel(), towerLevel);

		assertEquals(towerModel5.getTowerPower(), towerPower);

		assertEquals(towerModel5.getTowerRange(), towerRange);

		assertEquals(towerModel5.getTowerFireRate(), towerFireRate);

		assertEquals(towerModel5.getTowerCost(), towerCost);

		assertEquals(towerModel5.getTowerImagePath(), towerImagePath);

		assertEquals(towerModel5.getTowerFireRangeUpgrade(), towerFireRangeUpgrade);

		assertEquals(towerModel5.getTowerFireRateUpgrade(), towerFireRateUpgrade);

		assertEquals(towerModel5.getTowerlevelUpgrade(), towerLevelUpgrade);

		assertEquals(towerModel5.getTowerPowerUpgrade(), towerPowerUpgrade);

		assertEquals(towerModel5.getTowerUpgradeCost(), towerUpgradeCost);

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
		towerModel5 = null;
		assertNull(towerModel5);

	}

}