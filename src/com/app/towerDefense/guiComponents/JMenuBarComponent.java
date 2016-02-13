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
import javax.swing.filechooser.FileNameExtensionFilter;

import com.app.towerDefense.bL.Map;
import com.app.towerDefense.guisystem.MapEditor;
import com.app.towerDefense.models.MapModel;
import com.app.towerDefense.staticContent.AppilicationEnums.E_JFileChooserrMode;
import com.app.towerDefense.staticContent.AppilicationEnums.E_MapEditorMode;
import com.app.towerDefense.staticContent.ApplicationStatics;
import com.app.towerDefense.utilities.FileStorage;



public class JMenuBarComponent {
	 JPanel   gameMapPanel;
	 JPanel   gameTowerPanel;
	//public JMenuBar getGameJMenuBar(final JFrame jframe,  final JPanel   _gameMapPanel, final JPanel   _gameTowerPanel)
	public JMenuBar getGameJMenuBar(final JFrame jframe)
	{
		
		//final JLabel backGround=new JLabel(new ImageIcon("images/gameBk.jpg"));
	final JLabel backGround=new JLabel(new ImageIcon(((new ImageIcon(
			"images/gameBk.png").getImage()
	            .getScaledInstance(840, 840/12*10,
	                    java.awt.Image.SCALE_SMOOTH)))));
		jframe.add(backGround);
		//gameMapPanel=_gameMapPanel;
		//gameTowerPanel=_gameTowerPanel;
		
		
		JMenuBar menuBar = new  JMenuBar();
		
		JMenu menuFile = new JMenu(ApplicationStatics.MENU_FILE);
		menuBar.add(menuFile);
		
		final JMenuItem menuItemPlay = new JMenuItem(ApplicationStatics.MENU_ITEM_PLAY);
		menuFile.add(menuItemPlay);		
		final JMenuItem menuItemCreateMap = new JMenuItem(ApplicationStatics.MENU_ITEM_CREATE_MAP);
		menuFile.add(menuItemCreateMap);		
		final JMenuItem menuItemOpenMap = new JMenuItem(ApplicationStatics.MENU_ITEM_OPEN_MAP);
		menuFile.add(menuItemOpenMap);		
		final JMenuItem menuItemExit = new JMenuItem(ApplicationStatics.MENU_ITEM_EXIT);
		menuFile.add(menuItemExit);
				
		JMenu menuHelp = new JMenu(ApplicationStatics.MENU_HELP);
		menuBar.add(menuHelp);
		final JMenuItem menuItemAbout = new JMenuItem(ApplicationStatics.MENU_ITEM_ABOUT);
		menuHelp.add(menuItemAbout);
		
				
		class menuItemAction implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(menuItemPlay))
				{
					JFileChooser fileChooser = new JFileChooserComponent().getJFileChooser(E_JFileChooserrMode.Open);
					int result = fileChooser.showOpenDialog(jframe);
					if (result == JFileChooser.APPROVE_OPTION) {
					    File file = fileChooser.getSelectedFile();
					    MapModel mapModel 	= (new com.app.towerDefense.utilities.FileStorage()).openMapFile(file);
					    if(mapModel != null)
						  {
					    	if(mapModel.mapSecret.contains("_Team5"))
					    	{
					    		jframe.getContentPane().removeAll();
					    		jframe.setLayout(new BorderLayout());
					    		gameMapPanel= (new JPanelComponent()).getMapPlayGridPanel(mapModel, jframe.getSize(), E_MapEditorMode.Open);
					    		//jframe.add(gameMapPanel);
					    		jframe.getContentPane().add(gameMapPanel, BorderLayout.NORTH);
					    		jframe.getContentPane().add(new JPanelComponent().getGameTowerPanel(jframe.getSize()), BorderLayout.SOUTH);
					    		jframe.setVisible(true);
					    	}
					    	else
					    	{
					    		JOptionPane.showMessageDialog(null, "In valid Map File.");
					    	}
					    	
							  
						  }
						  else
							  JOptionPane.showMessageDialog(null, "Unable to .tdm open File");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No File Selected");
					}
				}
				else if(e.getSource().equals(menuItemCreateMap))
				{
										
					final JTextField txtX = new JTextField();
					final JTextField txtY = new JTextField();
					
					txtX.addKeyListener(new KeyAdapter() {
			            public void keyTyped(KeyEvent e) {
			                char ch = e.getKeyChar();
			                if (!(Character.isDigit(ch)
		                            || (ch == KeyEvent.VK_BACK_SPACE)
		                            || (ch == KeyEvent.VK_DELETE))) {
		                        e.consume();
		                    }
			                if(txtX.getText().length() > 2)
			                	e.consume();
			            }
			        });
					
					txtY.addKeyListener(new KeyAdapter() {
			            public void keyTyped(KeyEvent e) {
			                char ch = e.getKeyChar();
			                if (!(Character.isDigit(ch)
		                            || (ch == KeyEvent.VK_BACK_SPACE)
		                            || (ch == KeyEvent.VK_DELETE))) {
		                        e.consume();
		                    }
			                if(txtY.getText().length() > 2)
			                	e.consume();
			            }
			        });
									
					Object[] message = {
					    "Size of X:", txtX,
					    "Size of Y:", txtY
					};

					int option = JOptionPane.showConfirmDialog(null, message, "SET SIZE OF MAP", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						String x =txtX.getText().trim();
						String y =txtY.getText().trim();
						
						if(x.length() == 0 )
							JOptionPane.showMessageDialog(null, "Size of X May not Be Empty");
						
						else if(y.length() == 0 )
						JOptionPane.showMessageDialog(null, "Size of Y May not Be Empty");
						
						else if(Integer.parseInt(x) < 1 ||  Integer.parseInt(x) > 30)
							JOptionPane.showMessageDialog(null, "Size of X must Lie between 1 - 30");
						
						else if(Integer.parseInt(y) < 1 ||  Integer.parseInt(y) > 30)
							JOptionPane.showMessageDialog(null, "Size of Y must Lie between 1 - 30");
						
						else
						{
							MapModel mapModel = new MapModel();
					
							mapModel.setMapWidth(Integer.parseInt(x));
							mapModel.setMapHeight(Integer.parseInt(y));
							new MapEditor(jframe, 
									ApplicationStatics.TITLE_MAP_EDITOR,
									ApplicationStatics.CHILD_POPUP_WINDOW_WIDTH, 
									ApplicationStatics.CHILD_POPUP_WINDOW_HEIGHT , 
									mapModel,
									E_MapEditorMode.Create);
						}
					} 
					else {
					    System.out.println("Login canceled");
					}
					
					
				}
				else if(e.getSource().equals(menuItemOpenMap))
				{
					JFileChooser fileChooser = new JFileChooserComponent().getJFileChooser(E_JFileChooserrMode.Open);
					int result = fileChooser.showOpenDialog(jframe);
					if (result == JFileChooser.APPROVE_OPTION) {
					    File file = fileChooser.getSelectedFile();
					    MapModel mapModel 	= (new com.app.towerDefense.utilities.FileStorage()).openMapFile(file);
					    if(mapModel != null)
						  {
					    	if(mapModel.mapSecret.contains("_Team5"))
					    	{
					    		new MapEditor(jframe, 
										ApplicationStatics.TITLE_MAP_EDITOR,
										ApplicationStatics.CHILD_POPUP_WINDOW_WIDTH, 
										ApplicationStatics.CHILD_POPUP_WINDOW_HEIGHT , 
										mapModel,
										E_MapEditorMode.Open);
					    	}
					    	else
					    	{
					    		JOptionPane.showMessageDialog(null, "In valid Map File.");
					    	}
					    	
							  
						  }
						  else
							  JOptionPane.showMessageDialog(null, "Unable to .tdm open File");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No File Selected");
					}								
				}
				else if(e.getSource().equals(menuItemExit))
				{
					System.exit(0);
				}
				else if(e.getSource().equals(menuItemAbout))
				{
					JOptionPane.showMessageDialog(null, "**** Tower Defense Game **** \r\n Version 1.0 Build 1 \r\n Developed By Team5 \r\n All rights reserved  � Fall 2016");
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
	
	public JMenuBar getMapEditorJMenuBar(final MapModel mapModel, final JFrame jframe)
	{
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
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(menuItemSave)) {
					String MapValidationStatus=(new Map()).mapValidations(mapModel);
					
					if (MapValidationStatus!=null)
						JOptionPane.showMessageDialog(null,MapValidationStatus);
					else {
						JFileChooser fileChooser = new JFileChooserComponent().getJFileChooser(E_JFileChooserrMode.Save);
						int result = fileChooser.showSaveDialog(null);
						if (result == JFileChooser.APPROVE_OPTION) {
							File file = fileChooser.getSelectedFile();
							mapModel.setMapSecret();
							String msg = new FileStorage().saveMapFile(file,
									mapModel);
							if (msg.contains("SUCCESS")) {
								JOptionPane.showMessageDialog(null,
										"File Save Successfuly.");
								closeFrame(jframe);
							} else
								JOptionPane.showMessageDialog(null, msg);
						}
					}
				}

				else if (e.getSource().equals(menuItemExit)) {
					closeFrame(jframe);
				}

			}

		}
		menuItemSave.addActionListener(new menuItemAction());
		menuItemExit.addActionListener(new menuItemAction());
		menuBar.add(menuFile);
		return menuBar;
	}
	
	public void closeFrame(JFrame jframe) {
		jframe.dispose();
	}

}
