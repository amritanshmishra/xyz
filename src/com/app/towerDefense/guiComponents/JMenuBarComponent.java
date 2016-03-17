package com.app.towerDefense.guiComponents;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.app.towerDefense.gameLogic.Map;
import com.app.towerDefense.guisystem.MapEditor;
import com.app.towerDefense.models.MapModel;
import com.app.towerDefense.staticContent.AppilicationEnums.E_JFileChooserMode;
import com.app.towerDefense.staticContent.AppilicationEnums.E_MapEditorMode;
import com.app.towerDefense.staticContent.ApplicationStatics;
import com.app.towerDefense.utilities.FileStorage;

/**
 * This class handles all menu bar component of the application
 * 
 * @author Sajjad Ashraf
 * 
 */
public class JMenuBarComponent {
	private JPanel gameMapPanel;

	private BottomGamePanelView bottomGamePanel;
	private JPanelComponent panelComponent;

	/**
	 * this Function Implement the Menu bar for Gmae Main Window
	 * 
	 * @param new_jframe
	 *            as JFrame
	 * @return JMenuBar
	 */
	public JMenuBar getGameJMenuBar(final JFrame new_jframe) {

		// Set Background Image
		final JLabel backGround = new JLabel(new ImageIcon(((new ImageIcon(
				"images/gameBk.png").getImage().getScaledInstance(
				new_jframe.getSize().width,
				(int) ((int) new_jframe.getSize().height - 30),
				java.awt.Image.SCALE_SMOOTH)))));
		new_jframe.add(backGround);

		JMenuBar menuBar = new JMenuBar();

		JMenu menuFile = new JMenu(ApplicationStatics.MENU_FILE);
		menuBar.add(menuFile);

		final JMenuItem menuItemPlay = new JMenuItem(
				ApplicationStatics.MENU_ITEM_PLAY);
		menuFile.add(menuItemPlay);
		final JMenuItem menuItemCreateMap = new JMenuItem(
				ApplicationStatics.MENU_ITEM_CREATE_MAP);
		menuFile.add(menuItemCreateMap);
		final JMenuItem menuItemOpenMap = new JMenuItem(
				ApplicationStatics.MENU_ITEM_OPEN_MAP);
		menuFile.add(menuItemOpenMap);
		final JMenuItem menuItemExit = new JMenuItem(
				ApplicationStatics.MENU_ITEM_EXIT);
		menuFile.add(menuItemExit);

		JMenu menuHelp = new JMenu(ApplicationStatics.MENU_HELP);
		menuBar.add(menuHelp);
		final JMenuItem menuItemAbout = new JMenuItem(
				ApplicationStatics.MENU_ITEM_ABOUT);
		menuHelp.add(menuItemAbout);

		/**
		 * This class handle the menu Item action on click action
		 * 
		 * @author Sajjad
		 * 
		 */
		class menuItemAction implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent new_e) {
				if (new_e.getSource().equals(menuItemPlay)) {
					ApplicationStatics.START_WAVE = false;
					JFileChooser fileChooser = new JFileChooserComponent()
							.getJFileChooser(E_JFileChooserMode.Open);
					int result = fileChooser.showOpenDialog(new_jframe);
					if (result == JFileChooser.APPROVE_OPTION) {
						File file = fileChooser.getSelectedFile();
						MapModel mapModel = (new com.app.towerDefense.utilities.FileStorage())
								.openMapFile(file);
						if (mapModel != null) {
							if (mapModel.mapSecret.contains("_Team5")) {
								new_jframe.getContentPane().removeAll();
								new_jframe.setLayout(new BorderLayout());
								panelComponent = new JPanelComponent();
								/*
								 * gameMapPanel =
								 * (panelComponent).getMapPlayGridPanel(
								 * mapModel, new_jframe.getSize(),
								 * E_MapEditorMode.Open);
								 */
								gameMapPanel = (panelComponent)
										.getMapEditorGridPanel(mapModel,
												new_jframe.getSize(),
												E_MapEditorMode.Play);

								ApplicationStatics.GAME_OVER = false;

								// jframe.add(gameMapPanel);
								new_jframe.getContentPane().add(gameMapPanel,
										BorderLayout.NORTH);
								bottomGamePanel = (BottomGamePanelView) new JPanelComponent()
										.getGameTowerPanel(new_jframe.getSize());
								// bottomGamePanel.setMapButtons(panelComponent.getButtons());
								new_jframe.getContentPane().add(
										bottomGamePanel, BorderLayout.SOUTH);
								new_jframe.setVisible(true);
								panelComponent
										.setBottomGamePanelView(bottomGamePanel);
								ApplicationStatics.PLAYERMODEL
										.addObserver(panelComponent);
							} else {
								JOptionPane.showMessageDialog(null,
										"In valid Map File.");
							}

						} else
							JOptionPane.showMessageDialog(null,
									"Unable to .tdm open File");
					} else {
						JOptionPane.showMessageDialog(null, "No File Selected");
					}
				} else if (new_e.getSource().equals(menuItemCreateMap)) {

					final JTextField txtX = new JTextField();
					final JTextField txtY = new JTextField();

					txtX.addKeyListener(new KeyAdapter() {
						public void keyTyped(KeyEvent e) {
							char ch = e.getKeyChar();
							if (!(Character.isDigit(ch)
									|| (ch == KeyEvent.VK_BACK_SPACE) || (ch == KeyEvent.VK_DELETE))) {
								e.consume();
							}
							if (txtX.getText().length() > 2)
								e.consume();
						}
					});

					txtY.addKeyListener(new KeyAdapter() {
						public void keyTyped(KeyEvent e) {
							char ch = e.getKeyChar();
							if (!(Character.isDigit(ch)
									|| (ch == KeyEvent.VK_BACK_SPACE) || (ch == KeyEvent.VK_DELETE))) {
								e.consume();
							}
							if (txtY.getText().length() > 2)
								e.consume();
						}
					});

					Object[] message = { "Size of X:", txtX, "Size of Y:", txtY };

					int option = JOptionPane.showConfirmDialog(null, message,
							"SET SIZE OF MAP", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						String x = txtX.getText().trim();
						String y = txtY.getText().trim();

						if (x.length() == 0)
							JOptionPane.showMessageDialog(null,
									"Size of X May not Be Empty");

						else if (y.length() == 0)
							JOptionPane.showMessageDialog(null,
									"Size of Y May not Be Empty");

						else if (Integer.parseInt(x) < 1
								|| Integer.parseInt(x) > 30)
							JOptionPane.showMessageDialog(null,
									"Size of X must Lie between 1 - 30");

						else if (Integer.parseInt(y) < 1
								|| Integer.parseInt(y) > 30)
							JOptionPane.showMessageDialog(null,
									"Size of Y must Lie between 1 - 30");

						else {
							MapModel mapModel = new MapModel();

							mapModel.setMapWidth(Integer.parseInt(x));
							mapModel.setMapHeight(Integer.parseInt(y));
							new MapEditor(
									new_jframe,
									ApplicationStatics.TITLE_MAP_EDITOR,
									ApplicationStatics.CHILD_POPUP_WINDOW_WIDTH,
									ApplicationStatics.CHILD_POPUP_WINDOW_HEIGHT,
									mapModel, E_MapEditorMode.Create);
						}
					} else {
						System.out.println("Login canceled");
					}

				} else if (new_e.getSource().equals(menuItemOpenMap)) {
					JFileChooser fileChooser = new JFileChooserComponent()
							.getJFileChooser(E_JFileChooserMode.Open);
					int result = fileChooser.showOpenDialog(new_jframe);
					if (result == JFileChooser.APPROVE_OPTION) {
						File file = fileChooser.getSelectedFile();
						MapModel mapModel = (new com.app.towerDefense.utilities.FileStorage())
								.openMapFile(file);
						if (mapModel != null) {
							if (mapModel.mapSecret.contains("_Team5")) {
								new MapEditor(
										new_jframe,
										ApplicationStatics.TITLE_MAP_EDITOR,
										ApplicationStatics.CHILD_POPUP_WINDOW_WIDTH,
										ApplicationStatics.CHILD_POPUP_WINDOW_HEIGHT,
										mapModel, E_MapEditorMode.Open);
							} else {
								JOptionPane.showMessageDialog(null,
										"In valid Map File.");
							}

						} else
							JOptionPane.showMessageDialog(null,
									"Unable to .tdm open File");
					} else {
						JOptionPane.showMessageDialog(null, "No File Selected");
					}
				} else if (new_e.getSource().equals(menuItemExit)) {
					System.exit(0);
				} else if (new_e.getSource().equals(menuItemAbout)) {
					JOptionPane
							.showMessageDialog(
									null,
									"**** Tower Defense Game **** \r\n Version 1.0 Build 1 \r\n Developed By Team5 \r\n All rights reserved  � Fall 2016");
				}
			}

		}
		menuItemPlay.addActionListener(new menuItemAction());
		menuItemCreateMap.addActionListener(new menuItemAction());
		menuItemOpenMap.addActionListener(new menuItemAction());
		menuItemExit.addActionListener(new menuItemAction());
		menuItemAbout.addActionListener(new menuItemAction());
		return menuBar;
	}

	/**
	 * This method gets the Map editor menu bar
	 * 
	 * @param new_mapModel
	 *            type MapModel object is passed to the getMapEditorJmenuBar
	 * @param new_jframe
	 *            type JFrame the frame of the application
	 * @return the menu bar type JMenuBar
	 */
	public JMenuBar getMapEditorJMenuBar(final MapModel new_mapModel,
			final JFrame new_jframe) {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu(ApplicationStatics.MENU_FILE);
		final JMenuItem menuItemSave = new JMenuItem(
				ApplicationStatics.MENU_ITEM_SAVE);
		menuFile.add(menuItemSave);
		final JMenuItem menuItemExit = new JMenuItem(
				ApplicationStatics.MENU_ITEM_EXIT);
		menuFile.add(menuItemExit);

		class menuItemAction implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent new_event) {
				if (new_event.getSource().equals(menuItemSave)) {
					String MapValidationStatus = (new Map())
							.mapValidations(new_mapModel);

					if (MapValidationStatus != null)
						JOptionPane
								.showMessageDialog(null, MapValidationStatus);
					else {
						JFileChooser fileChooser = new JFileChooserComponent()
								.getJFileChooser(E_JFileChooserMode.Save);
						int result = fileChooser.showSaveDialog(null);
						if (result == JFileChooser.APPROVE_OPTION) {
							File file = fileChooser.getSelectedFile();
							new_mapModel.setMapSecret();

							new_mapModel
									.setMapRoutPath(ApplicationStatics.MAP_ROUT_PATH);
							new_mapModel
									.setMapRoutBoundaries(ApplicationStatics.MAP_PATH_BOUNDARY_BUTTONS_NAME);
							new_mapModel.getMapRoutPathList();

							String msg = new FileStorage().saveMapFile(file,
									new_mapModel);
							if (msg.contains("SUCCESS")) {
								JOptionPane.showMessageDialog(null,
										"File Save Successfuly.");
								closeFrame(new_jframe);
							} else
								JOptionPane.showMessageDialog(null, msg);
						}
					}
				}

				else if (new_event.getSource().equals(menuItemExit)) {
					closeFrame(new_jframe);
				}

			}

		}
		menuItemSave.addActionListener(new menuItemAction());
		menuItemExit.addActionListener(new menuItemAction());
		menuBar.add(menuFile);
		return menuBar;
	}

	/**
	 * This method closes the frame of the application
	 * 
	 * @param new_jframe
	 *            the frame of the application
	 */
	public void closeFrame(JFrame new_jframe) {
		new_jframe.dispose();
	}

	/**
	 * This method returns the bottom panel
	 * 
	 * @return bottom game panel object
	 */
	public BottomGamePanelView getBottomPanel() {
		return bottomGamePanel;
	}

	/**
	 * This method returns the top map panel
	 * 
	 * @return game map panel object
	 */
	public JPanelComponent getPanelComponent() {
		return panelComponent;
	}

}
