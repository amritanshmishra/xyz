package com.app.towerDefense.gameLogic;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.app.towerDefense.models.Tower;
import com.app.towerDefense.staticContent.AppilicationEnums.E_LogViewerState;
import com.app.towerDefense.staticContent.ApplicationStatics;
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
	Tower tower;

	// Log
	// final static Logger logger = Logger.getLogger(LogReader.class);

	public LogReader(String new_log_file_path,
			E_LogViewerState new_elog_viewer_state,
			Tower new_tower) {
		logFilePath = new_log_file_path;
		file = new File(logFilePath);
		logReadingState = new_elog_viewer_state;
		logResultant = "";
		tower = new_tower;
		// logger.info("Function Called :- LogReader(new_log_file_path:"+new_log_file_path+", new_elog_viewer_state: "+new_elog_viewer_state+")");
	}

	public String read() {
		logResultant = new MiscellaneousHelper().readFile(file);
		
		if(E_LogViewerState.CurrentSessionLog == logReadingState){
			return parseForCurrentSession();
		}
		else if(E_LogViewerState.TowerLog == logReadingState){
			logResultant= parseForCurrentSession();
		}
		else if(E_LogViewerState.TowerCollectionLog == logReadingState){
			logResultant =  parseForCurrentSession();
		}
		else if(E_LogViewerState.MapPlayersStatistics == logReadingState){
			return parseForCurrentSession();
		}
		// logger.info("Function Called read() ");
		return logResultant;
	}
	
	public String parseForCurrentSession(){
		logResultant = new MiscellaneousHelper().readFile(file);		
		Pattern pattern = Pattern.compile("((.|\n)*)"+ApplicationStatics.getLog_Current_Session_Tag());
	    Matcher matcher = pattern.matcher(logResultant);
	    while (matcher.find()) {
	      logResultant = logResultant.substring(matcher.end(),  logResultant.length());      
	    }
		return logResultant;
	}
	
	/*
	public static void main(String new_args[]) {
	
		File file = new File(ApplicationStatics.LOG_File_PATH);
		String data = new MiscellaneousHelper().readFile(file);
		
		Pattern pattern = Pattern.compile("((.|\n)*)LOG_CURRENT_SESSION_TAG_20160331220328194");
	    Matcher matcher = pattern.matcher(data);
	    int index=1;
	    // check all occurance
	    while (matcher.find()) {
	      System.out.println(index++);
	      //System.out.println("Start index: " + matcher.start());
	      //System.out.println(" End index: " + matcher.end() + " ");
	      //System.out.println(matcher.group(1));
	      //System.out.println("count : "+matcher.groupCount());
	      System.out.println(data.substring(0,  matcher.end()));
	    	//++index;
	      
	    }
	    //System.out.println(data);
	}
	*/

}