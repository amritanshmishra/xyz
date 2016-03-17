package com.app.towerDefense.models;
/**
 * The classes that implement a concrete strategy should implement this.
 * The Tower class uses this to use a concrete strategy.
 * @author usbaitass
 *
 */
public interface Strategy {

	/**
	 * Method whose implementation varies depending on the strategy adopted.
	 * 
	 */
	void execute();
	
}
