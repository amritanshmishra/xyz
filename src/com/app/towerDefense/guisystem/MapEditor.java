package com.app.towerDefense.guisystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.app.towerDefence.models.MapModel;
import com.app.towerDefense.guisystem.GameMenu.E_MapEditorMode;
import com.app.towerDefense.staticContent.ApplicationStatics;
import com.app.towerDefense.utilities.FileStorage;

//public class MapEditor extends JDialog  {
public class MapEditor extends JFrame  {
MapModel mapModel;

public MapEditor(JFrame parent, String title, int width, int height, E_MapEditorMode mapEditorMode){
		//super(parent, title, true);
	    if (parent != null) {
	      Dimension parentSize = parent.getSize(); 
	      Point p = parent.getLocation(); 
	      setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
	    }
	    
	    this.setTitle(title);		
		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));
		this.setResizable(false);
		this.setLocationRelativeTo(null); //center window on the screen
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);	    
	    
	   if(E_MapEditorMode.Create == mapEditorMode)
	   {
		   title+=" "+ApplicationStatics.MAP_MODE_CREATE;
		   mapModel = new MapModel();
		   
		   menuInitialization();

		   mapPanelInitialization();
	   }
	   else
	   {
		   title+=" "+ApplicationStatics.MAP_MODE_OPEN;
	   }
	    
		
		
		
	}
	
	private void menuInitialization()
	{
		JMenuBar menuBar = new  JMenuBar();
		this.setJMenuBar(menuBar);
		JMenu menuFile = new JMenu(ApplicationStatics.MENU_FILE);
		menuBar.add(menuFile);
		
		final JMenuItem menuItemSave = new JMenuItem(ApplicationStatics.MENU_ITEM_SAVE);
		menuFile.add(menuItemSave);
		final JMenuItem menuItemExit = new JMenuItem(ApplicationStatics.MENU_ITEM_EXIT);
		menuFile.add(menuItemExit);
		
		class menuItemAction implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(menuItemSave))
				{
					if(!mapModel.isEntryDone)
						JOptionPane.showMessageDialog(null, "Please First Select an Entry Point.");
					else if(!mapModel.isExitDone)
						JOptionPane.showMessageDialog(null, "Please First Select an Exit Point.");
					else
					{
						 JFileChooser fileChooser = new JFileChooser();
						 fileChooser.setDialogTitle("Tower Defence Map Save");
						 fileChooser.setFileFilter(new FileNameExtensionFilter("Tower Defence Map", "tdm"));
						int result= fileChooser.showSaveDialog(null);
						 if(result== JFileChooser.APPROVE_OPTION)
						 {
							 File file=fileChooser.getSelectedFile();
							  String msg= new FileStorage().saveMapFile(file, mapModel);
							  if(msg.contains("SUCCESS"))
							  {
								  JOptionPane.showMessageDialog(null, "File Save Successfuly.");
								  CloseFrame();
							  }
							  else
								  JOptionPane.showMessageDialog(null, msg);
						 }
					}
				}
				
				else if(e.getSource().equals(menuItemExit))
				{
					CloseFrame();  
				}
				
			}
			
		}
		menuItemSave.addActionListener(new menuItemAction());
		menuItemExit.addActionListener(new menuItemAction());	

	}
	
	private void mapPanelInitialization(){
		
		mapModel.mapGridSelection = new int[ApplicationStatics.MAP_GRID_HEIGHT][ApplicationStatics.MAP_GRID_WIDTH]; 	
		mapModel.setMapWidth(ApplicationStatics.MAP_GRID_WIDTH);
		mapModel.setMapHeight(ApplicationStatics.MAP_GRID_HEIGHT);
		JPanel panel = new JPanel();
		GridLayout gridLayout = new GridLayout(
				ApplicationStatics.MAP_GRID_HEIGHT, 
				ApplicationStatics.MAP_GRID_WIDTH, 
				3, 
				3);
		panel.setLayout(gridLayout);
		JButton b[][] = new JButton[ApplicationStatics.MAP_GRID_HEIGHT][ApplicationStatics.MAP_GRID_WIDTH];

		for (int i = 0; i < ApplicationStatics.MAP_GRID_HEIGHT; i++)
		{
		      for (int j = 0; j < ApplicationStatics.MAP_GRID_WIDTH; j++)
		      {
		        b[i][j] = new JButton();
		        int value = 0;
		        int multiple=0;
		        
		        multiple=ApplicationStatics.MAP_GRID_WIDTH;
		        		
		        if(i==0 && j==0)
		        	value=0;
		        else 
		        	value = 1+ j+ (i * multiple);
		        mapModel.mapGridSelection[i][j]=0;
		        b[i][j].setName(value+":"+i+":"+j);
		        b[i][j].setBackground(Color.gray); 
		        b[i][j].addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JButton btn =((JButton)e.getSource());
						String[] nameArry = btn.getName().split(":");
						int _i = Integer.parseInt(nameArry[1]);
						int _j = Integer.parseInt(nameArry[2]);
						if(mapModel.mapGridSelection[_i][_j]==0)
						{
							btn.setBackground(Color.green);
							mapModel.mapGridSelection[_i][_j]=1;
						} 
						else if(mapModel.mapGridSelection[_i][_j]== 1)
						{
							mapModel.mapGridSelection[_i][_j]=0;
							btn.setBackground(Color.gray);
						}
						else if(mapModel.mapGridSelection[_i][_j]== 2)
						{
							mapModel.mapGridSelection[_i][_j]=0;
							btn.setBackground(Color.gray);
							btn.setText("");
							mapModel.isEntryDone=false;
						}
						else if(mapModel.mapGridSelection[_i][_j]== 3)
						{
							mapModel.mapGridSelection[_i][_j]=0;
							btn.setBackground(Color.gray);
							btn.setText("");
							mapModel.isExitDone=false;
						}
											
						System.out.println(" Btn Name : "+btn.getName());
					}		
					
				});
		        
		        b[i][j].addMouseListener(new MouseAdapter(){
		        	  public void mouseClicked(MouseEvent e){
		        	    //boolean mine = field.isMine(x, y);
		        	    if (e.getButton() == MouseEvent.BUTTON1) {
		        	    }
		        	    else if (e.getButton() == MouseEvent.BUTTON2) {
		        	    }
		        	    else if (e.getButton() == MouseEvent.BUTTON3) {
		        	    	JButton btn =((JButton)e.getSource());
		        	    	String[] nameArry = btn.getName().split(":");
							int _i = Integer.parseInt(nameArry[1]);
							int _j = Integer.parseInt(nameArry[2]);
							
							if(mapModel.mapGridSelection[_i][_j]==2)
							{
								mapModel.mapGridSelection[_i][_j]=0;
								btn.setBackground(Color.gray);
								btn.setText("");
								mapModel.isEntryDone=false;
							}
							else if(mapModel.mapGridSelection[_i][_j]==3)
							{
								mapModel.mapGridSelection[_i][_j]=0;
								btn.setBackground(Color.gray);
								btn.setText("");
								mapModel.isExitDone=false;
							}
							else if(mapModel.mapGridSelection[_i][_j]==0 || mapModel.mapGridSelection[_i][_j]==1)
							{
								if(!mapModel.isEntryDone)
								{
									btn.setBackground(Color.RED);
									btn.setText("E");
									mapModel.mapGridSelection[_i][_j]=2;
									mapModel.isEntryDone=true;
								}
								else if(!mapModel.isExitDone)
								{
									btn.setBackground(Color.RED);
									btn.setText("O");
									mapModel.mapGridSelection[_i][_j]=3;
									mapModel.isExitDone=true;
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Enrty and Already Selected");
								}
							}
		        	    	
							
		        	    	
		        	    }
		        	  }
		        });
		        
		        panel.add(b[i][j]);
		      }
		  }
		this.setContentPane(panel);
	}
	
	public void CloseFrame(){
	    super.dispose();
	}

}
