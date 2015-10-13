package yuzrie.javamaze;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by yuzrie on 10/12/15.
 * Class Type: JPanel
 * This is a class derived from JPanel where it will show
 * the image/map of the maze.
 */
public class ImagePanel extends JPanel {

    // knows the condition of maze
    private Maze maze;

    // the images need to get from lecturer
    Image goodBotImage = Toolkit.getDefaultToolkit().getImage("src/yuzrie/javamaze/goodbot.png");
    Image badBotImage = Toolkit.getDefaultToolkit().getImage("src/yuzrie/javamaze/badbot.png");
    Image homeImage = Toolkit.getDefaultToolkit().getImage("src/yuzrie/javamaze/home.png");
    Image emptySpotImage = Toolkit.getDefaultToolkit().getImage("src/yuzrie/javamaze/grass.png");
    Image obstacleImage = Toolkit.getDefaultToolkit().getImage("src/yuzrie/javamaze/obstacle.png");

    ImagePanel(Maze maze) {
        this.maze = maze;   // initialize the map
        // sets program preferred screen size
        this.setPreferredSize(new Dimension(maze.getMapWidth()*60, maze.getMapHeight()*60));
    }

    @Override
    public void paintComponents(Graphics graphics) {
        // draw maze onto a JPanel
        super.paintComponent(graphics);

        // get and draw map from maze
        Tile[][] map = maze.getMap();
        for (int row = 0; row < maze.getMapWidth(); row++) {
            for (int col = 0; col < maze.getMapHeight(); col++) {
                if (map[row][col].isWalkable())
                    graphics.drawImage(emptySpotImage, row*60, col*60, this);
                else
                    graphics.drawImage(obstacleImage, row*60, col*60, this);
            }
         }

        // get and draw home
        graphics.drawImage(homeImage, maze.getGoal_x(), maze.getGoal_y(), this);

        // get and draw bad bots start position
        ArrayList<Robot> badBots = maze.getBadBots();
        for (Robot badBot : badBots) {
            graphics.drawImage(badBotImage, badBot.getX_coordinate()*60, badBot.getY_coordinate()*60, this);
        }

        // get and draw good bot start position
        graphics.drawImage(goodBotImage, maze.getGoodBot().getX_coordinate()*60, maze.getGoodBot().getY_coordinate()*60, this);
    }
}
