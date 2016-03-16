package com.app.towerDefense.guiComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.app.towerDefense.models.MapModel;
import com.app.towerDefense.models.Tower;
import com.app.towerDefense.models.TowerFactory;
import com.app.towerDefense.staticContent.AppilicationEnums.E_MapEditorMode;
import com.app.towerDefense.staticContent.ApplicationStatics;
import com.app.towerDefense.utilities.MiscellaneousHelper;

/**
 * This class has All JPanel Implementation like GamePlayMap JPanel, MapEdiort
 * JPanel.
 * 
 * @author Sajjad Ashraf
 * 
 */
public class JPanelComponent implements Observer{

	private BottomGamePanelView bottomGamePanel;

	private JButton mapButtonsGrid2DArray[][];
	private JButton jButtonEntry;
	private JButton jButtonExit;
	public JButton jButtonTower;
	public MapPanel mapPanel; //CHANGE Ulan

	private E_MapEditorMode mapEditorMode;

	/**
	 * get Implemented Panel for Game Window screen Tower Section
	 * 
	 * @param parentDimension
	 *            type Dimension dimension of parent Screen so that this panel
	 *            Fit or reshape accordingly
	 * @return JPanel
	 */
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

	/**
	 * get Implemented Panel for Game Window screen Map Section in Playing mode
	 * 
	 * @param type
	 *            Integer width of parent
	 * @param type
	 *            Integer height of parent
	 * @return JPanel
	 */
	public JPanel getGameMapPanel(int width, int height) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));
		panel.setMaximumSize(new Dimension(width, height));
		panel.setMinimumSize(new Dimension(width, height));
		panel.setBackground(Color.GREEN);
		return panel;
	}

	/**
	 * get Implemented Panel for Game Window screen Actual Map Grid this one
	 * Function is used for three different purposes 1) Map Grid when Mode is
	 * Play 2) Map Grid Editor when Mode is Create 3) Map Grid Editor when Mode
	 * is OPen
	 * 
	 * @param mapModel
	 *            Type MapModel
	 * @param parentDimension
	 *            Type Dimension
	 * @param mode
	 *            Type E_MapEditorMode Enum variable with three possible values
	 *            {Create, Open, Play}
	 * @return JPanel
	 */
	public JPanel getMapEditorGridPanel(final MapModel mapModel,
			Dimension parentDimension, E_MapEditorMode mode) {
		mapEditorMode = mode;
		JPanel panel;
		GridLayout gridLayout;

		// When Create Mode Initialize the mapGridSelection to new
		if (E_MapEditorMode.Create == mapEditorMode) {
			mapModel.mapGridSelection = new int[mapModel.getMapHeight()][mapModel
					.getMapWidth()];
		}

		// In case 'Play' Increase Panel size According to the Play Game Window
		if (E_MapEditorMode.Play == mapEditorMode) {

			panel = new MapPanel();
			gridLayout = new GridLayout(mapModel.getMapHeight(),
					mapModel.getMapWidth(), 0, 0);
			panel.setLayout(gridLayout);

			mapPanel = (MapPanel)panel; //CHANGE Ulan
			
			if (parentDimension != null) {
				panel.setPreferredSize(new Dimension(parentDimension.width,
						parentDimension.height * 3 / 4 - 10));
				panel.setMaximumSize(new Dimension(parentDimension.width,
						parentDimension.height * 3 / 4 - 10));
				panel.setMinimumSize(new Dimension(parentDimension.width,
						parentDimension.height * 3 / 4 - 10));
			}
		} else {
			panel = new JPanel();
			gridLayout = new GridLayout(mapModel.getMapHeight(),
					mapModel.getMapWidth(), 3, 3);
			panel.setLayout(gridLayout);
		}

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
					// Click event
					addButtonClickEvents(mapButtonsGrid2DArray[i][j], mapModel);
					// Right Click Event
					addMouseClickOnButtonEvents(mapButtonsGrid2DArray[i][j],
							mapModel);
				}

				else if (E_MapEditorMode.Open == mapEditorMode) {

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

					// Click event
					addButtonClickEvents(mapButtonsGrid2DArray[i][j], mapModel);
					// Right Click Event
					addMouseClickOnButtonEvents(mapButtonsGrid2DArray[i][j],
							mapModel);
				}

				else if (E_MapEditorMode.Play == mapEditorMode) {
					mapButtonsGrid2DArray[i][j].setBorder(new LineBorder(
							Color.green, 0));
					mapButtonsGrid2DArray[i][j].setPreferredSize(new Dimension(
							10, 10));

					// Condition for Path cell
					if (mapModel.mapGridSelection[i][j] == ApplicationStatics.MAP_PATH_POINT) {
						// b[i][j].setBackground(Color.green);

				/*		mapButtonsGrid2DArray[i][j]
								.setIcon(new ImageIcon(
										((new ImageIcon(
												ApplicationStatics.IMAGE_PATH_MAP_ROUTE)
												.getImage().getScaledInstance(
												(int) parentDimension
														.getWidth()
														/ mapModel
																.getMapWidth(),
												(int) parentDimension
														.getHeight()
														/ mapModel
																.getMapHeight(),
												java.awt.Image.SCALE_SMOOTH)))));
		*/
						mapButtonsGrid2DArray[i][j].setVisible(false);
						ApplicationStatics.PATH_ARRAY.add(i);
						ApplicationStatics.PATH_ARRAY.add(j);
						
						// Click event
						addButtonClickEvents(mapButtonsGrid2DArray[i][j],
								mapModel);
						// Right Click Event
						// addMouseClickOnButtonEvents(b[i][j], i, j, mapModel);

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
					// Condition for Entry Cell
					else if (mapModel.mapGridSelection[i][j] == ApplicationStatics.MAP_ENTRY_POINT) {
						mapButtonsGrid2DArray[i][j].setBackground(Color.red);
						mapButtonsGrid2DArray[i][j].setText("E");
						// b[i][j].setIcon(new ImageIcon (
						// ApplicationStatics.IMAGE_PATH_MAP_ENTRY));
						mapButtonsGrid2DArray[i][j].setEnabled(false);
					}
					// Condition for Exit Cell
					else if (mapModel.mapGridSelection[i][j] == ApplicationStatics.MAP_EXIT_POINT) {
						mapButtonsGrid2DArray[i][j].setBackground(Color.red);
						mapButtonsGrid2DArray[i][j].setText("O");
						mapButtonsGrid2DArray[i][j].setEnabled(false);
						// b[i][j].setIcon( new ImageIcon (
						// ApplicationStatics.IMAGE_PATH_MAP_EXIT));
					}
					// Condition for Scenery Cell
					else {
						mapButtonsGrid2DArray[i][j]
								.setIcon(new ImageIcon(
										((new ImageIcon(
												ApplicationStatics.IMAGE_PATH_MAP_Scenery)
												.getImage().getScaledInstance(
												(int) parentDimension
														.getWidth()
														/ mapModel
																.getMapWidth(),
												(int) parentDimension
														.getHeight()
														/ mapModel
																.getMapHeight(),
												java.awt.Image.SCALE_SMOOTH)))));

						// Click event
						addButtonClickEvents(mapButtonsGrid2DArray[i][j],
								mapModel);
						// Right Click Event
						// addMouseClickOnButtonEvents(b[i][j], i, j, mapModel);

					}

				}

				panel.add(mapButtonsGrid2DArray[i][j]);
			}
		}
		// this.setContentPane(panel);

		if (E_MapEditorMode.Play == mapEditorMode) {
			if (ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME.length() > 1) {
				ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME = (new MiscellaneousHelper())
						.RemoveCharacterFromEndorRight(
								ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME,
								",");
			}
			System.out.println("MAP Boundary Points : "
					+ ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME);
			ApplicationStatics.MAP_BUTTONS = mapButtonsGrid2DArray;
		}
		
		
		return panel;
	}

	/**
	 * Actually Map Grid contains buttons inside each cell of grid and on click
	 * of these button we perform certain actions this method implements logic
	 * behind the on click of button
	 * 
	 * @param button
	 *            Type JButton
	 * @param mapModel
	 *            Type MapModel
	 */
	private void addButtonClickEvents(JButton button, final MapModel mapModel) {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = ((JButton) e.getSource());
				String[] nameArry = btn.getName().split(":");
				int _i = Integer.parseInt(nameArry[1]);
				int _j = Integer.parseInt(nameArry[2]);

				// If Previously an Scenery Point
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

				System.out.println("Button Click Event Btn Name : "
						+ btn.getName());

				//-- ulan's code here
				String[] tempStr = btn.getName().split(":");
				int new_x = Integer.parseInt(tempStr[1]);
				int new_y = Integer.parseInt(tempStr[2]);

				Tower tempTM = TowerFactory.getTower("Shooter");
				
				System.out.println("x : "+new_x + " , y : "+ new_y);

				ApplicationStatics.SET_TOWER_DESCR_VISIBLE = false;
				
				if(bottomGamePanel != null && bottomGamePanel.towerDescrPanel!= null){
					bottomGamePanel.towerDescrPanel.updateTowerDscrPanel(tempTM);
				}
				ApplicationStatics.CURRENT_SELECTED_TOWER = 4;
				

				if (ApplicationStatics.HAS_BOUGHT_TOWER) {
					System.out.println("The Button " + btn.getName() + " is clicked");
					if (!ApplicationStatics.PLAYERMODEL.towerModelArray.isEmpty()) {

						// -- sets the tower coordinates
						int arrSize = ApplicationStatics.PLAYERMODEL.towerModelArray.size();
						ApplicationStatics.PLAYERMODEL.towerModelArray.get(arrSize - 1).setXY(new_x, new_y);
						ApplicationStatics.HAS_BOUGHT_TOWER = false;
						setMapButtonsToYellow();
					} else {
						System.out.println("Dont have towers");
					}
				} else {
					if (!ApplicationStatics.PLAYERMODEL.towerModelArray.isEmpty()) {

						for (int i = 0; i < ApplicationStatics.PLAYERMODEL.towerModelArray.size(); i++) {
							tempTM = ApplicationStatics.PLAYERMODEL.towerModelArray.get(i);

							if (new_x == tempTM.getX() && new_y == tempTM.getY()) {
								System.out.println("HERE x=" + tempTM.getTowerName());
								ApplicationStatics.SET_TOWER_DESCR_VISIBLE = true;
								bottomGamePanel.towerDescrPanel.updateTowerDscrPanel(tempTM);
							}
						}
					}
				}
				
				
			}
		});
	}

	/**
	 * Actually Map Grid contains buttons inside each cell of grid and on right
	 * click on these button we perform certain actions this method implements
	 * logic behind the on right click of button
	 * 
	 * @param button
	 *            Type JButton
	 * @param mapModel
	 *            Type MapModel
	 */
	private void addMouseClickOnButtonEvents(JButton button,
			final MapModel mapModel) {
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// boolean mine = field.isMine(x, y);
				// When Right button Clicked of Mouse
				if (e.getButton() == MouseEvent.BUTTON1) {
				}
				// When Middle button Clicked of Mouse
				else if (e.getButton() == MouseEvent.BUTTON2) {
				}
				// When Left button Clicked of Mouse
				else if (e.getButton() == MouseEvent.BUTTON3) {
					JButton btn = ((JButton) e.getSource());
					String[] nameArry = btn.getName().split(":");
					int _i = Integer.parseInt(nameArry[1]);
					int _j = Integer.parseInt(nameArry[2]);

					// if Previously it is Entry Button
					if (mapModel.mapGridSelection[_i][_j] == ApplicationStatics.MAP_ENTRY_POINT) {
						// Change mapGridSelection value
						mapModel.mapGridSelection[_i][_j] = ApplicationStatics.MAP_Scenery_POINT;
						btn.setBackground(Color.gray);
						btn.setText("");
						jButtonEntry = null;
						mapModel.isEntryDone = false;
						mapModel.setEntryPoint(null);
					}
					// if Previously it is Exit Button
					else if (mapModel.mapGridSelection[_i][_j] == ApplicationStatics.MAP_EXIT_POINT) {
						mapModel.mapGridSelection[_i][_j] = ApplicationStatics.MAP_Scenery_POINT;
						btn.setBackground(Color.gray);
						btn.setText("");
						jButtonExit = null;
						mapModel.isExitDone = false;
						mapModel.setExitPoint(null);
					}
					// if Previously it is Path and Scenery button
					else if (mapModel.mapGridSelection[_i][_j] == ApplicationStatics.MAP_Scenery_POINT
							|| mapModel.mapGridSelection[_i][_j] == ApplicationStatics.MAP_PATH_POINT) {
						// Check Entry is already Selected
						if (!mapModel.isEntryDone) {
							btn.setBackground(Color.RED);
							btn.setText("E");
							jButtonEntry = btn;
							mapModel.mapGridSelection[_i][_j] = ApplicationStatics.MAP_ENTRY_POINT;
							mapModel.setEntryPoint(new Point(_i, _j));
							mapModel.isEntryDone = true;
						} else if (!mapModel.isExitDone) {
							btn.setBackground(Color.RED);
							btn.setText("O");
							jButtonExit = btn;
							mapModel.mapGridSelection[_i][_j] = ApplicationStatics.MAP_EXIT_POINT;
							mapModel.setExitPoint(new Point(_i, _j));
							mapModel.isExitDone = true;
						} else {
							JOptionPane
									.showMessageDialog(null,
											"Both Enrty and Exit Point Already Selected");
						}
					}
					System.out.println(" Mouse Right Clicked Event Btn Name : "
							+ btn.getName());
				}
			}
		});
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

	/**
	 * @param jButtonTower
	 *            the jButtonTower to set
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

	/**
	 * update method from observable PlayerModel class
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		setMapButtonsToYellow();
	}
	
	/**
	 * This method sets the Buttons to Yellow on the map that are eligible for
	 * tower placement
	 * 
	 * @param new_mapButtons
	 *            the reference to our map buttons
	 */
	public void setMapButtonsToYellow() {

		String stringMapCoord = "";
		System.out.println("inside setMapButtonsToYellow "+ ApplicationStatics.HAS_BOUGHT_TOWER);

		for (int i = 0; i < ApplicationStatics.MAP_BUTTONS.length; i++) {

			for (int j = 0; j < ApplicationStatics.MAP_BUTTONS[i].length; j++) {
				stringMapCoord = "" + (i) + ":" + j;
				if (ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME.contains(stringMapCoord)) {

					ApplicationStatics.MAP_BUTTONS[i][j].setEnabled(true);
					if (ApplicationStatics.HAS_BOUGHT_TOWER) {
						ApplicationStatics.MAP_BUTTONS[i][j].setIcon(new ImageIcon(ApplicationStatics.IMAGE_PATH_MAP_ButtonYellow));
						setTowersOnMap(i, j);
					} else {
						// -- sets all button icons to green scenery and later
						int x = ApplicationStatics.MAP_BUTTONS[i][j].getWidth();
						int y = ApplicationStatics.MAP_BUTTONS[i][j].getHeight();
						ApplicationStatics.MAP_BUTTONS[i][j]
								.setIcon(new ImageIcon(new ImageIcon(ApplicationStatics.IMAGE_PATH_MAP_Scenery)
										.getImage().getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH)));

						setTowersOnMap(i, j);
					}
				} else { // -- disable buttons boundaries
					ApplicationStatics.MAP_BUTTONS[i][j].setEnabled(!ApplicationStatics.HAS_BOUGHT_TOWER);
		//			ApplicationStatics.MAP_BUTTONS[i][j].setDisabledIcon(new ImageIcon());
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
	public void setTowersOnMap(int new_i, int new_j) {
		for (int k = 0; k < ApplicationStatics.PLAYERMODEL.towerModelArray.size(); k++) {
			int x = ApplicationStatics.PLAYERMODEL.towerModelArray.get(k).getX();
			int y = ApplicationStatics.PLAYERMODEL.towerModelArray.get(k).getY();
			if (new_i == x && new_j == y) {
				if (ApplicationStatics.HAS_BOUGHT_TOWER) {
					ApplicationStatics.MAP_BUTTONS[new_i][new_j].setEnabled(false);
				} else {
					ApplicationStatics.MAP_BUTTONS[new_i][new_j].setEnabled(true);
				}
				ApplicationStatics.MAP_BUTTONS[new_i][new_j].setIcon(ApplicationStatics.PLAYERMODEL.towerModelArray.get(k).getTowerImage());
			}
		}
		
		
		
	}

}
