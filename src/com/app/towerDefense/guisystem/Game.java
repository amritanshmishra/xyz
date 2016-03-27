package com.app.towerDefense.guisystem;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import org.apache.log4j.Logger;

import com.app.towerDefense.guiComponents.BottomGamePanelView;
import com.app.towerDefense.guiComponents.JMenuBarComponent;
import com.app.towerDefense.guiComponents.JPanelComponent;
import com.app.towerDefense.models.PlayerModel;
import com.app.towerDefense.staticContent.ApplicationStatics;
import com.app.towerDefense.utilities.MiscellaneousHelper;

//change 1

/**
 * 
 * @author usbaitass
 * 
 *         Main Class that initiates the creation of the project Applied the
 *         Singleton Pattern on Game Class.
 */
public class Game extends Canvas implements Runnable { // change 1

	private static final long serialVersionUID = 1324355855108644765L;

	//Log
	final static Logger logger = Logger.getLogger(Game.class);
	
	private static Game instance = new Game();

	private int width;
	private int height;
	private String title;

	private JMenuBarComponent jMenuBarComponent;
	private JMenuBar gameJMenuBar;
	private BottomGamePanelView bottomGamePanel;
	private JPanelComponent panelComponent;
	private JFrame frame;

	// THREAD
	private Thread thread; // change 1
	private boolean running = false; // change 1

	
	/**
	 * Constructor of the Game Class
	 */
	public Game() {
		// logs
		ApplicationStatics.setLog_Current_Session_Tag(new MiscellaneousHelper().getCurrentDateStr());
		logger.info(ApplicationStatics.getLog_Current_Session_Tag());

		// game frame settings		
		width = ApplicationStatics.WINDOW_WIDTH;
		height = ApplicationStatics.WINDOW_HEIGHT;
		title = ApplicationStatics.getTitleGameWindow();
		
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
		logger.info("Game Loaded!!");
		// -- creating new Player

		// panelComponent = jMenuBarComponent.getPanelComponent();
		// bottomGamePanel = jMenuBarComponent.getBottomPanel();

	}
	
	
	public void refreshGameFrameTitle()
	{
		title = ApplicationStatics.getTitleGameWindow();
		frame.setTitle(title);
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
	 * Main Method of the class that creates the Game Instance and starts the
	 * game.
	 * 
	 * @param new_args
	 *            contains the supplied command-line arguments as an array of
	 *            String objects
	 */
	public static void main(String new_args[]) {
		Game.getInstance().start();
	}

	/**
	 * GAME LOOP , updates the game. This method runs the thread
	 */
	@Override
	// change 1
	public void run() {
		// TODO Auto-generated method stub
		long lastTime = System.nanoTime();
		double amountOfTicks = 50.0; // Game speed 5.0
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		// int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				if (ApplicationStatics.GAME_OVER) {
					stop();
					break;
				}
				delta--;
			}
			// frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// System.out.println("FPS: " + frames);
				// frames = 0;
			}
		}
		stop();

	}

	/**
	 * This method starts the thread
	 */
	public synchronized void start() {// change 1
		thread = new Thread(this);
		running = true;
		thread.start();
	}

	/**
	 * This method stops the thread
	 */
	public synchronized void stop() {// change 1
		try {
			thread.join(0); // stops the thread
			// thread.stop();
			// thread.join(0);
			System.out.println("Game loop is stopped.");
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("EXCEPTION HERE void stop function.");
		}
	}

	/**
	 * Drawing on map panel
	 */
	private void tick() {// change 1
		//

		if (!ApplicationStatics.GAME_OVER) { // check if game is over
			// try {
			if ((panelComponent = jMenuBarComponent.getPanelComponent()) != null) {
				panelComponent.mapPanel.revalidate();
				panelComponent.mapPanel.repaint();

				bottomGamePanel = jMenuBarComponent.getBottomPanel();

				if (ApplicationStatics.START_WAVE && bottomGamePanel != null) { // check
																				// if
																				// wave
																				// is
																				// started
					bottomGamePanel.towerShopPanel.enableTowerButtons(false);
					bottomGamePanel.towerDescrPanel.enableButtons(false);
					bottomGamePanel.infoPanel.startWaveButton.setEnabled(false);
				} else if (!ApplicationStatics.START_WAVE
						&& bottomGamePanel != null) {
					bottomGamePanel.towerShopPanel.enableTowerButtons(true);
					bottomGamePanel.towerDescrPanel.enableButtons(true);
					bottomGamePanel.infoPanel.startWaveButton.setEnabled(true);
				}
			}

			// } catch (Exception e) {
			// catching exception when program still has not created play
			// mode map
			// }
		} else {
			System.out.println("GMALSDLASDK:AKSDkalsdk");
			System.out.println("Game over : " + ApplicationStatics.GAME_OVER);
			System.out.println("Start wave : " + ApplicationStatics.START_WAVE);
			Game.getInstance().stop();
		}

	}

	// END
}
