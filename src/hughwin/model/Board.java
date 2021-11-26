package hughwin.model;

import hughwin.controller.BoardController;

public class Board {

    private int x;
    private int[][] matrix;

    public Board(int x, BoardController boardController){
        this.x = x;
        this.matrix = new int[x][x];
    }
}
