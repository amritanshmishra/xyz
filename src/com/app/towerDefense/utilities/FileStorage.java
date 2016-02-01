package com.app.towerDefense.utilities;

import java.io.File;
import java.io.FileWriter;

import com.app.towerDefence.models.MapModel;
import com.google.gson.Gson;

public class FileStorage {

	public String saveMapFile(File file, MapModel mapModel) {
		String fileContent = getJsonFromObject(mapModel);
		fileContent = (new MiscellaneousHelper()).EncodeBase64(fileContent);
		String filePath = file.getPath();
		if (!filePath.endsWith(".tdm"))
			filePath += ".tdn";
		try {
			FileWriter fileWriter = new FileWriter(filePath);
			fileWriter.write(fileContent);
			fileWriter.flush();
			fileWriter.close();
			return "SUCCESS";
		} catch (Exception e) {
			// TODO: handle exception
			// JOptionPane.showMessageDialog(null, e.getMessage());
			return "ERROR : " + e.getMessage();
		}
	}

	public String getJsonFromObject(Object object) {
		Gson gson = new Gson();
		return gson.toJson(object);
	}

	public Object getObjectFromJson(String jsonString, Class<?> _class) {
		Gson gson = new Gson();
		return gson.fromJson(jsonString, _class);
	}

}
