package hughwin.controller;

import hughwin.model.Board;
import hughwin.view.BoardView;
import hughwin.view.Welcome;

import javax.swing.*;

public class BoardController {

    private Board board;
    private Welcome welcome;
    private BoardView boardView;

    public BoardController(){
        this.welcome = new Welcome(this);
    }

    public void startGame(int rowsAndColumns, int cells){
        this.board = new Board(rowsAndColumns, this);
        this.boardView = new BoardView(rowsAndColumns);
        System.out.println("Starting game " + rowsAndColumns);
    }


}
