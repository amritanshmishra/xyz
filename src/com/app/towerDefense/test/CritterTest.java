package com.app.towerDefense.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.towerDefense.models.BasicCritter;
import com.app.towerDefense.models.CritterFactory;
import com.app.towerDefense.models.CritterType;
import com.app.towerDefense.models.MapModel;
import com.app.towerDefense.staticContent.ApplicationStatics;
import com.app.towerDefense.utilities.FileStorage;

/**
 * The class <code>BasicCritterTest</code> contains tests for the class
 * <code>{@link BasicCritter}</code>.
 * 
 * 
 * @author Amritansh Mishra
 * @version 1.0
 */
public class CritterTest {

	CritterType basicCritter;
	CritterType advancedCritter;
	int actualHealth = 10;
	int currentHealth = 10;
	int critterId = 10;
	Image critterImage = new ImageIcon(ApplicationStatics.IMAGE_PATH_CRITTER)
			.getImage();
	MapModel mapModel;
//	File file = new File("testfiles\\abc.tdm"); // for Windows OS
	File file = new File("testfiles/abc.tdm"); // for Mac OS

	/**
	 * Test case Initialization for CritterTest
	 */
	@Before
	public void critterTestCase() {
		System.out
				.println("@BeforeClass - oneTimeSetUp-Creating object of class BasicCritter & AdvancedCritter");
		basicCritter = CritterFactory.getCritterfromFactory("BasicCritter");
		advancedCritter = CritterFactory
				.getCritterfromFactory("AdvancedCritter");
		basicCritter.setID(critterId);
	}

	/**
	 * Test case for factory validation
	 */
	@Test
	public void testFactoryInstanceCreation() {
		assertNotNull(basicCritter);
		assertNotNull(advancedCritter);
		Assert.assertTrue(basicCritter instanceof BasicCritter);
	
	}

	/**
	 * Test Case for critter health, critter id, image
	 */
	@Test
	public void testCritterAttributes() {
		assertEquals(basicCritter.getActualHealth(), actualHealth);
		assertEquals(basicCritter.getCurrentHealth(), currentHealth);
		assertEquals(basicCritter.getCritterId(), critterId);
		assertEquals(basicCritter.getCritterImage(), critterImage);
	}

	/**
	 * Test case for setting block parameters
	 */
	/*@Test
	public void testSetBlocksParams() {

		basicCritter.setBlocksParams(400, 300);

		assertEquals(400, basicCritter.getBlockW());
		assertEquals(300, basicCritter.getBlockH());
	}*/

	/**
	 * Test case for x and y co-rdinates for critters
	 */
	@Test
	public void testSetXY() {

		basicCritter.setXY(6, 3);
		assertEquals(6, basicCritter.getX());
		assertEquals(3, basicCritter.getY());
	}

	/**
	 * Test case for calculate critter path
	 */
	@Test
	public void testCalculateCritterPath() {
		boolean isException = true;
		basicCritter.setXY(6, 6);
	//	basicCritter.setBlocksParams(400, 300);

		mapModel = (new FileStorage()).openMapFile(file);
		ApplicationStatics.PATH_ARRAY1 = mapModel.getMapRoutPathList();

		try {
			basicCritter.calculatePath();
			isException = false;
		} catch (Exception e) {
			isException = true;
		}
		assertFalse(isException);
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
		basicCritter = null;
		critterImage = null;
		mapModel = null;
		file = null;
		assertNull(basicCritter);
		assertNull(critterImage);
		assertNull(mapModel);
		assertNull(file);

	}

}
