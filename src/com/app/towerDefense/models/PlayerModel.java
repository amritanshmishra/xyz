package com.app.towerDefense.models;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.app.towerDefense.staticContent.ApplicationStatics;

/**
 * 
 * @author usbaitass
 * 
 *         Player class that stores the Player information such as sunCurrency,
 *         hp, gameWave, player name and his Towers.
 * 
 */
public class PlayerModel extends Observable{

	private int sunCurrency;
	private int hpPlayer;
	private int gameWave;
	private String playerName;
	public ArrayList<TowerModel> towerModelArray;

	/**
	 * Constructor that initializes default values
	 */
	public PlayerModel() {
		playerName = "defaultName";
		sunCurrency = 500;
		hpPlayer = 10;
		gameWave = 1;
		towerModelArray = new ArrayList<TowerModel>();
	}

	/**
	 * Constructor that assigns its parameter to class attributes
	 * 
	 * @param new_playerName
	 *            Player name
	 * @param new_sunCurrency
	 *            Player's amount of money
	 * @param new_hpPlayer
	 *            Player health status
	 * @param new_gameWave
	 *            Game wave status
	 */
	public PlayerModel(String new_playerName, int new_sunCurrency, int new_hpPlayer, int new_gameWave) {
		playerName = new_playerName;
		sunCurrency = new_sunCurrency;
		hpPlayer = new_hpPlayer;
		gameWave = new_gameWave;
		towerModelArray = new ArrayList<TowerModel>();
		
	}

	/**
	 * @return amount of sun currency Player has.
	 */
	public int getSunCurrency() {
		return sunCurrency;
	}

	/**
	 * adds value to sun currency
	 * 
	 * @param value
	 *            amount of increase
	 */
	public void addSunCurrency(int value) {
		sunCurrency += value;
		setChanged();
		notifyObservers();
	}

	/**
	 * subtracts value from sun currency
	 * 
	 * @param value
	 *            amount of decrease
	 */
	public void subSunCurrency(int value) {
		sunCurrency -= value;
		setChanged();
		notifyObservers();
	}

	/**
	 * @return amount of health Player has.
	 */
	public int getHpPlayer() {
		return hpPlayer;
	}

	/**
	 * 
	 * @return current game level
	 */
	public int getGameWave() {
		return gameWave;
	}

	/**
	 * 
	 * @return Name of the Player
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * creates new Tower Model and adds it to ArrayList of Tower Models of
	 * Player
	 * 
	 * @param new_towerID
	 *            Tower id
	 * @return bought tower model
	 */
	public TowerModel buyTower(int new_towerID) {
		TowerModel tempTM = null;
		
		switch (new_towerID) {
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

		ApplicationStatics.HAS_BOUGHT_TOWER = true;
		subSunCurrency(tempTM.getTowerCost());
		
		System.out.println("Player bought Tower id = " + Integer.toString(new_towerID));

		return tempTM;
	}

	/**
	 * deletes the tower from ArrayList of Tower Models
	 * 
	 * @param new_towerID
	 *            Tower id that will be removed
	 * @return true if deleted successfully
	 */
	public boolean sellTower(int new_towerID) {
		System.out.println("inside sellTower()");
		if (towerModelArray.isEmpty()) {
			return false;
		} else {
			int refundTM = towerModelArray.get(new_towerID).getRefund();
			addSunCurrency(refundTM);
			towerModelArray.remove(new_towerID);
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "You were refunded = " + Integer.toString(refundTM) + " suns.");
			return true;
		}
	}

	/**
	 * call the function from tower model that upgrade the tower
	 * 
	 * @param new_towerID
	 *            Tower id
	 * @return Tower model with upgraded attributes
	 */
	public TowerModel upgradeTower(int new_towerID) {
		TowerModel tempTM = towerModelArray.get(new_towerID); 
		tempTM.upgradeTower();
		return tempTM;
	}

	/**
	 * prints all towers in the ArrayList in System command
	 */
	public void printAllTowers() {
		for (int i = 0; i < towerModelArray.size(); i++) {
			System.out.println(towerModelArray.get(i).getTowerName() + " x="+towerModelArray.get(i).getX() + " y="+towerModelArray.get(i).getY());
		}
	}
	
	/**
	 * This method gets the tower array
	 * @return the tower model array list
	 */
	public ArrayList<TowerModel> getTowerModelArray(){
		return towerModelArray;
	} 
	
	

	// END
}
