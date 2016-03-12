package com.app.towerDefense.guiComponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.app.towerDefense.models.TowerModel;
import com.app.towerDefense.staticContent.ApplicationStatics;
/**
 * This class creates the view of tower description
 * that shows the current selected tower information
 * @author usbaitass
 *
 */
public class TowerDescriptionPanel extends JPanel implements Observer {

	private static final long serialVersionUID = -2664654291872636064L;
	public static JLabel towerLabelDESCR = new JLabel(new ImageIcon(ApplicationStatics.IMAGE_PATH_MAP_Tower1));
	private JLabel[] labelStatsTower;
	private JLabel towerNameLabel;
	private JButton upgradeTowerButton;
	private JButton sellBuyTowerButton;
	private JButton strategyTowerButton;
	public static boolean setTowerDescrPanelVisible;
/**
 * Constructor
 * @param new_width sets width by a given parameter
 * @param new_height sets height by a given parameter
 */
	public TowerDescriptionPanel(int new_width, int new_height) {

		setTowerDescrPanelVisible = false;

		this.setMinimumSize(new Dimension(new_width, new_height));
		this.setMaximumSize(new Dimension(new_width, new_height));
		this.setPreferredSize(new Dimension(new_width, new_height));
		this.setBackground(new Color(205, 183, 158)); // BROWN

		// -- setting layout
		BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);

		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(new_width * 2 / 3, new_height));
		rightPanel.setPreferredSize(new Dimension(new_width * 1 / 3, new_height));

		leftPanel.setBackground(new Color(205, 183, 158)); // BROWN
		rightPanel.setBackground(new Color(205, 183, 158)); // BROWN

		GridLayout gridLayoutLeft = new GridLayout(6, 3);
		leftPanel.setLayout(gridLayoutLeft);

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
			labelStatsTower[i].setFont(new Font("Serif", Font.BOLD, 14));
			labelStatsTower[i].setBorder(BorderFactory.createLineBorder(Color.GRAY));
			labelStatsTower[i].setBackground(Color.WHITE);
			labelStatsTower[i].setOpaque(true);
			leftPanel.add(labelStatsTower[i]);
		}

		// --Adding 4 buttons to Tower Description Panel
		// -- setting layouts and secondary panels
		BorderLayout borderLayoutRight = new BorderLayout();
		rightPanel.setLayout(borderLayoutRight);

		// -- Labels that show the Name of the tower
