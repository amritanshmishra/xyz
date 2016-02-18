package com.app.towerDefense.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.app.towerDefense.models.MapModel;
import com.google.gson.Gson;

/**
 * This class is for saving a map
 * 
 * @author Sajjad 
 *
 */
public class FileStorage {

	public String saveMapFile(File file, MapModel mapModel) {
		String fileContent = getJsonFromObject(mapModel);
		fileContent = (new MiscellaneousHelper()).EncodeBase64(fileContent);
		String filePath = file.getPath();
		if (!filePath.endsWith(".tdm"))
			filePath += ".tdm";
		try {
			FileWriter fileWriter = new FileWriter(filePath);
			fileWriter.write(fileContent);
			fileWriter.flush();
			fileWriter.close();
			return "SUCCESS";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR : " + e.getMessage();
		}
	}
	
	public MapModel openMapFile(File file) {
		
		String fileContent ="";
		 try {
			 fileContent = new String(Files.readAllBytes(Paths.get(file.getPath())));
			 fileContent = (new MiscellaneousHelper()).DecodeBase64(fileContent);
			 return (MapModel) getObjectFromJson(fileContent, MapModel.class);
		} catch (IOException e) {
			e.printStackTrace();
			return  null;
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
