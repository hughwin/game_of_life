package hughwin.model;

import hughwin.controller.BoardController;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Board {

    private final int gridDimensions;
    private final int cells;
    private final Set<Cell> cellSet = new HashSet<>();
    private final BoardController boardController;
    private Cell[][] matrix;

    public Board(int gridDimensions, int cells, BoardController boardController) {
        this.gridDimensions = gridDimensions;
        this.cells = cells;
        this.matrix = new Cell[gridDimensions][gridDimensions];
        this.boardController = boardController;
    }

    public void generateInitialCells() {
        for (int i = 0; i < cells; i++) {
            generateUniqueCell();
        }
    }

    public Cell generateUniqueCell() {
        Random random = new Random();
        Cell cell = new Cell(random.nextInt(gridDimensions), random.nextInt(gridDimensions));
        if (cellSet.contains(cell)) generateUniqueCell();
        else {
            matrix[cell.getX()][cell.getY()] = cell;
            cellSet.add(cell);
        }
        return cell;
    }

    public void advanceOneGeneration() {
        Cell[][] nextGen = new Cell[gridDimensions][gridDimensions];
        for (int i = 0; i < gridDimensions; i++) {
            for (int j = 0; j < gridDimensions; j++) {
                int livingNeighbours = calculateLivingNeighbors(i, j);
                if (matrix[i][j] != null && (livingNeighbours > 3 || livingNeighbours < 2)) nextGen[i][j] = null;
                else if (matrix[i][j] != null) {
                    nextGen[i][j] = new Cell(i, j);
                } else if (matrix[i][j] == null && (livingNeighbours == 3)) nextGen[i][j] = new Cell(i, j);
            }
        }
        boardController.updateBoard(nextGen);
        matrix = nextGen;
    }

    private int calculateLivingNeighbors(int i, int j) {
        int liveCount = 0;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                // check for boundary conditions
                if (i + x < 0 || i + x > (this.gridDimensions - 1) || y + j < 0 || y + j > (this.gridDimensions - 1)) {
                    continue;
                }
                if (matrix[i + x][y + j] != null) liveCount++;
            }
        }

        // remove since we may have counted ourselves
        if (matrix[i][j] != null) liveCount--;
        System.out.println(liveCount);
        return liveCount;
    }

}
