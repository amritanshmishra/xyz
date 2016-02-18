package com.app.towerDefense.guiComponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.app.towerDefense.models.PlayerModel;
import com.app.towerDefense.models.TowerModel;
import com.app.towerDefense.models.TowerModel1;
import com.app.towerDefense.models.TowerModel2;
import com.app.towerDefense.models.TowerModel3;
import com.app.towerDefense.models.TowerModel4;
import com.app.towerDefense.models.TowerModel5;
import com.app.towerDefense.staticContent.ApplicationStatics;

/**
 * 
 * @author usbaitass Ulan Baitassov
 *         <p>
 *         Class description:<br>
 *         creates the Panel on which the game information is displayed: such as
 *         tower shop, tower description panel, player's amount of currency and
 *         health, the wave and critter information
 *         </p>
 */
public class BottomGamePanelView extends JPanel implements ActionListener {

	// -- Class attributes
	private int width, height;
	public JButton towerButtonDESCR = new JButton(new ImageIcon(ApplicationStatics.IMAGE_PATH_MAP_Tower1));
	private JLabel[] labelStatsTower;
	private TowerModel[] new_towerModel = new TowerModel[5];
	private JLabel towerNameLabel;
	private JLabel towerLevelLabel;
	private PlayerModel playerModel;
	public int currentSelectedTower;
	private JLabel sunCurrencyLabel;
	public boolean setTowerDescrPanelVisible;
	private JButton upgradeTowerButton;
	private JButton sellBuyTowerButton;
	private JButton[][] mapButtons;
	public boolean hasBoughtTower;

	/**
	 * The constructor
	 * 
	 * @param new_width
	 *            width of the frame
	 * @param new_height
	 *            height of the frame
	 */
	public BottomGamePanelView(int new_width, int new_height) {
		this.width = new_width;
		this.height = new_height;

		setTowerDescrPanelVisible = false;
		hasBoughtTower = false;
		currentSelectedTower = 0;

		// -- creating new Player
		playerModel = new PlayerModel();

		// -----CREATING---Five--Towers---for---SHOP-------
		new_towerModel[0] = (TowerModel) new TowerModel1();
		new_towerModel[1] = (TowerModel) new TowerModel2();
		new_towerModel[2] = (TowerModel) new TowerModel3();
		new_towerModel[3] = (TowerModel) new TowerModel4();
		new_towerModel[4] = (TowerModel) new TowerModel5();

		// ---BOTTOM-GAME-PANEL-VIEW-- setting Dimensions and layout
		// -- it holds 3 major panel: tower shop, tower description and game
		// info panel
		this.setMinimumSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setPreferredSize(new Dimension(width, height));
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		this.setBackground(new Color(205, 183, 158)); // BROWN
		GridLayout gridLayout = new GridLayout(1, 3);
		this.setLayout(gridLayout);

		// ------THREE----PANELS-------------------------------
		// --Information Panel holds the info of the Player's sunCurrency, life
		// and Critters
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

		// -- Adding these 3 panels on ButtonGamePanelView
		this.add(infoPanel);
		this.add(towerDescrPanel);
		this.add(towerShopPanel);

		// ----TOWER---SHOP--PANEL------------------
		// -- setting layout and creating buttons
		GridLayout gridLayout2 = new GridLayout(2, 3);
		towerShopPanel.setLayout(gridLayout2);

		// -- creating 5 tower
		JButton[] towerButton = new JButton[5];

		for (int i = 0; i < 5; i++) {
			towerButton[i] = new JButton(new_towerModel[i].getTowerImage());
			towerButton[i].setText(Integer.toString(new_towerModel[i].getTowerCost()));
			towerButton[i].setName("tower" + Integer.toString(i));

			towerShopPanel.add(towerButton[i]);
			towerButton[i].addActionListener(this);
		}

		// ---TOWER--DESCRIPTION--PANEL--------
		// -- setting layout
		GridLayout gridLayout3 = new GridLayout(2, 2);
		towerDescrPanel.setLayout(gridLayout3);

		JPanel topTDscrPanel = new JPanel();
		JPanel botTDscrPanel = new JPanel();

		topTDscrPanel.setBackground(new Color(205, 183, 158)); // BROWN
		botTDscrPanel.setBackground(new Color(205, 183, 158)); // BROWN

		GridLayout gridLayout4 = new GridLayout(6, 3);
		topTDscrPanel.setLayout(gridLayout4);

		// -- Adding Labels on Tower Description Panel
		// -- which displays the tower information
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
			labelStatsTower[i].setBackground(Color.WHITE);
			labelStatsTower[i].setOpaque(true);
			topTDscrPanel.add(labelStatsTower[i]);
		}

