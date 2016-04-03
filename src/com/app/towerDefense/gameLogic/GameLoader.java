package com.app.towerDefense.gameLogic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
	int hpPlayer;
	int sunCurrency;
	int gameWave;
	int lastTowerID;
	ArrayList<Tower> tempTowerModelArray;
	String[] dataArray;
	

	public GameLoader(String new_gamePath) {
		try {
			in = new BufferedReader(new FileReader(new_gamePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tempTowerModelArray = new ArrayList<Tower>();
		
		try {
	
			String temp = in.readLine();
			
			dataArray=temp.split(":");
			
			playerName = dataArray[0];

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
				if(strStrategy=="NearToEND"){
					tempTower.setStrategy(new NearestToEndPointStrategy());
				}else if(strStrategy=="NearTower"){
					tempTower.setStrategy(new NearestToTowerStrategy());
				}else if(strStrategy=="Strongest"){
					tempTower.setStrategy(new StrongestStrategy());
				}else if(strStrategy=="Weakest"){
					tempTower.setStrategy(new WeakestStrategy());
				}
				tempTowerModelArray.add(tempTower);
			}

			 ApplicationStatics.PLAYERMODEL = new PlayerModel(playerName, sunCurrency, hpPlayer, gameWave);
			 ApplicationStatics.PLAYERMODEL.towerModelArray = tempTowerModelArray;
			 ApplicationStatics.PLAYERMODEL.lastTowerID = lastTowerID;
			 
			 System.out.println("HERE lastTowerID:"+ApplicationStatics.PLAYERMODEL.lastTowerID+" read:"+lastTowerID);
			 
			// ApplicationStatics.PLAYERMODEL.printAllTowers();
			

			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void recalculate(){
		
		for(int i=0; i<ApplicationStatics.PLAYERMODEL.towerModelArray.size(); i++){
			ApplicationStatics.PLAYERMODEL.towerModelArray.get(i).calculateRangeCircleCoordinates();
		}
		
	}

}
