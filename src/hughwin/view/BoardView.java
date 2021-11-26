package hughwin.view;

import javax.swing.*;
import java.awt.*;

public class BoardView {

    private final JPanel[][] squareMatrix;

    public BoardView(int grid) {
        JFrame frame = new JFrame();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
        frame.setLocationRelativeTo(null);


        JPanel containerPanel = new JPanel();
        frame.add(containerPanel);
        containerPanel.setLayout(new GridLayout(grid, grid));
        squareMatrix = new JPanel[grid][grid];

        for (int i = 0; i < grid; i++) {
            for (int k = 0; k < grid; k++) {
                JPanel square = new JPanel();
                square.setBorder(BorderFactory.createLineBorder(Color.black));
                containerPanel.add(square);
                squareMatrix[i][k] = square;
            }
        }
        frame.pack();
        frame.setVisible(true);
    }

    public void paintSquareAsCell(int x, int y) {
        System.out.println("Setting background: " + x + " " + y);
        squareMatrix[x][y].setBackground(Color.black);
    }
}
