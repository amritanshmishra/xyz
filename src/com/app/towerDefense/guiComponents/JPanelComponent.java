package com.app.towerDefense.guiComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.app.towerDefense.staticContent.ApplicationStatics;
import com.app.towerDefense.staticContent.AppilicationEnums.*;
import com.app.towerDefense.utilities.MiscellaneousHelper;
import com.app.towerDefense.models.MapModel;
import com.app.towerDefense.models.TowerModel;
import com.app.towerDefense.models.TowerModel1;

/**
 * This class is for the jpanel component in our application
 * 
 * @author Sajjad Ashraf
 *
 */
public class JPanelComponent {

	public BottomGamePanelView bottomGamePanel;
	public JButton[][] buttons;

	/**
	 * This method is map window tower section
	 * 
	 * @param new_parentDimension
	 *            the dimentsion of the game tower panel
	 * @return jpanel bottom game panel
	 */
	public JPanel getGameTowerPanel(Dimension new_parentDimension) {
		bottomGamePanel = new BottomGamePanelView(new_parentDimension.width, new_parentDimension.height * 1 / 4 - 30);
		bottomGamePanel
				.setPreferredSize(new Dimension(new_parentDimension.width, new_parentDimension.height * 1 / 4 - 30));
		bottomGamePanel
				.setMaximumSize(new Dimension(new_parentDimension.width, new_parentDimension.height * 1 / 4 - 30));
		bottomGamePanel
				.setMinimumSize(new Dimension(new_parentDimension.width, new_parentDimension.height * 1 / 4 - 30));
		// panel.setBackground(Color.CYAN);
		return bottomGamePanel;
	}

