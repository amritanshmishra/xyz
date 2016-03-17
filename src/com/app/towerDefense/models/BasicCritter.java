package com.app.towerDefense.models;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.app.towerDefense.staticContent.ApplicationStatics;

import javafx.beans.InvalidationListener;

/**
 * This class is the basic critter that would move on the map Contains different
 * methhods to create and move a critter on the map selected by player
 * 
 * @author Amritansh Mishra
 *
 */
public class BasicCritter extends java.util.Observable implements CritterType {

	/**
	 * current X and Y position of critter
	 */
	public int x, y;
	public int directionX; //decides which direction critter moves
	public int directionY;
	private int i = 0;
	private int blockW, blockH;
	public Image image;
	private int critterId;
	int xNext; //x and y of the next path point
	int yNext; 
	int xExit; //x and y points of the exit on the map
	int yExit;

	/**
	 * value of critter
	 */
	public int value;
	/**
	 * Actual Health of critter
	 */
	public int actualHealth;
	/**
	 * Current Health of critter
	 */
	public int currentHealth;

	/**
	 * Constructor to initialize the critter with image
	 */
	public BasicCritter() {
		image = new ImageIcon(ApplicationStatics.IMAGE_PATH_MAP_CRITTER1).getImage();
		actualHealth = 10;
		currentHealth = actualHealth;
		value = 10;
	}

	/**
	 * Gets the x co-ordinate for critter
	 */
	@Override
	public int getX() {
		return x;
	}

	/**
	 * Gets the y co-ordinate for critter
	 */
	@Override
	public int getY() {
		return y;
	}

	/**
	 * Get actual health of the critter
	 */
	@Override
	public int getActualHealth() {
		return actualHealth;
	}

	/**
	 * Returns the current health of the critter
	 */
	@Override
	public int getCurrentHealth() {
		return currentHealth;
	}

	/**
	 * Returns critter id
	 */
	@Override
	public int getCritterId() {
		return critterId;
	}

	/**
	 * Calculates the path on which the critter would move
	 */
	@Override
	public boolean calculatePath() {
		
//		 System.out.println("i : "+i+" ,  arraysize : "+ (ApplicationStatics.PATH_ARRAY1.size()-1));
		
		//check if it is the end of the path
			if(i == ApplicationStatics.PATH_ARRAY1.size()-1){
				return false;
			}
			
			//calculate the next x and y coordinates of the next block of the path 
			xNext = ApplicationStatics.PATH_ARRAY1.get(i + 1).y * blockW;
			yNext = ApplicationStatics.PATH_ARRAY1.get(i + 1).x * blockH;
			//calculate the critter movement direction
			directionY = ApplicationStatics.PATH_ARRAY1.get(i + 1).x - ApplicationStatics.PATH_ARRAY1.get(i).x;
			directionX = ApplicationStatics.PATH_ARRAY1.get(i + 1).y - ApplicationStatics.PATH_ARRAY1.get(i).y;
		
			//move to next block when conditions satisfy
			if (directionX == 1 || directionX == -1){
				if( x == xNext){
			//		System.out.println("inside 1 :" + (i++));
					i++;
				}
			}else if(directionX ==0){
				if (directionY == 1 || directionY == -1) {
					if(y==yNext){
			//			System.out.println("inside 2" + (i++));
						i++;
					}
				}
			}
			//increment or decrement the x and y coordinates of the critter
			x += directionX;
			y += directionY;	
		//notify all observers about a change in x and y
		setChanged();
		notifyObservers();
//		System.out.println("inside critter   x : " + x + " , y : " + y);
	
		return true; //successful path calculation

	}

	/**
	 * This method sets the button(blocks) parameters to local variable
	 */
	public void setBlocksParams(int new_w, int new_h) {
		blockW = new_w;
		blockH = new_h;
	//	System.out.println("blockW:"+blockW+" blockH:"+blockH);
	}

	/**
	 * This method returns the image used for the critter
	 */
	@Override
	public Image getCritterImage() {
		return image;
	}


	/**
	 * This method sets the id for the basic critter
	 */
	@Override
	public void setID(int new_id) {
		critterId = new_id;
	}

	/**This method returns the block width
	 * @return the block width
	 */
	public int getBlockW() {
		return blockW;
	}

	/**
	 * This method returns the block height
	 * @return the block height
	 */
	public int getBlockH() {
		return blockH;
	}

	@Override
	public void addListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * This method sets the initial x and y coordinates for the critter
	 */
	@Override
	public void setXY(int new_xEntry, int new_yEntry) {
		// TODO Auto-generated method stub
		x = new_xEntry;
		y = new_yEntry;
	//	System.out.println("myX : "+x+" , myY : "+y);
	}

	/**
	 * This method sets the exit x and y coordinates for the critter
	 */
	@Override
	public void setXYExit(int new_xExit, int new_yExit) {
		// TODO Auto-generated method stub
		xExit = new_xExit;
		yExit = new_yExit;
	}

	@Override
	public boolean decreaseLife(int new_power) {
		// TODO Auto-generated method stub
		currentHealth = currentHealth - new_power;
		if(currentHealth < 0){
			return false;
		}
		return true;
	}
	
	/**
	 * This method returns the money value of a critter when it dies.
	 * @return amount of currency
	 */
	public int getValue(){
		return value;
	}

	/**
	 * This method sets the critter image path to new one
	 */
	@Override
	public void setCritterImage(String new_path) {
		// TODO Auto-generated method stub
		image = new ImageIcon(new_path).getImage();	
	}

}
