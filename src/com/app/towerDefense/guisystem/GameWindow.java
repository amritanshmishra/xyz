package com.app.towerDefense.guisystem;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import com.app.towerDefense.guiComponents.JMenuBarComponent;

/**
 * 
 * This class creates the game main frame and initialise GUI
 * 
 * @author usbaitass
 *
 */
public class GameWindow extends JFrame {

	private JMenuBar gameJMenuBar;

	/**
	 * WINDOW Constructor
	 * 
	 * @param new_width
	 *            the width of the frame
	 * @param new_height
	 *            the height of the frame
	 * @param new_title
	 *            the title of the game
	 * @param new_game
	 *            the game main class
	 */
	public GameWindow(int new_width, int new_height, String new_title, Game new_game) {

		this.setTitle(new_title);
		this.setPreferredSize(new Dimension(new_width, new_height));
		this.setMaximumSize(new Dimension(new_width, new_height));
		this.setMinimumSize(new Dimension(new_width, new_height));
		this.setResizable(false);
		this.setLocationRelativeTo(null); // center window on the screen
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// -- initialize GUI of the Game
		initGUI();

		this.setVisible(true);
		// this.add(game);

		// game.start();
	}

	/**
	 * This method initialise the GUI
	 */
	public void initGUI() {
		this.getContentPane().removeAll();
		this.setLayout(new BorderLayout());

		gameJMenuBar = (new JMenuBarComponent()).getGameJMenuBar(this);
		this.setJMenuBar(gameJMenuBar);
	}

	
}
