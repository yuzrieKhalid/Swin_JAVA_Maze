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

    // file path (starts from src)
    private static String filePath = "src/yuzrie/javamaze/mazemap.txt";

    // good and bad bots
    private static ArrayList<Robot> badBots = new ArrayList<Robot>();
    private static Robot goodBot;

    // from file declaration
    private static int mapWidth, mapHeight;
    private static int start_x, start_y, goal_x, goal_y;
    private static int numBadBot, numObstacles;
    private static String locationBadBots, locationObstacles;
    private static Tile[][] map;

    Maze () {}

    /** Maze Operations and Checks
     * can read map file (.txt)
     * can tokenize required locations
     * has main class
     * instantiates Robot, Tile, Maze
     * has goodBot, badBot, Empty Lot, Obstacle, Home
     * note: map is a 2D array of Tiles
     * */

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

        // init map
        map = new Tile[mapHeight][mapWidth];
        for (int row = 0; row < mapHeight; row++) {
            for (int col = 0; col < mapWidth; col++) {
                map[row][col] = new Tile();
            }
        }

        // init player location
        goodBot = new Robot(start_x, start_y);

        // tokenize and initialize string containing ','
        tokenization();
    }

    public static void tokenization() {
        // tokenize BadBots
        StringTokenizer badBots_token = new StringTokenizer(locationBadBots, ",");
        for(int i=0; i < numBadBot; i++) {
            int pointX = Integer.parseInt(badBots_token.nextToken());
            int pointY = Integer.parseInt(badBots_token.nextToken());
            Robot badBot = new Robot(pointX, pointY);
            badBots.add(badBot);
        }

        // tokenize Obstacles
        StringTokenizer obstacles_token = new StringTokenizer(locationObstacles, ",");
        for (int i=0; i < numObstacles; i++) {
            int pointX = Integer.parseInt(obstacles_token.nextToken());
            int pointY = Integer.parseInt(obstacles_token.nextToken());
            map[pointX][pointY].setIsWalkable(false);
        }
    }
    /** Main class here **/
    public static void main(String[] args) throws IOException {
        Robot RobotTest = new Robot(2,1);

        readfile();

        System.out.println("-------------TEST------------------");

        System.out.println("Hello I am RobotTest");
        System.out.println("My x coordinate is " + RobotTest.getX_coordinate());
        System.out.println("My y coordinate is " + RobotTest.getY_coordinate());

        System.out.println("-------TEST--------END-------------");

    }
}
