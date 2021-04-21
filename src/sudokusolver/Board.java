package sudokusolver;

import edu.princeton.cs.algs4.Graph;

public class Board {
    public int[][] grid = new int[9][9];

    public Board() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                this.grid[row][col] = 0;
            }
        }
    }

    public boolean isFull(int[][] grid) {
        for (int row = 0; row < 9; row++){
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == 0) return false;
            }
        }
        return true;
    }

    public void fillGrid(int[][] grid) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        //Find unfilled cell and fill it.
        for (int i = 1; i < 82; i++) {

        }

        //Check value has/has not been used in row
        //Check value has/has not been used in column
        //Check value has not been used in 3x3 square

    }
}
