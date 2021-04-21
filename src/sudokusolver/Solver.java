package sudokusolver;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.ST;

public class Solver
{
	private Board board;
	private int[] col = new int[9];
	private int[] row = new int[9];
	private int[][] box = new int[3][3];
	
	public Solver(Board board)
	{
		this.board = board;
		// need to make this immutable and return a copy in board class
		int[][] grid = board.grid;
		
		for (int r = 0; r < 9; ++r)
		{
            for (int c = 0; c < 9; ++c)
            {
                if (grid[r][c] != '0')
                {
                    int x = grid[r][c];
                    col[c] = x;
                    row[r] = x;
                    box[r/3][c/3] = x;
                }
            }
		}
		
		
		
	}
	
	
	
	
    
	
}
