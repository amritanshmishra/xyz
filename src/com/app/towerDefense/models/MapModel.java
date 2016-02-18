package com.app.towerDefense.models;

import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This class is for the Map Model
 * 
 * @author Sajjad
 *
 */
public class MapModel {
	public String mapSecret;
	public String mapAutoGeneratedDescription;
	Point entryPoint;
	Point exitPoint;
	public boolean isEntryDone;
	public boolean isExitDone;
	public int mapGridSelection[][];
	int mapWidth;
	int mapHeight;

/**
 * The constructor for MapModel
 * @param new_mapSecret the string used to detect the map belongs to our application
 * @param new_mapAutoGeneratedDescription map description
 * @param new_entryPoint entry point on the map
 * @param new_exitPoint exit point on the map
 * @param new_isEntryDone has an entry point
 * @param new_isExitDone has an exit point
 * @param new_mapGridSelection map grid selections
 * @param new_mapWidth map width
 * @param new_mapHeight map height
 */
	public MapModel(String new_mapSecret, String new_mapAutoGeneratedDescription,
			Point new_entryPoint, Point new_exitPoint, boolean new_isEntryDone,
			boolean new_isExitDone, int[][] new_mapGridSelection, int new_mapWidth,
			int new_mapHeight) {
		super();
		this.mapSecret = new_mapSecret;
		this.mapAutoGeneratedDescription= new_mapAutoGeneratedDescription;
		this.entryPoint=new_entryPoint;
		this.exitPoint=new_exitPoint;
		this.isEntryDone = new_isEntryDone;
		this.isExitDone = new_isExitDone;
		this.mapGridSelection = new_mapGridSelection;
		this.mapWidth = new_mapWidth;
		this.mapHeight = new_mapHeight;
	}
	public MapModel()
	{
		
	}

	/**
	 * This method gets map secret
	 * @return the mapSecret
	 */
	public String getMapSecret() {
		return mapSecret;
	}

	/**
	 * This method sets the map secret
	 */
	public void setMapSecret() {
		this.mapSecret = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())+"_Team5";
	}
	
	/**
	 * This method gets map description
	 * @return the map auto generated description
	 */
	public String getMapAutoGeneratedDescription() {
		return mapAutoGeneratedDescription;
	}

	/**
	 * This method sets the map auto generated description
	 * @param mapAutoGeneratedDescription the description
	 */
	public void setMapAutoGeneratedDescription(
			String mapAutoGeneratedDescription) {
		this.mapAutoGeneratedDescription = mapAutoGeneratedDescription;
	}

	/**
	 * This method gets the isEntry done
	 * @return entryDone 
	 */
	public boolean isEntryDone() {
		return isEntryDone;
	}

	/**
	 * This method sets the isEntryDone
	 * @param isEntryDone
	 */
	public void setEntryDone(boolean isEntryDone) {
		this.isEntryDone = isEntryDone;
	}
	/**
	 * 
	 * @return isExitDone
	 */
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

	public Point getEntryPoint() {
		return entryPoint;
	}

	public void setEntryPoint(Point entryPoint) {
		this.entryPoint = entryPoint;
	}

	public Point getExitPoint() {
		return exitPoint;
	}

	public void setExitPoint(Point exitPoint) {
		this.exitPoint = exitPoint;
	}

}
