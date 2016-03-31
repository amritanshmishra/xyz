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

	// Log
	// final static Logger logger = Logger.getLogger(LogReader.class);

	public LogReader(String new_log_file_path,
			E_LogViewerState new_elog_viewer_state) {
		logFilePath = new_log_file_path;
		file = new File(logFilePath);
		logReadingState = new_elog_viewer_state;
		logResultant = "";
		// logger.info("Function Called :- LogReader(new_log_file_path:"+new_log_file_path+", new_elog_viewer_state: "+new_elog_viewer_state+")");
	}

	public String read() {
		logResultant = new MiscellaneousHelper().readFile(file);
		// logger.info("Function Called read() ");
		return logResultant;
	}

}
