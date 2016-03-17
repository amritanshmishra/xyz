package com.app.towerDefense.guiComponents;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.app.towerDefense.models.CritterFactory;
import com.app.towerDefense.models.CritterType;
import com.app.towerDefense.models.MapModel;
import com.app.towerDefense.models.PlayerModel;
import com.app.towerDefense.staticContent.ApplicationStatics;

/**
 * Draws elements on map
 * 
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

	// Critter Exit point co-ordinates
	int xExit = 0;
	int yExit = 0;

	// To release multiple critters in the game
	long multipleCriiterCounter = 0;

	MapModel mapModel;
	// Variable to create number of critter based on game levels
	int wave = 2;
	static ArrayList<CritterType> critter = new ArrayList<CritterType>();

	public static Graphics graphics;

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
		try {
			graphics = new_graphics;
			if (!ApplicationStatics.GAME_OVER) {
				if (ApplicationStatics.START_WAVE) {

					if (isInitialCond) {
						panelInit();
						for (int i = 0; i < wave; i++) {
							critter.add(CritterFactory
									.getCritterfromFactory("BasicCritter"));
							critter.get(i).setBlocksParams(blockWidth,
									blockHeight);
							critter.get(i).setXY(xEntry, yEntry);
							critter.get(i).setXYExit(xExit, yExit);

							critter.get(i).setID(i);
						}
						isInitialCond = false;
					}

					super.paintComponent(new_graphics);
					if (critter.size() > 0) {
						// System.out.println("count : " +
						// multipleCriiterCounter);
						for (int i = 0; i < critter.size(); i++) {
							if (critter.get(i).calculatePath()) {
								// System.out.println("i : " + i + ", size : " +
								// critter.size());

								new_graphics.drawImage(critter.get(i)
										.getCritterImage(), critter.get(i)
										.getX(), critter.get(i).getY(), 30, 30,
										null);

								if (multipleCriiterCounter < (i + 1) * 30) {
									// System.out.println("Inside Counter");
									break;
								}
							} else {
								if (ApplicationStatics.PLAYERMODEL
										.decrementHealth(1)) {
									System.out.println("Player is still alive");
								} else {
									ApplicationStatics.GAME_OVER = true;
									// Game.getInstance().stop();
									break;
								}
								critter.remove(i);
								i = 0;
							}

						}
					}

					for (int k = 0; k < PlayerModel.towerModelArray.size(); k++) {
						Ellipse2D ellipse = new Ellipse2D.Double(
								PlayerModel.towerModelArray.get(k).getXT(),
								(int) PlayerModel.towerModelArray.get(k)
										.getYT(),
								ApplicationStatics.BLOCK_WIDTH * 3,
								ApplicationStatics.BLOCK_HEIGHT * 3);
						Graphics2D g2 = (Graphics2D) graphics;
						((Graphics2D) graphics).setStroke(new BasicStroke(2));
						graphics.setColor(Color.BLACK);
						g2.draw(ellipse);
						// System.out.println(PlayerModel.towerModelArray.get(k).getXT()+"
						// "+ PlayerModel.towerModelArray.get(k).getYT()+" "+
						// PlayerModel.towerModelArray.get(k).getDT()+" "+
						// PlayerModel.towerModelArray.get(k).getDT());

					}

					Graphics2D g2 = (Graphics2D) new_graphics;
					g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
							RenderingHints.VALUE_ANTIALIAS_ON);
					// int w = getWidth();
					// int h = getHeight();
					g2.setPaint(Color.red);

					multipleCriiterCounter++;

					if (critter.size() == 0 && !ApplicationStatics.GAME_OVER) {
						ApplicationStatics.START_WAVE = false;
						isInitialCond = true;
						multipleCriiterCounter = 0;
						ApplicationStatics.PLAYERMODEL.incGameWave();
					}
				}
			}

		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Wave Completed");
			if (critter.size() == 0 && !ApplicationStatics.GAME_OVER) {
				ApplicationStatics.START_WAVE = false;
				isInitialCond = true;
				multipleCriiterCounter = 0;
				// ApplicationStatics.PLAYERMODEL.incGameWave();
			}
		}

	}

	/**
	 * Draws the shooting lines from tower to critter
	 * 
	 * @param new_tx
	 *            tower x coordinate
	 * @param new_ty
	 *            tower y coordinate
	 * @param new_cx
	 *            critter x coordinate
	 * @param new_cy
	 *            critter y coordinate
	 * @param new_tower_types
	 *            tower type number
	 * @param new_isdied
	 *            true if tower is busy with critter
	 * @param new_critterId
	 *            current critter id
	 */
	public static void drawLines(int new_tx, int new_ty, int new_cx,
			int new_cy, String new_tower_types, boolean new_isdied,
			int new_critterId) {
		// graphics = (Graphics2D) graphics;
		if (new_tower_types == "Burner") {
			graphics.setColor(Color.RED);
			// ((Graphics2D) graphics).setStroke(new BasicStroke(10));
		} else if (new_tower_types == "Freezer") {
			graphics.setColor(Color.BLUE);
			// ((Graphics2D) graphics).setStroke(new BasicStroke(10));
		} else if (new_tower_types == "Splasher") {
			graphics.setColor(Color.YELLOW);
			// ((Graphics2D) graphics).setStroke(new BasicStroke(10));
		} else if (new_tower_types == "Shooter") {
			graphics.setColor(Color.GREEN);
			// ((Graphics2D) graphics).setStroke(new BasicStroke(10));
		}

		// ((Graphics2D) graphics).draw(new
		// Line2D.Float(new_tx,new_ty,new_cx,new_cy));
		((Graphics2D) graphics).setStroke(new BasicStroke(10));
		graphics.drawLine(new_tx, new_ty, new_cx, new_cy);

		if (!new_isdied) {
			for (int j = 0; j < critter.size(); j++) {
				if (critter.get(j).getCritterId() == new_critterId) {
					critter.remove(j);
				}
			}

		}
	}

	/**
	 * This method iniitializes the route in the map panel for critters
	 */
	public void panelInit() {
		if (mapModel != null) {
			ApplicationStatics.PATH_ARRAY1 = mapModel.getMapRoutPathList();
			// System.out.println("Map Model is not null");
			panelWidth = this.getWidth();
			panelHeight = this.getHeight();
			blockWidth = panelWidth / mapModel.getMapWidth();
			blockHeight = panelHeight / mapModel.getMapHeight();

			ApplicationStatics.BLOCK_WIDTH = blockWidth;
			ApplicationStatics.BLOCK_HEIGHT = blockHeight;

			xEntry = ApplicationStatics.PATH_ARRAY1.get(0).y * blockWidth;
			yEntry = ApplicationStatics.PATH_ARRAY1.get(0).x * blockHeight;

			xExit = ApplicationStatics.PATH_ARRAY1
					.get(ApplicationStatics.PATH_ARRAY1.size() - 1).y
					* blockWidth;
			yExit = ApplicationStatics.PATH_ARRAY1
					.get(ApplicationStatics.PATH_ARRAY1.size() - 1).x
					* blockHeight;

			for (int k = 0; k < ApplicationStatics.PATH_ARRAY1.size(); k += 1) {
				System.out.println(k + " : x="
						+ ApplicationStatics.PATH_ARRAY1.get(k).x + " , y="
						+ ApplicationStatics.PATH_ARRAY1.get(k).y);
			}

			wave = 2 * ApplicationStatics.PLAYERMODEL.getGameWave();

		}
	}

}
