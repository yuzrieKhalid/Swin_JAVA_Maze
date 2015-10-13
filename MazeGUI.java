package yuzrie.javamaze;

import javax.swing.*;

/**
 * Created by yuzrie on 10/13/15.
 * Class Type JFrame
 * In short, this class provides the GUI
 */
public class MazeGUI extends JFrame {
    private Maze maze;
    private ImagePanel imagePanel;

    public MazeGUI(Maze maze) {
        super("Java RobotMaze");
        this.setSize(850, 650);

        imagePanel = new ImagePanel(maze);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
}
