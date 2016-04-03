/**
 * 
 */
package com.app.towerDefense.models;

/**
 * @author Sajjad Ashraf
 *
 */
public class MapPlayersStatisticsModel {
	
	String playerName;
	String currentSessionStart;
	String waveNo;
	String currentSessionEnd; 

	/**
	 * 
	 */
	public MapPlayersStatisticsModel() {
		
	}
	
	

	/**
	 * @param new_playerName
	 * @param new_currentSessionStart
	 * @param new_waveNo
	 * @param new_currentSessionEnd
	 */
	public MapPlayersStatisticsModel(String new_playerName,
			String new_currentSessionStart, String new_waveNo,
			String new_currentSessionEnd) {
		super();
		this.playerName = new_playerName;
		this.currentSessionStart = new_currentSessionStart;
		this.waveNo = new_waveNo;
		this.currentSessionEnd = new_currentSessionEnd;
	}

	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * @return the currentSessionStart
	 */
	public String getCurrentSessionStart() {
		return currentSessionStart;
	}

	/**
	 * @param currentSessionStart the currentSessionStart to set
	 */
	public void setCurrentSessionStart(String currentSessionStart) {
		this.currentSessionStart = currentSessionStart;
	}

	/**
	 * @return the waveNo
	 */
	public String getWaveNo() {
		return waveNo;
	}

	/**
	 * @param waveNo the waveNo to set
	 */
	public void setWaveNo(String waveNo) {
		this.waveNo = waveNo;
	}

	/**
	 * @return the currentSessionEtart
	 */
	public String getCurrentSessionEnd() {
		return currentSessionEnd;
	}

	/**
	 * @param currentSessionEtart the currentSessionEtart to set
	 */
	public void setCurrentSessionEnd(String currentSessionEtart) {
		this.currentSessionEnd = currentSessionEtart;
	}
	
	
	
	
}
