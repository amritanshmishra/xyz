package com.app.towerDefense.models;

import com.app.towerDefense.staticContent.ApplicationStatics;

/**
 * This class is one of the strategies: where tower targets the critter which is
 * nearest to end tower
 * 
 * @author usbaitass
 *
 */
public class NearestToTowerStrategy implements Strategy {

	@Override
	public void execute(Tower new_tower, CritterType new_critter) {
		// TODO Auto-generated method stub
		// System.out.println("Strategy : Nearest to Tower");

		if (new_tower.getTargetCritter() != null) {

			if (new_tower.getTargetCritter().getCritterId() != new_critter.getCritterId()) {

				int x0 = new_tower.getXMid();
				int y0 = new_tower.getYMid();

				int x1 = new_tower.getTargetCritter().getXCr();
				int y1 = new_tower.getTargetCritter().getYCr();

				int x2 = new_critter.getXCr();
				int y2 = new_critter.getYCr();
				
		//		System.out.println("x0:"+x0+" y0:"+y0+" x1:"+x1+" y1:"+y1+" x2:"+x2+" y2"+y2);

				double d1 = Math.sqrt(((x0 - x1) < 0 ? -1 * (x0 - x1) : (x0 - x1) ) ^ 2 + ((y0 - y1) < 0 ? -1 * (y0 - y1) : (y0 - y1) ) ^ 2);
				double d2 = Math.sqrt(((x0 - x2) < 0 ? -1 * (x0 - x2) : (x0 - x2) ) ^ 2 + ((y0 - y2) < 0 ? -1 * (y0 - y2) : (y0 - y2) ) ^ 2);
		//		System.out.println(
		//				"cr:" + new_tower.getTargetCritter().getCritterId() + " d1:" + String.format("%.2f", d1)
		//						+ " cr:" + new_critter.getCritterId() + " d2:" + String.format("%.2f", d2));

				if (d1 > d2) {
					new_tower.setTargetCritter(new_critter);
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
		return "NearTower";
	}

}
