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
		{
			BasicCritter c = new BasicCritter();
			for(int i=0;i<PlayerModel.towerModelArray.size();i++)
			{
				c.addObserver(PlayerModel.towerModelArray.get(i));
			}
			return c;

		}
		else if (new_critterType.equalsIgnoreCase("BasicCritter")) {
			BasicCritter c = new BasicCritter();
			for(int i=0;i<PlayerModel.towerModelArray.size();i++)
			{
				c.addObserver(PlayerModel.towerModelArray.get(i));
			}
			return c;

		} else if (new_critterType.equalsIgnoreCase("AdvancedCritter")) {
			return new AdvancedCritter();
		}

		return null;

	}

}
