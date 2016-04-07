package com.app.towerDefense.models;

import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.app.towerDefense.staticContent.ApplicationStatics;
import com.app.towerDefense.utilities.MiscellaneousHelper;

/**
 * This class is for the Map Model
 * 
 * @author Sajjad Ashraf
 *
 */
public class MapModel implements Cloneable {
	public String mapSecret;
	public String mapAutoGeneratedDescription;
	public String mapRoutPath;
	public String mapRoutBoundaries;
	Point entryPoint;
	Point exitPoint;
	public ArrayList<Point> mapRoutPathList;
	public boolean isEntryDone;
	public boolean isExitDone;
	public int mapGridSelection[][];
	int mapWidth;
	int mapHeight;
	ArrayList<MapPlayersStatisticsModel> mapPlayersStatisticsArray = new ArrayList<MapPlayersStatisticsModel>();

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

	/**
	 * Default constructor
	 */
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
		this.mapSecret = new MiscellaneousHelper().getCurrentDateStr() + ApplicationStatics.MAP_SECRECT_TAG;
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
	 * @param new_isExitDone
	 *            checks if exit point is selected
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
	 * @param new_mapHeight
	 *            height of the map
	 */
	public void setMapHeight(int new_mapHeight) {
		this.mapHeight = new_mapHeight;
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
	 * @param new_entryPoint
	 *            entry point on the map
	 */
	public void setEntryPoint(Point new_entryPoint) {
		this.entryPoint = new_entryPoint;
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

	/**
	 * @return the mapRoutPath
	 */
	public String getMapRoutPath() {
		return mapRoutPath;
	}

	/**
	 * @param new_mapRoutPath
	 *            the mapRoutPath to set
	 */
	public void setMapRoutPath(String new_mapRoutPath) {
		this.mapRoutPath = new_mapRoutPath;
	}

	/**
	 * @return the mapRoutBoundaries
	 */
	public String getMapRoutBoundaries() {
		return mapRoutBoundaries;
	}

	/**
	 * @param new_mapRoutBoundaries
	 *            the mapRoutBoundaries to set
	 */
	public void setMapRoutBoundaries(String new_mapRoutBoundaries) {
		this.mapRoutBoundaries = new_mapRoutBoundaries;
	}

	/**
	 * @return the mapRoutPathList
	 */
	public ArrayList<Point> getMapRoutPathList() {
		if (mapRoutPath != null) {
			String[] tempList = mapRoutPath.split(";");
			mapRoutPathList = new ArrayList<Point>();
			for (int i = 0; i < tempList.length; i++) {
				String[] tempListShort = tempList[i].split(",");
				mapRoutPathList.add(new Point(Integer.parseInt(tempListShort[0]), Integer.parseInt(tempListShort[1])));
			}
		}
		return mapRoutPathList;
	}

	/**
	 * @param new_mapRoutPathList
	 *            the mapRoutPathList to set
	 */
	public void setMapRoutPathList(ArrayList<Point> new_mapRoutPathList) {
		this.mapRoutPathList = new_mapRoutPathList;
	}

	/**
	 * @return the mapPlayersStatisticsArray
	 */
	public ArrayList<MapPlayersStatisticsModel> getMapPlayersStatisticsArray() {
		return mapPlayersStatisticsArray;
	}

	/**
	 * @param mapPlayersStatisticsArray
	 *            the mapPlayersStatisticsArray to set
	 */
	public void addToMapPlayersStatisticsArray(MapPlayersStatisticsModel new_mapPlayersStatisticsModel) {

		boolean isAdded = false;
		int length = this.mapPlayersStatisticsArray.size();
		for (int i = 0; i < length; i++) {
			if (this.mapPlayersStatisticsArray.get(i).getCurrentSessionStart()
					.contains(new_mapPlayersStatisticsModel.getCurrentSessionStart())) {
				int index = i;
				this.mapPlayersStatisticsArray.get(index).setPlayerName(new_mapPlayersStatisticsModel.getPlayerName());
				this.mapPlayersStatisticsArray.get(index)
						.setCurrentSessionEnd(new_mapPlayersStatisticsModel.getCurrentSessionEnd());
				this.mapPlayersStatisticsArray.get(index).setWaveNo(new_mapPlayersStatisticsModel.getWaveNo());
				isAdded = true;
				System.out.println(" Update : ");
				break;
			}
		}
		if (!isAdded) {
			System.out.println(" New : ");
			this.mapPlayersStatisticsArray.add(new_mapPlayersStatisticsModel);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
