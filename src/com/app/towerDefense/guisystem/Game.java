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
	

	/**
	 * Constructor of the Game Class
	 */
	public Game() {
		// game frame settings
		width = ApplicationStatics.WINDOW_WIDTH;
		height = ApplicationStatics.WINDOW_HEIGHT;
		title = "Tower Defence Game by \"Team 5\".";
		
		ApplicationStatics.PLAYERMODEL = new PlayerModel();
		
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
