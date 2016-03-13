package com.app.towerDefense.bL;

import java.awt.Point;

import com.app.towerDefense.models.MapModel;
import com.app.towerDefense.staticContent.ApplicationStatics;
import com.app.towerDefense.staticContent.AppilicationEnums.*;

/**
 * This class validates map features(Entry,Exit,Scenery) and map path from the
 * root
 * 
 * @author Sajjad Ashraf
 *
 */
public class Map {

	/**
	 * This method validates the map
	 * 
	 * @param new_mapModel
	 *            as a map
	 * @return the routeStatus
	 */
	public String mapValidations(MapModel new_mapModel) {
		String routeStatus = null;
		if (!new_mapModel.isEntryDone || new_mapModel.getEntryPoint() == null) {
			routeStatus = "Please First Select an Entry Point.";
			new_mapModel.setMapAutoGeneratedDescription(routeStatus);
		}

		else if (!new_mapModel.isExitDone || new_mapModel.getExitPoint() == null) {
			routeStatus = "Please First Select an Exit Point.";
			new_mapModel.setMapAutoGeneratedDescription(routeStatus);
		}

		else {
			routeStatus = mapPathValidation(new_mapModel);
			if (routeStatus.contains("Success")) {
				new_mapModel.setMapAutoGeneratedDescription(routeStatus);
				routeStatus = null;
			} else {
				new_mapModel.setMapAutoGeneratedDescription(routeStatus);
			}
		}

		return routeStatus;

	}

