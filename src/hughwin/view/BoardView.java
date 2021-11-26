package hughwin.view;

import javax.swing.*;
import java.awt.*;

public class BoardView {

    public BoardView(int grid){
        JFrame frame = new JFrame();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(100, 100, (int) dim.getWidth(), (int) dim.getHeight());
        frame.setLocationRelativeTo(null);


        JPanel containerPanel = new JPanel();
        frame.add(containerPanel);
        containerPanel.setLayout(new GridLayout(grid, grid));

        for(int i = 0; i < grid; i++){
            for(int k = 0; k < grid; k++) {
                JPanel square = new JPanel();
                square.setBorder(BorderFactory.createLineBorder(Color.black));
                containerPanel.add(square);
            }
        }
        frame.pack();
        frame.setVisible(true);
    }


}
