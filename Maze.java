package yuzrie.javamaze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by yuzrie on 10/7/15.
 * Class Type: Main Class
 *
 */
public class Maze {

    /** Maze Operations and Checks
     * can read map file (.txt)
     * can tokenize required locations
     * has main class
     * instantiates Robot, Tile, Maze
     * has goodBot, badBot, Empty Lot, Obstacle, Home
     * note: map is a 2D array of Tiles
     * */

    // file path (starts from src)
    private static String filePath = "src/yuzrie/javamaze/mazemap.txt";

    // good and bad bots
    private static ArrayList<Robot> badBots = new ArrayList<Robot>();
    private static Robot goodBot;

    // knows the location of each object
    private static int mapWidth, mapHeight;
    private static int start_x, start_y, goal_x, goal_y;
    private static int numBadBot, numObstacles;
    private static String locationBadBots, locationObstacles;
    private static Tile home, obstacles;

    // knows the map of maze
    private static Tile[][] map;
    private MazeGUI gui;

    Maze () {
        readfile();

        System.out.println("Maze constructor working");
        System.out.println("Test coordinate: " + map[3][2].getTileName());
        System.out.println("Test coordinate: " + map[0][19].getTileName());
        System.out.println("Test coordinate: " + map[0][0].getTileName());

        gui = new MazeGUI(this);
    }

    // This file reading technique is very static
    public static void readfile() {
        BufferedReader input;
        try {
            FileReader file = new FileReader(filePath);
            input = new BufferedReader(file);

            // the scanning MUST BE in this order because it scans line by line
            Scanner scan = new Scanner(input);
            mapWidth = Integer.parseInt(scan.nextLine());
            mapHeight = Integer.parseInt(scan.nextLine());
            start_x = Integer.parseInt(scan.nextLine());
            start_y = Integer.parseInt(scan.nextLine());
            goal_x = Integer.parseInt(scan.nextLine());
            goal_y = Integer.parseInt(scan.nextLine());
            numBadBot = Integer.parseInt(scan.nextLine());
            locationBadBots = scan.nextLine();
            numObstacles = Integer.parseInt(scan.nextLine());
            locationObstacles = scan.nextLine();

            // as in Java JDK 8, no need for input.close()
        } catch (IOException e) { e.printStackTrace(); }

        // initialize map elements
        initMap();
    }

    public static void initMap() {
        // initialize map
        map = new Tile[mapHeight][mapWidth];
        for (int row=0; row < mapHeight; row++) {
            for (int col=0; col < mapWidth; col++) {
                // System.out.println(row + " " + col);
                map[row][col] = new Tile();
                /** The Location Coordinate
                 * take note that instead of map(x,y), we do map(y,x)
                 * because we need to go through the row first then col
                 * */
            }
        }

        // initialize goal / home
        home = map[goal_y][goal_x];
        home.setTileName("Home");

        // initialize player location
        goodBot = new Robot(start_x, start_y);

        // tokenize BadBots
        StringTokenizer badBots_token = new StringTokenizer(locationBadBots, ",");
        for(int i=0; i < numBadBot; i++) {
            int pointX = Integer.parseInt(badBots_token.nextToken());
            int pointY = Integer.parseInt(badBots_token.nextToken());
            Robot badBot = new Robot(pointX, pointY);
            badBots.add(badBot);
            //System.out.println(badBots.get(i).getX_coordinate() + " " + badBots.get(i).getY_coordinate());
        }

        // tokenize Obstacles
        StringTokenizer obstacles_token = new StringTokenizer(locationObstacles, ",");
        for (int i=0; i < numObstacles; i++) {
            int pointX = Integer.parseInt(obstacles_token.nextToken());
            int pointY = Integer.parseInt(obstacles_token.nextToken());
            // System.out.println(pointX + " " + pointY);
            obstacles = map[pointY][pointX];
            obstacles.setIsWalkable(false);
            obstacles.setHasObject(true);
            obstacles.setTileName("Obstacles");
            // System.out.println(obstacles.hasObject());
        }
    }

    // Accessor functions


    public static Tile[][] getMap() { return map; }
    public static int getMapWidth() { return mapWidth; }
    public static int getMapHeight() { return mapHeight; }
    public static int getGoal_x() { return goal_x; }
    public static int getGoal_y() { return goal_y; }
    public static Robot getGoodBot() { return goodBot; }
    public static ArrayList<Robot> getBadBots() { return badBots; }

    public static void setGoodBot(Robot goodBot) { Maze.goodBot = goodBot; }
    public static void setBadBots(ArrayList<Robot> badBots) { Maze.badBots = badBots; }

    /** Main class here **/
    public static void main(String[] args) {
        Maze maze = new Maze();
    }
}
