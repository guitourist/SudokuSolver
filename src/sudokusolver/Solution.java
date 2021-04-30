package sudokusolver;

import edu.princeton.cs.algs4.SymbolGraph;
import java.awt.*;

public class Solution
{
	private int[][] grid;
	private int[] row = new int[9];
	private int[] col = new int[9];
	private int[][] box = new int[3][3];

	public Solution(Board board) {
	    this.grid = board.grid;
    }
	
	public void solveSudoku() {
		//Fill column, row, and box arrays with
	    for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++){
			    if (grid[r][c] != 0) {
			        int x = grid[r][c];
			        col[c] = x;
                    row[r] = x;
                    box[r/3][c/3] = x;
                }
            }
        }
        //dfs(grid, 0, 0);
    }


    public int[][] getGrid()
    {
        return grid;
    }

    public void printGraph(SymbolGraph sg) {
	    for (Integer i : sg.graph().adj(0)) {
            System.out.println(sg.nameOf(i));
        }
    }

    public Point returnFirstFilledCell(int[][] findcell) {
	    for (int i = 0; i < 9; i++) {
	        for (int j = 0; j < 9; j++) {
	            if (findcell[i][j] != 0) {
	                return new Point(i, j);
                }
            }
        }
	    return null;
    }

    public SymbolGraph createGraph(String filename) {
        return new SymbolGraph(filename, ",");
    }
}
