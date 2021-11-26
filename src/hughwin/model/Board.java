package hughwin.model;

import hughwin.controller.BoardController;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Board {

    private final int x;
    private final Cell[][] matrix;
    private final Set<Cell> cellSet = new HashSet<>();

    public Board(int gridDimensions, int cells, BoardController boardController) {
        this.x = gridDimensions;
        this.matrix = new Cell[gridDimensions][gridDimensions];
        generateInitialCells(cells);
    }

    public void generateInitialCells(int cells) {
        Random random = new Random();
        for (int i = 0; i < cells; i++) {
            generateUniqueCell();
        }
    }

    public Cell generateUniqueCell() {
        Random random = new Random();
        Cell cell = new Cell(random.nextInt(x), random.nextInt(x));
        if (cellSet.contains(cell)) generateUniqueCell();
        else matrix[cell.getX()][cell.getY()] = cell;
        return cell;
    }

    public Cell[][] getMatrix() {
        return this.matrix;
    }

}
