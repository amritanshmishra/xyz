package com.app.towerDefense.guisystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameMenu extends JPanel{

	private static final long serialVersionUID = -307815763272568727L;
	
// GAMEMENU Constructor	
	public GameMenu(int width, int height){

		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));
		
		this.setBackground(Color.BLACK);
		
		
		this.setLayout(new GridLayout(3,1));
		
		JLabel label = new JLabel();
		label.setText("CHOOSE MAP from the list");
		label.setForeground(Color.WHITE);
		this.add(label);
		
		JButton button = new JButton("CREATE MAP");
		this.add(button);
		
	}
	
	
// END	
}