	/**
	 * this method returns the panel for the game map
	 * 
	 * @param new_width
	 *            width of the panel
	 * @param new_height
	 *            height of the panel
	 * @return the game map panel
	 */
	public JPanel getGameMapPanel(int new_width, int new_height) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(new_width, new_height));
		panel.setMaximumSize(new Dimension(new_width, new_height));
		panel.setMinimumSize(new Dimension(new_width, new_height));
		panel.setBackground(Color.GREEN);
		return panel;
	}

	/**
	 * this method gets the map editor panel
	 * 
	 * @param new_mapModel
	 *            creates a new map model
	 * @param new_mapEditorMode
	 *            map editor mode
	 * @return the panel for the map editor
	 */
	public JPanel getMapEditorGridPanel(final MapModel new_mapModel, E_MapEditorMode new_mapEditorMode) {
		if (E_MapEditorMode.Create == new_mapEditorMode) {
			new_mapModel.mapGridSelection = new int[new_mapModel.getMapHeight()][new_mapModel.getMapWidth()];
		}

		JPanel panel = new JPanel();
		GridLayout gridLayout = new GridLayout(new_mapModel.getMapHeight(), new_mapModel.getMapWidth(), 3, 3);
		panel.setLayout(gridLayout);
		JButton b[][] = new JButton[new_mapModel.getMapHeight()][new_mapModel.getMapWidth()];

		for (int i = 0; i < new_mapModel.getMapHeight(); i++) {
			for (int j = 0; j < new_mapModel.getMapWidth(); j++) {
				b[i][j] = new JButton();
				int value = 0;
				int multiple = 0;

				multiple = new_mapModel.getMapWidth();

				if (i == 0 && j == 0)
					value = 0;
				else
					value = 1 + j + (i * multiple);

				b[i][j].setName(value + ":" + i + ":" + j);

				if (E_MapEditorMode.Create == new_mapEditorMode) {
					new_mapModel.mapGridSelection[i][j] = 0;
					b[i][j].setBackground(Color.gray);
				} else {
					if (new_mapModel.mapGridSelection[i][j] == 1) {
						b[i][j].setBackground(Color.green);
					} else if (new_mapModel.mapGridSelection[i][j] == 2) {
						b[i][j].setBackground(Color.red);
						b[i][j].setText("E");
					} else if (new_mapModel.mapGridSelection[i][j] == 3) {
						b[i][j].setBackground(Color.red);
						b[i][j].setText("O");
					} else {
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
						if (new_mapModel.mapGridSelection[_i][_j] == 0) {
							btn.setBackground(Color.green);
							new_mapModel.mapGridSelection[_i][_j] = 1;
						} else if (new_mapModel.mapGridSelection[_i][_j] == 1) {
							new_mapModel.mapGridSelection[_i][_j] = 0;
							btn.setBackground(Color.gray);
						} else if (new_mapModel.mapGridSelection[_i][_j] == 2) {
							new_mapModel.mapGridSelection[_i][_j] = 0;
							btn.setBackground(Color.gray);
							btn.setText("");
							new_mapModel.isEntryDone = false;
						} else if (new_mapModel.mapGridSelection[_i][_j] == 3) {
							new_mapModel.mapGridSelection[_i][_j] = 0;
							btn.setBackground(Color.gray);
							btn.setText("");
							new_mapModel.isExitDone = false;
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

							if (new_mapModel.mapGridSelection[_i][_j] == 2) {
								new_mapModel.mapGridSelection[_i][_j] = 0;
								btn.setBackground(Color.gray);
								btn.setText("");
								new_mapModel.isEntryDone = false;
								new_mapModel.setEntryPoint(null);
							} else if (new_mapModel.mapGridSelection[_i][_j] == 3) {
								new_mapModel.mapGridSelection[_i][_j] = 0;
								btn.setBackground(Color.gray);
								btn.setText("");
								new_mapModel.isExitDone = false;
								new_mapModel.setExitPoint(null);
							} else if (new_mapModel.mapGridSelection[_i][_j] == 0
									|| new_mapModel.mapGridSelection[_i][_j] == 1) {
								if (!new_mapModel.isEntryDone) {
									btn.setBackground(Color.RED);
									btn.setText("E");
									new_mapModel.mapGridSelection[_i][_j] = 2;
									new_mapModel.setEntryPoint(new Point(_i, _j));
									new_mapModel.isEntryDone = true;
								} else if (!new_mapModel.isExitDone) {
									btn.setBackground(Color.RED);
									btn.setText("O");
									new_mapModel.mapGridSelection[_i][_j] = 3;
									new_mapModel.setExitPoint(new Point(_i, _j));
									new_mapModel.isExitDone = true;
								} else {
									JOptionPane.showMessageDialog(null, "Enrty and Already Selected");
								}
							}

						}
					}
				});

				panel.add(b[i][j]);
			}
		}
		// this.setContentPane(panel);
		return panel;
	}

	/**
	 * this method allows the map editor window to create and open map mode
	 * 
	 * @param new_mapModel
	 *            creates a new map model
	 * @param new_parentDimension
	 *            dimension of the map editor windows
	 * @param mapEditorMode
	 *            object of the map editor mode
	 * @return jpanel
	 */
	public JPanel getMapPlayGridPanel(final MapModel new_mapModel, Dimension new_parentDimension,
			E_MapEditorMode mapEditorMode) {
		// if (E_MapEditorMode.Create == mapEditorMode) {
		// mapModel.mapGridSelection = new int[mapModel.getMapHeight()][mapModel
		// .getMapWidth()];
		// }

		JPanel panel = new JPanel();
		GridLayout gridLayout = new GridLayout(new_mapModel.getMapHeight(), new_mapModel.getMapWidth(), 0, 0);
		panel.setLayout(gridLayout);
		if (new_parentDimension != null) {
			panel.setPreferredSize(new Dimension(new_parentDimension.width, new_parentDimension.height * 3 / 4 - 10));
			panel.setMaximumSize(new Dimension(new_parentDimension.width, new_parentDimension.height * 3 / 4 - 10));
			panel.setMinimumSize(new Dimension(new_parentDimension.width, new_parentDimension.height * 3 / 4 - 10));
		}

		final JButton b[][] = new JButton[new_mapModel.getMapHeight()][new_mapModel.getMapWidth()];

		for (int i = 0; i < new_mapModel.getMapHeight(); i++) {
			for (int j = 0; j < new_mapModel.getMapWidth(); j++) {
				b[i][j] = new JButton();
				b[i][j].setBorder(new LineBorder(Color.green, 0));
				b[i][j].setPreferredSize(new Dimension(10, 10));
				int value = 0;
				int multiple = 0;

				multiple = new_mapModel.getMapWidth();

				if (i == 0 && j == 0)
					value = 0;
				else
					value = 1 + j + (i * multiple);

				b[i][j].setName(value + ":" + i + ":" + j);

				// if (E_MapEditorMode.Create == mapEditorMode) {
				// mapModel.mapGridSelection[i][j] = 0;
				// //b[i][j].setBackground(Color.gray);
				// b[i][j].setIcon( new ImageIcon (
				// ApplicationStatics.IMAGE_PATH_MAP_Scenery));
				//
				// }
				// else
				{
					if (new_mapModel.mapGridSelection[i][j] == 1) {
						// b[i][j].setBackground(Color.green);

						b[i][j].setIcon(new ImageIcon(
								((new ImageIcon(ApplicationStatics.IMAGE_PATH_MAP_ROUTE).getImage().getScaledInstance(
										(int) new_parentDimension.getWidth() / new_mapModel.getMapWidth(),
										(int) new_parentDimension.getHeight() / new_mapModel.getMapHeight(),
										java.awt.Image.SCALE_SMOOTH)))));

						if ((i >= 0 && i < new_mapModel.getMapHeight()) || (j >= 0 && j < new_mapModel.getMapWidth())) {
							String name = "";
							// Select Down button
							if (i != new_mapModel.getMapHeight() - 1) {
								if (new_mapModel.mapGridSelection[i + 1][j] != 1
										&& new_mapModel.mapGridSelection[i + 1][j] != 2
										&& new_mapModel.mapGridSelection[i + 1][j] != 3) {
									name = "" + (i + 1) + ":" + j;
									if (!ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME.contains(name))
										ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME += name + ",";
								}
							}

							// Select up button
							if (i > 0) {
								if (new_mapModel.mapGridSelection[i - 1][j] != 1
										&& new_mapModel.mapGridSelection[i - 1][j] != 2
										&& new_mapModel.mapGridSelection[i - 1][j] != 3) {
									name = "" + (i - 1) + ":" + j;
									if (!ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME.contains(name))
										ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME += name + ",";
								}
							}

							// Checking for Left cell
							if (j != new_mapModel.getMapWidth() - 1) {
								if (new_mapModel.mapGridSelection[i][j + 1] != 1
										&& new_mapModel.mapGridSelection[i][j + 1] != 2
										&& new_mapModel.mapGridSelection[i][j + 1] != 3) {
									name = "" + (i) + ":" + (j + 1);
									if (!ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME.contains(name))
										ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME += name + ",";
								}
							}

							// Checking For Right Cell
							if (j > 0) {
								if (new_mapModel.mapGridSelection[i][j - 1] != 1
										&& new_mapModel.mapGridSelection[i][j - 1] != 2
										&& new_mapModel.mapGridSelection[i][j - 1] != 3) {
									name = "" + (i) + ":" + (j - 1);
									if (!ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME.contains(name))
										ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME += name + ",";
								}
							}

						}

					} else if (new_mapModel.mapGridSelection[i][j] == 2) {
						b[i][j].setBackground(Color.red);
						b[i][j].setText("E");
						// b[i][j].setIcon(new ImageIcon (
						// ApplicationStatics.IMAGE_PATH_MAP_ENTRY));
					} else if (new_mapModel.mapGridSelection[i][j] == 3) {
						b[i][j].setBackground(Color.red);
						b[i][j].setText("O");
						// b[i][j].setIcon( new ImageIcon (
						// ApplicationStatics.IMAGE_PATH_MAP_EXIT));
					} else {
						// b[i][j].setBackground(Color.gray);
						// b[i][j].setIcon( new ImageIcon (
						// ApplicationStatics.IMAGE_PATH_MAP_Scenery));
						b[i][j].setIcon(new ImageIcon(
								((new ImageIcon(ApplicationStatics.IMAGE_PATH_MAP_Scenery).getImage().getScaledInstance(
										(int) new_parentDimension.getWidth() / new_mapModel.getMapWidth(),
										(int) new_parentDimension.getHeight() / new_mapModel.getMapHeight(),
										java.awt.Image.SCALE_SMOOTH)))));

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
						if (new_mapModel.mapGridSelection[_i][_j] == 0) {
							btn.setBackground(Color.green);
							new_mapModel.mapGridSelection[_i][_j] = 1;
						} else if (new_mapModel.mapGridSelection[_i][_j] == 1) {
							new_mapModel.mapGridSelection[_i][_j] = 0;
							btn.setBackground(Color.gray);
						} else if (new_mapModel.mapGridSelection[_i][_j] == 2) {
							new_mapModel.mapGridSelection[_i][_j] = 0;
							btn.setBackground(Color.gray);
							btn.setText("");
							new_mapModel.isEntryDone = false;
						} else if (new_mapModel.mapGridSelection[_i][_j] == 3) {
							new_mapModel.mapGridSelection[_i][_j] = 0;
							btn.setBackground(Color.gray);
							btn.setText("");
							new_mapModel.isExitDone = false;
						}

						String[] tempStr = btn.getName().split(":");
						int new_x = Integer.parseInt(tempStr[1]);
						int new_y = Integer.parseInt(tempStr[2]);

						TowerModel tempTM = new TowerModel1();
						;

						// bottomGamePanel.setTowerDescrPanelVisible = true;
						// bottomGamePanel.updateTowerDscrPanel(tempTM);

						if (bottomGamePanel.currentSelectedTower == 0) {
							bottomGamePanel.setTowerDescrPanelVisible = false;
						}

						if (bottomGamePanel.hasBoughtTower) {
							System.out.println("The Button " + btn.getName() + " is clicked");
							if (!bottomGamePanel.getPlayerModel().towerModelArray.isEmpty()) {

								// -- sets the tower coordinates
								int arrSize = bottomGamePanel.getPlayerModel().towerModelArray.size();
								bottomGamePanel.getPlayerModel().towerModelArray.get(arrSize - 1).setXY(new_x, new_y);

								bottomGamePanel.hasBoughtTower = false;
								bottomGamePanel.setMapButtonsToYellow(b);
							} else {
								System.out.println("Dont have towers");
							}
						} else {
							if (!bottomGamePanel.getPlayerModel().towerModelArray.isEmpty()) {

								for (int i = 0; i < bottomGamePanel.getPlayerModel().towerModelArray.size(); i++) {
									tempTM = bottomGamePanel.getPlayerModel().towerModelArray.get(i);

									if (new_x == tempTM.getX() && new_y == tempTM.getY()) {
										System.out.println("HERE x=" + tempTM.getTowerName());
										bottomGamePanel.setTowerDescrPanelVisible = true;
										bottomGamePanel.updateTowerDscrPanel(tempTM);
										bottomGamePanel.towerButtonDESCR
												.setName(Integer.toString(new_x) + ":" + Integer.toString(new_y));
									}
								}

							}

						}

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

							if (new_mapModel.mapGridSelection[_i][_j] == 2) {
								new_mapModel.mapGridSelection[_i][_j] = 0;
								btn.setBackground(Color.gray);
								btn.setText("");
								new_mapModel.isEntryDone = false;
								new_mapModel.setEntryPoint(null);
							} else if (new_mapModel.mapGridSelection[_i][_j] == 3) {
								new_mapModel.mapGridSelection[_i][_j] = 0;
								btn.setBackground(Color.gray);
								btn.setText("");
								new_mapModel.isExitDone = false;
								new_mapModel.setExitPoint(null);
							} else if (new_mapModel.mapGridSelection[_i][_j] == 0
									|| new_mapModel.mapGridSelection[_i][_j] == 1) {
								if (!new_mapModel.isEntryDone) {
									btn.setBackground(Color.RED);
									btn.setText("E");
									new_mapModel.mapGridSelection[_i][_j] = 2;
									new_mapModel.setEntryPoint(new Point(_i, _j));
									new_mapModel.isEntryDone = true;
								} else if (!new_mapModel.isExitDone) {
									btn.setBackground(Color.RED);
									btn.setText("O");
									new_mapModel.mapGridSelection[_i][_j] = 3;
									new_mapModel.setExitPoint(new Point(_i, _j));
									new_mapModel.isExitDone = true;
								} else {
									JOptionPane.showMessageDialog(null, "Enrty and Already Selected");
								}
							}

						}
					}
				});

				panel.add(b[i][j]);
			}
		}

		// this.setContentPane(panel);
		if (ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME.length() > 1) {
			ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME = (new MiscellaneousHelper())
					.RemoveCharacterFromEndorRight(ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME, ",");
		}
		System.out.print(ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME);
		setButtons(b);

		return panel;
	}

	/**
	 * This method sets the reference button to map buttons
	 * 
	 * @param new_buttons
	 *            the reference button
	 */
	public void setButtons(JButton[][] new_buttons) {
		buttons = new_buttons;
	}

	/**
	 * This method gets the map buttons
	 * 
	 * @return map buttons
	 */
	public JButton[][] getButtons() {
		return buttons;
	}

	/**
	 * This method sets the reference to bottom game panel
	 * 
	 * @param new_panel
	 *            the reference to object of BottomGamePanelView
	 */
	public void setBottomGamePanelView(BottomGamePanelView new_panel) {
		bottomGamePanel = new_panel;
	}

}
