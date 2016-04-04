package com.app.towerDefense.gameLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.apache.log4j.Logger;

import com.app.towerDefense.guiComponents.JMenuBarComponent;
import com.app.towerDefense.guisystem.Game;
import com.app.towerDefense.models.MapModel;
import com.app.towerDefense.models.NearestToEndPointStrategy;
import com.app.towerDefense.models.NearestToTowerStrategy;
import com.app.towerDefense.models.PlayerModel;
import com.app.towerDefense.models.StrongestStrategy;
import com.app.towerDefense.models.Tower;
import com.app.towerDefense.models.TowerFactory;
import com.app.towerDefense.models.WeakestStrategy;
import com.app.towerDefense.staticContent.ApplicationStatics;

/**
 * This class loads the selected player's game
 * 
 * @author usbaitass
 *
 */
public class GameLoader {

	BufferedReader in;

	String playerName;
	String mapFilePath;
	int hpPlayer;
	int sunCurrency;
	int gameWave;
	int lastTowerID;
	ArrayList<Tower> tempTowerModelArray;
	String[] dataArray,dataFileInfoArray;
	File fileGameLoad;
	final static Logger logger = Logger.getLogger(GameLoader.class);
	//JFrame jframe;
	
	/**
	 * Constructor of GameLoader that takes the file path as a parameter
	 * @param new_file file path
	 */
	public GameLoader(File new_file){
		fileGameLoad = new_file;
		//jframe=new_jframe;
//		try {
//			//in = new BufferedReader(new FileReader(new_gamePath));
//			in = new BufferedReader(new FileReader(new_file.getAbsoluteFile()));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		tempTowerModelArray = new ArrayList<Tower>();
//		
//		//try {
//	
//			String temp = in.readLine();
//			
//			dataArray=temp.split(";");
//			
//			dataFileInfoArray = dataArray[0].split(",");
//			playerName=dataFileInfoArray[0];
//			mapFilePath=dataFileInfoArray[1];
//
//			hpPlayer = Integer.parseInt(dataArray[1]);
//			sunCurrency = Integer.parseInt(dataArray[2]);
//			gameWave = Integer.parseInt(dataArray[3]);
//			lastTowerID = Integer.parseInt(dataArray[4]);
//
//			Tower tempTower;
//			
//			for(int i=5; i<dataArray.length; i+=6){	
//				tempTower = TowerFactory.getTower(dataArray[i+1]);
//				tempTower.towerID = Integer.parseInt(dataArray[i]);
//				for(int j=1;j<Integer.parseInt(dataArray[i+2]); j++){
//					tempTower.upgradeTower();
//				}
//				tempTower.setXY(Integer.parseInt(dataArray[i+3]), Integer.parseInt(dataArray[i+4]));
//				String strStrategy = dataArray[i+5];
//				if(strStrategy=="NearToEND"){
//					tempTower.setStrategy(new NearestToEndPointStrategy());
//				}else if(strStrategy=="NearTower"){
//					tempTower.setStrategy(new NearestToTowerStrategy());
//				}else if(strStrategy=="Strongest"){
//					tempTower.setStrategy(new StrongestStrategy());
//				}else if(strStrategy=="Weakest"){
//					tempTower.setStrategy(new WeakestStrategy());
//				}
//				tempTowerModelArray.add(tempTower);
//			}
//
//			 ApplicationStatics.PLAYERMODEL = new PlayerModel(playerName, sunCurrency, hpPlayer, gameWave);
//			 ApplicationStatics.PLAYERMODEL.towerModelArray = tempTowerModelArray;
//			 ApplicationStatics.PLAYERMODEL.lastTowerID = lastTowerID;
//			 
//			 System.out.println("HERE lastTowerID:"+ApplicationStatics.PLAYERMODEL.lastTowerID+" read:"+lastTowerID);
//			 
//			// ApplicationStatics.PLAYERMODEL.printAllTowers();
//			in.close();
//			
//			// Map Load
//			File file = new File(mapFilePath);
//			if(file.exists() && !file.isDirectory()) { 
////				logger.info( String.format(ApplicationStatics.MSG_FILE_SELECT, "Loading Map"," Name:"+file.getName()+" "));
////				MapModel mapModel = (new com.app.towerDefense.utilities.FileStorage())
////						.openMapFile(file);
////				if (mapModel.mapSecret.contains(ApplicationStatics.MAP_SECRECT_TAG)) {
////					//Update Player Name on Screen
////					ApplicationStatics.PLAYERMODEL.playerName = playerName.replaceAll(" ", "_");
////					logger.info(ApplicationStatics.MSG_GAME_PLAYER_NAME+" : "+ApplicationStatics.PLAYERMODEL.playerName);
////					Game.getInstance().refreshGameFrameTitle();
////					
////					JMenuBarComponent jMenuBarComponent = new JMenuBarComponent();
////					jMenuBarComponent.loadGamePlayGrid(jframe, mapModel, file, false);
////					recalculate();
////				}
//				
//			}
//			else
//			{
//				 throw new Exception("Map file not found. \n Please past file on folloing path and then try again. \n Path:"+file.getAbsolutePath()); 
//			}
			
			/*
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/

	}
	
	/**
	 * This method is called when user selects the game to load
	 * it reads the data from a file and loads the game as it was saved
	 */
	public void load(){
		try {
			//in = new BufferedReader(new FileReader(new_gamePath));
			in = new BufferedReader(new FileReader(fileGameLoad.getAbsoluteFile()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tempTowerModelArray = new ArrayList<Tower>();
		
		try {
	
			String temp = in.readLine();
			
			dataArray=temp.split(";");
			
			dataFileInfoArray = dataArray[0].split(",");
			playerName=dataFileInfoArray[0];
			mapFilePath=dataFileInfoArray[1];

			hpPlayer = Integer.parseInt(dataArray[1]);
			sunCurrency = Integer.parseInt(dataArray[2]);
			gameWave = Integer.parseInt(dataArray[3]);
			lastTowerID = Integer.parseInt(dataArray[4]);

			Tower tempTower;
			
			for(int i=5; i<dataArray.length; i+=6){	
				tempTower = TowerFactory.getTower(dataArray[i+1]);
				tempTower.towerID = Integer.parseInt(dataArray[i]);
				for(int j=1;j<Integer.parseInt(dataArray[i+2]); j++){
					tempTower.upgradeTower();
				}
				tempTower.setXY(Integer.parseInt(dataArray[i+3]), Integer.parseInt(dataArray[i+4]));
				String strStrategy = dataArray[i+5];
				if(strStrategy.equalsIgnoreCase("NearToEND")){
					tempTower.setStrategy(new NearestToEndPointStrategy());
				}else if(strStrategy.equalsIgnoreCase("NearTower")){
					tempTower.setStrategy(new NearestToTowerStrategy());
				}else if(strStrategy.equalsIgnoreCase("Strongest")){
					tempTower.setStrategy(new StrongestStrategy());
				}else if(strStrategy.equalsIgnoreCase("Weakest")){
					tempTower.setStrategy(new WeakestStrategy());
				}
				tempTowerModelArray.add(tempTower);
			}

			 ApplicationStatics.PLAYERMODEL = new PlayerModel(playerName, sunCurrency, hpPlayer, gameWave);
			 ApplicationStatics.PLAYERMODEL.towerModelArray = tempTowerModelArray;
			 ApplicationStatics.PLAYERMODEL.lastTowerID = lastTowerID;
			 
		//	 System.out.println("HERE lastTowerID:"+ApplicationStatics.PLAYERMODEL.lastTowerID+" read:"+lastTowerID);
			 
			// ApplicationStatics.PLAYERMODEL.printAllTowers();
			in.close();
			// Map Load
//			File file = new File(mapFilePath);
//			if(file.exists() && !file.isDirectory()) { 
////				logger.info( String.format(ApplicationStatics.MSG_FILE_SELECT, "Loading Map"," Name:"+file.getName()+" "));
////				MapModel mapModel = (new com.app.towerDefense.utilities.FileStorage())
////						.openMapFile(file);
////				if (mapModel.mapSecret.contains(ApplicationStatics.MAP_SECRECT_TAG)) {
////					//Update Player Name on Screen
////					ApplicationStatics.PLAYERMODEL.playerName = playerName.replaceAll(" ", "_");
////					logger.info(ApplicationStatics.MSG_GAME_PLAYER_NAME+" : "+ApplicationStatics.PLAYERMODEL.playerName);
////					Game.getInstance().refreshGameFrameTitle();
////					
////					JMenuBarComponent jMenuBarComponent = new JMenuBarComponent();
////					jMenuBarComponent.loadGamePlayGrid(jframe, mapModel, file, false);
////					recalculate();
////				}
//				returnMsg=mapFilePath;
//			}
//			else
//			{
//				returnMsg="ERROR:Map file not found. \n Please past file on folloing path and then try again. \n Path:"+file.getAbsolutePath(); 
//			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//returnMsg="ERROR:"+e.getMessage();
		}
		
	
	}
	
	/**
	 * This method selects the map path from data that was read from load()
	 * @return map path string
	 */
	public String getMapFilePath(){
		String returnMsg="";
		try {
			
			in = new BufferedReader(new FileReader(fileGameLoad.getAbsoluteFile()));
				
				String temp = in.readLine();
				
				dataArray=temp.split(";");
				
				dataFileInfoArray = dataArray[0].split(",");
				playerName=dataFileInfoArray[0];
				mapFilePath=dataFileInfoArray[1];
				returnMsg =mapFilePath;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return returnMsg;
	}
	
	/**
	 * This method recalculates the towers range based on their given location
	 */
	public void recalculate(){
		
		for(int i=0; i<ApplicationStatics.PLAYERMODEL.towerModelArray.size(); i++){
			ApplicationStatics.PLAYERMODEL.towerModelArray.get(i).calculateRangeCircleCoordinates();
		}
		
	}
	
//END
}
