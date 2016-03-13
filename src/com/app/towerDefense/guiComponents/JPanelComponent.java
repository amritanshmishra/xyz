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

import com.app.towerDefense.models.MapModel;
import com.app.towerDefense.staticContent.AppilicationEnums.E_MapEditorMode;
import com.app.towerDefense.staticContent.ApplicationStatics;
import com.app.towerDefense.utilities.MiscellaneousHelper;

public class JPanelComponent {

	private BottomGamePanelView bottomGamePanel;
	
	private JButton mapButtonsGrid2DArray[][];
	private JButton jButtonEntry;
	private JButton jButtonExit;
	public JButton jButtonTower;
	
	private E_MapEditorMode mapEditorMode; 
	// -- Map Window Tower Section
 	public JPanel getGameTowerPanel(Dimension parentDimension) {
		bottomGamePanel = new BottomGamePanelView(parentDimension.width,
				parentDimension.height * 1 / 4 - 30);
		bottomGamePanel.setPreferredSize(new Dimension(parentDimension.width,
				parentDimension.height * 1 / 4 - 30));
		bottomGamePanel.setMaximumSize(new Dimension(parentDimension.width,
				parentDimension.height * 1 / 4 - 30));
		bottomGamePanel.setMinimumSize(new Dimension(parentDimension.width,
				parentDimension.height * 1 / 4 - 30));
		// panel.setBackground(Color.CYAN);
		return bottomGamePanel;
	}

