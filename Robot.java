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
    private List<Point> prevLocation = new ArrayList<Point>();

    Robot (int x_coordinate, int y_coordinate) {
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }

    /** Robot Operation
     * Can move: up, right, down, left
     * Can whether undo is available or not
     * Can get current coordinate
     * Can set current coordinate into prevLocation collection
     * */

    public int getX_coordinate() { return x_coordinate; }

    public int getY_coordinate() { return y_coordinate; }

    public void setPrevLocation() {
        Point newLocation = new Point(x_coordinate, y_coordinate);
        prevLocation.add(newLocation);
    }
}
