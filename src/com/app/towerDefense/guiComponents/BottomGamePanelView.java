package com.app.towerDefense.guiComponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.app.towerDefense.models.PlayerModel;
import com.app.towerDefense.models.TowerModel;

/**
 * 
 * @author usbaitass
 *
 */
public class BottomGamePanelView extends JPanel implements ActionListener {

	// -- Class attributes
	private int width, height;
	private JButton towerButtonDESCR = new JButton(new ImageIcon("images/tower1.png"));
	private JLabel[] labelStatsTower;
	private TowerModel[] towerModelShop = new TowerModel[5];
	private JLabel towerNameLabel;
	private JLabel towerLevelLabel;
	private PlayerModel playerModel;
	private String currentSelectedTowerName;
	
	// constructor
	public BottomGamePanelView(int new_width, int new_height) {
		this.width = new_width;
		this.height = new_height;

		// -- creating new Player
		playerModel = new PlayerModel();

		// -----CREATING---Five--Towers---for---SHOP---
		for (int i = 0; i < 5; i++) {
			towerModelShop[i] = new TowerModel(i);
		}

		// -----BOTTOM---MAIN---PANEL--That holds 3 major panels below
		this.setMinimumSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setPreferredSize(new Dimension(width, height));
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.setBackground(new Color(205, 183, 158)); // BROWN
		GridLayout gridLayout = new GridLayout(1, 3);
		this.setLayout(gridLayout);

		// ------THREE----PANELS-----------
		// --This Panel holds the information of the Player and Critters in the
		// Game
		JPanel infoPanel = new JPanel();
		infoPanel.setMinimumSize(new Dimension(width / 3, height));
		infoPanel.setMaximumSize(new Dimension(width / 3, height));
		infoPanel.setPreferredSize(new Dimension(width / 3, height));

		// --The Tower Description Panel, contains info about selected Tower
		JPanel towerDescrPanel = new JPanel();
		towerDescrPanel.setMinimumSize(new Dimension(width / 3, height));
		towerDescrPanel.setMaximumSize(new Dimension(width / 3, height));
		towerDescrPanel.setPreferredSize(new Dimension(width / 3, height));
		towerDescrPanel.setBackground(new Color(205, 183, 158)); // BROWN

		// --The Tower Shop Panel that displays the Towers and their prices
		JPanel towerShopPanel = new JPanel();
		towerShopPanel.setMinimumSize(new Dimension(width / 3, height));
		towerShopPanel.setMaximumSize(new Dimension(width / 3, height));
		towerShopPanel.setPreferredSize(new Dimension(width / 3, height));
		towerShopPanel.setBackground(new Color(205, 183, 158)); // BROWN

		this.add(infoPanel);
		this.add(towerDescrPanel);
		this.add(towerShopPanel);

		// ----TOWER---SHOP--PANEL-----
		GridLayout gridLayout2 = new GridLayout(2, 3);
		towerShopPanel.setLayout(gridLayout2);

		JButton[] towerButton = new JButton[5];

		for (int i = 0; i < 5; i++) {
			towerButton[i] = new JButton(new ImageIcon(towerModelShop[i].getTowerImagePath()));
			towerButton[i].setText(Integer.toString(towerModelShop[i].getTowerCost()));
			towerButton[i].setName(towerModelShop[i].getTowerName()+Integer.toString(i));

			towerShopPanel.add(towerButton[i]);
			towerButton[i].addActionListener(this);
		}

		// ---TOWER--DESCRIPTION--PANEL---
		GridLayout gridLayout3 = new GridLayout(2, 2);
		towerDescrPanel.setLayout(gridLayout3);

		JPanel topTDscrPanel = new JPanel();
		JPanel botTDscrPanel = new JPanel();

		GridLayout gridLayout4 = new GridLayout(6, 3);
		topTDscrPanel.setLayout(gridLayout4);

		labelStatsTower = new JLabel[18];

		for (int i = 0; i < 18; i++) {
			String s = Integer.toString(i);
			if (i == 0) {
				s = "Level";
			} else if (i == 3) {
				s = "Power";
			} else if (i == 6) {
				s = "Range";
			} else if (i == 9) {
				s = "Fire Rate";
			} else if (i == 12) {
				s = "Special";
			} else if (i == 15) {
				s = "Cost";
			}
			labelStatsTower[i] = new JLabel(s, SwingConstants.CENTER);
			labelStatsTower[i].setFont(new Font("Serif", Font.PLAIN, 11));
			labelStatsTower[i].setBorder(BorderFactory.createLineBorder(Color.GRAY));
			topTDscrPanel.add(labelStatsTower[i]);
		}

		GridLayout gridLayout5 = new GridLayout(1, 3);
		botTDscrPanel.setLayout(gridLayout5);

		JPanel pPanel1 = new JPanel();
		pPanel1.setBackground(new Color(205, 183, 158)); // BROWN
		GridLayout gridLayout6 = new GridLayout(2, 1);
		pPanel1.setLayout(gridLayout6);

		JPanel pPanel2 = new JPanel();
		pPanel2.setBackground(new Color(205, 183, 158)); // BROWN
		GridLayout gridLayout7 = new GridLayout(2, 1);
		pPanel2.setLayout(gridLayout7);

		towerNameLabel = new JLabel(towerModelShop[0].getTowerName(), SwingConstants.CENTER);
		towerLevelLabel = new JLabel("Level " + Integer.toString(towerModelShop[0].getTowerlevel()),
				SwingConstants.CENTER);

		JButton sellBuyTowerButton = new JButton("buy");
		sellBuyTowerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//-- get current selected tower id
				Character ch = currentSelectedTowerName.charAt(currentSelectedTowerName.length()-1);
				int tempTid = ch.charValue()-48;
				
				int tempTCost = towerModelShop[tempTid].getTowerCost();
				int currentBalance = playerModel.getSunCurrency();
										
				if(currentBalance >= tempTCost){
						
						playerModel.buyTower(tempTid);
				}else{
					
				}
						
				System.out.println("ID = "+ Integer.toString(tempTid));
			}
			
		});

		JButton upgradeTowerButton = new JButton("upgrade");
		upgradeTowerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("upgrade button was clicked!");
			}
		});

		// -- set initial description to Tower 0
		updateTowerDscrPanel(0);

		pPanel1.add(sellBuyTowerButton);
		pPanel1.add(towerNameLabel);

		pPanel2.add(upgradeTowerButton);
		pPanel2.add(towerLevelLabel);

		botTDscrPanel.add(towerButtonDESCR);
		botTDscrPanel.add(pPanel1);
		botTDscrPanel.add(pPanel2);

		towerDescrPanel.add(topTDscrPanel);
		towerDescrPanel.add(botTDscrPanel);

		// ---INFO---PANEL----------
		GridLayout gridLayout8 = new GridLayout(2, 1);
		infoPanel.setLayout(gridLayout8);

		JPanel topInfoPanel = new JPanel();
		JPanel botInfoPanel = new JPanel();

		topInfoPanel.setBackground(new Color(205, 183, 158)); // BROWN
		botInfoPanel.setBackground(new Color(205, 183, 158)); // BROWN

		GridLayout gridLayout9 = new GridLayout(1, 3);
		topInfoPanel.setLayout(gridLayout9);

		JButton b1 = new JButton(new ImageIcon("images/sun.png"));

		JLabel b2 = new JLabel("B2");
		String sb2 = "<html> Sun<br>" + Integer.toString(playerModel.getSunCurrency()) + "</html>";
		b2.setText(sb2);
		b2.setFont(new Font("Serif", Font.BOLD, 20));

		JPanel b3 = new JPanel(new BorderLayout());

		JLabel b33 = new JLabel("HP " + Integer.toString(playerModel.getHpPlayer()), SwingConstants.CENTER);
		b33.setFont(new Font("Serif", Font.BOLD, 20));
		b33.setForeground(Color.RED);
		b3.add(b33, BorderLayout.CENTER);

		topInfoPanel.add(b1);
		topInfoPanel.add(b2);
		topInfoPanel.add(b3);

		JLabel gameLvlLabel = new JLabel("LEVEL " + Integer.toString(playerModel.getGameWave()), SwingConstants.CENTER);
		gameLvlLabel.setFont(new Font("Serif", Font.BOLD, 20));
		gameLvlLabel.setHorizontalAlignment(JLabel.CENTER);

		GridLayout gridLayout10 = new GridLayout(1, 2);
		botInfoPanel.setLayout(gridLayout10);
		String s = "<html><b><font size='5'>Wave: 1</font></b><br>Critter: Zomby<br>Health: 50</html>";
		JLabel critterLabel = new JLabel(s, SwingConstants.CENTER);

		JButton critterIconButton = new JButton(new ImageIcon("images/critter1.gif"));

		botInfoPanel.add(critterLabel);
		botInfoPanel.add(critterIconButton);

		infoPanel.add(topInfoPanel);
		infoPanel.add(botInfoPanel);

	}

	// -- Method that updates the info on Tower Description Panel
	// -- if any Tower is clicked
	public void updateTowerDscrPanel(int new_towerID) {
		// -- level
		labelStatsTower[1].setText(Integer.toString(towerModelShop[new_towerID].getTowerlevel()));
		labelStatsTower[2].setText(Integer.toString(towerModelShop[new_towerID].getTowerlevel() + 1));
		// -- power
		labelStatsTower[4].setText(Integer.toString(towerModelShop[new_towerID].getTowerPower()));
		labelStatsTower[5].setText(Integer.toString(towerModelShop[new_towerID].getTowerPower() * 2));
		// -- range
		labelStatsTower[7].setText(Integer.toString(towerModelShop[new_towerID].getTowerRange()));
		labelStatsTower[8].setText(Integer.toString(towerModelShop[new_towerID].getTowerRange() + 1));
		// -- fire rate
		labelStatsTower[10].setText(Integer.toString(towerModelShop[new_towerID].getTowerFireRate()));
		labelStatsTower[11].setText(Integer.toString(towerModelShop[new_towerID].getTowerFireRate() + 2));
		// -- special ability
		labelStatsTower[13].setText(Integer.toString(0));
		labelStatsTower[14].setText(Integer.toString(0));
		// -- cost
		labelStatsTower[16].setText(Integer.toString(towerModelShop[new_towerID].getTowerCost()));
		labelStatsTower[17].setText(Integer.toString((int) (towerModelShop[new_towerID].getTowerCost() * 0.5)));

		towerNameLabel.setText(towerModelShop[new_towerID].getTowerName());
		towerLevelLabel.setText("Level " + Integer.toString(towerModelShop[new_towerID].getTowerlevel()));
		
		currentSelectedTowerName = "tower"+ Integer.toString(new_towerID);
	}
	
	public void updateGameInfoPanel(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		JButton button = (JButton) o;		
		String bName = button.getName();
		Character ch = bName.charAt(bName.length()-1);
		int tempTid = ch.charValue()-48;
		
		System.out.println("Shop Panel: Tower id = "+ tempTid);
		
		towerButtonDESCR.setIcon(button.getIcon());

		updateTowerDscrPanel(tempTid);
	}

	// END
}