	/**
	 * This method validates the map path
	 * 
	 * @param new_map the map
	 *            
	 * @return the status of the map verified or not-verified
	 */
	public String mapPathValidation(MapModel new_map) {
		int mapWidth = new_map.getMapWidth();
		int mapHeight = new_map.getMapHeight();
		Point entryPoint = new_map.getEntryPoint();
		Point exitPoint = new_map.getExitPoint();
		int mapPathCellCount = 1;// for Entry Point
		int mapRoutCount = 0;// map rout count
		String status = "";
		int i = entryPoint.x;
		int j = entryPoint.y;
		E_MapValidationDirecton dirUpDown = E_MapValidationDirecton.Initial;
		E_MapValidationDirecton dirLeftRight = E_MapValidationDirecton.Initial;
		int predictiveConnectedCellCount;
		String routTrack=""+i+","+j+";";
		while ((i >= 0 && i < mapHeight) || (j >= 0 && j < mapWidth)) {
			predictiveConnectedCellCount=0;		
			int cellValue = 0;
			int connectedCellFound = 0;

			// Checking for Down cell
			if (i < mapHeight
					&& (dirUpDown == E_MapValidationDirecton.Initial || dirUpDown == E_MapValidationDirecton.Down)) {
				if (i == mapHeight - 1) {
					dirUpDown = E_MapValidationDirecton.Up;
				} else {
					cellValue = new_map.getMapGridSelection()[i + 1][j];
					if (cellValue == ApplicationStatics.MAP_PATH_POINT) {
						i++;
						mapPathCellCount++;
						connectedCellFound++;
						dirUpDown = E_MapValidationDirecton.Down;
						
						//Alternate Route Check						
						if(i < mapHeight -1 && 
						   new_map.getMapGridSelection()[i + 1][j]!= ApplicationStatics.MAP_Scenery_POINT)
						{
							predictiveConnectedCellCount++;
						}
						if(j < mapWidth -1 && 
								   new_map.getMapGridSelection()[i][j+1]!= ApplicationStatics.MAP_Scenery_POINT)
						{
							predictiveConnectedCellCount++;
						}
						if(j > 0&& 
								   new_map.getMapGridSelection()[i][j-1]!= ApplicationStatics.MAP_Scenery_POINT)
						
						{
							predictiveConnectedCellCount++;
						}
						
						if(predictiveConnectedCellCount > 1)
						{
							status = "Error:Cells:" + mapPathCellCount
									+ ":Map has Alternate Path.";
							break;
						}
						else
						{
							predictiveConnectedCellCount=0;
						}
						routTrack+=""+i+","+j+";";
						
					} else if (cellValue == ApplicationStatics.MAP_EXIT_POINT) // Check if it is Exit point
					{
						dirUpDown = E_MapValidationDirecton.Down;
						if (mapPathCellCount <= 2) {
							mapPathCellCount++;
							connectedCellFound++;
							status = "Error:Cells:" + mapPathCellCount
									+ ":Map is not correct has only Entry and Exit points.";
							break;
						} else {
							mapPathCellCount++;
							connectedCellFound++;
							status = "Success:Cells:" + mapPathCellCount + "";
							break;
						}						
					}
					else
					{
						dirUpDown = E_MapValidationDirecton.Initial;
					}
				}

			}

			// Checking For Up Cell
			if (i >= 0 && (dirUpDown == E_MapValidationDirecton.Initial || dirUpDown == E_MapValidationDirecton.Up)) {
				if (i == 0) {
					dirUpDown = E_MapValidationDirecton.Down;
				} else {
					cellValue = new_map.getMapGridSelection()[i - 1][j];
					if (cellValue == ApplicationStatics.MAP_PATH_POINT) {
						i--;
						mapPathCellCount++;
						connectedCellFound++;
						dirUpDown = E_MapValidationDirecton.Up;
						
						//Alternate Route Check						
						if(i > 0 && 
						   new_map.getMapGridSelection()[i - 1][j]!= ApplicationStatics.MAP_Scenery_POINT)
						{
							predictiveConnectedCellCount++;
						}
						if(j < mapWidth -1 && 
								   new_map.getMapGridSelection()[i][j+1]!= ApplicationStatics.MAP_Scenery_POINT)
						{
							predictiveConnectedCellCount++;
						}
						if(j > 0&& 
								   new_map.getMapGridSelection()[i][j-1]!= ApplicationStatics.MAP_Scenery_POINT)
						
						{
							predictiveConnectedCellCount++;
						}
						
						if(predictiveConnectedCellCount > 1)
						{
							status = "Error:Cells:" + mapPathCellCount
									+ ":Map has Alternate Path.";
							break;
						}
						else
						{
							predictiveConnectedCellCount=0;
						}
						routTrack+=""+i+","+j+";";
					} else if (cellValue == ApplicationStatics.MAP_EXIT_POINT) {		
						dirUpDown = E_MapValidationDirecton.Up;
						if (mapPathCellCount <= 2) {
							mapPathCellCount++;
							connectedCellFound++;
							status = "Error:Cells:" + mapPathCellCount
									+ ":Map is not correct has only Entry and Exit points.";
							break;
						} else {
							mapPathCellCount++;
							connectedCellFound++;
							status = "Success:Cells:" + mapPathCellCount + "";
							break;
						}
					}
					else
					{
						dirUpDown = E_MapValidationDirecton.Initial;
					}
				}

			}

			// Checking for Left cell
			if (j < mapWidth && (dirLeftRight == E_MapValidationDirecton.Initial
					|| dirLeftRight == E_MapValidationDirecton.Left)) {
				if (j == mapWidth - 1) {
					dirLeftRight = E_MapValidationDirecton.Right;
				} else {
					cellValue = new_map.getMapGridSelection()[i][j + 1];
					if (cellValue == ApplicationStatics.MAP_PATH_POINT) {
						j++;
						mapPathCellCount++;
						connectedCellFound++;
						dirLeftRight = E_MapValidationDirecton.Left;
						
						//Alternate Route Check	
						if(j < mapWidth -1 && 
								   new_map.getMapGridSelection()[i][j+1]!= ApplicationStatics.MAP_Scenery_POINT)
						{
							predictiveConnectedCellCount++;
						}
						if(i < mapHeight -1 && 
								   new_map.getMapGridSelection()[i+1][j]!= ApplicationStatics.MAP_Scenery_POINT)
						
						{
							predictiveConnectedCellCount++;
						}
						if(i > 0 && 
						   new_map.getMapGridSelection()[i - 1][j]!= ApplicationStatics.MAP_Scenery_POINT)
						{
							predictiveConnectedCellCount++;
						}	
						if(predictiveConnectedCellCount > 1)
						{
							status = "Error:Cells:" + mapPathCellCount
									+ ":Map has Alternate Path.";
							break;
						}
						else
						{
							predictiveConnectedCellCount=0;
						}
						routTrack+=""+i+","+j+";";
						
					} else if (cellValue == ApplicationStatics.MAP_EXIT_POINT) // Check if it is Exit point
					{
						dirLeftRight = E_MapValidationDirecton.Left;
						if (mapPathCellCount <= 2) {
							mapPathCellCount++;
							connectedCellFound++;
							status = "Error:Cells:" + mapPathCellCount
									+ ":Map is not correct has only Entry and Exit points.";
							break;
						} else {
							mapPathCellCount++;
							connectedCellFound++;
							status = "Success:Cells:" + mapPathCellCount + "";
							break;
						}
					}
					else
					{
						dirLeftRight = E_MapValidationDirecton.Initial;
					}
				}

			}

			// Checking For Right Cell
			if (j >= 0 && (dirLeftRight == E_MapValidationDirecton.Initial
					|| dirLeftRight == E_MapValidationDirecton.Right)) {
				if (j == 0) {
					dirLeftRight = E_MapValidationDirecton.Left;
				} else {
					cellValue = new_map.getMapGridSelection()[i][j - 1];
					if (cellValue == ApplicationStatics.MAP_PATH_POINT) {
						j--;
						mapPathCellCount++;
						connectedCellFound++;
						dirLeftRight = E_MapValidationDirecton.Right;
						
						//Alternate Route Check	
						if(j >= 0 && 
								   new_map.getMapGridSelection()[i][j-1]!= ApplicationStatics.MAP_Scenery_POINT)
						{
							predictiveConnectedCellCount++;
						}
						if(i < mapHeight -1 && 
								   new_map.getMapGridSelection()[i+1][j]!= ApplicationStatics.MAP_Scenery_POINT)
						
						{
							predictiveConnectedCellCount++;
						}
						if(i > 0 && 
						   new_map.getMapGridSelection()[i - 1][j]!= ApplicationStatics.MAP_Scenery_POINT)
						{
							predictiveConnectedCellCount++;
						}	
						if(predictiveConnectedCellCount > 1)
						{
							status = "Error:Cells:" + mapPathCellCount
									+ ":Map has Alternate Path.";
							break;
						}
						else
						{
							predictiveConnectedCellCount=0;
						}
						routTrack+=""+i+","+j+";";
					} else if (cellValue == ApplicationStatics.MAP_EXIT_POINT) {
						dirLeftRight = E_MapValidationDirecton.Right;
						if (mapPathCellCount <= 2) {
							mapPathCellCount++;
							connectedCellFound++;
							status = "Error:Cells:" + mapPathCellCount
									+ ":Map is not correct has only Entry and Exit points.";
							break;
						} else {
							mapPathCellCount++;
							connectedCellFound++;
							status = "Success:Cells:" + mapPathCellCount + "";
							break;
						}
					}
					else
					{
						dirLeftRight = E_MapValidationDirecton.Initial;
					}
				}
			}
			if (connectedCellFound == 0) {
				status = "Error:Cells" + mapPathCellCount + ":Map is not Connected";
				break;
			}

		}
		if(status.contains("Success")){
			if(!checkIndependentSelectedCells(new_map,routTrack))
			{
				status="Error:Cells" + mapPathCellCount + ":Map has some Independant or non connected cells";
			}
		}
		return status;
	}
	
	private boolean checkIndependentSelectedCells(MapModel new_map, String routTrack)
	{
		boolean result=true;
		int mapWidth = new_map.getMapWidth();
		int mapHeight = new_map.getMapHeight();
		int value;
		for (int i = 0; i < mapHeight; i++) {
			for (int j = 0; j < mapWidth; j++) {
				value = new_map.getMapGridSelection()[i][j];
				if( value== ApplicationStatics.MAP_PATH_POINT)
				{
					if(!routTrack.contains(""+i+","+j+";")){
						return false; 
					}
				}
			}
		}		
		return result;
	}
}
