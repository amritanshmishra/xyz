package com.app.towerDefense.guisystem;

import java.io.FileNotFoundException;
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

	PrintWriter out;

	/**
	 * Constructor
	 */
	public GameSaver() {
		savePlayerData();

	}

	public void savePlayerData() {

		try {
			out = new PrintWriter("Data.txt");

			String playerName = ApplicationStatics.PLAYERMODEL.getPlayerName();
			int hpPlayer = ApplicationStatics.PLAYERMODEL.getHpPlayer();
			int sunCurrency = ApplicationStatics.PLAYERMODEL.getSunCurrency();
			int gameWave = ApplicationStatics.PLAYERMODEL.getGameWave();
			int lastTowerID = ApplicationStatics.PLAYERMODEL.lastTowerID;

			out.println(playerName+"_PLAYERNAME");
			out.println(hpPlayer+"_HP");
			out.println(sunCurrency+"_SUNS");
			out.println(gameWave+"_WAVE");
			out.println(lastTowerID+"_LASTTOWERID");

			for (int i = 0; i < ApplicationStatics.PLAYERMODEL.towerModelArray.size(); i++) {
				out.print("Tower:"+ApplicationStatics.PLAYERMODEL.towerModelArray.get(i).towerID);
				out.print(" name:"+ApplicationStatics.PLAYERMODEL.towerModelArray.get(i).getTowerName());
				out.print(" level:"+ApplicationStatics.PLAYERMODEL.towerModelArray.get(i).getTowerlevel());
				out.print(" x:"+ApplicationStatics.PLAYERMODEL.towerModelArray.get(i).getX());
				out.print(" y:"+ApplicationStatics.PLAYERMODEL.towerModelArray.get(i).getY());
				out.println(" strategy:"+ApplicationStatics.PLAYERMODEL.towerModelArray.get(i).getStrategy().getStrategyName());
			}

			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
