package com.app.towerDefense.guiComponents;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.app.towerDefense.staticContent.AppilicationEnums.*;

/**
 * This class allows us to select a file from system.
 * 
 * @author Sajjad Ashraf
 *
 */
public class JFileChooserComponent {

	/**
	 * The Constructor
	 * 
	 * @param new_fileChooserMode
	 *            the mode of a file open and on the base of this argument it behave accordingly.
	 * @return a file
	 */
	private JFileChooser fileChooser;
	
	public JFileChooser getJFileChooser(E_JFileChooserMode new_fileChooserMode) {
		fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		if (new_fileChooserMode == E_JFileChooserMode.Open) {
			fileChooser.setDialogTitle("Tower Defense Select .tdm file");
		} else {
			fileChooser.setDialogTitle("Tower Defence Map Save");
		}
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Tower Defence Map", "tdm"));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		return fileChooser;
	}

	/**
	 * @return the fileChooser
	 */
	public JFileChooser getFileChooser() {
		return fileChooser;
	}
	
	
}
