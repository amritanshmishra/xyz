package com.app.towerDefense.gameLogic;

import java.io.File;

import com.app.towerDefense.staticContent.AppilicationEnums.E_LogViewerState;
import com.app.towerDefense.utilities.MiscellaneousHelper;

/**
 * This Class contain the logic how to read a log file depending upload it state
 * 
 * @author Sajjad Ashraf
 * 
 */
public class LogReader {
	File file;
	String logFilePath;
	String logResultant;
	E_LogViewerState logReadingState; 

	public LogReader(String new_log_file_path, E_LogViewerState new_elog_viewer_state)
	{
		logFilePath=new_log_file_path;
		file = new File(logFilePath);
		logReadingState=new_elog_viewer_state;
		logResultant="";
	}
	
	public String read()
	{
		logResultant= new MiscellaneousHelper().readFile(file);
		return logResultant;
	}

}
