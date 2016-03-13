package com.app.towerDefense.guiComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.app.towerDefense.models.TowerModel;
import com.app.towerDefense.models.TowerModel1;
import com.app.towerDefense.models.TowerModel2;
import com.app.towerDefense.models.TowerModel3;
import com.app.towerDefense.models.TowerModel4;
import com.app.towerDefense.staticContent.ApplicationStatics;
/**
 * This class creates the view of the game shop panel
 * @author usbaitass
 *
 */
public class TowerShopPanel extends Observable implements ActionListener {

	JPanel panel;
/**
 * Constructor
 * @param new_width recieves given width parameter
 * @param new_height receives given height parameter
 */
	public TowerShopPanel(int new_width, int new_height) {

		// -----CREATING---Five--Towers---for---SHOP-------
		ApplicationStatics.TOWER_MODELS[0] = (TowerModel) new TowerModel1();
		ApplicationStatics.TOWER_MODELS[1] = (TowerModel) new TowerModel2();
		ApplicationStatics.TOWER_MODELS[2] = (TowerModel) new TowerModel3();
		ApplicationStatics.TOWER_MODELS[3] = (TowerModel) new TowerModel4();
		
		panel = new JPanel();

		panel.setMinimumSize(new Dimension(new_width, new_height));
		panel.setMaximumSize(new Dimension(new_width, new_height));
		panel.setPreferredSize(new Dimension(new_width, new_height));
		panel.setBackground(new Color(205, 183, 158)); // BROWN

		// ----TOWER---SHOP--PANEL------------------
		// -- setting layout and creating buttons
		GridLayout gridLayout = new GridLayout(2, 2);
		panel.setLayout(gridLayout);

		// -- creating 5 tower
		JButton[] towerButton = new JButton[4];

		for (int i = 0; i < 4; i++) {
			towerButton[i] = new JButton(ApplicationStatics.TOWER_MODELS[i].getTowerImage());
			towerButton[i].setText(Integer.toString(ApplicationStatics.TOWER_MODELS[i].getTowerCost()));
			towerButton[i].setName("tower" + Integer.toString(i));

			panel.add(towerButton[i]);
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
	
		String tempS = bName.substring(0, bName.length() - 1);

		if (tempS.compareTo("tower") == 0) {
			System.out.println("Shop Panel: Tower id = " + tempTid);

			ApplicationStatics.SET_TOWER_DESCR_VISIBLE = false;
			ApplicationStatics.CURRENT_SELECTED_TOWER = tempTid;
			setChanged();
			notifyObservers();
		}
	}
	
	/**
	 * This method returns the Tower shop panel
	 * @return panel object
	 */
	public JPanel getPanel(){
		return panel;
	}
	
//END	
}
