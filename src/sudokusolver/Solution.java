package sudokusolver;

import edu.princeton.cs.algs4.DepthFirstSearch;
import edu.princeton.cs.algs4.SymbolGraph;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;

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



//	private boolean dfs(int[][] dfsgrid, int r, int c)
//	{
//		if (c == 9) {
//            r++;
//            c = 0;
//        }
//        if (r == 9) {
//            return true;
//        }
//        if (dfsgrid[r][c] != 0) {
//            return dfs(dfsgrid, r, c + 1);
//        }
//        for (int i = 1; i <= 9; ++i) {
//            if (check(i, r, c)) {
//                dfsgrid[r][c] = i;
//                col[c] = i;
//                row[r] = i;
//                box[r/3][c/3] = i;
//                if (dfs(dfsgrid, r, c + 1)) {
//                    return true;
//                }
//                dfsgrid[r][c] = 0;
//                col[c] = 0;
//                row[r] = 0;
//                box[r/3][c/3] = 0;
//            }
//        }
//        return false;
//	}

    public int[][] getGrid()
    {
        return grid;
    }

//    public void solveSudokuWithGraph(String filename, Point p) {
//	    SymbolGraph sg = createGraph(filename);
//        DepthFirstSearch dfs = new DepthFirstSearch(sg.graph(), grid[p.x][p.y]);
//        for (Integer i : sg.graph().adj(grid[p.x][p.y])) {
//            if (sg.nameOf(i))
//
//
//        }
//    }

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
