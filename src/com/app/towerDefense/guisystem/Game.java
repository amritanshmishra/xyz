package com.app.towerDefense.guisystem;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

import com.app.towerDefense.guiComponents.BottomGamePanelView;
import com.app.towerDefense.guiComponents.JMenuBarComponent;
import com.app.towerDefense.guiComponents.JPanelComponent;
import com.app.towerDefense.models.PlayerModel;
import com.app.towerDefense.staticContent.ApplicationStatics;

/**
 * 
 * @author usbaitass
 *
 *         Main Class that initiates the creation of the project Applied the
 *         Singleton Pattern on Game Class.
 */
public class Game extends Object {

	private static Game instance = new Game();

	private int width;
	private int height;
	private String title;

	private JMenuBarComponent jMenuBarComponent;
	private JMenuBar gameJMenuBar;
	private BottomGamePanelView bottomGamePanel;
	private JPanelComponent panelComponent;
	private JFrame frame;
	
	private PlayerModel playerModel;
	

	/**
	 * Constructor of the Game Class
	 */
	public Game() {
		// game frame settings
		width = ApplicationStatics.WINDOW_WIDTH;
		height = ApplicationStatics.WINDOW_HEIGHT;
		title = "Tower Defence Game by \"Team 5\".";
		frame = new JFrame();
		frame.setTitle(title);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); // center window on the screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().removeAll();
		frame.setLayout(new BorderLayout());
		jMenuBarComponent = new JMenuBarComponent();
		gameJMenuBar = jMenuBarComponent.getGameJMenuBar(frame);
		frame.setJMenuBar(gameJMenuBar);
		frame.setVisible(true);

		// -- creating new Player
		playerModel = new PlayerModel();

		panelComponent = jMenuBarComponent.getPanelComponent();
		bottomGamePanel = jMenuBarComponent.getBottomPanel();
		

		

	}

	/**
	 * If instance was not previously created, then created one and return the
	 * instance.
	 * 
	 * @return game object - instance
	 */
	public static Game getInstance() {
		if (instance == null) {
			instance = new Game();
		}
		return instance;
	}

	/**
	 * method that will start the game process and threads
	 */
	public void start() {
		
	}

	/**
	 * This method is for accessing the Tower model objects
	 * 
	 * @return Player Model object
	 */
	public PlayerModel getPlayerModel() {
		return playerModel;
	}
	
	
	
	//*******************--------------------------*********************************
	
	
	
	
	
	/**
	 * This method sets the Buttons to Yellow on the map that are eligible for
	 * tower placement
	 * 
	 * @param new_mapButtons
	 *            the reference to our map buttons
	 */
	/*public void setMapButtonsToYellow(JButton[][] new_mapButtons) {

		String stringMapCoord = "";

		for (int i = 0; i < new_mapButtons.length; i++) {

			for (int j = 0; j < new_mapButtons[i].length; j++) {
				stringMapCoord = "" + (i) + ":" + j;
				if (ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME.contains(stringMapCoord)) {

					new_mapButtons[i][j].setEnabled(true);
					if (hasBoughtTower) {
						new_mapButtons[i][j].setIcon(new ImageIcon(ApplicationStatics.IMAGE_PATH_MAP_ButtonYellow));
						setTowersOnMap(mapButtons, i, j);
					} else {
						// -- sets all button icons to green scenery and later
						int x = new_mapButtons[i][j].getWidth();
						int y = new_mapButtons[i][j].getHeight();
						new_mapButtons[i][j]
								.setIcon(new ImageIcon(new ImageIcon(ApplicationStatics.IMAGE_PATH_MAP_Scenery)
										.getImage().getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH)));

						setTowersOnMap(mapButtons, i, j);
					}
				} else { // -- disable buttons boundaries
					new_mapButtons[i][j].setEnabled(!hasBoughtTower);
				}
			}
		}
	}*/

	/**
	 * This method sets icons on the map buttons where they have been placed by
	 * player
	 * 
	 * @param new_mapButtons
	 *            reference to our map button
	 * @param new_i
	 *            x coordinate of the button
	 * @param new_j
	 *            y coordinate of the button
	 */
	/*public void setTowersOnMap(JButton[][] new_mapButtons, int new_i, int new_j) {
		for (int k = 0; k < playerModel.towerModelArray.size(); k++) {
			int x = playerModel.towerModelArray.get(k).getX();
			int y = playerModel.towerModelArray.get(k).getY();
			if (new_i == x && new_j == y) {
				if (hasBoughtTower) {
					new_mapButtons[new_i][new_j].setEnabled(false);
				} else {
					new_mapButtons[new_i][new_j].setEnabled(true);
				}
				new_mapButtons[new_i][new_j].setIcon(playerModel.towerModelArray.get(k).getTowerImage());
			}
		}
	}*/


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//************=================================================***********
	

	/**
	 * Main Method of the class that creates the Game Instance and starts the
	 * game.
	 * 
	 * @param args
	 *            contains the supplied command-line arguments as an array of
	 *            String objects
	 */
	public static void main(String args[]) {
		Game.getInstance().start();
	}

	// END
}
