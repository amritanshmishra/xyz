package com.app.towerDefense.critterFactory;

import java.awt.Point;
import java.util.LinkedList;

/**
* This is factory class to create different kind of enemies
* @author Amritansh Mishra
* 
*/
public class CritterFactory {
/**
* 
* @param critterType Type of critter 
* @param critterId Id of critter
* @param critterPath Path of critter
* @param movePoint Path of critter
* @param actualHealth Actual Health of critter
* @param currentHealth Current Health of critter
* @param value Value of critter
* @param critterActualSpeed Actual Speed of critter
* @param critterCurrentSpeed Current Speed of critter
* @return critter
*/
public CritterType getCritterfromFactory(String critterType)
{
	 if(critterType == null)
     	return new BasicCritter();
	 else if(critterType.equalsIgnoreCase("Critter X")){
		 	return new BasicCritter();
	 }
	 else if(critterType.equalsIgnoreCase("Critter Y")){
		 return new AdvancedCritter();
	 }
          
	 return null;
        
}

}
