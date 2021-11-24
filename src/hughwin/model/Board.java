package hughwin.model;

public class Board {

    private int x;
    private int y;
    private int[][] matrix;

    public Board(int x, int y){
        this.x = x;
        this.y = y;
        this.matrix = new int[x][y];
    }
}
