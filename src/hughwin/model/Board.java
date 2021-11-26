package hughwin.model;

import hughwin.controller.BoardController;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Board implements Runnable {

    private final int x;
    private final Cell[][] matrix;
    private final Set<Cell> cellSet = new HashSet<>();
    private final BoardController boardController;

    public Board(int gridDimensions, int cells, BoardController boardController) {
        this.x = gridDimensions;
        this.matrix = new Cell[gridDimensions][gridDimensions];
        this.boardController = boardController;
        generateInitialCells(cells);
    }

    public void generateInitialCells(int cells) {
        for (int i = 0; i < cells; i++) {
            generateUniqueCell();
        }
    }

    public Cell generateUniqueCell() {
        Random random = new Random();
        Cell cell = new Cell(random.nextInt(x), random.nextInt(x));
        if (cellSet.contains(cell)) generateUniqueCell();
        else {
            matrix[cell.getX()][cell.getY()] = cell;
            cellSet.add(cell);
        }
        return cell;
    }

    public Cell[][] generateCell(int x, int y, Cell[][] clonedMatrix) {
        Cell cell = new Cell(x, y);
        cellSet.add(cell);
        clonedMatrix[x][y] = cell;
        return clonedMatrix;
    }

    public Cell[][] removeCell(int x, int y, Cell[][] clonedMatrix) {
        Cell cell = new Cell(x, y);
        cellSet.remove(cell);
        clonedMatrix[x][y] = null;
        return clonedMatrix;
    }

    public Cell[][] getMatrix() {
        return this.matrix;
    }

    public void advanceOneGeneration() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (matrix[i][j] == null) matrix[i][j] = new Cell(i, j);
                else matrix[i][j] = null;
            }
        }
        boardController.updateBoard(matrix);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            advanceOneGeneration();
        }
    }
}
