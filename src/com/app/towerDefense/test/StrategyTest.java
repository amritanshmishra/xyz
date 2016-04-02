package com.app.towerDefense.test;

import static org.junit.Assert.*;
import org.junit.*;

import org.junit.Test;

import com.app.towerDefense.models.BasicCritter;
import com.app.towerDefense.models.Shooter;

public class StrategyTest {
	
	Shooter tower;
	BasicCritter critter1;
	BasicCritter critter2;
	
	@BeforeClass public static void beforeClass(){
		System.out.println("Entered StrategyTest Class");
	}
	
	@AfterClass public static void afterClass(){
		System.out.println("Left StrategyTest Class");
	}
	
	@Before public void before(){
		System.out.print("inside");
	}
	
	@After public void after(){
		System.out.println("outside");
		
	}
	
	@Test public void testStrongestStrategy(){
		System.out.println(" testStrongestStrategy()");
		
		
		
	}

}
