package com.app.towerDefense.models;

/**
 * This is the critter factory class to create different kind of critters
 * 
 * @author Amritansh Mishra
 * 
 */
public class CritterFactory {

	/**
	 * Creates critter of diiferent types
	 * 
	 * @param new_critterType
	 * @return
	 */
	static public CritterType getCritterfromFactory(String new_critterType) {
		if (new_critterType == null)
			return new BasicCritter();
		else if (new_critterType.equalsIgnoreCase("BasicCritter")) {
			return new BasicCritter();
		} else if (new_critterType.equalsIgnoreCase("AdvancedCritter")) {
			return new AdvancedCritter();
		}

		return null;

	}

}
