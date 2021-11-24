package hughwin.controller;

import hughwin.model.Board;
import hughwin.view.Welcome;

public class GameStart {

    private Board board;
    private Welcome welcome;

    public GameStart(){

        this.welcome = new Welcome(this);
    }

    public void startGame(int rowsAndColums){
//        this.board = new Board();
        System.out.println("Starting game");
    }


}
