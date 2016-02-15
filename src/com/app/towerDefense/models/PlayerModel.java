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
		sunCurrency = 100;
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
		
		System.out.println("inside buyTower() in Player Model");
		
		TowerModel tempTM = new TowerModel(new_towerID);
		towerModelArray.add(tempTM);
		subSunCurrency(tempTM.getTowerCost());
		
		System.out.println("Player bought Tower id = "+ Integer.toString(new_towerID));
		return true;
	}

	// END
}
