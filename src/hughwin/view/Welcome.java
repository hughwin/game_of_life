package hughwin.view;

import hughwin.controller.GameStart;

import javax.swing.*;
import java.awt.*;

public class Welcome {

    private final String splash = "Welcome to Conway's Game of Life!";
    private final String instructions = "Please select the number rows and columns for the Game of Life. The program will then create a square matrix.";
    private RowsAndColumns rowsAndColumns;
    private GameStart gameStart;

    public Welcome(GameStart gameStart){

        this.gameStart = gameStart;
        this.rowsAndColumns = new RowsAndColumns();

        JFrame frame = new JFrame("Conway's Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);

        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.PAGE_AXIS));
        frame.add(containerPanel);

        JPanel splashPanel = new JPanel();
        containerPanel.add(splashPanel);
        JLabel splashHeader = new JLabel("<html><div style='text-align: center;'>" + splash + "</div></html>");
        splashPanel.add(splashHeader);

        JPanel instructionsPanel = new JPanel();
        containerPanel.add(instructionsPanel);
        JLabel instructionsLabel = new JLabel(String.format("<html><body style=\"text-align: justify;  text-justify: inter-word;\">%s</body></html>", instructions));
        instructionsPanel.add(instructionsLabel);

        JPanel settingsPanel = new JPanel();
        containerPanel.add(settingsPanel);
        settingsPanel.add(rowsAndColumns.getField());

        JPanel buttonsPanel = new JPanel();
        containerPanel.add(buttonsPanel);
        Button startButton = new Button("Start");
        startButton.addActionListener(e -> gameStart.startGame(rowsAndColumns.getInteger()));
        buttonsPanel.add(startButton);

        frame.pack();
        frame.setVisible(true);
    }

}
