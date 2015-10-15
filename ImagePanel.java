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
    Tile[][] map = maze.getMap();

    private static int TILE_DIMENS = 30;

    // the images need to get from lecturer
    Image goodBotImage = Toolkit.getDefaultToolkit().getImage("src/yuzrie/javamaze/goodbot.png");
    Image badBotImage = Toolkit.getDefaultToolkit().getImage("src/yuzrie/javamaze/badbot.png");
    Image homeImage = Toolkit.getDefaultToolkit().getImage("src/yuzrie/javamaze/home.png");
    Image emptySpotImage = Toolkit.getDefaultToolkit().getImage("src/yuzrie/javamaze/grass.png");
    Image obstacleImage = Toolkit.getDefaultToolkit().getImage("src/yuzrie/javamaze/obstacle.png");

    ImagePanel(Maze maze) {
        this.maze = maze;   // initialize the map
        // sets image panel preferred screen size
        this.setPreferredSize(new Dimension(Maze.getMapWidth()*TILE_DIMENS, Maze.getMapHeight()*TILE_DIMENS));
    }

    @Override
    public void paintComponent(Graphics graphics) {
        // draw maze onto a JPanel
        super.paintComponent(graphics);

        // paint the empty spot and obstacles
        for (int row = 0; row < Maze.getMapWidth(); row++) {
            for (int col = 0; col < Maze.getMapHeight(); col++) {
                if (map[col][row].isWalkable())
                    graphics.drawImage(emptySpotImage, row*TILE_DIMENS, col*TILE_DIMENS, this);
                else
                    graphics.drawImage(obstacleImage, row*TILE_DIMENS, col*TILE_DIMENS, this);
            }
        }

        // paint home
        graphics.drawImage(homeImage, maze.getGoal_x()*TILE_DIMENS, maze.getGoal_y()*TILE_DIMENS, this);

        // get and draw bad bots start position
        ArrayList<Robot> badBots = maze.getBadBots();
        for (Robot badBot : badBots) {
            graphics.drawImage(badBotImage, badBot.getX_coordinate()*TILE_DIMENS, badBot.getY_coordinate()*TILE_DIMENS, this);
        }

        // get and draw good bot start position
        graphics.drawImage(goodBotImage, maze.getGoodBot().getX_coordinate()*TILE_DIMENS,
                maze.getGoodBot().getY_coordinate()*TILE_DIMENS, this);

    }
}
