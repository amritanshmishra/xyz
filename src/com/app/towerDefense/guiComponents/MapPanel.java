package com.app.towerDefense.guiComponents;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.app.towerDefense.models.CritterFactory;
import com.app.towerDefense.models.CritterType;
import com.app.towerDefense.models.MapModel;
import com.app.towerDefense.staticContent.ApplicationStatics;
/**
 * Draws elements on map
 * @author usbaitass
 *
 */
public class MapPanel extends JPanel {

	private static final long serialVersionUID = -9082005090002375868L;

	int panelWidth;
	int panelHeight;
	int blockWidth;
	int blockHeight;

	boolean isInitialCond = true;
	// Critter entry point co-ordinates
	int xEntry = 0;
	int yEntry = 0;

	// To release multiple critters in the game
	long multipleCriiterCounter = 0;

	MapModel mapModel;
	// Variable to create number of critter based on game levels
	int wave = 2 * 2;
	ArrayList<CritterType> critter = new ArrayList<CritterType>();

	/**
	 * Parameterized constructor for Map Panel
	 * 
	 * @param new_mapModel
	 */
	public MapPanel(MapModel new_mapModel) {
		mapModel = new_mapModel;

	}

	/**
	 * Creates critter objects and calculates the path on which critter has to
	 * move
	 * 
	 * @param new_graphics
	 */
	@Override
	protected void paintComponent(Graphics new_graphics) {

		if (ApplicationStatics.START_WAVE) {

			if (isInitialCond) {
				panelInit();
				for (int i = 0; i < wave; i++) {
					critter.add(CritterFactory.getCritterfromFactory("BasicCritter"));
					critter.get(i).setBlocksParams(blockWidth, blockHeight);
					critter.get(i).setXY(xEntry, yEntry);
					critter.get(i).setID(i);
				}
				isInitialCond = false;
			}

			super.paintComponent(new_graphics);

			//System.out.println("count : " + multipleCriiterCounter);
			for (int i = 0; i < wave; i++) {

				critter.get(i).calculatePath();
				new_graphics.drawImage(critter.get(i).getCritterImage(), critter.get(i).getX(), critter.get(i).getY(),
						30, 30, null);
				if (multipleCriiterCounter < (i + 1) * 30) {
			//		System.out.println("Inside Counter");
					break;
				}

			}

			multipleCriiterCounter++;

		}
	}

	/**
	 * This method iniitializes the route in the map panel for critters
	 */
	public void panelInit() {
		if (mapModel != null) {
			ApplicationStatics.PATH_ARRAY1 = mapModel.getMapRoutPathList();
			System.out.println("Map Model is not null");
			panelWidth = this.getWidth();
			panelHeight = this.getHeight();
			blockWidth = panelWidth / mapModel.getMapWidth();
			blockHeight = panelHeight / mapModel.getMapHeight();
			
			ApplicationStatics.BLOCK_WIDTH = blockWidth;
			ApplicationStatics.BLOCK_HEIGHT = blockHeight;

			xEntry = ApplicationStatics.PATH_ARRAY1.get(0).x * blockWidth;
			yEntry = ApplicationStatics.PATH_ARRAY1.get(0).y * blockHeight;

			System.out.println("blockW : " + blockWidth + " , blockH : " + blockHeight + " , width : "
					+ mapModel.getMapWidth() + " , height : " + mapModel.getMapHeight());

			for (int k = 0; k < ApplicationStatics.PATH_ARRAY1.size(); k += 1) {
				System.out.println(k + " : x=" + ApplicationStatics.PATH_ARRAY1.get(k).x + " , y="
						+ ApplicationStatics.PATH_ARRAY1.get(k).y);
			}

		}
	}

}
