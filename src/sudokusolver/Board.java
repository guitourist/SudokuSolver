package sudokusolver;

import edu.princeton.cs.algs4.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Board {
    public int[][] grid = new int[9][9];
    public Graph graph;
    private int solveability = 0;

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

    public boolean isEmpty(int[][] grid) {
        for (int row = 0; row < 9; row++){
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] != 0) return false;
            }
        }
        return true;
    }

    public boolean fillGrid(int[][] grid) {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        //Find unfilled cell and fill it.
        for (int i = 0; i < 81; i++) {
            int row = i / 9;
            int col = i % 9;
            if (grid[row][col] == 0) {

                //Shuffle collection
                List<Integer> intList = Arrays.asList(intArray);
                Collections.shuffle(intList);
                Integer[] numbers = intList.toArray(intArray);
                for (int j = 0; j < numbers.length; j++) {

                    //Test Row to see if it contains the value
                    if (!Arrays.asList(grid[row][0], grid[row][1], grid[row][2], grid[row][3], grid[row][4], grid[row][5], grid[row][6], grid[row][7], grid[row][8]).contains(numbers[j])) {

                        //Test Column to see if it contains the value
                        if (!Arrays.asList(grid[0][col],grid[1][col],grid[2][col],grid[3][col],grid[4][col],grid[5][col],grid[6][col],grid[7][col],grid[8][col]).contains(numbers[j])) {

                            //Test squares to see if they contain value
                            int[] testsquare;
                            if (row < 3) {
                                if (col < 3) {
                                    testsquare = testSection(grid, 3, 3, 0, 0);
                                } else if (col < 6){
                                    testsquare = testSection(grid, 3, 6, 0, 3);
                                } else {
                                    testsquare = testSection(grid, 3, 9, 0, 6);
                                }
                            } else if (row < 6){
                                if (col < 3) {
                                    testsquare = testSection(grid, 6, 3, 3, 0);
                                } else if (col < 6) {
                                    testsquare = testSection(grid, 6, 6, 3, 3);
                                } else {
                                    testsquare = testSection(grid, 6, 9, 3, 6);
                                }
                            } else {
                                if (col < 3) {
                                    testsquare = testSection(grid, 9, 3, 6, 0);
                                } else if (col < 6) {
                                    testsquare = testSection(grid, 9, 6, 6, 3);
                                } else {
                                    testsquare = testSection(grid, 9, 9, 6, 6);
                                }
                            }
                            if (!Arrays.asList(testsquare[0], testsquare[1], testsquare[2], testsquare[3], testsquare[4],
                                    testsquare[5], testsquare[6], testsquare[7], testsquare[8]).contains(numbers[j])) {
                                grid[row][col] = numbers[j];
                                if (isFull(grid))
                                    return true;
                                else if (fillGrid(grid))
                                    break;
                            }
                        }
                    }
                }
                    break;
            }
        }
        return false;
    }

    private int[] testSection(int[][] grid, int rowMax, int colMax, int rowMod, int colMod) {

        int[] square = new int[9];
        int count = 0;
        for (int i = rowMod; i < rowMax; i++) {
            for (int j = colMod; j < colMax; j++) {
                square[count] = grid[i][j];
                count++;
            }
        }
        return square;
    }

    public void printGrid(int[][] grid) {
        for(int i = 0; i < 9; i++) {
                System.out.println(Arrays.toString(grid[i]));
        }
    }

    public int[][] getNewGrid(int[][] currentGrid) {
        do {
            currentGrid = createEmptyGrid();
            fillGrid(currentGrid);
        } while (!IsValid.isValidSudoku(currentGrid));
        return currentGrid;
    }

    public int[][] solveGrid(int[][] toBeSolved) {
        for (int i = 0; i < 100000; i++) {
            fillGrid(toBeSolved);
            if (IsValid.isValidSudoku(toBeSolved)) {
                solveability = i;
                return toBeSolved;
            }

        }
        return createEmptyGrid();
    }

    public int[][] removeNumbers(int[][] removeGrid, int difficulty) {
        Set<Integer> set = new HashSet<>();
        for (int r = 0; r < difficulty; r++) {
            set.add(StdRandom.uniform(0, 81));
        }
        for (Integer ii : set) {
            int row = ii / 9;
            int col = ii % 9;
            if (row + col == 8)
                removeGrid[row][col] = 0;
            else {
                removeGrid[row][col] = 0;
                removeGrid[8 - col][8 - row] = 0;
            }

        }
        return removeGrid;
    }

    public int[][] createEmptyGrid() {
        int[][] emptyGrid = new int[9][9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                emptyGrid[row][col] = 0;
            }
        }
        return emptyGrid;
    }

    public void writeGridToFile(int[][] writtenGrid) throws IOException {
        StringBuilder sb = new StringBuilder();
        int count = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(count).append(",").append(writtenGrid[i][j]).append("\n");
                    count++;
                }
            }
        try {
            FileWriter fw = new FileWriter("grid.txt");
            fw.write(sb.toString());
            fw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public int getSolveability() {
        return solveability;
    }

    public String uniqueBoardID(int[][] grid) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                sb.append(grid[row][col]);
            }
        }
        return sb.toString();
    }
}
