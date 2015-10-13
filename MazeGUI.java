package yuzrie.javamaze;

import javax.swing.*;
import java.awt.*;

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

        // create directional buttons
        JButton directionUp = new JButton("^");
        JButton directionLeft = new JButton("<");
        JButton directionRight = new JButton(">");
        JButton directionDown = new JButton("v");
        JButton directionStay = new JButton("Stay");

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
        JButton undoButton = new JButton("Undo");

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
        contentPane.add(centerPanel, BorderLayout.CENTER);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void updateImagePanel() {
        super.repaint();
    }
}
