package com.app.towerDefence.models;

public class MapModel {
	public String mapSecret;
	public boolean isEntryDone;
	public boolean isExitDone;
	public int mapGridSelection[][];
	int mapWidth;
	int mapHeight;
	
		
	public MapModel(String mapSecret, boolean isEntryDone, boolean isExitDone,
			int[][] mapGridSelection, int mapWidth, int mapHeight) {
		super();
		this.mapSecret = mapSecret;
		this.isEntryDone = isEntryDone;
		this.isExitDone = isExitDone;
		this.mapGridSelection = mapGridSelection;
		this.mapWidth=mapWidth;
		this.mapHeight=mapHeight;
	}
	
	public MapModel() {
		// TODO Auto-generated constructor stub
	}

	public String getMapSecret() {
		return mapSecret;
	}
	public void setMapSecret(String mapSecret) {
		this.mapSecret = mapSecret;
	}
	public boolean isEntryDone() {
		return isEntryDone;
	}
	public void setEntryDone(boolean isEntryDone) {
		this.isEntryDone = isEntryDone;
	}
	public boolean isExitDone() {
		return isExitDone;
	}
	public void setExitDone(boolean isExitDone) {
		this.isExitDone = isExitDone;
	}
	public int[][] getMapGridSelection() {
		return mapGridSelection;
	}
	public void setMapGridSelection(int[][] mapGridSelection) {
		this.mapGridSelection = mapGridSelection;
	}

	public int getMapWidth() {
		return mapWidth;
	}

	public void setMapWidth(int mapWidth) {
		this.mapWidth = mapWidth;
	}

	public int getMapHeight() {
		return mapHeight;
	}

	public void setMapHeight(int mapHeight) {
		this.mapHeight = mapHeight;
	}
	
	
	
	
}