		// --Adding 3 buttons to Tower Description Panel
		// -- setting layouts and secondary panels
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

		// -- Labels that show the Name and Level of the tower
		towerNameLabel = new JLabel(new_towerModel[0].getTowerName(), SwingConstants.CENTER);
		towerLevelLabel = new JLabel("Level " + Integer.toString(new_towerModel[0].getTowerlevel()),
				SwingConstants.CENTER);

		// -- initializing the Sell-Buy Tower Button
		// and implementing functionality
		sellBuyTowerButton = new JButton("BUY");
		sellBuyTowerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (sellBuyTowerButton.getText() == "BUY") {

					int tempTCost = new_towerModel[currentSelectedTower].getTowerCost();
					int currentBalance = playerModel.getSunCurrency();

					if (currentBalance >= tempTCost) {
						// -- true if BUY is success
						TowerModel tempTM = playerModel.buyTower(currentSelectedTower);
						if (tempTM != null) {

							hasBoughtTower = true;
							updateGameInfoPanel();
							setMapButtonsToYellow(mapButtons);

							JFrame frame = new JFrame();
							JOptionPane.showMessageDialog(frame,
									"You have bought a tower.\n Place it ONLY on the YELLOW Part on the map please.");
						}
					} else {
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, "You don't have enough suns for this tower.");
					}
				}else{
					System.out.println("SELLING"+ towerButtonDESCR.getName());
					
					String[] tempStr = towerButtonDESCR.getName().split(":");
					int temp_x = Integer.parseInt(tempStr[0]);
					int temp_y = Integer.parseInt(tempStr[1]);
					
					for (int k = 0; k < playerModel.towerModelArray.size(); k++) {
						int x = playerModel.towerModelArray.get(k).getX();
						int y = playerModel.towerModelArray.get(k).getY();
						if (temp_x == x && temp_y == y) {
							if (playerModel.sellTower(k)) {
								int w = mapButtons[x][y].getWidth();
								int h = mapButtons[x][y].getHeight();
								
								mapButtons[x][y].setIcon(new ImageIcon(new ImageIcon(ApplicationStatics.IMAGE_PATH_MAP_Scenery)
										.getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH)));
								System.out.println("tower deleted successfully.");
								
								setTowerDescrPanelVisible = false;
								updateTowerDscrPanel(new TowerModel1());
								updateGameInfoPanel();
								
							} else {
								System.out.println("could not delete tower.");
							}
						}
					}
					
				}
			}

		});

		// -- initializing the tower upgrade button
		// -- and implementing its functionality
		upgradeTowerButton = new JButton("UPGRADE");
		upgradeTowerButton.setOpaque(true);
		upgradeTowerButton.setVisible(false);
		upgradeTowerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("upgrade button was clicked!");
				// ++++++++++++++++++++++++++++?????????????????????????????????????????
			}
		});

		// -- initializing the tower description panel information to default
		updateTowerDscrPanel(new TowerModel1());

		// -- adding the labels and buttons on Tower Description Panel
		pPanel1.add(sellBuyTowerButton);
		pPanel1.add(towerNameLabel);

		pPanel2.add(upgradeTowerButton);
		pPanel2.add(towerLevelLabel);

		botTDscrPanel.add(towerButtonDESCR);
		botTDscrPanel.add(pPanel1);
		botTDscrPanel.add(pPanel2);

		towerDescrPanel.add(topTDscrPanel);
		towerDescrPanel.add(botTDscrPanel);

		// ---INFO---PANEL------------------
		// -- setting layout and secondary panels
		GridLayout gridLayout8 = new GridLayout(2, 1);
		infoPanel.setLayout(gridLayout8);

		JPanel topInfoPanel = new JPanel();
		JPanel botInfoPanel = new JPanel();

		topInfoPanel.setBackground(new Color(205, 183, 158)); // BROWN
		botInfoPanel.setBackground(new Color(205, 183, 158)); // BROWN

		GridLayout gridLayout9 = new GridLayout(1, 3);
		topInfoPanel.setLayout(gridLayout9);

		// creating and setting labels and buttons on Game Info Panel
		JButton sunButton = new JButton(new ImageIcon(ApplicationStatics.IMAGE_PATH_MAP_Sun));
		sunButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("sun button was clicked!");
				playerModel.printAllTowers();
			}
		});

		sunCurrencyLabel = new JLabel("B2");
		String tempString = "<html> Sun<br>" + Integer.toString(playerModel.getSunCurrency()) + "</html>";
		sunCurrencyLabel.setText(tempString);
		sunCurrencyLabel.setFont(new Font("Serif", Font.BOLD, 20));

		JPanel tempPanel = new JPanel(new BorderLayout());

		// -- Label that show the health status of the player
		JLabel b33 = new JLabel("HP " + Integer.toString(playerModel.getHpPlayer()), SwingConstants.CENTER);
		b33.setFont(new Font("Serif", Font.BOLD, 20));
		b33.setForeground(Color.RED);
		tempPanel.add(b33, BorderLayout.CENTER);

		topInfoPanel.add(sunButton);
		topInfoPanel.add(sunCurrencyLabel);
		topInfoPanel.add(tempPanel);

		// -- label that shows game wave number
		JLabel gameLvlLabel = new JLabel("LEVEL " + Integer.toString(playerModel.getGameWave()), SwingConstants.CENTER);
		gameLvlLabel.setFont(new Font("Serif", Font.BOLD, 20));
		gameLvlLabel.setHorizontalAlignment(JLabel.CENTER);

		GridLayout gridLayout10 = new GridLayout(1, 2);
		botInfoPanel.setLayout(gridLayout10);
		String s = "<html><b><font size='5'>Wave: 1</font></b><br>Critter: Zomby<br>Health: 50</html>";
		JLabel critterLabel = new JLabel(s, SwingConstants.CENTER);

		// -- button that displays the critter image as background image
		JButton critterIconButton = new JButton(new ImageIcon(ApplicationStatics.IMAGE_PATH_MAP_Critter1));

		// -- adding labels and buttons on Game info Panel
		botInfoPanel.add(critterLabel);
		botInfoPanel.add(critterIconButton);

		infoPanel.add(topInfoPanel);
		infoPanel.add(botInfoPanel);

	}

	/**
	 * <p>
	 * updates the Tower Description Panel information when new tower is
	 * selected
	 * </p>
	 * 
	 * @param new_towerID
	 *            tower Id
	 */
	public void updateTowerDscrPanel(TowerModel new_towerModel) {
		labelStatsTower[1].setText(Integer.toString(new_towerModel.getTowerlevel()));
		labelStatsTower[4].setText(Integer.toString(new_towerModel.getTowerPower()));
		labelStatsTower[7].setText(Integer.toString(new_towerModel.getTowerRange()));
		labelStatsTower[10].setText(Integer.toString(new_towerModel.getTowerFireRate()));
		labelStatsTower[13].setText(Integer.toString(0));
		labelStatsTower[16].setText(Integer.toString(new_towerModel.getTowerCost()));

		towerNameLabel.setText(new_towerModel.getTowerName());
		towerLevelLabel.setText("Level " + Integer.toString(new_towerModel.getTowerlevel()));
		towerButtonDESCR.setIcon(new_towerModel.getTowerImage());

		// currentSelectedTowerName = "tower" + Integer.toString(new_towerID);
		// -- checks if tower is selected from the shop or the map
		if (setTowerDescrPanelVisible) {
			labelStatsTower[2].setText(Integer.toString(new_towerModel.getTowerlevel() + 1));
			labelStatsTower[5].setText(Integer.toString(new_towerModel.getTowerPower() * 2));
			labelStatsTower[8].setText(Integer.toString(new_towerModel.getTowerRange() + 1));
			labelStatsTower[11].setText(Integer.toString(new_towerModel.getTowerFireRate() + 2));
			labelStatsTower[14].setText(Integer.toString(0));
			labelStatsTower[17].setText(Integer.toString((int) (new_towerModel.getTowerCost() * 0.5)));
			sellBuyTowerButton.setText("SELL");
			upgradeTowerButton.setText("UPGRADE");

			labelStatsTower[2].setVisible(true);
			labelStatsTower[5].setVisible(true);
			labelStatsTower[8].setVisible(true);
			labelStatsTower[11].setVisible(true);
			labelStatsTower[14].setVisible(true);
			labelStatsTower[17].setVisible(true);
			upgradeTowerButton.setVisible(true);
		} else {
			labelStatsTower[2].setText("");
			labelStatsTower[5].setText("");
			labelStatsTower[8].setText("");
			labelStatsTower[11].setText("");
			labelStatsTower[14].setText("");
			labelStatsTower[17].setText("");
			sellBuyTowerButton.setText("BUY");
			upgradeTowerButton.setText("");

			labelStatsTower[2].setVisible(false);
			labelStatsTower[5].setVisible(false);
			labelStatsTower[8].setVisible(false);
			labelStatsTower[11].setVisible(false);
			labelStatsTower[14].setVisible(false);
			labelStatsTower[17].setVisible(false);
			upgradeTowerButton.setVisible(false);
		}
	}

	/**
	 * updates info on sun currency
	 */
	public void updateGameInfoPanel() {
		String sb2 = "<html> Sun<br>" + Integer.toString(playerModel.getSunCurrency()) + "</html>";
		sunCurrencyLabel.setText(sb2);
	}

	/**
	 * assigns the pointer to buttons on the map
	 * 
	 * @param new_mapButtons
	 */
	public void setMapButtons(JButton[][] new_mapButtons) {
		mapButtons = new_mapButtons;
	}

	/**
	 * This method is for accessing the Tower model objects
	 * 
	 * @return Player Model object
	 */
	public PlayerModel getPlayerModel() {
		return playerModel;
	}

	/**
	 * re-implementation of method action performed for tower buttons in which
	 * if tower button is clicked, it updates its info on tower description
	 * panel
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		JButton button = (JButton) o;
		String bName = button.getName();

		Character ch = bName.charAt(bName.length() - 1);
		int tempTid = ch.charValue() - 48;
		currentSelectedTower = tempTid;

		String tempS = bName.substring(0, 5);

		if (tempS.compareTo("tower") == 0) {
			System.out.println("Shop Panel: Tower id = " + tempTid);

			setTowerDescrPanelVisible = false;

			towerButtonDESCR.setIcon(button.getIcon());
			if (tempTid == 0) {
				updateTowerDscrPanel(new TowerModel1());
			} else if (tempTid == 1) {
				updateTowerDscrPanel(new TowerModel2());
			} else if (tempTid == 2) {
				updateTowerDscrPanel(new TowerModel3());
			} else if (tempTid == 3) {
				updateTowerDscrPanel(new TowerModel4());
			} else if (tempTid == 4) {
				updateTowerDscrPanel(new TowerModel5());
			}

		}
	}

	/**
	 * This method sets the Buttons to Yellow on the map that are eligible for
	 * tower placement
	 * 
	 * @param new_mapButtons
	 *            the reference to our map buttons
	 */
	public void setMapButtonsToYellow(JButton[][] new_mapButtons) {

		String stringMapCoord = "";

		for (int i = 0; i < new_mapButtons.length; i++) {

			for (int j = 0; j < new_mapButtons[i].length; j++) {
				stringMapCoord = "" + (i) + ":" + j;
				if (ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME.contains(stringMapCoord)) {

					new_mapButtons[i][j].setEnabled(true);
					if (hasBoughtTower) {
						new_mapButtons[i][j].setIcon(new ImageIcon(ApplicationStatics.IMAGE_PATH_MAP_ButtonYellow));
						setTowersOnMap(mapButtons, i, j);
					} else {
						// -- sets all button icons to green scenery and later
						int x = new_mapButtons[i][j].getWidth();
						int y = new_mapButtons[i][j].getHeight();
						new_mapButtons[i][j]
								.setIcon(new ImageIcon(new ImageIcon(ApplicationStatics.IMAGE_PATH_MAP_Scenery)
										.getImage().getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH)));

						setTowersOnMap(mapButtons, i, j);
					}
				} else { // -- disable buttons boundaries
					new_mapButtons[i][j].setEnabled(!hasBoughtTower);
				}
			}
		}
	}

	/**
	 * This method sets icons on the map buttons where they have been placed by
	 * player
	 * 
	 * @param new_mapButtons
	 *            reference to our map button
	 * @param new_i
	 *            x coordinate of the button
	 * @param new_j
	 *            y coordinate of the button
	 */
	public void setTowersOnMap(JButton[][] new_mapButtons, int new_i, int new_j) {
		for (int k = 0; k < playerModel.towerModelArray.size(); k++) {
			int x = playerModel.towerModelArray.get(k).getX();
			int y = playerModel.towerModelArray.get(k).getY();
			if (new_i == x && new_j == y) {
				if (hasBoughtTower) {
					new_mapButtons[new_i][new_j].setEnabled(false);
				} else {
					new_mapButtons[new_i][new_j].setEnabled(true);
				}
				new_mapButtons[new_i][new_j].setIcon(playerModel.towerModelArray.get(k).getTowerImage());
			}
		}
	}
	

	// END
}
