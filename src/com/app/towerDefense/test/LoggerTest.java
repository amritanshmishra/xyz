package com.app.towerDefense.test;

import java.io.File;
import javax.swing.JTextArea;
import org.junit.*;
import com.app.towerDefense.gameLogic.LogReader;
import com.app.towerDefense.models.PlayerModel;
import com.app.towerDefense.models.Tower;
import com.app.towerDefense.staticContent.AppilicationEnums.E_LogViewerState;
import com.app.towerDefense.staticContent.ApplicationStatics;

/**
 * This class test each log of items(buy tower, sell tower, upgrade tower,
 * critter hits)
 * 
 * @author George Ekow-Daniels
 *
 */
public class LoggerTest {

	File file;
	JTextArea txtdisplay;
	E_LogViewerState e_logViewState;
	PlayerModel player;
	Tower tower1;
	Tower tower2;
	int viewtype = 1;
	LogReader lr;

	/**
	 * creates object befor test case
	 */
	@Before
	public void beforeloggerTestCase() {
		file = new File("testlog.txt");
		txtdisplay = new JTextArea();
		viewtype++;
		ApplicationStatics.isLogViewerOpen = true;
		ApplicationStatics.setLog_Current_Session_Tag("20160407111907423");
		player = new PlayerModel();

	}

}
