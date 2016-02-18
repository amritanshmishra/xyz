package com.app.towerDefense.models;

import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is for the Map Model
 * 
 * @author Sajjad Ashraf
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
	 * 
	 * @param new_mapSecret
	 *            the string used to detect the map belongs to our application
	 * @param new_mapAutoGeneratedDescription
	 *            map description
	 * @param new_entryPoint
	 *            entry point on the map
	 * @param new_exitPoint
	 *            exit point on the map
	 * @param new_isEntryDone
	 *            has an entry point
	 * @param new_isExitDone
	 *            has an exit point
	 * @param new_mapGridSelection
	 *            map grid selections
	 * @param new_mapWidth
	 *            map width
	 * @param new_mapHeight
	 *            map height
	 */
	public MapModel(String new_mapSecret, String new_mapAutoGeneratedDescription, Point new_entryPoint,
			Point new_exitPoint, boolean new_isEntryDone, boolean new_isExitDone, int[][] new_mapGridSelection,
			int new_mapWidth, int new_mapHeight) {
		super();
		this.mapSecret = new_mapSecret;
		this.mapAutoGeneratedDescription = new_mapAutoGeneratedDescription;
		this.entryPoint = new_entryPoint;
		this.exitPoint = new_exitPoint;
		this.isEntryDone = new_isEntryDone;
		this.isExitDone = new_isExitDone;
		this.mapGridSelection = new_mapGridSelection;
		this.mapWidth = new_mapWidth;
		this.mapHeight = new_mapHeight;
	}

	public MapModel() {
		// default constructor
	}

	/**
	 * This method gets map secret
	 * 
	 * @return the mapSecret
	 */
	public String getMapSecret() {
		return mapSecret;
	}

	/**
	 * This method sets the map secret
	 */
	public void setMapSecret() {
		this.mapSecret = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + "_Team5";
	}

	/**
	 * This method gets map description
	 * 
	 * @return the map auto generated description
	 */
	public String getMapAutoGeneratedDescription() {
		return mapAutoGeneratedDescription;
	}

	/**
	 * This method sets the map auto generated description
	 * 
	 * @param new_mapAutoGeneratedDescription
	 *            the description
	 */
	public void setMapAutoGeneratedDescription(String new_mapAutoGeneratedDescription) {
		this.mapAutoGeneratedDescription = new_mapAutoGeneratedDescription;
	}

	/**
	 * This method gets the isEntry done
	 * 
	 * @return entryDone Check if entry point is selected
	 */
	public boolean isEntryDone() {
		return isEntryDone;
	}

	/**
	 * This method sets the isEntryDone
	 * 
	 * @param new_isEntryDone
	 *            check if entry point selected
	 */
	public void setEntryDone(boolean new_isEntryDone) {
		this.isEntryDone = new_isEntryDone;
	}

	/**
	 * this method checks if the exit point is chosen
	 * 
	 * @return isExitDone boolean value
	 */
	public boolean isExitDone() {
		return isExitDone;
	}

	/**
	 * this method sets the exit point
	 * 
	 * @param new_isExitDone checks if exit point is selected
	 */
	public void setExitDone(boolean new_isExitDone) {
		this.isExitDone = new_isExitDone;
	}

	/**
	 * this method gets map grid selection
	 * 
	 * @return mapGridSelection map grid selection
	 */
	public int[][] getMapGridSelection() {
		return mapGridSelection;
	}

	/**
	 * this method sets the map grid selection
	 * 
	 * @param new_mapGridSelection
	 *            map grid selection
	 */
	public void setMapGridSelection(int[][] new_mapGridSelection) {
		this.mapGridSelection = new_mapGridSelection;
	}

	/**
	 * this method gets map width
	 * 
	 * @return mapwidth width of the map
	 */
	public int getMapWidth() {
		return mapWidth;
	}

	/**
	 * this method sets map width
	 * 
	 * @param mapWidth
	 *            width of the map
	 */
	public void setMapWidth(int mapWidth) {
		this.mapWidth = mapWidth;
	}

	/**
	 * this method gets the height of the map
	 * 
	 * @return mapHeight height of the map
	 */
	public int getMapHeight() {
		return mapHeight;
	}

	/**
	 * this method sets the map height
	 * 
	 * @param mapHeight
	 *            height of the map
	 */
	public void setMapHeight(int mapHeight) {
		this.mapHeight = mapHeight;
	}

	/**
	 * this returns the entry point on the map
	 * 
	 * @return entryPoint entry point on the map
	 */
	public Point getEntryPoint() {
		return entryPoint;
	}

	/**
	 * this method sets the entry point on the map
	 * 
	 * @param entryPoint
	 *            entry point on the map
	 */
	public void setEntryPoint(Point entryPoint) {
		this.entryPoint = entryPoint;
	}

	/**
	 * this method returns the exit point
	 * 
	 * @return exitPoint exit point on the map
	 */
	public Point getExitPoint() {
		return exitPoint;
	}

	/**
	 * this method sets the exit point on the map
	 * 
	 * @param new_exitPoint
	 *            exit point on the map
	 */
	public void setExitPoint(Point new_exitPoint) {
		this.exitPoint = new_exitPoint;
	}

}
