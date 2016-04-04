package com.app.towerDefense.gameLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.app.towerDefense.guiComponents.MapPanel;
import com.app.towerDefense.models.Tower;

import com.app.towerDefense.staticContent.ApplicationStatics;

/**
 * This class saves the game data
 * 
 * @author usbaitass
 *
 */
public class GameSaver {

	//PrintWriter out;
	FileWriter out;
	File file;
	String filePath; 
	/**
	 * Constructor
	 * @throws IOException 
	 */
	public GameSaver(File new_file) throws IOException {
		file=new_file;
		filePath = file.getPath();
		savePlayerData();		

	}

	public void savePlayerData() throws IOException {

		try {
			//out = new PrintWriter("Data.txt");
			//out = new PrintWriter(file.getAbsoluteFile());
			if (!filePath.endsWith(".tdg"))
				filePath += ".tdg";
			
			out = new FileWriter(filePath);

			//String playerName = ApplicationStatics.PLAYERMODEL.getPlayerName();
			String playerName = ApplicationStatics.PLAYERMODEL.getPlayerName()+","+ApplicationStatics.MAP_CURRENT_OPENED_FILE_PATH;
			int hpPlayer = ApplicationStatics.PLAYERMODEL.getHpPlayer();
			int sunCurrency = ApplicationStatics.PLAYERMODEL.getSunCurrency();
			int gameWave = ApplicationStatics.PLAYERMODEL.getGameWave();
			int lastTowerID = ApplicationStatics.PLAYERMODEL.lastTowerID;

			//out.print(playerName+":"+hpPlayer+":"+sunCurrency+":"+gameWave+":"+lastTowerID);
			out.write(playerName+";"+hpPlayer+";"+sunCurrency+";"+gameWave+";"+lastTowerID);
			
			for (int i = 0; i < ApplicationStatics.PLAYERMODEL.towerModelArray.size(); i++) {
				out.write(";"+ApplicationStatics.PLAYERMODEL.towerModelArray.get(i).towerID);
				out.write(";"+ApplicationStatics.PLAYERMODEL.towerModelArray.get(i).getTowerName());
				out.write(";"+ApplicationStatics.PLAYERMODEL.towerModelArray.get(i).getTowerlevel());
				out.write(";"+ApplicationStatics.PLAYERMODEL.towerModelArray.get(i).getX());
				out.write(";"+ApplicationStatics.PLAYERMODEL.towerModelArray.get(i).getY());
				out.write(";"+ApplicationStatics.PLAYERMODEL.towerModelArray.get(i).getStrategy().getStrategyName());
			}
			
			

			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
