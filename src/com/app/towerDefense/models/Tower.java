package com.app.towerDefense.models;
/**
 * 
 */


import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;

import com.app.towerDefense.staticContent.ApplicationStatics;

/**
 * Tower abstract class is the super-typer of all types of objects produced by the TowerFactory. 
 * @author George Ekow-Daniels
 *
 */
public abstract class Tower implements Observer {
	
	public int towerID;
	protected String towerName;
	protected int towerRange;
	protected int towerPower;
	protected int towerFireRate;
	protected int towerCost;
	protected int towerlevel;
	protected Icon towerImage;
	protected String towerImagePath;
	protected Dimension TowerCordinate;
	protected int towerUpgradeCost;
	protected int towerlevelUpgrade;
	protected int towerPowerUpgrade;
	protected int towerFireRateUpgrade;
	protected int towerFireRangeUpgrade;
	protected int x, y;
	
	protected Strategy strategy;

	/**
	 * This method gets the name of the tower
	 * 
	 * @return the tower name
	 */
	public abstract String getTowerName();

	/**
	 * This method sets the Tower name
	 * 
	 */
	public abstract void setTowerName();

	/**
	 * This method gets the value the value for range upgrade
	 * 
	 * @return the tower fire range upgrade value
	 */
	public abstract int getTowerFireRangeUpgrade();
	

	/**
	 * This method sets the tower fire range upgrade value
	 * 
	 */
	public abstract void setTowerFireRangeUpgrade();

	/**
	 * This method gets the
	 * 
	 * @return the tower range
	 */
	public abstract int getTowerRange();

	/**
	 * This is the method for setting the tower range
	 * 
	 */
	public abstract void setTowerRange();

	/**
	 * This method gets tower power
	 * 
	 * @return the tower power
	 */
	public abstract int getTowerPower();

	/**
	 * The method sets the <b>power</b> of the tower
	 * 
	 */
	public abstract void setTowerPower();

	/**
	 * This set the firing rate of a tower
	 * 
	 * @return the fire rate of a tower
	 */
	public abstract int getTowerFireRate();

	/**
	 * This method sets the firing rate of a tower
	 * 
	 */
	public abstract void setTowerFireRate();

	/**
	 * This method gets the current cost of towers
	 * 
	 * @return the cost of tower
	 */
	public abstract int getTowerCost();

	/**
	 * This method sets the cost of the tower
	 * 
	 */
	public abstract void setTowerCost();

	/**
	 * This method gets the tower level
	 * 
	 * @return the current tower level
	 */
	public abstract int getTowerlevel();

	/**
	 * This method sets the tower level
	 *
	 */
	public abstract void setTowerlevel();

	/**
	 * This method sets the tower image
	 * 
	 * @return the tower image
	 */
	public abstract Icon getTowerImage();

	/**
	 * This method sets the image of the tower
	 */
	public abstract void setTowerImage();

	/**
	 * This method gets the tower coordinates
	 * 
	 * @return the tower coordinate
	 */
	public abstract Dimension getTowerCordinate();

	/**
	 * This method sets the tower coordinate
	 *
	 */
	public abstract void setTowerCordinate();

	/**
	 * This method gets upgrade cost of a tower
	 * 
	 * @return the tower upgrade cost
	 */
	public abstract int getTowerUpgradeCost();

	/**
	 * This method sets the tower upgrade cost
	 * 
	 */
	public abstract void setTowerUpgradeCost();

	/**
	 * This method gets tower upgrade level
	 * 
	 * @return the tower level upgrade
	 */
	public abstract int getTowerlevelUpgrade();

	/**
	 * This method sets level upgrade of a tower
	 *
	 */
	public abstract void setTowerlevelUpgrade();

	/**
	 * This method gets power upgrade of a tower
	 * 
	 * @return the tower power upgrade
	 */
	public abstract int getTowerPowerUpgrade();

	/**
	 * This method sets tower power upgrade
	 * 
	 */
	public abstract void setTowerPowerUpgrade();

	/**
	 * This method gets the fire rate update of a tower
	 * 
	 * @return the tower fire rate update
	 */
	public abstract int getTowerFireRateUpgrade() ;

	/**
	 * This method sets the tower firing rate upgrade
	 * 
	 */
	public abstract void setTowerFireRateUpgrade();

	
	/**
	 * This method get the tower model's X coordinate
	 * 
	 * @return x coordinate of tower model
	 */
	public abstract int getX();
	
	/**
	 * This method get the tower model's Y coordinate
	 * 
	 * @return y coordinate of tower model
	 */
	public abstract int getY();
	
	/**
	 * This method sets the X and Y coordinates of the tower model
	 * 
	 */
	public abstract void setXY(int new_x,int new_y);
	
	/**
	 * This method upgrades Tower
	 */
	public abstract void upgradeTower();
	
	/**
	 * This method calculates the amount for refund after a sell of a tower
	 * @return the value of the tower
	 */
	public abstract int getRefund();
	 
	/**
	 * Plugs in a specific strategy to be used 
	 * @param strategy object
	 */
	public abstract void setStrategy(Strategy strategy);
	
	/**
	 * Method that executes a different strategy depending on what strategy was 
     * plugged in upon instantiation.
	 */
	public abstract void executeStrategy();
	
	public void update(Observable critter, Object x)
	{
		int xblockdifference=((1*ApplicationStatics.BLOCK_HEIGHT));//+ApplicationStatics.BLOCK_HEIGHT);
		int yblockdifference=((1*ApplicationStatics.BLOCK_WIDTH));//+ApplicationStatics.BLOCK_WIDTH);
		
		int xpix = (this.getX()*ApplicationStatics.BLOCK_HEIGHT);//+ApplicationStatics.BLOCK_HEIGHT;
		int ypix = (this.getY()*ApplicationStatics.BLOCK_WIDTH);//+ApplicationStatics.BLOCK_WIDTH;
		
		/*System.out.println("Cx="+((CritterType)critter).getX()+
				", Cy="+((CritterType)critter).getY()
				+", x :"+xpix +", y "+ypix);
		*/
		if((xpix<=((CritterType)critter).getX()|| ((CritterType)critter).getX()<=(xpix+xblockdifference))&& (ypix<=((CritterType)critter).getY()|| ((CritterType)critter).getY()<=(ypix+yblockdifference)))
		{
			System.out.println("in tower range shoot");
		}
		
		/*if(ypix<=((CritterType)critter).getY()&& ((CritterType)critter).getY()<=(ypix+yblockdifference))
		{
			System.out.println("in y range");
		}
		/*Ellipse2D.Double circle =
				  new Ellipse2D.Double((double) this.getX(), this.getY(), 200,200)
				  ;
		if(circle.contains( ((CritterType)critter).getX(), ((CritterType)critter).getY()))
		{
			System.out.println("Shooter");
		}
		else
		{
			
		}
		
		/*if(
				((((CritterType)critter).getX()<=(xpix+xblockdifference)
					&&((CritterType)critter).getY()==ypix))|| 
				((((CritterType)critter).getX()>=(xpix-xblockdifference)
					&&((CritterType)critter).getY()==ypix))||
				((((CritterType)critter).getX()==(xpix)
					&&((CritterType)critter).getY()>=ypix+yblockdifference))||
				(((CritterType)critter).getX()==(xpix)
					&&((CritterType)critter).getY()<=ypix-yblockdifference))
		{
			System.out.println("Shoot me "+this.towerName+" Critter ID"+ ((CritterType)critter).getCritterId() );
		}
		*/
				
			
		
		
	}
	
}
