package com.app.towerDefense.guiComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.app.towerDefense.map.Map;
import com.app.towerDefense.models.MapModel;
import com.app.towerDefense.staticContent.ApplicationStatics;
import com.app.towerDefense.utilities.FileStorage;

public class JMenuBarComponent {
	
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
						JFileChooser fileChooser = new JFileChooser();
						fileChooser.setDialogTitle("Tower Defence Map Save");
						fileChooser.setFileFilter(new FileNameExtensionFilter(
								"Tower Defence Map", "tdm"));
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