//		towerNameLabel = new JLabel(TowerShopPanel.new_towerModel[0].getTowerName(), SwingConstants.CENTER);
		towerNameLabel = new JLabel("towerName");
		
		// -- initializing the Sell-Buy Tower Button
		// and implementing functionality
		sellBuyTowerButton = new JButton("BUY");
		sellBuyTowerButton.setPreferredSize(new Dimension(70, 20));
		/*
		 * sellBuyTowerButton.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * 
		 * if (sellBuyTowerButton.getText() == "BUY" && currentSelectedTower <
		 * 5) {
		 * 
		 * int tempTCost = new_towerModel[currentSelectedTower].getTowerCost();
		 * int currentBalance = playerModel.getSunCurrency();
		 * 
		 * if (currentBalance >= tempTCost) { // -- true if BUY is success
		 * TowerModel tempTM = playerModel.buyTower(currentSelectedTower); if
		 * (tempTM != null) {
		 * 
		 * hasBoughtTower = true; updateGameInfoPanel();
		 * setMapButtonsToYellow(mapButtons);
		 * 
		 * JFrame frame = new JFrame(); JOptionPane.showMessageDialog(frame,
		 * "You have bought a tower.\n Place it ONLY on the YELLOW Part on the map please."
		 * ); } } else { JFrame frame = new JFrame();
		 * JOptionPane.showMessageDialog(frame,
		 * "You don't have enough suns for this tower."); } } else {
		 * System.out.println("SELLING" + towerButtonDESCR.getName());
		 * 
		 * String[] tempStr = towerButtonDESCR.getName().split(":"); int temp_x
		 * = Integer.parseInt(tempStr[0]); int temp_y =
		 * Integer.parseInt(tempStr[1]);
		 * 
		 * for (int k = 0; k < playerModel.towerModelArray.size(); k++) { int x
		 * = playerModel.towerModelArray.get(k).getX(); int y =
		 * playerModel.towerModelArray.get(k).getY(); if (temp_x == x && temp_y
		 * == y) { if (playerModel.sellTower(k)) { int w =
		 * mapButtons[x][y].getWidth(); int h = mapButtons[x][y].getHeight();
		 * 
		 * mapButtons[x][y] .setIcon(new ImageIcon(new
		 * ImageIcon(ApplicationStatics.IMAGE_PATH_MAP_Scenery)
		 * .getImage().getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH)));
		 * System.out.println("tower deleted successfully.");
		 * 
		 * setTowerDescrPanelVisible = false; updateTowerDscrPanel(new
		 * TowerModel1()); updateGameInfoPanel();
		 * 
		 * } else { System.out.println("could not delete tower."); } } } } }
		 * 
		 * 
		 * });
		 */
		// -- initializing the tower upgrade button
		// -- and implementing its functionality
		upgradeTowerButton = new JButton("UPGRADE");
		upgradeTowerButton.setOpaque(true);
		upgradeTowerButton.setVisible(true);
		upgradeTowerButton.setPreferredSize(new Dimension(70, 20));
		/*
		 * upgradeTowerButton.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * System.out.println("upgrade button was clicked!");
		 * 
		 * // System.out.println("button coordinates= " +
		 * towerButtonDESCR.getName());
		 * 
		 * String[] tempStr = towerButtonDESCR.getName().split(":"); int temp_x
		 * = Integer.parseInt(tempStr[0]); int temp_y =
		 * Integer.parseInt(tempStr[1]);
		 * 
		 * TowerModel tempTM = null;
		 * 
		 * for (int k = 0; k < playerModel.towerModelArray.size(); k++) { int x
		 * = playerModel.towerModelArray.get(k).getX(); int y =
		 * playerModel.towerModelArray.get(k).getY(); if (temp_x == x && temp_y
		 * == y) { tempTM = playerModel.upgradeTower(k); if (tempTM != null) {
		 * 
		 * System.out.println("Tower is upgraded successfully.");
		 * 
		 * playerModel.subSunCurrency(tempTM.getTowerUpgradeCost());
		 * 
		 * updateTowerDscrPanel(tempTM); updateGameInfoPanel();
		 * 
		 * JFrame frame = new JFrame(); JOptionPane.showMessageDialog(frame,
		 * "You upgraded the tower successfully.");
		 * 
		 * System.out.println("new Cost = " +
		 * Integer.toString(tempTM.getTowerCost()));
		 * 
		 * } else { System.out.println("could not upgrade tower."); } } }
		 * 
		 * } });
		 */
		// -- initializing the tower description panel information to default
		//updateTowerDscrPanel(new TowerModel1());

		// -- adding the labels and buttons on Tower Description Panel
		strategyTowerButton = new JButton("STRATEGY");
		strategyTowerButton.setOpaque(true);
		strategyTowerButton.setVisible(true);
		strategyTowerButton.setPreferredSize(new Dimension(70, 20));

		JPanel botPanel = new JPanel();
		botPanel.setLayout(new BorderLayout());
		botPanel.add(strategyTowerButton, BorderLayout.WEST);
		botPanel.add(upgradeTowerButton, BorderLayout.EAST);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.add(sellBuyTowerButton, BorderLayout.NORTH);
		topPanel.add(botPanel, BorderLayout.SOUTH);

		rightPanel.add(towerNameLabel, BorderLayout.NORTH);
		rightPanel.add(towerLabelDESCR, BorderLayout.CENTER);
		rightPanel.add(topPanel, BorderLayout.SOUTH);

		this.add(leftPanel, BorderLayout.CENTER);
		this.add(rightPanel, BorderLayout.EAST);

	}

	/**
	 * updates the Tower Description Panel information when new tower is
	 * selected
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
		towerLabelDESCR.setIcon(new_towerModel.getTowerImage());

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
			strategyTowerButton.setVisible(true);
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
			strategyTowerButton.setVisible(false);
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	//	updateTowerDscrPanel(new TowerModel1());
	}

}
