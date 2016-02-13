package com.app.towerDefense.guisystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.app.towerDefense.guiComponents.JMenuBarComponent;
import com.app.towerDefense.guiComponents.JPanelComponent;
import com.app.towerDefense.staticContent.ApplicationStatics;

public class GameWindow extends JFrame{

	private JMenuBar gameJMenuBar;
	//private JPanel   gameTowerPanel;
	//private JPanel   gameMapPanel;
	
	/*
	public GameWindow(JPanel  _gameTowerPanel, JPanel   _gameMapPanel)
	{
		gameTowerPanel=_gameTowerPanel;
		gameMapPanel = _gameMapPanel;
		this.add(_gameTowerPanel);
		this.add(_gameTowerPanel);
	}
	*/
	
	//-- WINDOW Constructor
	public GameWindow(int width, int height, String title, Game game){
		
		this.setTitle(title);
		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));
		this.setResizable(false);
		this.setLocationRelativeTo(null); //center window on the screen
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//-- initialize GUI of the Game		
		initGUI(width, height);
		
		this.setVisible(true);
		//this.add(game);
		
		
		//game.start();
	}
		

	//-- initialize GUI of the Game	
	public void initGUI(int width, int height){
		this.getContentPane().removeAll();
		this.setLayout(new BorderLayout());
		
		

        //background.setLayout(new FlowLayout());
		/*try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("images/gameBk.jpg")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		// Set 
		//gameMapPanel=new JPanelComponent().getGameMapPanel(width, height*3/4);
		//this.add(gameMapPanel, BorderLayout.NORTH);

		//gameTowerPanel =new JPanelComponent().getGameTowerPanel(width, height/4);
		//this.add(gameTowerPanel , BorderLayout.SOUTH);
		
		//-- Creating Top Menu Bar
		//gameJMenuBar = (new JMenuBarComponent()).getGameJMenuBar(this, gameMapPanel, gameTowerPanel);
		gameJMenuBar = (new JMenuBarComponent()).getGameJMenuBar(this);
		this.setJMenuBar(gameJMenuBar);
	}
	
	//public void update
	
	//END	
}
