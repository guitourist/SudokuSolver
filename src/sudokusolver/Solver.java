package sudokusolver;

public class Solver
{
	private int[][] grid;
	private int[] col = new int[9];
	private int[] row = new int[9];
	private int[][] box = new int[3][3];
	
	public Solver(Board board)
	{
		grid = board.grid;
		// need to make this immutable and return a copy in board class
	}
	
	public void solveSudoku()
	{
		for (int i = 0; i < 9; ++i)
		{
            for (int j = 0; j < 9; ++j)
            {
                if (grid[i][j] != '0')
                {
                    int x = grid[i][j];
                    col[j] = x;
                    row[i] = x;
                    box[i/3][j/3] = x;
                }
            }
		}
		
		dfs(grid, 0, 0);
	}

	private boolean dfs(int[][] grid, int i, int j)
	{
		if (j == 9) {
            i++;
            j = 0;
        }
        if (i == 9) {
            return true;
        }       
        if (grid[i][j] != '.') {
            return dfs(grid, i, j + 1);
        }
        for (int k = 1; k <= 9; ++k) {
            if (check(k, i, j)) {
                grid[i][j] = (char)(48 + k);
                col[j] = k;
                row[i] = k;
                box[i/3][j/3] = k;
                if (dfs(grid, i, j + 1)) {                  
                    return true;
                }
                grid[i][j] = 0;
                col[j] = 0;
                row[i] = 0;       
                box[i/3][j/3] = 0;
            }
        }
        return false;
	}
	
	private boolean check(int x, int i, int j) {
        return (col[j] != x) && (row[i] != x) && (box[i/3][j/3] != x);
    }    
}
