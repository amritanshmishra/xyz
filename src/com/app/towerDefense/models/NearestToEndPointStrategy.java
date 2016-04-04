package com.app.towerDefense.models;
/**
 * This class is one of the strategies:
 * where tower targets the critter which is nearest to end point
 * @author usbaitass
 *
 */
public class NearestToEndPointStrategy implements Strategy{

	@Override
	public void execute(Tower new_tower, CritterType new_critter) {
		// TODO Auto-generated method stub
	//	System.out.println("Strategy : Nearest to End");
		
		if (new_tower.getTargetCritter() != null) {

			if (new_tower.getTargetCritter().getCritterId() != new_critter.getCritterId()) {
				
				
				if(new_tower.getTargetCritter().getCurrentBlockI() < new_critter.getCurrentBlockI()){
					new_tower.setTargetCritter(new_critter);
				}else if(new_tower.getTargetCritter().getCurrentBlockI() == new_critter.getCurrentBlockI()){
					
					if(new_tower.getTargetCritter().getDirectionX() > 0){
						if(new_tower.getTargetCritter().getX() < new_critter.getX()){
							new_tower.setTargetCritter(new_critter);
						}
					}else if(new_tower.getTargetCritter().getDirectionX() < 0){
						if(new_tower.getTargetCritter().getX() > new_critter.getX()){
							new_tower.setTargetCritter(new_critter);
						}
					}else if(new_tower.getTargetCritter().getDirectionY() > 0){
						if(new_tower.getTargetCritter().getY() < new_critter.getY()){
							new_tower.setTargetCritter(new_critter);
						}
					}else if(new_tower.getTargetCritter().getDirectionY() < 0){
						if(new_tower.getTargetCritter().getY() > new_critter.getY()){
							new_tower.setTargetCritter(new_critter);
						}
					}	
				}		
			}
		} else {
			new_tower.setTargetCritter(new_critter);
		}
		new_tower.shoot();
	}

	@Override
	public String getStrategyName() {
		// TODO Auto-generated method stub
		return "NearToEND";
	}

}
