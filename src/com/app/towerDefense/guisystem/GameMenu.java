package com.app.towerDefense.guisystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.app.towerDefense.models.MapModel;
import com.app.towerDefense.staticContent.ApplicationStatics;

public class GameMenu extends JPanel{
	public JFrame jframe;
	public enum E_MapEditorMode {
	    Create,Open
	}
	private static final long serialVersionUID = -307815763272568727L;

	public GameMenu(JFrame _jframe){
		jframe=_jframe;
		JMenuBar menuBar = new  JMenuBar();
		jframe.setJMenuBar(menuBar);
		
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
					JOptionPane.showMessageDialog(null, "Play Map Button Clicked");
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
							MapEditor dlg = new MapEditor(jframe, 
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
					
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
					fileChooser.setDialogTitle("Tower Defense Select .tdm file");
					fileChooser.setAcceptAllFileFilterUsed(false);
					fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Tower Defence Map", "tdm"));
					fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					
					int result = fileChooser.showOpenDialog(GameMenu.this);
					if (result == JFileChooser.APPROVE_OPTION) {
					    File file = fileChooser.getSelectedFile();
					    MapModel mapModel 	= (new com.app.towerDefense.utilities.FileStorage()).openMapFile(file);
					    if(mapModel != null)
						  {
					    	if(mapModel.mapSecret.contains("_Team5"))
					    	{
					    		MapEditor dlg = new MapEditor(jframe, 
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
					/*MapEditor dlg = new MapEditor(jframe, 
							ApplicationStatics.TITLE_MAP_EDITOR,
							ApplicationStatics.CHILD_POPUP_WINDOW_WIDTH, 
							ApplicationStatics.CHILD_POPUP_WINDOW_HEIGHT , 
							E_MapEditorMode.Open);*/
					
					
				}
				else if(e.getSource().equals(menuItemExit))
				{
					System.exit(0);
				}
				else if(e.getSource().equals(menuItemAbout))
				{
					JOptionPane.showMessageDialog(null, "ABOUT Button Clicked");
				}
			}
			
			
		}
		menuItemPlay.addActionListener(new menuItemAction());
		menuItemCreateMap.addActionListener(new menuItemAction());
		menuItemOpenMap.addActionListener(new menuItemAction());
		menuItemExit.addActionListener(new menuItemAction());
		menuItemAbout.addActionListener(new menuItemAction());	
		
	}
	
// END	
}

