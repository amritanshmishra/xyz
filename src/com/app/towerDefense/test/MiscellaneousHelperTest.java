package com.app.towerDefense.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.towerDefense.models.MapModel;
import com.app.towerDefense.utilities.MiscellaneousHelper;
/**
 * The class <code>MiscellaneousHelperTest</code> contains tests for the class
 * <code>{@link MiscellaneousHelper}</code>.
 *
 *
 * @author Sajjad Ashraf
 * @version 1.0 
 */
public class MiscellaneousHelperTest {

	MiscellaneousHelper miscellaneousHelper;
	
	/**
	 * Test case Initialization for MiscellaneousHelperTest
	 */
	@Before
	public void towerModel1TestCase() {
		System.out.println("@BeforeClass - oneTimeSetUp-Creating object of class MapModel");
		miscellaneousHelper = new MiscellaneousHelper();
	}
	
	/**
	 * Run Unit Test IsDouble which return true if String is double else false
	 * 
	 */
	@Test
	public void testIsDouble()
	{
		assertTrue(miscellaneousHelper.isDouble("10.23"));
		assertFalse(miscellaneousHelper.isDouble("Helle10.23"));
	}
	
	/**
	 * Run Unit Test RemoveCharacterFromStrartorLeft  it removes character from start to left
	 */
	@Test
	public void testRemoveCharacterFromStrartorLeft(){
		assertEquals("123", miscellaneousHelper.RemoveCharacterFromStrartorLeft("00123", "0"));
		assertEquals("123", miscellaneousHelper.RemoveCharacterFromStrartorLeft(" 123", " "));
	}
	
	/**
	 * 
	 * Run Unit Test RemoveCharacterFromEndorRight it removes character from end or right
	 */
	@Test
	public void testRemoveCharacterFromEndorRight()
	{
		assertEquals(" hello", miscellaneousHelper.RemoveCharacterFromEndorRight(" hello   ", " "));
		assertEquals("$10000.00", miscellaneousHelper.RemoveCharacterFromEndorRight("$10000.00$$$", "$"));
	}
	
	/**
	 * 
	 * Run Unit Test RemoveCharacterFromBothEnd it removes character from both sides Left and Right
	 */
	@Test
	public void testRemoveCharacterFromBothEnd()
	{
		assertEquals("hello", miscellaneousHelper.RemoveCharacterFromBothEnd("  hello    ", " "));
		assertEquals("100.00", miscellaneousHelper.RemoveCharacterFromBothEnd("  100.00    ", " "));
	}
	
	/**
	 * 
	 * Run Unit Test EncodeBase64 Convert String into base64Encoded String
	 */
	@Test
	public void testEncodeBase64()
	{
		assertEquals("aGVsbG8=", miscellaneousHelper.EncodeBase64("hello"));
	}
	
	
	/**
	 * 
	 * Run Unit Test DecodeBase64 Convert Encoded64 String into normal String
	 */
	@Test
	public void testDecodeBase64()
	{
		assertEquals("hello", miscellaneousHelper.DecodeBase64("aGVsbG8="));
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
		miscellaneousHelper = null;
		assertNull(miscellaneousHelper);

	}

}