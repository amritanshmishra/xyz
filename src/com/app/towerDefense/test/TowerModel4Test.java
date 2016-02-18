package com.app.towerDefense.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.towerDefense.models.TowerModel4;

/**
 * The class <code>TowerModel4Test</code> contains tests for the class
 * <code>{@link TowerModel4}</code>.
 *
 *
 * @author Amritansh Mishra
 * @version $Revision: 1.0 $
 */
public class TowerModel4Test {

	TowerModel4 towerModel4;

	@Before
	public void towerModel4TestCase() {
		System.out.println("@BeforeClass - oneTimeSetUp-Creating object of class towerModel4");
		towerModel4 = new TowerModel4();
	}

	/**
	 * Test case for setter methods in class towerModel4
	 */
	@Test
	public void test() {

		int towerLevel = 1;
		int towerPower = 8;
		int towerRange = 6;
		int towerFireRate = 2;
		int towerCost = 80;
		int towerFireRateUpgrade = 1;
		int towerLevelUpgrade = 1;
		int towerUpgradeCost = 40;
		int towerFireRangeUpgrade = 1;
		int towerPowerUpgrade = 3;
		String towerName = "Machine Gun";
		String towerImagePath = "images/tower4.png";
		// Change towerImagePath

		assertNotNull(towerModel4);

		assertEquals(towerModel4.getTowerName(), towerName);

		assertEquals(towerModel4.getTowerlevel(), towerLevel);

		assertEquals(towerModel4.getTowerPower(), towerPower);

		assertEquals(towerModel4.getTowerRange(), towerRange);

		assertEquals(towerModel4.getTowerFireRate(), towerFireRate);

		assertEquals(towerModel4.getTowerCost(), towerCost);

		assertEquals(towerModel4.getTowerImagePath(), towerImagePath);

		assertEquals(towerModel4.getTowerFireRangeUpgrade(), towerFireRangeUpgrade);

		assertEquals(towerModel4.getTowerFireRateUpgrade(), towerFireRateUpgrade);

		assertEquals(towerModel4.getTowerlevelUpgrade(), towerLevelUpgrade);

		assertEquals(towerModel4.getTowerPowerUpgrade(), towerPowerUpgrade);

		assertEquals(towerModel4.getTowerUpgradeCost(), towerUpgradeCost);

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
		towerModel4 = null;
		assertNull(towerModel4);

	}

}
