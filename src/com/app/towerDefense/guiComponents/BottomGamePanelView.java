package com.app.towerDefense.guiComponents;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BottomGamePanelView extends JPanel{

//constructor	
	public BottomGamePanelView(int newWidth, int newHeight){
		this.width = newWidth;
		this.height = newHeight;
		
//------MAP---AREA------
/*		JPanel mapPanel = new JPanel();
		mapPanel.setMinimumSize(new Dimension(width, height*3/4));
		mapPanel.setMaximumSize(new Dimension(width, height*3/4));
		mapPanel.setPreferredSize(new Dimension(width, height*3/4));		
		mapPanel.setBackground(Color.GREEN);		
*/
//-----BOTTOM---MAIN---PANEL---------------				
					
		this.setMinimumSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setPreferredSize(new Dimension(width, height));
		this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		this.setBackground(new Color(205,183,158)); //BROWN
		
		GridLayout gridLayout = new GridLayout(1,3);
		this.setLayout(gridLayout);
		
//------THREE----PANELS-----------
		JPanel infoPanel = new JPanel();
		infoPanel.setMinimumSize(new Dimension(width/3, height));
		infoPanel.setMaximumSize(new Dimension(width/3, height));
		infoPanel.setPreferredSize(new Dimension(width/3, height));
		
		JPanel towerDescrPanel = new JPanel();
		towerDescrPanel.setMinimumSize(new Dimension(width/3, height));
		towerDescrPanel.setMaximumSize(new Dimension(width/3, height));
		towerDescrPanel.setPreferredSize(new Dimension(width/3, height));
		towerDescrPanel.setBackground(new Color(205,183,158)); //BROWN
		
		JPanel towerShopPanel = new JPanel();
		towerShopPanel.setMinimumSize(new Dimension(width/3, height));
		towerShopPanel.setMaximumSize(new Dimension(width/3, height));
		towerShopPanel.setPreferredSize(new Dimension(width/3, height));
		towerShopPanel.setBackground(new Color(205,183,158)); //BROWN
		
		this.add(infoPanel);
		this.add(towerDescrPanel);
		this.add(towerShopPanel);

		
//-------TOWER------SHOP----PANEL---------
		GridLayout gridLayout2 = new GridLayout(2,3);
		towerShopPanel.setLayout(gridLayout2);
				
		JButton[] towerButton = new JButton[5];
		
		for(int i=0; i<5; i++){
			String s = Integer.toString((i+1)*50);
			String ss = "images/tower"+Integer.toString(i+1)+".png";
			towerButton[i] = new JButton(new ImageIcon(ss));
			towerButton[i].setText(s);
			towerShopPanel.add(towerButton[i]);
		}
		
			
//------TOWER----DESCRIPTION----PANEL------
		GridLayout gridLayout3 = new GridLayout(2,2);
		towerDescrPanel.setLayout(gridLayout3);
		
		JPanel topPanel = new JPanel();
		JPanel botPanel = new JPanel();
		
		
		GridLayout gridLayout4 = new GridLayout(6,3);
		topPanel.setLayout(gridLayout4);
			
		JLabel[] labels = new JLabel[18];
		
		for(int i=0; i<18; i++){
			String s = Integer.toString(i);
			if(i == 0){
				s = "Level";
			}else if(i == 3){
				s = "Power";
			}else if(i == 6){
				s = "Range";
			}else if(i == 9){
				s = "Fire Rate";
			}else if(i == 12){
				s = "Special";
			}else if(i == 15){
				s = "Cost";
			}
			labels[i] = new JLabel(s, SwingConstants.CENTER);
			labels[i].setBorder(BorderFactory.createLineBorder(Color.GRAY));
			topPanel.add(labels[i]);
		}
		
		
		GridLayout gridLayout5 = new GridLayout(1,3);
		botPanel.setLayout(gridLayout5);
		
		
		JPanel pPanel1 = new JPanel();
		pPanel1.setBackground(new Color(205,183,158)); //BROWN
		GridLayout gridLayout6 = new GridLayout(2,1);
		pPanel1.setLayout(gridLayout6);

		JPanel pPanel2 = new JPanel();
		pPanel2.setBackground(new Color(205,183,158)); //BROWN
		GridLayout gridLayout7 = new GridLayout(2,1);
		pPanel2.setLayout(gridLayout7);
		
		JButton towerButtonDESCR = new JButton("imgTOWER");
		
		JLabel topLabel1 = new JLabel("Potato", SwingConstants.CENTER);
		JLabel topLabel2 = new JLabel("Level 1", SwingConstants.CENTER);
		
		JButton sellTowerButton = new JButton("sell");
		JButton upgradeTowerButton = new JButton("upgrade");
		
		pPanel1.add(sellTowerButton);
		pPanel1.add(topLabel1);
		
		pPanel2.add(upgradeTowerButton);
		pPanel2.add(topLabel2);
		
		botPanel.add(towerButtonDESCR);		
		botPanel.add(pPanel1);
		botPanel.add(pPanel2);
		
		towerDescrPanel.add(topPanel);
		towerDescrPanel.add(botPanel);
		

//--------INFO----PANEL----------
		GridLayout gridLayout8 = new GridLayout(3,1);
		infoPanel.setLayout(gridLayout8);
		
		JPanel topInfoPanel = new JPanel();
		JPanel midInfoPanel = new JPanel();
		JPanel botInfoPanel = new JPanel();
		
		topInfoPanel.setBackground(new Color(205,183,158)); //BROWN
		midInfoPanel.setBackground(new Color(205,183,158)); //BROWN
		botInfoPanel.setBackground(new Color(205,183,158)); //BROWN
		
		GridLayout gridLayout9 = new GridLayout(1,3);
		topInfoPanel.setLayout(gridLayout9);

		
		JButton b1 = new JButton(new ImageIcon("images/sun.png"));
		
		
		JLabel b2 = new JLabel("B2");
		b2.setText("  100");
		b2.setFont(new Font("Serif", Font.BOLD, 20));
		
		
		
		JPanel b3 = new JPanel(new BorderLayout());
		
		JLabel b33 = new JLabel("HP 10", SwingConstants.CENTER);
		b33.setFont(new Font("Serif", Font.BOLD, 20));
		b33.setForeground(Color.RED);
		b3.add(b33, BorderLayout.CENTER);
		
		
		topInfoPanel.add(b1);
		topInfoPanel.add(b2);
		topInfoPanel.add(b3);
		
		//????????????	HERE

		
		JLabel gameLvlLabel = new JLabel("LEVEL 1", SwingConstants.CENTER);
		gameLvlLabel.setFont(new Font("Serif", Font.BOLD, 20));
		gameLvlLabel.setHorizontalAlignment(JLabel.CENTER);
		
		
		midInfoPanel.setLayout(new BorderLayout());
		midInfoPanel.add(gameLvlLabel, BorderLayout.CENTER);
		
		
		GridLayout gridLayout10 = new GridLayout(1,3);
		botInfoPanel.setLayout(gridLayout10);
		JLabel critterLabel = new JLabel("Critter Zomby", SwingConstants.CENTER);
		
		JButton critterIconButton = new JButton(new ImageIcon("images/critter1.png"));
		
		JLabel critterInfoLabel = new JLabel("Health: 50", SwingConstants.CENTER);
		
		
		botInfoPanel.add(critterLabel);
		botInfoPanel.add(critterIconButton);
		botInfoPanel.add(critterInfoLabel);
		
		
		infoPanel.add(topInfoPanel);
		infoPanel.add(midInfoPanel);
		infoPanel.add(botInfoPanel);
		
		
		
//-----------------------		
/*		frame.add(mapPanel, BorderLayout.CENTER);
		frame.add(this, BorderLayout.SOUTH);
		frame.setVisible(true);
//--------END------------
 * 
 */
	}
	
/*	
	public static JFrame frame;
	
	public static void main(String[] args)
	{
		
		int WIDTH = 840;
		int HEIGHT = WIDTH / 12 * 9;
		frame = new JFrame();
		frame.setTitle("Temp Frame");
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); //center window on the screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BottomGamePanelView bottomGamePanelView = new BottomGamePanelView(WIDTH, HEIGHT/4);
		
	}
*/	
	
	private int width, height;
	
//END	
}
