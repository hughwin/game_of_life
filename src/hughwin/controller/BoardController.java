package hughwin.controller;

import hughwin.model.Board;
import hughwin.model.Cell;
import hughwin.view.BoardView;
import hughwin.view.Welcome;


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
        this.board = new Board(rowsAndColumns, cells, this);
        this.boardView = new BoardView(rowsAndColumns);
        System.out.println("Starting game " + rowsAndColumns);
        updateBoard(board.getMatrix());
    }

    public void updateBoard(Cell[][] matrix) {
        for (int i = 0; i < grid; i++) {
            for (int k = 0; k < grid; k++) {
                if (matrix[i][k] != null) boardView.paintSquareAsCell(i, k);
            }
        }
    }

}
