package com.app.towerDefense.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.app.towerDefense.models.TowerModel5;

/**
 * The class is a test suite for all the tower model test cases.
 *
 *
 * @author Amritansh Mishra
 * @version 1.0
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ TowerModel1Test.class, TowerModel2Test.class, TowerModel3Test.class, TowerModel4Test.class,
		TowerModel5Test.class })
public class TowerModelTestSuite {

}
