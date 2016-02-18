package com.app.towerDefense.guisystem;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import com.app.towerDefense.guiComponents.JMenuBarComponent;

/**
 * 
 * @author usbaitass
 *
 *         
 *
 */
public class GameWindow extends JFrame {

	private JMenuBar gameJMenuBar;

	// -- WINDOW Constructor
	public GameWindow(int width, int height, String title, Game game) {

		this.setTitle(title);
		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));
		this.setResizable(false);
		this.setLocationRelativeTo(null); // center window on the screen
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// -- initialize GUI of the Game
		initGUI(width, height);

		this.setVisible(true);
		// this.add(game);

		// game.start();
	}

	// -- initialize GUI of the Game
	public void initGUI(int width, int height) {
		this.getContentPane().removeAll();
		this.setLayout(new BorderLayout());

		gameJMenuBar = (new JMenuBarComponent()).getGameJMenuBar(this);
		this.setJMenuBar(gameJMenuBar);
	}

	// END
}
