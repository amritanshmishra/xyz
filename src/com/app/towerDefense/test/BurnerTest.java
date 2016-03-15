package com.app.towerDefense.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.app.towerDefense.models.Tower;
import com.app.towerDefense.models.TowerFactory;

/**
 * The class <code>BurnerTest</code> contains tests for the class
 * <code>{@link Burner}</code>.
 *
 *
 * @author George Ekow-Daniels
 * @version 1.0
 */
public class BurnerTest {

	Tower burner;

	@Before
	public void burnerTestCase() {
		System.out.println("@BeforeClass - oneTimeSetUp-Creating object of class Burner");
		burner = TowerFactory.getTower("Burner");
	}

	/**
	 * Test case for setter methods in class TowerModel3
	 */
	@Test
	public void test() {

		int towerLevel = 1;
		int towerPower = 2;
		int towerRange = 4;
		int towerFireRate = 2;
		int towerCost = 60;
		int towerFireRateUpgrade = 1;
		int towerLevelUpgrade = 1;
		int towerUpgradeCost = 30;
		int towerFireRangeUpgrade = 1;
		int towerPowerUpgrade = 2;
		String towerName = "Burner";
		// Change towerImagePath

		assertNotNull(burner);

		assertEquals(burner.getTowerName(), towerName);

		assertEquals(burner.getTowerlevel(), towerLevel);

		assertEquals(burner.getTowerPower(), towerPower);

		assertEquals(burner.getTowerRange(), towerRange);

		assertEquals(burner.getTowerFireRate(), towerFireRate);

		assertEquals(burner.getTowerCost(), towerCost);

		assertEquals(burner.getTowerFireRangeUpgrade(), towerFireRangeUpgrade);

		assertEquals(burner.getTowerFireRateUpgrade(), towerFireRateUpgrade);

		assertEquals(burner.getTowerlevelUpgrade(), towerLevelUpgrade);
		
		assertEquals(burner.getTowerPowerUpgrade(), towerPowerUpgrade);

		assertEquals(burner.getTowerUpgradeCost(), towerUpgradeCost);

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
		burner = null;
		assertNull(burner);

	}

}