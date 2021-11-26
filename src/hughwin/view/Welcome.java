package hughwin.view;

import hughwin.controller.BoardController;

import javax.swing.*;
import java.awt.*;

public class Welcome {

    private final String splash = "Welcome to Conway's Game of Life!";
    private final String instructions = "Please select the number rows and columns for the Game of Life. The program will then create a square matrix.";
    private BoardController gameStart;

    public Welcome(BoardController gameStart){

        this.gameStart = gameStart;

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

        NumberInputField rowsField = new NumberInputField("Enter the rows and columns here");
        containerPanel.add(rowsField.getField());

        NumberInputField cellsField = new NumberInputField("Enter the number of starting cells here");
        containerPanel.add(cellsField.getField());

        JPanel buttonsPanel = new JPanel();
        containerPanel.add(buttonsPanel);
        Button startButton = new Button("Start");
        startButton.addActionListener(e -> {
            gameStart.startGame(rowsField.getInteger(), cellsField.getInteger());
            frame.dispose();
        });
        buttonsPanel.add(startButton);

        frame.pack();
        frame.setVisible(true);
    }

}
