package com.app.towerDefense.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.towerDefense.models.TowerModel2;
import com.app.towerDefense.models.TowerModel3;

/**
 * The class <code>TowerModel3Test</code> contains tests for the class
 * <code>{@link TowerModel3}</code>.
 *
 *
 * @author Amritansh Mishra
 * @version $Revision: 1.0 $
 */
public class TowerModel3Test {

	TowerModel3 towerModel3;

	@Before
	public void towerModel3TestCase() {
		System.out.println("@BeforeClass - oneTimeSetUp-Creating object of class TowerModel3");
		towerModel3 = new TowerModel3();
	}

	/**
	 * Test case for setter methods in class TowerModel3
	 */
	@Test
	public void test() {

		int towerLevel = 1;
		int towerPower = 6;
		int towerRange = 4;
		int towerFireRate = 2;
		int towerCost = 60;
		int towerFireRateUpgrade = 1;
		int towerLevelUpgrade = 1;
		int towerUpgradeCost = 30;
		int towerFireRangeUpgrade = 1;
		int towerPowerUpgrade = 4;
		String towerName = "Soldier";
		String towerImagePath = "images/tower3.png";
		// Change towerImagePath

		assertNotNull(towerModel3);

		assertEquals(towerModel3.getTowerName(), towerName);

		assertEquals(towerModel3.getTowerlevel(), towerLevel);

		assertEquals(towerModel3.getTowerPower(), towerPower);

		assertEquals(towerModel3.getTowerRange(), towerRange);

		assertEquals(towerModel3.getTowerFireRate(), towerFireRate);

		assertEquals(towerModel3.getTowerCost(), towerCost);

		assertEquals(towerModel3.getTowerImagePath(), towerImagePath);

		assertEquals(towerModel3.getTowerFireRangeUpgrade(), towerFireRangeUpgrade);

		assertEquals(towerModel3.getTowerFireRateUpgrade(), towerFireRateUpgrade);

		assertEquals(towerModel3.getTowerlevelUpgrade(), towerLevelUpgrade);
		
		assertEquals(towerModel3.getTowerPowerUpgrade(), towerPowerUpgrade);

		assertEquals(towerModel3.getTowerUpgradeCost(), towerUpgradeCost);

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
		towerModel3 = null;
		assertNull(towerModel3);

	}

}