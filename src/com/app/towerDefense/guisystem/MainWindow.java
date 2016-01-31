package com.app.towerDefense.guisystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.app.towerDefense.staticContent.ApplicationStatics;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 5881054831746644916L;

// WINDOW Constructor
	public MainWindow(int width, int height, String title, Game game){
		
		this.setTitle(title);
		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));
		this.setResizable(false);
		this.setLocationRelativeTo(null); //center window on the screen
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creating Top Menu Bar
		new GameMenu(this);
		//runGameMenu(width, height);
	
				
		initGUI(width, height);
		
		this.setVisible(true);
		//this.add(game);
		
		
//		game.start();
	}
	
//
	public void runGameMenu(int width, int height){
	//	this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		//GameMenu gm = new GameMenu(width, height);
		//this.add(gm);		
	}
	

// initialize GUI of the Game	
	public void initGUI(int width, int height){
		this.getContentPane().removeAll();
		this.setLayout(new BorderLayout());
		
		MapWindow mw = new MapWindow(width, height*3/4);
		this.add(mw, BorderLayout.NORTH);

		
		GamePanel gp = new GamePanel(width, height/4);
		this.add(gp, BorderLayout.SOUTH);
	}
	
// END	
}
