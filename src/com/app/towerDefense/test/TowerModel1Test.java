package com.app.towerDefense.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.app.towerDefense.models.TowerModel1;

/**
 * The class <code>TowerModel1Test</code> contains tests for the class
 * <code>{@link TowerModel1}</code>.
 *
 *
 * @author Amritansh Mishra
 * @version 1.0 
 */
public class TowerModel1Test {

	TowerModel1 towerModel1;

	@Before
	public void towerModel1TestCase() {
		System.out.println("@BeforeClass - oneTimeSetUp-Creating object of class TowerModel1");
		towerModel1 = new TowerModel1();
	}
	
	/**
	 * Test case for setter methods in class TowerModel1
	 */
	@Test
	public void test() {

		int towerLevel = 1;
		int towerPower = 2;
		int towerRange = 2;
		int towerFireRate = 2;
		int towerCost = 20;
		int towerFireRateUpgrade = 1;
		int towerLevelUpgrade = 1;
		int towerUpgradeCost = 10;
		int towerFireRangeUpgrade = 1;
		int towerPowerUpgrade=1;
		String towerName = "Sunflower";
		String towerImagePath = "images/tower1.png";
		//Change towerImagePath

		assertNotNull(towerModel1);

		assertEquals(towerModel1.getTowerName(), towerName);

		assertEquals(towerModel1.getTowerlevel(), towerLevel);

		assertEquals(towerModel1.getTowerPower(), towerPower);

		assertEquals(towerModel1.getTowerRange(), towerRange);

		assertEquals(towerModel1.getTowerFireRate(), towerFireRate);

		assertEquals(towerModel1.getTowerCost(), towerCost);

		assertEquals(towerModel1.getTowerImagePath(), towerImagePath);

		assertEquals(towerModel1.getTowerFireRangeUpgrade(), towerFireRangeUpgrade);

		assertEquals(towerModel1.getTowerFireRateUpgrade(), towerFireRateUpgrade);

		assertEquals(towerModel1.getTowerlevelUpgrade(), towerLevelUpgrade);
		
		assertEquals(towerModel1.getTowerPowerUpgrade(), towerPowerUpgrade);

		assertEquals(towerModel1.getTowerUpgradeCost(), towerUpgradeCost);

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
		towerModel1=null;
		assertNull(towerModel1);
		
	}

}
