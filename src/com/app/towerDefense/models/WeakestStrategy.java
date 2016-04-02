package com.app.towerDefense.models;
/**
 * This class is one of the strategies:
 * where tower targets the weakest critter in fire range.
 * @author usbaitass
 *
 */
public class WeakestStrategy implements Strategy{

	/**
	 * Executes the Weakest strategy 
	 */
	@Override
	public void execute(Tower new_tower, CritterType new_critter) {
		// TODO Auto-generated method stub
	//	System.out.println("Strategy : Weakest");
	
		
		if (new_tower.getTargetCritter() != null) {

		//	System.out.print("inside weakest ");
			if(new_tower.getTargetCritter().getCurrentHealth()>new_critter.getCurrentHealth() && new_tower.getTargetCritter().getCritterId() != new_critter.getCritterId()){
			
				new_tower.setTargetCritter(new_critter);
				System.out.println("inside weakest towerID:"+ new_tower.getTowerName() +" critter ID:"+new_critter.getCritterId());
			}
			
		} else {
			new_tower.setTargetCritter(new_critter);
		}
		
	//	System.out.println("asdad");

		new_tower.shoot();
	}

	@Override
	public String getStrategyName() {
		// TODO Auto-generated method stub
		return "Weakest";
	}

}
