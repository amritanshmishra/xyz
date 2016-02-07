package com.app.towerDefense.guisystem;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

import com.app.towerDefense.guiComponents.JMenuBarComponent;
import com.app.towerDefense.guiComponents.JPanelComponent;
import com.app.towerDefense.guisystem.GameMenu.E_MapEditorMode;
import com.app.towerDefense.models.MapModel;
import com.app.towerDefense.staticContent.ApplicationStatics;

//public class MapEditor extends JDialog  {
public class MapEditor extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MapModel mapModel;
	E_MapEditorMode mapEditorMode;

	public MapEditor(JFrame parent, String title, int width, int height,
			MapModel _mapModel, E_MapEditorMode _mapEditorMode) {
		if (parent != null) {
			Dimension parentSize = parent.getSize();
			Point p = parent.getLocation();
			setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
		}
		
		mapModel = _mapModel;
		mapEditorMode = _mapEditorMode;
		
		if (E_MapEditorMode.Create == mapEditorMode) {
			title += " " + ApplicationStatics.MAP_MODE_CREATE;
		} else {
			title += " " + ApplicationStatics.MAP_MODE_OPEN;
		}
		
		//--- Set Map Editor Windows Properties
		this.setTitle(title);
		this.setPreferredSize(new Dimension(width, height));
		this.setMaximumSize(new Dimension(width, height));
		this.setMinimumSize(new Dimension(width, height));
		this.setResizable(false);
		this.setLocationRelativeTo(null); 
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
		//-- Load MenuBar From Components
		this.setJMenuBar((new JMenuBarComponent()).getMapEditorJMenuBar(_mapModel, this));
		//-- Load GridEditor Panel From Components
		this.setContentPane((new JPanelComponent()).getMapGridPanel(mapModel, mapEditorMode));

	}

}
