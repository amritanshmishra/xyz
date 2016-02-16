package com.app.towerDefense.models;

import java.util.ArrayList;

/**
 * 
 * @author usbaitass
 * 
 */
public class PlayerModel {

	private int sunCurrency;
	private int hpPlayer;
	private int gameWave;
	private String playerName;
	private ArrayList<TowerModel> towerModelArray;

	public PlayerModel() {
		playerName = "defaultName";
		sunCurrency = 500;
		hpPlayer = 10;
		gameWave = 1;
		towerModelArray = new ArrayList<TowerModel>();
	}

	public PlayerModel(String new_playerName, int new_sunCurrency, int new_hpPlayer, int new_gameWave) {
		playerName = new_playerName;
		sunCurrency = new_sunCurrency;
		hpPlayer = new_hpPlayer;
		gameWave = new_gameWave;
		towerModelArray = new ArrayList<TowerModel>();
	}

	public int getSunCurrency() {
		return sunCurrency;
	}
	
	public void addSunCurrency(int value){
		sunCurrency += value;
	}
	
	public void subSunCurrency(int value){
		sunCurrency -= value;
	}
	
	public int getHpPlayer() {
		return hpPlayer;
	}
	
	public void setHpPlayer(int new_hpPlayer) {
		hpPlayer = new_hpPlayer;
	}
	
	public int getGameWave() {
		return gameWave;
	}
	
	public String getPlayerName(){
		return playerName;
	}
	
	public boolean buyTower(int new_towerID){
		TowerModel tempTM = null;;
		switch(new_towerID){
		case 0:
			tempTM = new TowerModel1();
			break;
		case 1:
			tempTM = new TowerModel2();
			break;
		case 2:
			tempTM = new TowerModel3();
			break;
		case 3:
			tempTM = new TowerModel4();
			break;
		case 4:
			tempTM = new TowerModel5();
			break;
		}
		towerModelArray.add(tempTM);
		
		subSunCurrency(tempTM.getTowerCost());
		
		System.out.println("Player bought Tower id = "+ Integer.toString(new_towerID));
		return true;
	}
	
	public boolean sellTower(int new_towerID){
		System.out.println("inside sellTower()");
		if(towerModelArray.isEmpty()){
			return false;
		}else{
			addSunCurrency(towerModelArray.get(new_towerID).getTowerCost());
			towerModelArray.remove(new_towerID);
			return true;
		}
	}
	
	public boolean upgradeTower(int new_towerID){
		System.out.println("inside upgradeTower()");
		
		return true;
	}
	
	public void printAllTowers(){
		for(int i=0; i<towerModelArray.size() ;i++){
			System.out.println(towerModelArray.get(i).getTowerName());
		}
	}
	

	// END
}
