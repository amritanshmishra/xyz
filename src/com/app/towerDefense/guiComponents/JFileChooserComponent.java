package com.app.towerDefense.guiComponents;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.app.towerDefense.staticContent.AppilicationEnums.*;

public class JFileChooserComponent {

	public JFileChooser getJFileChooser(E_JFileChooserrMode fileChooserrMode)
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		if(fileChooserrMode == E_JFileChooserrMode.Open)
		{
			fileChooser.setDialogTitle("Tower Defense Select .tdm file");
		}
		else
		{
			fileChooser.setDialogTitle("Tower Defence Map Save");
		}
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Tower Defence Map", "tdm"));
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		return fileChooser;
	}
}
