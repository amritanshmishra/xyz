package com.app.towerDefense.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.towerDefense.gameLogic.LogReader;
import com.app.towerDefense.gameLogic.Map;
import com.app.towerDefense.models.MapModel;
import com.app.towerDefense.models.Tower;
import com.app.towerDefense.staticContent.ApplicationStatics;
import com.app.towerDefense.staticContent.AppilicationEnums.E_LogViewerState;
import com.app.towerDefense.utilities.FileStorage;
import com.app.towerDefense.utilities.MiscellaneousHelper;

/**
 * The class <code>LogReaderTest</code> contains tests for the class
 * <code>{@link LogReader}</code>.
 * 
 * 
 * @author Sajjad Ashraf
 * @version 1.0
 */
public class LogReaderTest {

	File file ;
	LogReader logReader;
	E_LogViewerState logReadingState;
	Tower tower;
	
	public LogReaderTest() {
	}
	
	/**
	 * Test case Initialization for LogReaderTest
	 */
	@Before
	public void beforeLogReaderTest() {
		if(System.getProperty("os.name").contains("Windows"))
		{
			 file = new File("testfiles\\gameLog.log");//for Windows OS
		}
		else
		{
			file= new File("testfiles/gameLog.log"); //for Mac OSX
		}

		logReadingState=E_LogViewerState.GlobalLog;
		logReader= new LogReader(file.getPath(), logReadingState, tower);
		ApplicationStatics.setLog_Current_Session_Tag("20160407102707423");
		//tower= new 
		System.out
				.println("@BeforeClass - oneTimeSetUp-Creation");
	}
	
	/**
	 * Test case for Log Reader Constructors
	 */
	@Test
	public void testLogReader() {
		logReader= new LogReader(file.getPath(), logReadingState, tower);
		assertNotNull(logReader);
		assertEquals(file, logReader.getFile());
		assertEquals(logReadingState, logReader.getLogReadingState());
		assertEquals(tower, logReader.getTower());
	}
	
	/**
	 * Test case for Log Reader Constructors
	 */
	@Test
	public void testParseForCurrentSession() {
		//Set Log Session
		String result =logReader.parseForCurrentSession();
		assertEquals(7867, result.length());
		
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
	public void afterLogReaderTest() throws Exception {
		// Add additional tear down code here
		System.out.println("@AfterClass - oneTimeTearDown");		
		file = null;
		logReader=null;
		logReadingState=null;
		assertNull(file);
		assertNull(logReader);
		assertNull(logReadingState);
		assertNull(tower);
	}

}
