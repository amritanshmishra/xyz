package com.app.towerDefense.staticContent;

import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JButton;

import com.app.towerDefense.models.PlayerModel;
import com.app.towerDefense.models.Tower;

/**
 * This class contains all constant, Final and Static variables such as windows
 * width, height of window for main window and child window, titles, menu items
 * names and image paths
 * 
 * @author Sajjad Ashraf
 *
 */
public class ApplicationStatics {

	// Game Statistics
	public static final int WINDOW_WIDTH = 840;
	public static final int WINDOW_HEIGHT = (int) WINDOW_WIDTH / 12 * 9;

	public static final int CHILD_POPUP_WINDOW_WIDTH = (int) WINDOW_WIDTH - 100;
	public static final int CHILD_POPUP_WINDOW_HEIGHT = (int) WINDOW_HEIGHT - 100;

	// Map variables
	public static JButton[][] MAP_BUTTONS;
	public static boolean SET_TOWER_DESCR_VISIBLE = false;
	public static int CURRENT_SELECTED_TOWER = 0;
	public static Tower[] TOWER_MODELS = new Tower[4];
	public static PlayerModel PLAYERMODEL;
	public static boolean HAS_BOUGHT_TOWER = false;
	public static boolean START_WAVE = false;
	public static ArrayList<Integer> PATH_ARRAY = new ArrayList<Integer>();
	public static ArrayList<Point> PATH_ARRAY1;
	public static String MAP_ROUT_PATH;
	public static String MAP_PATH_BOUNDARY_BUTTONS_NAME = "";

	/*
	 * public static final int MAP_ENTRY_POINT=1; public static final int
	 * MAP_EXIT_POINT=900; public static final int MAP_PATH_POINT=1; public
	 * static final int MAP_Scenery_POINT=0;
	 */

	public static final int MAP_ENTRY_POINT = 2;
	public static final int MAP_EXIT_POINT = 3;
	public static final int MAP_PATH_POINT = 1;
	public static final int MAP_Scenery_POINT = 0;

	// Window Titles
	public static final String TITLE_MAP_EDITOR = "MAP EDITOR";
	public static final String MAP_MODE_CREATE = "(CREATE)";
	public static final String MAP_MODE_OPEN = "(OPEN)";

	// MENU Related Items
	public static final String MENU_FILE = "FILE";
	public static final String MENU_HELP = "HELP";
	public static final String MENU_ITEM_PLAY = "PLAY";
	public static final String MENU_ITEM_CREATE_MAP = "CREATE MAP";
	public static final String MENU_ITEM_OPEN_MAP = "OPEN_MAP";
	public static final String MENU_ITEM_ABOUT = "ABOUT";
	public static final String MENU_ITEM_SAVE = "SAVE";
	public static final String MENU_ITEM_EXIT = "EXIT";

	// -- Images Paths
	public static final String IMAGE_PATH_GAME_BK = "images/gameBk.png";
	public static final String IMAGE_PATH_MAP_ENTRY = "images/mapEntry.png";
	public static final String IMAGE_PATH_MAP_EXIT = "images/mapExit.png";
	public static final String IMAGE_PATH_MAP_ROUTE = "images/mapRouteGreen.png";
	public static final String IMAGE_PATH_MAP_SCENERY = "images/mapSceneryGreen.png";
	public static final String IMAGE_PATH_MAP_CRITTER1 = "images/critter1.gif";
	public static final String IMAGE_PATH_MAP_SUN = "images/sun.png";
	public static final String IMAGE_PATH_MAP_TOWER1 = "images/tower1.png";
	public static final String IMAGE_PATH_MAP_TOWER2 = "images/tower2.png";
	public static final String IMAGE_PATH_MAP_TOWER3 = "images/tower3.png";
	public static final String IMAGE_PATH_MAP_TOWER4 = "images/tower4.png";
	public static final String IMAGE_PATH_MAP_TOWER5 = "images/tower5.png";
	public static final String IMAGE_PATH_MAP_BUTTONYELLOW = "images/button_yellow.png";
	public static final String IMAGE_PATH_CRITTER="images/critter1.gif";
}
