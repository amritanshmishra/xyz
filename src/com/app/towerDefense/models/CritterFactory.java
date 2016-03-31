package com.app.towerDefense.models;

/**
 * This is the critter factory class to create different kind of critters
 * 
 * @author Amritansh Mishra
 * 
 */
public class CritterFactory {

	/**
	 * Creates critter of different types
	 * 
	 * @param new_critterType
	 *            creater type name
	 * @return critter type object
	 */
	static public CritterType getCritterfromFactory(String new_critterType) {

		if (new_critterType == null) {
			BasicCritter c = new BasicCritter();
			for (int i = 0; i < PlayerModel.towerModelArray.size(); i++) {
				//assign tower observers to critter objects
				c.addObserver(PlayerModel.towerModelArray.get(i));
			}
			return c;
		} else if (new_critterType.equalsIgnoreCase("BasicCritter")) {
			BasicCritter c = new BasicCritter();
			//assign tower observers to critter objects
			for (int i = 0; i < PlayerModel.towerModelArray.size(); i++) {
				c.addObserver(PlayerModel.towerModelArray.get(i));
			}
			return c;

		}

		return null;

	}

}
