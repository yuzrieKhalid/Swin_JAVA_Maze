package yuzrie.javamaze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        // sets the program on a BorderLayout
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        // create panel holder
        JPanel directionHolder = new JPanel();
        JPanel resetUndoHolder = new JPanel();

        // sets layout for each panel
        directionHolder.setLayout(new GridLayout(3,3));
        resetUndoHolder.setLayout(new GridLayout(4,2));

        // create directional buttons and its function
        JButton directionUp = new JButton("^");
        directionUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Maze.getGoodBot().moveUP(Maze.getMap());

                if (Maze.getGoodBot().outOfBound || Maze.getGoodBot().hasObstacle) {
                    Maze.setEndTurn(true); // will be false after badbots done moving
                }
                else {
                    System.out.println("Goodbot position: (" + Maze.getGoodBot().getX_coordinate() + ", "
                            + Maze.getGoodBot().getY_coordinate() + ")");
                }
                Maze.setEndTurn(true);
                Maze.moveAI();

                // set game over
                if (Maze.getGoodBot().getX_coordinate() == Maze.getGoal_x() && Maze.getGoodBot().getY_coordinate() == Maze.getGoal_y()) {
                    System.out.println("Game Over");
                    Maze.setGameOver(true);
                }
                imagePanel.repaint();
            }
        });
        JButton directionLeft = new JButton("<");
        directionLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Maze.getGoodBot().moveLEFT(Maze.getMap());
                if (Maze.getGoodBot().outOfBound || Maze.getGoodBot().hasObstacle) {
                    Maze.setEndTurn(true); // will be false after badbots done moving
                }
                else {
                    System.out.println("Goodbot position: (" + Maze.getGoodBot().getX_coordinate() + ", "
                            + Maze.getGoodBot().getY_coordinate() + ")");

                }
                Maze.setEndTurn(true);
                Maze.moveAI();

                // set game over
                if (Maze.getGoodBot().getX_coordinate() == Maze.getGoal_x() && Maze.getGoodBot().getY_coordinate() == Maze.getGoal_y()) {
                    System.out.println("Game Over");
                    Maze.setGameOver(true);
                }
                imagePanel.repaint();
            }
        });
        JButton directionRight = new JButton(">");
        directionRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Maze.getGoodBot().moveRIGHT(Maze.getMap());
                if (Maze.getGoodBot().outOfBound || Maze.getGoodBot().hasObstacle) {
                    Maze.setEndTurn(true); // will be false after badbots done moving
                }
                else {
                    System.out.println("Goodbot position: (" + Maze.getGoodBot().getX_coordinate() + ", "
                            + Maze.getGoodBot().getY_coordinate() + ")");
                }
                Maze.setEndTurn(true);
                Maze.moveAI();

                // set game over
                if (Maze.getGoodBot().getX_coordinate() == Maze.getGoal_x() && Maze.getGoodBot().getY_coordinate() == Maze.getGoal_y()) {
                    System.out.println("Game Over");
                    Maze.setGameOver(true);
                }
                imagePanel.repaint();
            }
        });
        JButton directionDown = new JButton("v");
        directionDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Maze.getGoodBot().moveDOWN(Maze.getMap());
                if (Maze.getGoodBot().outOfBound || Maze.getGoodBot().hasObstacle) {
                    Maze.setEndTurn(true); // will be false after badbots done moving
                }
                else {
                    System.out.println("Goodbot position: (" + Maze.getGoodBot().getX_coordinate() + ", "
                            + Maze.getGoodBot().getY_coordinate() + ")");
                }
                Maze.setEndTurn(true);
                Maze.moveAI();

                // set game over
                if (Maze.getGoodBot().getX_coordinate() == Maze.getGoal_x() && Maze.getGoodBot().getY_coordinate() == Maze.getGoal_y()) {
                    System.out.println("Game Over");
                    Maze.setGameOver(true);
                }
                imagePanel.repaint();
            }
        });
        JButton directionStay = new JButton("Stay");
        directionStay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Maze.setEndTurn(true);
                Maze.moveAI();
                imagePanel.repaint();
            }
        });

        // add directional buttons to its panel
        directionHolder.add(new JPanel());  // Grid [1][1]
        directionHolder.add(directionUp);   // Grid [1][2]
        directionHolder.add(new JPanel());  // Grid [1][3]
        directionHolder.add(directionLeft); // Grid [2][1]
        directionHolder.add(directionStay); // Grid [2][2]
        directionHolder.add(directionRight);// Grid [2][3]
        directionHolder.add(new JPanel());  // Grid [3][1]
        directionHolder.add(directionDown); // Grid [3][2]
        directionHolder.add(new JPanel());  // Grid [3][3]

        // create reset and undo buttons
        for (int i = 0; i < 4; i++)
            resetUndoHolder.add(new JPanel());
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Maze.setGameOver(false);
                Maze.initMap();
                imagePanel.repaint();
            }
        });
        JButton undoButton = new JButton("Undo");
        // TODO add a delete latest movement from the previous movement list

        // add reset and undo button to its panel
        resetUndoHolder.add(resetButton);
        resetUndoHolder.add(undoButton);

        // sets west and center panel for Border Layout
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(5,1));
        westPanel.setPreferredSize(new Dimension(220,350));
        westPanel.setMaximumSize(new Dimension(220,350));
        westPanel.add(directionHolder);
        westPanel.add(resetUndoHolder);
        for (int i = 0; i < 3; i++)
            westPanel.add(new JPanel());

        // centerPanel only contains imagePanel so no need to bother
        imagePanel = new ImagePanel(maze);
        JPanel centerPanel = new JPanel();
        centerPanel.add(imagePanel);

        // put each panel into contentPane
        contentPane.add(westPanel, BorderLayout.WEST);
        contentPane.add(centerPanel, BorderLayout.EAST);

        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        this.pack();
    }
}
