package com.app.towerDefense.gameLogic;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.app.towerDefense.models.MapModel;
import com.app.towerDefense.models.MapPlayersStatisticsModel;
import com.app.towerDefense.models.Tower;
import com.app.towerDefense.staticContent.AppilicationEnums.E_LogViewerState;
import com.app.towerDefense.staticContent.ApplicationStatics;
import com.app.towerDefense.utilities.FileStorage;
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
			return parseLogForTower();
		}
		else if(E_LogViewerState.TowerCollectionLog == logReadingState){
			logResultant =  parseLogForTowersCollection();
		}
		else if(E_LogViewerState.MapPlayersStatistics == logReadingState){
			return parseLogForMapPlayerStatistics();
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
	
	public String parseLogForTowersCollection(){
		// get Current Session Log
		logResultant = parseForCurrentSession();
		
		Pattern pattern = Pattern.compile("(.+Tower.+)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(logResultant);
	    StringBuilder sb = new StringBuilder();
	    while (matcher.find()) {
	    	sb.append(matcher.group()+"\n");     
		}
	    logResultant = sb.toString();
		return logResultant;
	}
	
	public String parseLogForTower(){
		logResultant = parseLogForTowersCollection();
		Pattern pattern ;
		if(tower == null){
			pattern = Pattern.compile("(.+Tower_.+_towerID_.+)", 
					Pattern.CASE_INSENSITIVE);
		}
		else
			pattern = Pattern.compile("(.+Tower_"+tower.getTowerName()+"_towerID_"+tower.towerID+".+)", 
				Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(logResultant);
	    StringBuilder sb = new StringBuilder();
	    while (matcher.find()) {
	    	sb.append(matcher.group()+"\n");  
	    }
	    logResultant = sb.toString();
		return logResultant;
	}
	
	public String parseLogForMapPlayerStatistics(){
		/*
		if(ApplicationStatics.MAP_MODEL!= null && 
		   ApplicationStatics.MAP_MODEL.getMapPlayersStatisticsArray()!= null &&
		   ApplicationStatics.MAP_MODEL.getMapPlayersStatisticsArray().size() > 0){
			*/
		if(ApplicationStatics.MAP_CURRENT_OPENED_FILE_PATH != "")
		{
			File file = new File(ApplicationStatics.MAP_CURRENT_OPENED_FILE_PATH);
			MapModel mapModel = (new FileStorage()).openMapFile(file);

	        Collections.sort(mapModel.getMapPlayersStatisticsArray(), new Comparator<MapPlayersStatisticsModel>(){

	          public int compare(MapPlayersStatisticsModel m1, MapPlayersStatisticsModel m2)
	          {
	             return m2.getWaveNo().compareTo(m1.getWaveNo());
	          }
	        });
	        
		   int length=mapModel.getMapPlayersStatisticsArray().size();
		   StringBuilder sb = new StringBuilder(); 
		   sb.append(" -------------------------------------------------------------------------------------------------\n");
		   sb.append(" S.No	PLAYER NAME	 START			WAVE NO.	      END \n");
		   sb.append(" -------------------------------------------------------------------------------------------------\n");
		   for (int i = 0; i < length; i++) {
			   	sb.append(" "+(i+1)+"	");
				sb.append(mapModel.getMapPlayersStatisticsArray().get(i).getPlayerName()+"	         ");
				sb.append(mapModel.getMapPlayersStatisticsArray().get(i).getCurrentSessionStart()+"	");
				sb.append(mapModel.getMapPlayersStatisticsArray().get(i).getWaveNo()+"	              ");
				sb.append(mapModel.getMapPlayersStatisticsArray().get(i).getCurrentSessionEnd()+"\n");
		   }
		   logResultant=sb.toString();
		}
		else
		{
			logResultant="First load Map.";
		}
		return logResultant;
	}
	
	/*
	public static void main(String new_args[]) {
	
		File file = new File(ApplicationStatics.LOG_File_PATH);
		String data = new MiscellaneousHelper().readFile(file);
		
//		Pattern pattern = Pattern.compile("((.|\n)*)LOG_CURRENT_SESSION_TAG_20160402161505652");
//	    Matcher matcher = pattern.matcher(data);
//	    int index=1;
//	    // check all occurance
//	    while (matcher.find()) {
//	      //System.out.println(index++);
//	      //System.out.println("Start index: " + matcher.start());
//	      //System.out.println(" End index: " + matcher.end() + " ");
//	      //System.out.println(matcher.group(1));
//	      //System.out.println("count : "+matcher.groupCount());
//	      //System.out.println(data.substring(0,  matcher.end()));
//	      //data=data.substring(matcher.end(), data.length());
//	      //System.out.println(data);
//	    	//++index;	      
//	    }
//	    
 * 
//	    
		//System.out.println(data);
		//Pattern pattern = Pattern.compile(".+TowerName_Freezer_1_Strat((.|\n)*)TowerName_Freezer_1_End");
	    //pattern = Pattern.compile("^(\\w+)\\s");
		String test = "\r\n  User Comments: This is \t a\ta \n test \n\n message \n";
		
		//Pattern pattern = Pattern.compile("^.+User Comments:\\s+(.*)", Pattern.DOTALL);
		//Pattern pattern = Pattern.compile("^(.+)TowerName_Freezer_1_Strat(.*)TowerName_Freezer_1_End", Pattern.DOTALL);
		
		//Pattern pattern = Pattern.compile("^(.+)TowerName_Freezer_1_Strat(.*)TowerName_Freezer_1_End", Pattern.DOTALL);
		
	    
		//pattern = Pattern.compile(".*TowerName_Freezer_1_Strat(.|\n).TowerName_Freezer_1_End");
	      //pattern = Pattern.compile("^(\\S+)$", Pattern.MULTILINE);
	    //pattern = Pattern.compile("(.*)TowerName_Freezer_1_Strat((.|\n)*)");
		
		//Matcher matcher = pattern.matcher(test);		
		
		//For TowersCollection
//		
//		Pattern pattern = Pattern.compile("(.+Tower.+)", Pattern.CASE_INSENSITIVE);
//		Matcher matcher = pattern.matcher(data);
//	    int index=1;
//	    StringBuilder sb = new StringBuilder();
//	    while (matcher.find()) {
//	    	sb.append(matcher.group()+"\n");
//  
//	    }
//	    data = sb.toString();
	    
	    //System.out.println("++++++++++++++++++++++++++++++++TOWER COLLECTION++++++++++++++++++++++++++++++++++++++");
	    //System.out.println(sb.toString());
	    //System.out.println("\r\n\r\n");
	    
	    
	  //For Towers
	    //pattern = Pattern.compile("(.+Tower.+)", Pattern.CASE_INSENSITIVE);
	    
		//pattern = Pattern.compile("^.+User Comments:\\s+(.*)", Pattern.DOTALL);
		//TowerName_Freezer_1_Strat(.|\n)+TowerName_Freezer_1_End
		Pattern pattern = Pattern.compile("(.+Tower_Shooter_towerID_0.+)", 
				Pattern.CASE_INSENSITIVE);
	    //(.+TowerName_Freezer_1_Strat)((.|\n)*)(.*TowerName_Freezer_1_End)
		//Pattern pattern = Pattern.compile(".+TowerName_Freezer_1_Strat(.*)TowerName_Freezer_1_End",Pattern.DOTALL);
		//Pattern pattern = Pattern.compile("[\\s\\S]*TowerName_Freezer_1_Strat(.*)TowerName_Freezer_1_End",Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(data);
	    int index=1;
	    StringBuilder sb = new StringBuilder();
	    while (matcher.find()) {
	    	//sb.append(matcher.group()+"\n");
	    	System.out.println("Index : "+(index++));
	    	sb.append(matcher.group()+"\n");
		    //System.out.println("count : "+matcher.groupCount());
	
	    }
	    //data = sb.toString();
	    //System.out.println("++++++++++++++++++++++++++++++++TOWERS++++++++++++++++++++++++++++++++++++++");
	    System.out.println(sb.toString());
	    //System.out.println("\r\n\r\n");
	    
	    
	}
	*/

}