package hughwin.view;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

import static javax.swing.SwingUtilities.invokeAndWait;
import static javax.swing.SwingUtilities.invokeLater;

public class BoardView {

    private final JPanel[][] squareMatrix;
    private final JPanel containerPanel;

    public BoardView(int grid) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
        frame.setLocationRelativeTo(null);


        JPanel containerPanel = new JPanel();
        this.containerPanel = containerPanel;
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
        invokeLater(() -> squareMatrix[x][y].setBackground(Color.black));
    }

    public void paintAsEmpty(int x, int y) {
        invokeLater(() -> squareMatrix[x][y].setBackground(Color.white));
    }

    public void updateBoard() {
        try {
            invokeAndWait(containerPanel::repaint);
        } catch (InterruptedException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
