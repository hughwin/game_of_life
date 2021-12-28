package hughwin.controller;

import hughwin.model.Board;
import hughwin.model.Cell;
import hughwin.view.BoardView;
import hughwin.view.Welcome;

import javax.swing.*;

public class BoardController {

    private final Welcome welcome;
    private Board board;
    private int grid;
    private BoardView boardView;

    public BoardController() {
        this.welcome = new Welcome(this);
    }

    public void startGame(int rowsAndColumns) {
        int cells = (int) ((rowsAndColumns * rowsAndColumns) * .4);
        this.grid = rowsAndColumns;
        this.boardView = new BoardView(rowsAndColumns);
        this.board = new Board(rowsAndColumns, cells, this);
        BoardWorker boardWorker = new BoardWorker();
        boardWorker.execute();
    }

    public void updateBoard(Cell[][] matrix) {
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
        protected Cell[][] doInBackground() throws InterruptedException {
            board.generateInitialCells();
            boardView.updateBoard();
            //noinspection InfiniteLoopStatement
            while (true) {
                boardView.updateBoard();
                board.advanceOneGeneration();
                Thread.sleep(200);
                System.out.println("Advancing");
            }
        }
    }

}
