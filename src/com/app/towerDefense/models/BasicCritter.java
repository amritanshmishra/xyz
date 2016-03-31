package com.app.towerDefense.models;

import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import com.app.towerDefense.guiComponents.MapPanel;
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
	public int directionX; // decides which direction critter moves
	public int directionY;
	private int i = 0;
	private int blockW, blockH;
	public Image image;
	private int critterId;
	int xNext; // x and y of the next path point
	int yNext;
	int xExit; // x and y points of the exit on the map
	int yExit;
	int speed;
	int actualSpeed;
	Timer timerFreezing;
	String currentPath;
	Timer timerBurning;
	public boolean isDead = false;
	public CritterHealthBar healthBar;
	public boolean showSplashArea;
	Timer timerSplash;

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
		value = 5;
		actualSpeed = 2;
		speed = actualSpeed;
		blockW = ApplicationStatics.BLOCK_WIDTH;
		blockH = ApplicationStatics.BLOCK_HEIGHT;
		timerFreezing = new Timer();
		currentPath = ApplicationStatics.IMAGE_PATH_MAP_CRITTER1;
		timerBurning = new Timer();
		
		healthBar = new CritterHealthBar();
		this.addObserver(healthBar);
		showSplashArea = false;
		timerSplash = new Timer();
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

		// System.out.println("i : "+i+" , arraysize : "+
		// (ApplicationStatics.PATH_ARRAY1.size()-1));

		// check if it is the end of the path
		if (i == ApplicationStatics.PATH_ARRAY1.size() - 1) {
			return false;
		}

		// calculate the next x and y coordinates of the next block of the path
		xNext = ApplicationStatics.PATH_ARRAY1.get(i + 1).y * blockW;
		yNext = ApplicationStatics.PATH_ARRAY1.get(i + 1).x * blockH;
		// calculate the critter movement direction
		directionY = ApplicationStatics.PATH_ARRAY1.get(i + 1).x - ApplicationStatics.PATH_ARRAY1.get(i).x;
		directionX = ApplicationStatics.PATH_ARRAY1.get(i + 1).y - ApplicationStatics.PATH_ARRAY1.get(i).y;

		// move to next block when conditions satisfy
		if (directionX == 1 || directionX == -1) {
			if (x == xNext || x == xNext - 1) {
				// System.out.println("inside 1 :" + (i++));
				i++;
				x = xNext;
			}
		} else if (directionX == 0) {
			if (directionY == 1 || directionY == -1) {
				if (y == yNext || y == yNext - 1) {
					// System.out.println("inside 2" + (i++));
					i++;
					y = yNext;
				}
			}
		}
		// increment or decrement the x and y coordinates of the critter
		x += directionX * speed;
		y += directionY * speed;

		// notify all observers about a change in x and y
		setChanged();
		notifyObservers();
		// System.out.println("inside critter x : " + x + " , y : " + y);

		return true; // successful path calculation

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
		// System.out.println("myX : "+x+" , myY : "+y);
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
		if (currentHealth <= 0) {
			return false;
		}
		currentHealth = currentHealth - new_power;

		return true;
	}

	/**
	 * This method returns the money value of a critter when it dies.
	 * 
	 * @return amount of currency
	 */
	public int getValue() {
		return value;
	}

	/**
	 * This method sets the critter image path to new one
	 */
	@Override
	public void setCritterImage(String new_path) {
		// TODO Auto-generated method stub
		if (ApplicationStatics.IMAGE_PATH_MAP_CRITTER1 == currentPath) {
			image = new ImageIcon(new_path).getImage();
			currentPath = new_path;
		}
	}

	/**
	 * This method returns the critter speed
	 * 
	 * @return speed value
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * This method slows the speed of critter movement
	 */
	public void slowSpeed() {
		speed = 1;
		timerFreezing.schedule(new TimerTask() {
			@Override
			public void run() {
				// Your database code here
				speed = actualSpeed;
				image = new ImageIcon(ApplicationStatics.IMAGE_PATH_MAP_CRITTER1).getImage();
				currentPath = ApplicationStatics.IMAGE_PATH_MAP_CRITTER1;
			}
		}, 1450);

	}

	/**
	 * This method sets the critter speed to original value
	 */
	public void setToNormalSpeed() {
		speed = actualSpeed;
	}

	/**
	 * This method burns the critter for the same amount after taking the damage
	 * from burning tower
	 * 
	 * @param new_amount
	 *            amount health to burn
	 */
	public void burnHealth(final int new_amount) {
		timerFreezing.schedule(new TimerTask() {
			@Override
			public void run() {
				// Your database code here
				if (decreaseLife(new_amount)) {
					System.out.println("critter id:" + critterId + " is burning for -" + new_amount);
				}
				killCritter();
				image = new ImageIcon(ApplicationStatics.IMAGE_PATH_MAP_CRITTER1).getImage();
				currentPath = ApplicationStatics.IMAGE_PATH_MAP_CRITTER1;
			}
		}, 1450);
	}

	@Override
	public boolean killCritter() {
		// TODO Auto-generated method stub
		if (currentHealth <= 0 && !isDead) {
			System.out.println("critter id:" + critterId + " is killed.");
			ApplicationStatics.PLAYERMODEL.addSunCurrency(getValue());
			for (int i = 0; i < MapPanel.critter.size(); i++) {
				if (MapPanel.critter.get(i).getCritterId() == critterId) {
					MapPanel.critter.remove(i);
				}
			}
			isDead = true;
			setChanged();
			notifyObservers();
			return true;
		}
		return false;
	}

	@Override
	public void splashDamage(int new_amount) {
		// TODO Auto-generated method stub

		showSplashArea = true;
		
		timerFreezing.schedule(new TimerTask() {
			@Override
			public void run() {
				// Your database code here
				showSplashArea = false;
			}
		}, 1450);
		
		Ellipse2D ellipse = new Ellipse2D.Double(x - blockW / 2, y - blockH / 2, blockW, blockH);
		for (int i = 0; i < MapPanel.critter.size(); i++) {
			if (ellipse.contains(MapPanel.critter.get(i).getX(), MapPanel.critter.get(i).getY())) {
				if (critterId != MapPanel.critter.get(i).getCritterId()) {
					if (MapPanel.critter.get(i).decreaseLife(new_amount)) {
						System.out.println("critter id:" + MapPanel.critter.get(i).getCritterId()
								+ " hit by splash damage -" + new_amount);
						MapPanel.critter.get(i).killCritter();
					}
				}
			}
		}
	}

	@Override
	public CritterHealthBar getHealthBar() {
		// TODO Auto-generated method stub
		return healthBar;
	}

	@Override
	public boolean getShowSplashArea() {
		// TODO Auto-generated method stub
		return showSplashArea;
	}

}
