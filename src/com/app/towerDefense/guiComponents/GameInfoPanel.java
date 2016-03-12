package com.app.towerDefense.guiComponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.app.towerDefense.staticContent.ApplicationStatics;
/**
 * This class creates view of the Game information panel
 * and all elements on it
 * @author usbaitass
 *
 */
public class GameInfoPanel extends JPanel {

	private static final long serialVersionUID = 8847617647575898521L;
	private JLabel sunCurrencyLabel;
	private JButton startPauseButton;
	private JLabel hpLabel;
	private JLabel waveLabel;
	private JLabel critterLabel;
	private JButton critterIconButton;
/**
 * Constructor
 * @param new_width the width parameter given by its parent
 * @param new_height the height parameter given by its parent
 */
	public GameInfoPanel(int new_width, int new_height) {

		this.setMinimumSize(new Dimension(new_width, new_height));
		this.setMaximumSize(new Dimension(new_width, new_height));
		this.setPreferredSize(new Dimension(new_width, new_height));

		// -- setting layout and secondary panels
		BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);

		JPanel leftInfoPanel = new JPanel();
		JPanel rightInfoPanel = new JPanel();
		leftInfoPanel.setPreferredSize(new Dimension(new_width/3, new_height));
		rightInfoPanel.setPreferredSize(new Dimension(new_width*2/3, new_height));

		leftInfoPanel.setBackground(new Color(205, 183, 158)); // BROWN
		rightInfoPanel.setBackground(new Color(205, 183, 158)); // BROWN
		
		leftInfoPanel.setLayout(new FlowLayout());
		
		// creating and setting labels and buttons on Game Info Panel
		JLabel sunButton = new JLabel(new ImageIcon(ApplicationStatics.IMAGE_PATH_MAP_Sun));
		
		sunCurrencyLabel = new JLabel("500");
		// String tempString = "<html> Sun<br>" +
		// Integer.toString(playerModel.getSunCurrency()) + "</html>";
		// sunCurrencyLabel.setText(tempString);
		sunCurrencyLabel.setFont(new Font("Serif", Font.BOLD, 13));

		
		// -- Label that show the health status of the player
		// JLabel b33 = new JLabel("HP " +
		// Integer.toString(playerModel.getHpPlayer()), SwingConstants.CENTER);
		hpLabel = new JLabel("HP 100");
		hpLabel.setFont(new Font("Serif", Font.BOLD, 13));
		hpLabel.setForeground(Color.RED);
		
		startPauseButton = new JButton("Start");
		startPauseButton.setVisible(true);
		

		leftInfoPanel.add(sunButton);
		leftInfoPanel.add(sunCurrencyLabel);
		leftInfoPanel.add(hpLabel);
		leftInfoPanel.add(startPauseButton);

		// -- label that shows game wave number
		// JLabel gameLvlLabel = new JLabel("LEVEL " +
		// Integer.toString(playerModel.getGameWave()), SwingConstants.CENTER);
		waveLabel = new JLabel("WAVE: 1");
		waveLabel.setFont(new Font("Serif", Font.BOLD, 15));
		waveLabel.setHorizontalAlignment(JLabel.CENTER);

		String s = "<html>Critter: Zomby x 5<br>Health: 50</html>";
		critterLabel = new JLabel(s, SwingConstants.CENTER);

		// -- button that displays the critter image as background image
		critterIconButton = new JButton(new ImageIcon(ApplicationStatics.IMAGE_PATH_MAP_Critter1));
		critterIconButton.setDisabledIcon(new ImageIcon(ApplicationStatics.IMAGE_PATH_MAP_Critter1));
		critterIconButton.setEnabled(false);
		
		// -- adding labels and buttons on Game info Panel
		rightInfoPanel.add(waveLabel);
		rightInfoPanel.add(critterLabel);
		rightInfoPanel.add(critterIconButton);

		this.add(leftInfoPanel, BorderLayout.WEST);
		this.add(rightInfoPanel, BorderLayout.EAST);

	}

	/**
	 * updates info on sun currency
	 */
	/*
	 * public void updateGameInfoPanel() { String sb2 = "<html> Sun<br>" +
	 * Integer.toString(playerModel.getSunCurrency()) + "</html>";
	 * sunCurrencyLabel.setText(sb2); }
	 */

}
