package com.app.towerDefense.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.towerDefense.models.PlayerModel;
import com.app.towerDefense.models.TowerModel;
import com.app.towerDefense.models.TowerModel1;

/**
 * The class <code>PlayerModelTest</code> contains tests for the class
 * <code>{@link PlayerModel}</code>.
 *
 *
 * @author Amritansh Mishra
 * @version Revision: 1.0
 */
public class PlayerModelTest {

	PlayerModel playerModel;
	TowerModel1 towerModel1;
	ArrayList<TowerModel> towerModelArray;

	@Before
	public void towerModel1TestCase() {
		System.out.println("@BeforeClass - oneTimeSetUp-Creating object of class PlayerModel");
		playerModel = new PlayerModel();
		towerModel1 = new TowerModel1();
		

	}

	/**
	 * Run the PlayerModel default constructor test.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testDefaultConstructor() {

		String playerName = "defaultName";
		int sunCurrency = 500;
		int hpPlayer = 10;
		int gameWave = 1;

		assertEquals(playerName, playerModel.getPlayerName());

		assertEquals(sunCurrency, playerModel.getSunCurrency());

		assertEquals(hpPlayer, playerModel.getHpPlayer());

		assertEquals(gameWave, playerModel.getGameWave());

	}

	/**
	 * Run the PlayerModel parameterized constructor test. PlayerModel(String ,
	 * int , int , int )
	 * 
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void testParameterizedConstructor() {

		String playerName = "testName";
		int sunCurrency = 100;
		int hpPlayer = 5;
		int gameWave = 5;

		playerModel = new PlayerModel(playerName, sunCurrency, hpPlayer, gameWave);

		assertEquals(playerName, playerModel.getPlayerName());

		assertEquals(sunCurrency, playerModel.getSunCurrency());

		assertEquals(hpPlayer, playerModel.getHpPlayer());

		assertEquals(gameWave, playerModel.getGameWave());

	}

	/**
	 * Test buyTower method.
	 *
	 * @throws Exception
	 *
	 *
	 */
	@Test
	public void buyTowerTest() {
		
		playerModel = new PlayerModel();
		towerModel1 = new TowerModel1();
		playerModel.buyTower(1);
		assertEquals(playerModel.towerModelArray.size(),1);

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
		playerModel = null;
		towerModel1 = null;
		assertNull(playerModel);
		assertNull(towerModel1);

	}

}
