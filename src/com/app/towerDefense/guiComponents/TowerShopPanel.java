package com.app.towerDefense.guiComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.app.towerDefense.models.TowerModel;
import com.app.towerDefense.models.TowerModel1;
import com.app.towerDefense.models.TowerModel2;
import com.app.towerDefense.models.TowerModel3;
import com.app.towerDefense.models.TowerModel4;
/**
 * This class creates the view of the game shop panel
 * @author usbaitass
 *
 */
public class TowerShopPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = -8703494596050702843L;

	private TowerModel[] new_towerModel = new TowerModel[4];
	private static int currentSelectedTower = 0;
/**
 * Constructor
 * @param new_width recieves given width parameter
 * @param new_height receives given height parameter
 */
	public TowerShopPanel(int new_width, int new_height) {

		// -----CREATING---Five--Towers---for---SHOP-------
		new_towerModel[0] = (TowerModel) new TowerModel1();
		new_towerModel[1] = (TowerModel) new TowerModel2();
		new_towerModel[2] = (TowerModel) new TowerModel3();
		new_towerModel[3] = (TowerModel) new TowerModel4();

		this.setMinimumSize(new Dimension(new_width, new_height));
		this.setMaximumSize(new Dimension(new_width, new_height));
		this.setPreferredSize(new Dimension(new_width, new_height));
		this.setBackground(new Color(205, 183, 158)); // BROWN

		// ----TOWER---SHOP--PANEL------------------
		// -- setting layout and creating buttons
		GridLayout gridLayout = new GridLayout(2, 2);
		this.setLayout(gridLayout);

		// -- creating 5 tower
		JButton[] towerButton = new JButton[4];

		for (int i = 0; i < 4; i++) {
			towerButton[i] = new JButton(new_towerModel[i].getTowerImage());
			towerButton[i].setText(Integer.toString(new_towerModel[i].getTowerCost()));
			towerButton[i].setName("tower" + Integer.toString(i));

			this.add(towerButton[i]);
			towerButton[i].addActionListener(this);
		}

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

		int tempTid = Integer.parseInt(bName.substring(bName.length() - 1));
		// currentSelectedTower = tempTid;

		String tempS = bName.substring(0, bName.length() - 1);

	//	System.out.println(tempS);

		if (tempS.compareTo("tower") == 0) {
			System.out.println("Shop Panel: Tower id = " + tempTid);

			TowerDescriptionPanel.setTowerDescrPanelVisible = false;

			TowerDescriptionPanel.towerLabelDESCR.setIcon(button.getIcon());
			
			if (tempTid == 0) {
				//updateTowerDscrPanel(new TowerModel1());
				currentSelectedTower = 0;
			} else if (tempTid == 1) {
				//updateTowerDscrPanel(new TowerModel2());
				currentSelectedTower = 1;
			} else if (tempTid == 2) {
				//updateTowerDscrPanel(new TowerModel3());
				currentSelectedTower = 2;
			} else if (tempTid == 3) {
				//updateTowerDscrPanel(new TowerModel4());
				currentSelectedTower = 3;
			}
	
		}
	}
	
//END	
}
