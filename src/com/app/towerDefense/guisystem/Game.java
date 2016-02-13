package com.app.towerDefense.guisystem;

public class Game{
	
	public static final int WIDTH = 840, HEIGHT = WIDTH / 12 * 10; //height = 630
	
// GAME Constructor	
	public Game(){
		
		new GameWindow(WIDTH, HEIGHT, "Tower Defence Game by \"Team 5\".", this);

	}
	
	public void start(){
	
	}
	
// MAIN Function	
	public static void main(String args[]){
		new Game();
	}
	
	
// END
}