	// -- Map Window Playing mode
	public JPanel getGameMapPanel(int width, int height) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));
		panel.setMaximumSize(new Dimension(width, height));
		panel.setMinimumSize(new Dimension(width, height));
		panel.setBackground(Color.GREEN);
		return panel;
	}

	// -- Map Editor window Create, Open and Play map mode
	public JPanel getMapEditorGridPanel(final MapModel mapModel, Dimension parentDimension,
			E_MapEditorMode mode) {
		mapEditorMode=mode;	
		JPanel panel;
		GridLayout gridLayout;		
		
		//When Create Mode Initialize the mapGridSelection to new
		if (E_MapEditorMode.Create == mapEditorMode) {
			mapModel.mapGridSelection = new int[mapModel.getMapHeight()][mapModel
					.getMapWidth()];
		}	
		
		//In case 'Play' Increase Panel size According to the Play Game Window
		if (E_MapEditorMode.Play == mapEditorMode) {
			
			panel = new JPanel();
			gridLayout = new GridLayout(mapModel.getMapHeight(),
					mapModel.getMapWidth(), 0, 0);
			panel.setLayout(gridLayout);
			
			if (parentDimension != null) {
				panel.setPreferredSize(new Dimension(parentDimension.width,
						parentDimension.height * 3 / 4 - 10));
				panel.setMaximumSize(new Dimension(parentDimension.width,
						parentDimension.height * 3 / 4 - 10));
				panel.setMinimumSize(new Dimension(parentDimension.width,
						parentDimension.height * 3 / 4 - 10));
			}			
		}
		else 
		{
			panel = new JPanel();
			gridLayout = new GridLayout(mapModel.getMapHeight(),
					mapModel.getMapWidth(), 3, 3);
			panel.setLayout(gridLayout);
		}
		//JButton b[][] = new JButton[mapModel.getMapHeight()][mapModel
		mapButtonsGrid2DArray = new JButton[mapModel.getMapHeight()][mapModel
				.getMapWidth()];

		for (int i = 0; i < mapModel.getMapHeight(); i++) {
			for (int j = 0; j < mapModel.getMapWidth(); j++) {
				mapButtonsGrid2DArray[i][j] = new JButton();
				int value = 0;
				int multiple = 0;

				multiple = mapModel.getMapWidth();

				if (i == 0 && j == 0)
					value = 0;
				else
					value = 1 + j + (i * multiple);

				mapButtonsGrid2DArray[i][j].setName(value + ":" + i + ":" + j);

				if (E_MapEditorMode.Create == mapEditorMode) {
					mapModel.mapGridSelection[i][j] = 0;
					mapButtonsGrid2DArray[i][j].setBackground(Color.gray);
					//Click event
					addButtonClickEvents(mapButtonsGrid2DArray[i][j], mapModel);
					//Right Click Event
					addMouseClickOnButtonEvents(mapButtonsGrid2DArray[i][j], mapModel);
				} 
				
				else if(E_MapEditorMode.Open == mapEditorMode) {
					
					if (mapModel.mapGridSelection[i][j] == ApplicationStatics.MAP_PATH_POINT) {
						mapButtonsGrid2DArray[i][j].setBackground(Color.green);
					} else if (mapModel.mapGridSelection[i][j] == ApplicationStatics.MAP_ENTRY_POINT) {
						mapButtonsGrid2DArray[i][j].setBackground(Color.red);
						mapButtonsGrid2DArray[i][j].setText("E");
					} else if (mapModel.mapGridSelection[i][j] == ApplicationStatics.MAP_EXIT_POINT) {
						mapButtonsGrid2DArray[i][j].setBackground(Color.red);
						mapButtonsGrid2DArray[i][j].setText("O");
					} else {
						mapButtonsGrid2DArray[i][j].setBackground(Color.gray);
					}
					
					
					//Click event
					addButtonClickEvents(mapButtonsGrid2DArray[i][j], mapModel);
					//Right Click Event
					addMouseClickOnButtonEvents(mapButtonsGrid2DArray[i][j], mapModel);
				}
				
				else if(E_MapEditorMode.Play == mapEditorMode){
					mapButtonsGrid2DArray[i][j].setBorder(new LineBorder(Color.green, 0));
					mapButtonsGrid2DArray[i][j].setPreferredSize(new Dimension(10, 10));
					
					//Condition for Path cell
					if (mapModel.mapGridSelection[i][j] == ApplicationStatics.MAP_PATH_POINT) {
						// b[i][j].setBackground(Color.green);

						mapButtonsGrid2DArray[i][j].setIcon(new ImageIcon(((new ImageIcon(
								ApplicationStatics.IMAGE_PATH_MAP_ROUTE)
								.getImage().getScaledInstance(
								(int) parentDimension.getWidth()
										/ mapModel.getMapWidth(),
								(int) parentDimension.getHeight()
										/ mapModel.getMapHeight(),
								java.awt.Image.SCALE_SMOOTH)))));
						
						//Click event
						addButtonClickEvents(mapButtonsGrid2DArray[i][j], mapModel);
						//Right Click Event
						//addMouseClickOnButtonEvents(b[i][j], i, j, mapModel);


						if ((i >= 0 && i < mapModel.getMapHeight())
								|| (j >= 0 && j < mapModel.getMapWidth())) {
							String name = "";
							// Select Down button
							if (i != mapModel.getMapHeight() - 1) {
								if (mapModel.mapGridSelection[i + 1][j] != ApplicationStatics.MAP_PATH_POINT
										&& mapModel.mapGridSelection[i + 1][j] != ApplicationStatics.MAP_ENTRY_POINT
										&& mapModel.mapGridSelection[i + 1][j] != ApplicationStatics.MAP_EXIT_POINT) {
									name = "" + (i + 1) + ":" + j;
									if (!ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME
											.contains(name))
										ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME += name
												+ ",";
								}
							}

							// Select up button
							if (i > 0) {
								if (mapModel.mapGridSelection[i - 1][j] != ApplicationStatics.MAP_PATH_POINT
										&& mapModel.mapGridSelection[i - 1][j] != ApplicationStatics.MAP_ENTRY_POINT
										&& mapModel.mapGridSelection[i - 1][j] != ApplicationStatics.MAP_EXIT_POINT) {
									name = "" + (i - 1) + ":" + j;
									if (!ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME
											.contains(name))
										ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME += name
												+ ",";
								}
							}

							// Checking for Left cell
							if (j != mapModel.getMapWidth() - 1) {
								if (mapModel.mapGridSelection[i][j + 1] != ApplicationStatics.MAP_PATH_POINT
										&& mapModel.mapGridSelection[i][j + 1] != ApplicationStatics.MAP_ENTRY_POINT
										&& mapModel.mapGridSelection[i][j + 1] != ApplicationStatics.MAP_EXIT_POINT) {
									name = "" + (i) + ":" + (j + 1);
									if (!ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME
											.contains(name))
										ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME += name
												+ ",";
								}
							}

							// Checking For Right Cell
							if (j > 0) {
								if (mapModel.mapGridSelection[i][j - 1] != ApplicationStatics.MAP_PATH_POINT
										&& mapModel.mapGridSelection[i][j - 1] != ApplicationStatics.MAP_ENTRY_POINT
										&& mapModel.mapGridSelection[i][j - 1] != ApplicationStatics.MAP_EXIT_POINT) {
									name = "" + (i) + ":" + (j - 1);
									if (!ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME
											.contains(name))
										ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME += name
												+ ",";
								}
							}

						}
						
											} 
					//Condition for Entry Cell
					else if (mapModel.mapGridSelection[i][j] == ApplicationStatics.MAP_ENTRY_POINT) {
						mapButtonsGrid2DArray[i][j].setBackground(Color.red);
						mapButtonsGrid2DArray[i][j].setText("E");
						// b[i][j].setIcon(new ImageIcon (
						// ApplicationStatics.IMAGE_PATH_MAP_ENTRY));
						mapButtonsGrid2DArray[i][j].setEnabled(false);
					} 
					//Condition for Exit Cell
					else if (mapModel.mapGridSelection[i][j] == ApplicationStatics.MAP_EXIT_POINT) {
						mapButtonsGrid2DArray[i][j].setBackground(Color.red);
						mapButtonsGrid2DArray[i][j].setText("O");
						mapButtonsGrid2DArray[i][j].setEnabled(false);
						// b[i][j].setIcon( new ImageIcon (
						// ApplicationStatics.IMAGE_PATH_MAP_EXIT));
					} 
					//Condition for Scenery Cell
					else {
						// b[i][j].setBackground(Color.gray);
						// b[i][j].setIcon( new ImageIcon (
						// ApplicationStatics.IMAGE_PATH_MAP_Scenery));
						mapButtonsGrid2DArray[i][j].setIcon(new ImageIcon(((new ImageIcon(
								ApplicationStatics.IMAGE_PATH_MAP_Scenery)
								.getImage().getScaledInstance(
								(int) parentDimension.getWidth()
										/ mapModel.getMapWidth(),
								(int) parentDimension.getHeight()
										/ mapModel.getMapHeight(),
								java.awt.Image.SCALE_SMOOTH)))));
						
						
						//Click event
						addButtonClickEvents(mapButtonsGrid2DArray[i][j], mapModel);
						//Right Click Event
						//addMouseClickOnButtonEvents(b[i][j], i, j, mapModel);


					}
					
					
				}
				/*
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
									mapModel.setEntryPoint(new Point(_i, _j));
									mapModel.isEntryDone = true;
								} else if (!mapModel.isExitDone) {
									btn.setBackground(Color.RED);
									btn.setText("O");
									mapModel.mapGridSelection[_i][_j] = 3;
									mapModel.setExitPoint(new Point(_i, _j));
									mapModel.isExitDone = true;
								} else {
									JOptionPane.showMessageDialog(null,
											"Enrty and Already Selected");
								}
							}

						}
					}
				});
				*/
				panel.add(mapButtonsGrid2DArray[i][j]);
			}
		}
		// this.setContentPane(panel);
		
		if(E_MapEditorMode.Play == mapEditorMode){
			if (ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME.length() > 1) {
				ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME = (new MiscellaneousHelper())
						.RemoveCharacterFromEndorRight(
								ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME,
								",");
			}
			System.out.println("MAP Boundary Points : "+ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME);
			ApplicationStatics.MAP_BUTTONS = mapButtonsGrid2DArray;
		}
		
		return panel;
	}

	/*
	// -- Map Grid for Play Window
	public JPanel getMapPlayGridPanel(final MapModel mapModel,
			Dimension parentDimension, E_MapEditorMode mapEditorMode) {
		// if (E_MapEditorMode.Create == mapEditorMode) {
		// mapModel.mapGridSelection = new int[mapModel.getMapHeight()][mapModel
		// .getMapWidth()];
		// }

		JPanel panel = new JPanel();
		GridLayout gridLayout = new GridLayout(mapModel.getMapHeight(),
				mapModel.getMapWidth(), 0, 0);
		panel.setLayout(gridLayout);
		if (parentDimension != null) {
			panel.setPreferredSize(new Dimension(parentDimension.width,
					parentDimension.height * 3 / 4 - 10));
			panel.setMaximumSize(new Dimension(parentDimension.width,
					parentDimension.height * 3 / 4 - 10));
			panel.setMinimumSize(new Dimension(parentDimension.width,
					parentDimension.height * 3 / 4 - 10));
		}

		final JButton b[][] = new JButton[mapModel.getMapHeight()][mapModel
				.getMapWidth()];

		for (int i = 0; i < mapModel.getMapHeight(); i++) {
			for (int j = 0; j < mapModel.getMapWidth(); j++) {
				b[i][j] = new JButton();
				b[i][j].setBorder(new LineBorder(Color.green, 0));
				b[i][j].setPreferredSize(new Dimension(10, 10));
				int value = 0;
				int multiple = 0;

				multiple = mapModel.getMapWidth();

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
				//{
					//Condition for Path cell
					if (mapModel.mapGridSelection[i][j] == 1) {
						// b[i][j].setBackground(Color.green);

						b[i][j].setIcon(new ImageIcon(((new ImageIcon(
								ApplicationStatics.IMAGE_PATH_MAP_ROUTE)
								.getImage().getScaledInstance(
								(int) parentDimension.getWidth()
										/ mapModel.getMapWidth(),
								(int) parentDimension.getHeight()
										/ mapModel.getMapHeight(),
								java.awt.Image.SCALE_SMOOTH)))));
						
						//Click event
						addButtonClickEvents(b[i][j], i, j, mapModel);
						//Right Click Event
						//addMouseClickOnButtonEvents(b[i][j], i, j, mapModel);


						if ((i >= 0 && i < mapModel.getMapHeight())
								|| (j >= 0 && j < mapModel.getMapWidth())) {
							String name = "";
							// Select Down button
							if (i != mapModel.getMapHeight() - 1) {
								if (mapModel.mapGridSelection[i + 1][j] != 1
										&& mapModel.mapGridSelection[i + 1][j] != 2
										&& mapModel.mapGridSelection[i + 1][j] != 3) {
									name = "" + (i + 1) + ":" + j;
									if (!ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME
											.contains(name))
										ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME += name
												+ ",";
								}
							}

							// Select up button
							if (i > 0) {
								if (mapModel.mapGridSelection[i - 1][j] != 1
										&& mapModel.mapGridSelection[i - 1][j] != 2
										&& mapModel.mapGridSelection[i - 1][j] != 3) {
									name = "" + (i - 1) + ":" + j;
									if (!ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME
											.contains(name))
										ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME += name
												+ ",";
								}
							}

							// Checking for Left cell
							if (j != mapModel.getMapWidth() - 1) {
								if (mapModel.mapGridSelection[i][j + 1] != 1
										&& mapModel.mapGridSelection[i][j + 1] != 2
										&& mapModel.mapGridSelection[i][j + 1] != 3) {
									name = "" + (i) + ":" + (j + 1);
									if (!ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME
											.contains(name))
										ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME += name
												+ ",";
								}
							}

							// Checking For Right Cell
							if (j > 0) {
								if (mapModel.mapGridSelection[i][j - 1] != 1
										&& mapModel.mapGridSelection[i][j - 1] != 2
										&& mapModel.mapGridSelection[i][j - 1] != 3) {
									name = "" + (i) + ":" + (j - 1);
									if (!ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME
											.contains(name))
										ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME += name
												+ ",";
								}
							}

						}
						
											} 
					//Condition for Entry Cell
					else if (mapModel.mapGridSelection[i][j] == 2) {
						b[i][j].setBackground(Color.red);
						b[i][j].setText("E");
						// b[i][j].setIcon(new ImageIcon (
						// ApplicationStatics.IMAGE_PATH_MAP_ENTRY));
						b[i][j].setEnabled(false);
					} 
					//Condition for Exit Cell
					else if (mapModel.mapGridSelection[i][j] == 3) {
						b[i][j].setBackground(Color.red);
						b[i][j].setText("O");
						b[i][j].setEnabled(false);
						// b[i][j].setIcon( new ImageIcon (
						// ApplicationStatics.IMAGE_PATH_MAP_EXIT));
					} 
					//Condition for Scenery Cell
					else {
						// b[i][j].setBackground(Color.gray);
						// b[i][j].setIcon( new ImageIcon (
						// ApplicationStatics.IMAGE_PATH_MAP_Scenery));
						b[i][j].setIcon(new ImageIcon(((new ImageIcon(
								ApplicationStatics.IMAGE_PATH_MAP_Scenery)
								.getImage().getScaledInstance(
								(int) parentDimension.getWidth()
										/ mapModel.getMapWidth(),
								(int) parentDimension.getHeight()
										/ mapModel.getMapHeight(),
								java.awt.Image.SCALE_SMOOTH)))));
						
						
						//Click event
						addButtonClickEvents(b[i][j], i, j, mapModel);
						//Right Click Event
						//addMouseClickOnButtonEvents(b[i][j], i, j, mapModel);


					}
				//}
					
				// disable click events for Entry Exit point
				if (mapModel.mapGridSelection[i][j] != 2 && mapModel.mapGridSelection[i][j] != 3) {
					
				} 
				

				panel.add(b[i][j]);
			}
		}

		// this.setContentPane(panel);
		if (ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME.length() > 1) {
			ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME = (new MiscellaneousHelper())
					.RemoveCharacterFromEndorRight(
							ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME,
							",");
		}
		System.out.print(ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME);
		ApplicationStatics.MAP_BUTTONS = b;

		return panel;
	}
	*/

	private  void addButtonClickEvents(JButton button, final MapModel mapModel)
	{
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btn = ((JButton) e.getSource());
				String[] nameArry = btn.getName().split(":");
				int _i = Integer.parseInt(nameArry[1]);
				int _j = Integer.parseInt(nameArry[2]);
				
				//If Previously an Scenery Point
				if (mapModel.mapGridSelection[_i][_j] == ApplicationStatics.MAP_Scenery_POINT) {
					btn.setBackground(Color.green);
					mapModel.mapGridSelection[_i][_j] = ApplicationStatics.MAP_PATH_POINT;
				} 
				// If Previously an Path point
				else if (mapModel.mapGridSelection[_i][_j] == ApplicationStatics.MAP_PATH_POINT) {
					mapModel.mapGridSelection[_i][_j] = ApplicationStatics.MAP_Scenery_POINT;
					btn.setBackground(Color.gray);
				}
				// If Previously an Entry point
				else if (mapModel.mapGridSelection[_i][_j] == ApplicationStatics.MAP_ENTRY_POINT) {
					mapModel.mapGridSelection[_i][_j] = ApplicationStatics.MAP_Scenery_POINT;
					btn.setBackground(Color.gray);
					btn.setText("");
					mapModel.isEntryDone = false;
					jButtonEntry = null;
				} 
				// If Previously an Exit Point
				else if (mapModel.mapGridSelection[_i][_j] == ApplicationStatics.MAP_EXIT_POINT) {
					mapModel.mapGridSelection[_i][_j] = ApplicationStatics.MAP_Scenery_POINT;
					btn.setBackground(Color.gray);
					btn.setText("");
					mapModel.isExitDone = false;
					jButtonExit = null;
				}
				
				System.out.println("Button Click Event Btn Name : " + btn.getName());
				//String[] tempStr = btn.getName().split(":");
				//int new_x = Integer.parseInt(tempStr[1]);
				//int new_y = Integer.parseInt(tempStr[2]);

				//TowerModel tempTM = new TowerModel1();

				// bottomGamePanel.setTowerDescrPanelVisible = true;
				// bottomGamePanel.updateTowerDscrPanel(tempTM);
				/*
				 * if (bottomGamePanel.currentSelectedTower == 5) {
				 * bottomGamePanel.setTowerDescrPanelVisible = false; }
				 * bottomGamePanel.currentSelectedTower = 5;
				 * bottomGamePanel.updateTowerDscrPanel(tempTM);
				 * 
				 * 
				 * if (bottomGamePanel.hasBoughtTower) {
				 * System.out.println("The Button " + btn.getName() +
				 * " is clicked"); if
				 * (!bottomGamePanel.getPlayerModel().
				 * towerModelArray.isEmpty()) {
				 * 
				 * // -- sets the tower coordinates int arrSize =
				 * bottomGamePanel
				 * .getPlayerModel().towerModelArray.size();
				 * bottomGamePanel
				 * .getPlayerModel().towerModelArray.get(arrSize -
				 * 1).setXY(new_x, new_y);
				 * 
				 * bottomGamePanel.hasBoughtTower = false;
				 * bottomGamePanel.setMapButtonsToYellow(b); } else {
				 * System.out.println("Dont have towers"); } } else { if
				 * (
				 * !bottomGamePanel.getPlayerModel().towerModelArray.isEmpty
				 * ()) {
				 * 
				 * for (int i = 0; i <
				 * bottomGamePanel.getPlayerModel().towerModelArray
				 * .size(); i++) { tempTM =
				 * bottomGamePanel.getPlayerModel
				 * ().towerModelArray.get(i);
				 * 
				 * if (new_x == tempTM.getX() && new_y == tempTM.getY())
				 * { System.out.println("HERE x=" +
				 * tempTM.getTowerName());
				 * bottomGamePanel.setTowerDescrPanelVisible = true;
				 * bottomGamePanel.updateTowerDscrPanel(tempTM);
				 * bottomGamePanel.towerButtonDESCR
				 * .setName(Integer.toString(new_x) + ":" +
				 * Integer.toString(new_y)); } }
				 * 
				 * }
				 * 
				 * }
				 */
			}
		});
	}
	
	private  void addMouseClickOnButtonEvents(JButton button, final MapModel mapModel)
	{
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// boolean mine = field.isMine(x, y);
				//When Right button Clicked of Mouse
				if (e.getButton() == MouseEvent.BUTTON1) {
				} 
				//When Middle button Clicked of Mouse
				else if (e.getButton() == MouseEvent.BUTTON2) {
				} 
				//When Left button Clicked of Mouse
				else if (e.getButton() == MouseEvent.BUTTON3) {
					JButton btn = ((JButton) e.getSource());
					String[] nameArry = btn.getName().split(":");
					int _i = Integer.parseInt(nameArry[1]);
					int _j = Integer.parseInt(nameArry[2]);
					
					//if Previously it is Entry Button
					if (mapModel.mapGridSelection[_i][_j] == ApplicationStatics.MAP_ENTRY_POINT) {
						//Change mapGridSelection value
						mapModel.mapGridSelection[_i][_j] = ApplicationStatics.MAP_Scenery_POINT;
						btn.setBackground(Color.gray);
						btn.setText("");
						jButtonEntry=null;
						mapModel.isEntryDone = false;
						mapModel.setEntryPoint(null);
					}
					//if Previously it is  Exit Button
					else if (mapModel.mapGridSelection[_i][_j] == ApplicationStatics.MAP_EXIT_POINT) {
						mapModel.mapGridSelection[_i][_j] = ApplicationStatics.MAP_Scenery_POINT;
						btn.setBackground(Color.gray);
						btn.setText("");
						jButtonExit=null;
						mapModel.isExitDone = false;
						mapModel.setExitPoint(null);
					}
					//if Previously it is Path and Scenery button
					else if (mapModel.mapGridSelection[_i][_j] == ApplicationStatics.MAP_Scenery_POINT
							|| mapModel.mapGridSelection[_i][_j] == ApplicationStatics.MAP_PATH_POINT) {
						//Check Entry is already Selected
						if (!mapModel.isEntryDone) {
							btn.setBackground(Color.RED);
							btn.setText("E");
							jButtonEntry=btn;
							mapModel.mapGridSelection[_i][_j] = ApplicationStatics.MAP_ENTRY_POINT;
							mapModel.setEntryPoint(new Point(_i, _j));
							mapModel.isEntryDone = true;
						} else if (!mapModel.isExitDone) {
							btn.setBackground(Color.RED);
							btn.setText("O");
							jButtonExit=btn;
							mapModel.mapGridSelection[_i][_j] = ApplicationStatics.MAP_EXIT_POINT;
							mapModel.setExitPoint(new Point(_i, _j));
							mapModel.isExitDone = true;
						} else {
							JOptionPane.showMessageDialog(null,
									"Both Enrty and Exit Point Already Selected");
						}
					}
					System.out.println(" Mouse Right Clicked Event Btn Name : " + btn.getName());
				}
			}
		});
	}
	
	/**
	 * This method gets the map buttons
	 * 
	 * @return map buttons
	 */
	/*
	 * public JButton[][] getButtons() { //return mapButtons; }
	 */
	/**
	 * This method sets the reference to bottom game panel
	 * 
	 * @param new_panel
	 *            the reference to object of BottomGamePanelView
	 */
	public void setBottomGamePanelView(BottomGamePanelView new_panel) {
		bottomGamePanel = new_panel;
	}

	/**
	 * @param jButtonTower the jButtonTower to set
	 */
	public void setjButtonTower(JButton jButtonTower) {
		this.jButtonTower = jButtonTower;
	}

	/**
	 * @return the bottomGamePanel
	 */
	public BottomGamePanelView getBottomGamePanel() {
		return bottomGamePanel;
	}

	/**
	 * @return the mapButtonGrid2DArray
	 */
	public JButton[][] getMapButtonGrid2DArray() {
		return mapButtonsGrid2DArray;
	}

	/**
	 * @return the jButtonEntry
	 */
	public JButton getjButtonEntry() {
		return jButtonEntry;
	}

	/**
	 * @return the jButtonExit
	 */
	public JButton getjButtonExit() {
		return jButtonExit;
	}

	/**
	 * @return the jButtonTower
	 */
	public JButton getjButtonTower() {
		return jButtonTower;
	}

	/**
	 * @return the mapEditorMode
	 */
	public E_MapEditorMode getMapEditorMode() {
		return mapEditorMode;
	}
	
	
}
