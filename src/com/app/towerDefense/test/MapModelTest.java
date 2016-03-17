package com.app.towerDefense.test;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.towerDefense.models.MapModel;

/**
 * The class <code>MapModelTest</code> contains tests for the class
 * <code>{@link MapModel}</code>.
 *
 *
 * @author Amritansh Mishra
 * @version 1.0
 */
public class MapModelTest {

	MapModel mapModel;

	/**
	 * Test case Initialization for MapModelTest
	 */
	@Before
	public void towerModel1TestCase() {
		System.out.println("@BeforeClass - oneTimeSetUp-Creating object of class MapModel");
		mapModel = new MapModel();

	}

	/**
	 * Run the MapModel parameterized constructor test.
	 *
	 *
	 */
	@Test
	public void test() {
		String mapSecret = "testSecret";
		String mapAutoGeneratedDescription = "testAutoGenerationDescritpion";
		Point entryPoint = new Point(3, 4);
		Point exitPoint = new Point(6, 7);
		boolean isEntryDone = true;
		boolean isExitDone = true;
		int mapGridSelection[][] = { { 1, 2 }, { 4, 5 } };
		int mapWidth = 10;
		int mapHeight = 10;

		mapModel = new MapModel(mapSecret, mapAutoGeneratedDescription, entryPoint, exitPoint, isEntryDone, isExitDone,
				mapGridSelection, mapWidth, mapHeight);

		assertNotNull(mapModel);

	}

	/**
	 * Run the MapModel getMapRoutPathList Method this method Compute a
	 * ArrayList on this bas of mapRoutPath.
	 *
	 */
	@Test
	public void testGetMapRoutPathList() {
		mapModel = new MapModel();
		mapModel.setMapRoutPath("0,0;1,0;2,0;3,0;3,1,3,2,3,3");
		mapModel.getMapRoutPathList();
		assertNotNull(mapModel);
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
		mapModel = null;
		assertNull(mapModel);

	}
}
