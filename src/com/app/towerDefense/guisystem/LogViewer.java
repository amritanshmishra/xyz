package com.app.towerDefense.guisystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import com.app.towerDefense.gameLogic.LogReader;
import com.app.towerDefense.guiComponents.JPanelComponent;
import com.app.towerDefense.models.Tower;
import com.app.towerDefense.staticContent.AppilicationEnums.E_LogViewerState;
import com.app.towerDefense.staticContent.ApplicationStatics;
/**
 * This is the Log Viewer class
 * 
 * @author Sajjad Ashraf
 * 
 */
public class LogViewer extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	E_LogViewerState eLogViewerState;
	String logFilePath="";
	static Color colors[] = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE,
	      Color.MAGENTA };
	
	public LogViewer(JFrame new_parent, String new_title, int new_width,
			int new_height, String new_log_file_path,
			E_LogViewerState new_elog_viewer_state, Tower new_tower) {
		//Set Window size
		if (new_parent != null) {
			Dimension parentSize = new_parent.getSize();
			Point p = new_parent.getLocation();
			setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
		}
		
		logFilePath = new_log_file_path;
		eLogViewerState = new_elog_viewer_state;
		
		//Set Title
		if (E_LogViewerState.GlobalLog == eLogViewerState) {
			new_title += " " + ApplicationStatics.LOG_VIEWER_MODE_GLOBLE;
		} else if (E_LogViewerState.CurrentSessionLog == eLogViewerState) {
			new_title += " " + ApplicationStatics.LOG_VIEWER_MODE_CURRENT_SESSION;
		}
		else if (E_LogViewerState.TowerLog == eLogViewerState) {
			new_title += " " + ApplicationStatics.LOG_VIEWER_MODE_TOWERS;
		}
		else if (E_LogViewerState.TowerCollectionLog == eLogViewerState) {
			new_title += " " + ApplicationStatics.LOG_VIEWER_MODE_TOWERS_COLLECTION;
		}	
		
		// --- Set Map Editor Windows Properties
		this.setTitle(new_title);
		this.setPreferredSize(new Dimension(new_width, new_height));
		this.setMaximumSize(new Dimension(new_width, new_height));
		this.setMinimumSize(new Dimension(new_width, new_height));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);		
		
		//Tabs
	    getContentPane().add(new JPanelComponent().getLogViewerPanel(new_log_file_path, new_elog_viewer_state, new_tower));
	    
	}
}
