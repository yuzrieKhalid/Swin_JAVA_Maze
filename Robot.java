package yuzrie.javamaze;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by yuzrie on 10/7/15.
 * Class Type: Object Class
 */
public class Robot {

    private int x_coordinate;
    private int y_coordinate;
    boolean outOfBound = false;
    boolean hasObstacle = false;
    private List<Point> prevLocation = new ArrayList<Point>();

    Robot (int x_coordinate, int y_coordinate) {
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }

    /** Robot Operation
     * Can get current coordinate
     * Can set current coordinate into prevLocation collection
     * Can move: up, right, down, left
     * Can whether undo is available or not
     * */

    public int getX_coordinate() { return x_coordinate; }

    public int getY_coordinate() { return y_coordinate; }

    public void setPrevLocation() {
        Point newLocation = new Point(x_coordinate, y_coordinate);
        prevLocation.add(newLocation);
    }

    /** Movements **/
    public void moveUP (Tile[][] location) {
        // Check out of bound
        if (y_coordinate - 1 < 0) {
            outOfBound = true;
            return;
        }

        // Check obstacle in the way
        else if (location[y_coordinate-1][x_coordinate].hasObstacle()) {
            hasObstacle = true;
            return;
        }

        // If everything is ok, perform movement
        else
            y_coordinate--;
    }

    public void moveLEFT(Tile[][] location) {
        if (x_coordinate - 1 < 0) {
            outOfBound = true;
            return;
        }

        else if (location[y_coordinate][x_coordinate -1].hasObstacle()) {
            hasObstacle = true;
            return;
        }

        else
            x_coordinate--;
    }

    public void moveDOWN (Tile[][] location) {
        if (y_coordinate + 1 > Maze.getMapHeight()) {
            outOfBound = true;
            return;
        }

        else if (location[y_coordinate+1][x_coordinate].hasObstacle()) {
            hasObstacle = true;
            return;
        }
        else
            y_coordinate++;
    }

    public void moveRIGHT(Tile[][] location) {
        if (x_coordinate + 1 > Maze.getMapWidth()) {
            outOfBound = true;
            return;
        }

        else if (location[y_coordinate][x_coordinate+1].hasObstacle()) {
            hasObstacle = true;
            return;
        }
        else
            x_coordinate++;
    }
}
