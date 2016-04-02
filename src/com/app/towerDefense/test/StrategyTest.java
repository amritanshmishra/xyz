package com.app.towerDefense.test;

import static org.junit.Assert.*;

import java.awt.Graphics;

import javax.swing.JPanel;

import org.junit.*;

import org.junit.Test;

import com.app.towerDefense.guiComponents.MapPanel;
import com.app.towerDefense.models.BasicCritter;
import com.app.towerDefense.models.MapModel;
import com.app.towerDefense.models.NearestToEndPointStrategy;
import com.app.towerDefense.models.NearestToTowerStrategy;
import com.app.towerDefense.models.Shooter;
import com.app.towerDefense.models.StrongestStrategy;
import com.app.towerDefense.models.WeakestStrategy;

public class StrategyTest {

	Shooter tower;
	BasicCritter critter1;
	BasicCritter critter2;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Entered StrategyTest Class");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("Left StrategyTest Class");
	}

	@Before
	public void before() {
		System.out.print("inside");

		tower = new Shooter();
		critter1 = new BasicCritter(1);
		critter2 = new BasicCritter(1);
		critter1.setID(1);
		critter2.setID(2);
		tower.towerID = 1;

		tower.setXY(10, 10);

	}

	@After
	public void after() {
		System.out.println("outside");
		tower = null;
		critter1 = null;
		critter2 = null;

	}

	@Test
	public void testStrongestStrategy() {
		System.out.println(" testStrongestStrategy()");

		MapPanel mapPanel = new MapPanel(new MapModel());

		assertNotNull(tower);
		assertNotNull(critter1);
		assertNotNull(critter2);

		assertEquals(10, critter1.getCurrentHealth());
		assertEquals(10, critter2.getCurrentHealth());

		tower.setStrategy(new StrongestStrategy());
		assertEquals("Strongest", tower.getStrategy().getStrategyName());

		Thread thread = new Thread();
		try {

			// initially tower has no targets
			// so if critter1 comes first, it will shoot it
			// and sleep for 500ms
			tower.executeStrategy(tower, critter1);

			// we assert if tower has shot the critter1
			assertEquals(9, critter1.getCurrentHealth());

			// we assume that after tower shot,
			// 2 critters try to notify the tower to shoot them
			// however tower will not shoot because it still sleeps
			thread.sleep(100);
			tower.executeStrategy(tower, critter1);
			tower.executeStrategy(tower, critter2);
			
			// later this critters try to notify again
			// tower selects the target and shoots based on their Health status
			// which critter has GREATER hp, it is gonna be the target
			thread.sleep(1000);
			tower.executeStrategy(tower, critter1);
			tower.executeStrategy(tower, critter2);
		
			// we check if the target was correctly chosen
			// in our case, it should be the critter2
			assertEquals(9, critter1.getCurrentHealth());
			assertEquals(9, critter2.getCurrentHealth());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testWeakestStrategy() {
		System.out.println(" testWeakestStrategy()");

		MapPanel mapPanel = new MapPanel(new MapModel());

		assertNotNull(tower);
		assertNotNull(critter1);
		assertNotNull(critter2);

		assertEquals(10, critter1.getCurrentHealth());
		assertEquals(10, critter2.getCurrentHealth());

		tower.setStrategy(new WeakestStrategy());
		assertEquals("Weakest", tower.getStrategy().getStrategyName());
		
		Thread thread = new Thread();
		try {

			// initially tower has no targets
			// so if critter1 comes first, it will shoot it
			// and sleep for 500ms
			tower.executeStrategy(tower, critter1);

			// we assert if tower has shot the critter1
			assertEquals(9, critter1.getCurrentHealth());

			// we assume that after tower shot,
			// 2 critters try to notify the tower to shoot them
			// however tower will not shoot because it still sleeps
			thread.sleep(100);
			tower.executeStrategy(tower, critter1);
			tower.executeStrategy(tower, critter2);
			
			// later this critters try to notify again
			// tower selects the target and shoots based on their Health status
			// which critter has LESSER hp, it is gonna be the target
			thread.sleep(1000);
			tower.executeStrategy(tower, critter1);
			tower.executeStrategy(tower, critter2);
		
			// we check if the target was correctly chosen
			// in our case, it should be the critter1
			assertEquals(8, critter1.getCurrentHealth());
			assertEquals(10, critter2.getCurrentHealth());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	public void testNearestToTowerStrategy() {
		System.out.println(" testNearestToTowerStrategy()");

		MapPanel mapPanel = new MapPanel(new MapModel());

		assertNotNull(tower);
		assertNotNull(critter1);
		assertNotNull(critter2);

		assertEquals(10, critter1.getCurrentHealth());
		assertEquals(10, critter2.getCurrentHealth());
		
		tower.setStrategy(new NearestToTowerStrategy());
		assertEquals("NearTower", tower.getStrategy().getStrategyName());
		
		tower.setXY(0, 0);
		critter1.xCr = 20;
		critter1.yCr = 0;
		critter2.xCr = 30;
		critter2.yCr = 0;
	
	//	System.out.println("critter1 x:"+critter1.getXCr()+" y:"+critter1.getYCr());
	//	System.out.println("critter2 x:"+critter2.getXCr()+" y:"+critter2.getYCr());

		Thread thread = new Thread();
		try {

			// initially tower has no targets
			// so if critter1 comes first, it will shoot it
			// and sleep for 500ms
			tower.executeStrategy(tower, critter1);

			// we assert if tower has shot the critter1
			assertEquals(9, critter1.getCurrentHealth());

			// we assume that after tower shot,
			// 2 critters try to notify the tower to shoot them
			// however tower will not shoot because it still sleeps
			thread.sleep(100);
			tower.executeStrategy(tower, critter1);
			tower.executeStrategy(tower, critter2);
			
			// later this critters try to notify again
			// tower selects the target and shoots based on their distance
			// which critter has smaller distance between it and tower,
			// it is gonna be the target
			thread.sleep(1000);
			tower.executeStrategy(tower, critter1);
			tower.executeStrategy(tower, critter2);
		
			// we check if the target was correctly chosen
			// in our case, it should be the critter1
			assertEquals(8, critter1.getCurrentHealth());
			assertEquals(10, critter2.getCurrentHealth());
			
			// now if we change the location of critter1
			// and make it further
			critter1.xCr = 40;
			critter1.yCr = 0;
			critter2.xCr = 30;
			critter2.yCr = 0;
			
//			System.out.println("critter1 x:"+critter1.getXCr()+" y:"+critter1.getYCr());
//			System.out.println("critter2 x:"+critter2.getXCr()+" y:"+critter2.getYCr());
			
			// critters call the shoot the function but the tower is still sleeps
			thread.sleep(100);
			tower.executeStrategy(tower, critter1);
			tower.executeStrategy(tower, critter2);
		
			// one second later we request shoot again
			thread.sleep(1000);
			tower.executeStrategy(tower, critter1);
			tower.executeStrategy(tower, critter2);
		
			// in this case, the distance between tower and critter2
			// became smaller than distance between tower and critter1
			// therefore, tower should shoot the critter2 now
			assertEquals(8, critter1.getCurrentHealth()); 
			assertEquals(9, critter2.getCurrentHealth());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testNearestToEndPointStrategy() {
		System.out.println(" testNearestToEndPointStrategy()");

		MapPanel mapPanel = new MapPanel(new MapModel());

		assertNotNull(tower);
		assertNotNull(critter1);
		assertNotNull(critter2);

		assertEquals(10, critter1.getCurrentHealth());
		assertEquals(10, critter2.getCurrentHealth());
		
		tower.setStrategy(new NearestToEndPointStrategy());
		assertEquals("NearToEND", tower.getStrategy().getStrategyName());
		
		tower.setXY(0, 0);
		critter1.xCr = 20;
		critter1.yCr = 0;
		critter2.xCr = 30;
		critter2.yCr = 0;
	
	//	System.out.println("critter1 x:"+critter1.getXCr()+" y:"+critter1.getYCr());
	//	System.out.println("critter2 x:"+critter2.getXCr()+" y:"+critter2.getYCr());

		Thread thread = new Thread();
		try {

			// initially tower has no targets
			// so if critter1 comes first, it will shoot it
			// and sleep for 500ms
			tower.executeStrategy(tower, critter1);

			// we assert if tower has shot the critter1
			assertEquals(9, critter1.getCurrentHealth());

			// we assume that after tower shot,
			// 2 critters try to notify the tower to shoot them
			// however tower will not shoot because it still sleeps
			thread.sleep(100);
			tower.executeStrategy(tower, critter1);
			tower.executeStrategy(tower, critter2);
			
			// later this critters try to notify again
			// tower selects the target and shoots based on their distance
			// which critter has smaller distance between it and tower,
			// it is gonna be the target
			thread.sleep(1000);
			tower.executeStrategy(tower, critter1);
			tower.executeStrategy(tower, critter2);
		
			// we check if the target was correctly chosen
			// in our case, it should be the critter1
			assertEquals(8, critter1.getCurrentHealth());
			assertEquals(10, critter2.getCurrentHealth());
			
			// now if we change the location of critter1
			// and make it further
			critter1.xCr = 40;
			critter1.yCr = 0;
			critter2.xCr = 30;
			critter2.yCr = 0;
			
//			System.out.println("critter1 x:"+critter1.getXCr()+" y:"+critter1.getYCr());
//			System.out.println("critter2 x:"+critter2.getXCr()+" y:"+critter2.getYCr());
			
			// critters call the shoot the function but the tower is still sleeps
			thread.sleep(100);
			tower.executeStrategy(tower, critter1);
			tower.executeStrategy(tower, critter2);
		
			// one second later we request shoot again
			thread.sleep(1000);
			tower.executeStrategy(tower, critter1);
			tower.executeStrategy(tower, critter2);
		
			// in this case, the distance between tower and critter2
			// became smaller than distance between tower and critter1
			// therefore, tower should shoot the critter2 now
			assertEquals(8, critter1.getCurrentHealth()); 
			assertEquals(9, critter2.getCurrentHealth());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
