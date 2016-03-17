package com.app.towerDefense.test;

import static org.junit.Assert.*;

import java.awt.Image;

import javax.swing.ImageIcon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.towerDefense.models.AdvancedCritter;
import com.app.towerDefense.models.BasicCritter;
import com.app.towerDefense.models.CritterFactory;
import com.app.towerDefense.models.CritterType;
import com.app.towerDefense.staticContent.ApplicationStatics;

import junit.framework.Assert;

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
	Image critterImage = new ImageIcon(ApplicationStatics.IMAGE_PATH_CRITTER).getImage();

	@Before
	public void critterTestCase() {
		System.out.println("@BeforeClass - oneTimeSetUp-Creating object of class BasicCritter & AdvancedCritter");
		basicCritter = CritterFactory.getCritterfromFactory("BasicCritter");
		advancedCritter = CritterFactory.getCritterfromFactory("AdvancedCritter");
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
		Assert.assertTrue(advancedCritter instanceof AdvancedCritter);

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
	 * Test case for calculate critter path
	 */
	@Test
	public void testCalculateCritterPath() {

	}

	/**
	 * Test case for setting block parameters
	 */
	@Test
	public void testSetBlocksParams() {

	}

	/**
	 * Test case for x and y co-rdinates for critters
	 */
	@Test
	public void testSetXY() {

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
		assertNull(basicCritter);
		assertNull(critterImage);

	}

}
