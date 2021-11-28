package hughwin.controller;

import hughwin.model.Board;
import hughwin.model.Cell;
import hughwin.view.BoardView;
import hughwin.view.Welcome;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;


public class BoardController {

    private final Welcome welcome;
    private Board board;
    private int grid;
    private BoardView boardView;

    public BoardController(){
        this.welcome = new Welcome(this);
    }

    public void startGame(int rowsAndColumns, int cells) {
        this.grid = rowsAndColumns;
        this.boardView = new BoardView(rowsAndColumns);
        this.board = new Board(rowsAndColumns, cells, this);
        System.out.println("Starting game " + rowsAndColumns);
        BoardWorker boardWorker = new BoardWorker();
        boardWorker.execute();
    }

    public void updateBoard(Cell[][] matrix) throws InterruptedException, InvocationTargetException {
        for (int i = 0; i < grid; i++) {
            for (int k = 0; k < grid; k++) {
                if (matrix[i][k] != null) boardView.paintSquareAsCell(i, k);
                else boardView.paintAsEmpty(i, k);
            }
        }
        boardView.updateBoard();
    }

    private class BoardWorker extends SwingWorker<Cell[][], Void> {

        @Override
        protected Cell[][] doInBackground() {
            //noinspection InfiniteLoopStatement
            while (true) {
                board.advanceOneGeneration();
            }
        }
    }

}
