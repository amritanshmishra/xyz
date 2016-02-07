package com.app.towerDefense.guiComponents;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.app.towerDefense.guisystem.GameMenu.E_MapEditorMode;
import com.app.towerDefense.models.MapModel;

public class JPanelComponent {

	public JPanel getMapGridPanel(final MapModel mapModel, E_MapEditorMode mapEditorMode){
		if (E_MapEditorMode.Create == mapEditorMode) {
			mapModel.mapGridSelection = new int[mapModel.getMapHeight()][mapModel
					.getMapWidth()];
		}

		JPanel panel = new JPanel();
		GridLayout gridLayout = new GridLayout(mapModel.getMapHeight(),
				mapModel.getMapWidth(), 3, 3);
		panel.setLayout(gridLayout);
		JButton b[][] = new JButton[mapModel.getMapHeight()][mapModel
				.getMapWidth()];

		for (int i = 0; i < mapModel.getMapHeight(); i++) {
			for (int j = 0; j < mapModel.getMapWidth(); j++) {
				b[i][j] = new JButton();
				int value = 0;
				int multiple = 0;

				multiple = mapModel.getMapWidth();

				if (i == 0 && j == 0)
					value = 0;
				else
					value = 1 + j + (i * multiple);

				b[i][j].setName(value + ":" + i + ":" + j);
				
				if (E_MapEditorMode.Create == mapEditorMode) {
					mapModel.mapGridSelection[i][j] = 0;
					b[i][j].setBackground(Color.gray);
				}
				else
				{
					if(mapModel.mapGridSelection[i][j]==1)
					{
						b[i][j].setBackground(Color.green);
					}
					else if(mapModel.mapGridSelection[i][j]==2)
					{
						b[i][j].setBackground(Color.red);
						b[i][j].setText("E");
					}
					else if(mapModel.mapGridSelection[i][j]==3)
					{
						b[i][j].setBackground(Color.red);
						b[i][j].setText("O");
					}
					else 
					{
						b[i][j].setBackground(Color.gray);
					}
				}
				b[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JButton btn = ((JButton) e.getSource());
						String[] nameArry = btn.getName().split(":");
						int _i = Integer.parseInt(nameArry[1]);
						int _j = Integer.parseInt(nameArry[2]);
						if (mapModel.mapGridSelection[_i][_j] == 0) {
							btn.setBackground(Color.green);
							mapModel.mapGridSelection[_i][_j] = 1;
						} else if (mapModel.mapGridSelection[_i][_j] == 1) {
							mapModel.mapGridSelection[_i][_j] = 0;
							btn.setBackground(Color.gray);
						} else if (mapModel.mapGridSelection[_i][_j] == 2) {
							mapModel.mapGridSelection[_i][_j] = 0;
							btn.setBackground(Color.gray);
							btn.setText("");
							mapModel.isEntryDone = false;
						} else if (mapModel.mapGridSelection[_i][_j] == 3) {
							mapModel.mapGridSelection[_i][_j] = 0;
							btn.setBackground(Color.gray);
							btn.setText("");
							mapModel.isExitDone = false;
						}

						System.out.println(" Btn Name : " + btn.getName());
					}

				});

				b[i][j].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						// boolean mine = field.isMine(x, y);
						if (e.getButton() == MouseEvent.BUTTON1) {
						} else if (e.getButton() == MouseEvent.BUTTON2) {
						} else if (e.getButton() == MouseEvent.BUTTON3) {
							JButton btn = ((JButton) e.getSource());
							String[] nameArry = btn.getName().split(":");
							int _i = Integer.parseInt(nameArry[1]);
							int _j = Integer.parseInt(nameArry[2]);

							if (mapModel.mapGridSelection[_i][_j] == 2) {
								mapModel.mapGridSelection[_i][_j] = 0;
								btn.setBackground(Color.gray);
								btn.setText("");
								mapModel.isEntryDone = false;
								mapModel.setEntryPoint(null);
							} else if (mapModel.mapGridSelection[_i][_j] == 3) {
								mapModel.mapGridSelection[_i][_j] = 0;
								btn.setBackground(Color.gray);
								btn.setText("");
								mapModel.isExitDone = false;
								mapModel.setExitPoint(null);
							} else if (mapModel.mapGridSelection[_i][_j] == 0
									|| mapModel.mapGridSelection[_i][_j] == 1) {
								if (!mapModel.isEntryDone) {
									btn.setBackground(Color.RED);
									btn.setText("E");
									mapModel.mapGridSelection[_i][_j] = 2;
									mapModel.setEntryPoint(new Point(_i,_j));
									mapModel.isEntryDone = true;
								} else if (!mapModel.isExitDone) {
									btn.setBackground(Color.RED);
									btn.setText("O");
									mapModel.mapGridSelection[_i][_j] = 3;
									mapModel.setExitPoint(new Point(_i,_j));
									mapModel.isExitDone = true;
								} else {
									JOptionPane.showMessageDialog(null,
											"Enrty and Already Selected");
								}
							}

						}
					}
				});

				panel.add(b[i][j]);
			}
		}
		//this.setContentPane(panel);
		return panel;
	}

}
