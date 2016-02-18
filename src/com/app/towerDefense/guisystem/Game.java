package com.app.towerDefense.guisystem;

import com.app.towerDefense.staticContent.ApplicationStatics;

/**
 * 
 * @author usbaitass
 *
 *         Main Class that initiates the creation of the project
 *
 */
public class Game {

	/**
	 * Constructor of the Game Class
	 */
	public Game() {

		new GameWindow(ApplicationStatics.WINDOW_WIDTH, ApplicationStatics.WINDOW_HEIGHT,
				"Tower Defence Game by \"Team 5\".", this);

	}

	/**
	 * method that will start the game process and threads
	 */
	public void start() {

	}

	/**
	 * Main Method of the class that creates the Game Instance.
	 * 
	 * @param args
	 *            contains the supplied command-line arguments as an array of
	 *            String objects
	 */
	public static void main(String args[]) {
		new Game();
	}

	// END
}
