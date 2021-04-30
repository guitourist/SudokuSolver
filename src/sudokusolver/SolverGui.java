package sudokusolver;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SolverGui extends JFrame {

    private JPanel MainPanel;
    private static final long serialVersionUID = 2L;
	private int[][] solved;
	private Board b;
	private int[][] unsolved;
	private Board c;
	private JPanel panelSolved;
	private int[][] completed;
	private JPanel solvedBoardPanel;

    /**
     * Create the frame.
     */
    public SolverGui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 746, 516);
        MainPanel = new JPanel();
        MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        MainPanel.setLayout(new BorderLayout(0, 0));
        setContentPane(MainPanel);

        //Container creation methods
        JPanel MainBackground = createMainBackground();
        JPanel TitleLabel = createTitleLabel(MainBackground);
        createSudokuSolverLabel(TitleLabel);
        JPanel SudokuBoardPanel = createSudokuBoardPanel(MainBackground);
        JPanel InitialBoardPanel = createInitialBoardPanel(SudokuBoardPanel);
        createInitialBoardLabel(InitialBoardPanel);
        JPanel SolvedBoardPanel = createSolvedBoardPanel(SudokuBoardPanel);
        createSolvedBoardLabel(SolvedBoardPanel);

        //To Print Solved Board
        

    }

    private void createSolvedBoardLabel(JPanel SolvedBoardPanel) {
        JLabel SolvedBoardLabel = new JLabel("Solved Board");
        SolvedBoardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        SolvedBoardLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 22));
        SolvedBoardLabel.setHorizontalAlignment(0);
        SolvedBoardPanel.add(SolvedBoardLabel, BorderLayout.NORTH);
    }

    private JPanel createSolvedBoardPanel(JPanel SudokuBoardPanel) {
        solvedBoardPanel = new JPanel();
        solvedBoardPanel.setBorder(new MatteBorder(10, 10, 10, 10, new Color(192, 192, 192)));
        solvedBoardPanel.setPreferredSize(new Dimension(350, 10));
        solvedBoardPanel.setBackground(new Color(119, 136, 153));
        SudokuBoardPanel.add(solvedBoardPanel, BorderLayout.EAST);
        solvedBoardPanel.setLayout(new BorderLayout(0, 0));
        
        JButton btnSolvedPuzzle = new JButton("Solved Puzzle");
        btnSolvedPuzzle.setHorizontalAlignment(SwingConstants.CENTER);
        solvedBoardPanel.add(btnSolvedPuzzle, BorderLayout.SOUTH);
        
        panelSolved = new JPanel();
        solvedBoardPanel.add(panelSolved, BorderLayout.CENTER);
        displaySudokuBoard(panelSolved, nineByNineArrayOfZeros());
        
        btnSolvedPuzzle.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
                panelSolved = new JPanel();
                solvedBoardPanel.add(panelSolved, BorderLayout.CENTER);
                completed = c.solveGrid(c.grid);
        		displaySudokuBoard(panelSolved, completed);
        		
        		panelSolved.setVisible(true);
        		panelSolved.revalidate();
        		panelSolved.repaint();
        	}
        });
        
        return solvedBoardPanel;
    }

    private void createInitialBoardLabel(JPanel InitialBoardPanel) {
        JLabel InitialBoardLabel = new JLabel("Initial Board");
        InitialBoardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        InitialBoardLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 22));
        InitialBoardPanel.add(InitialBoardLabel, BorderLayout.NORTH);
    }

    private JPanel createInitialBoardPanel(JPanel SudokuBoardPanel) {
        JPanel InitialBoardPanel = new JPanel();
        InitialBoardPanel.setBorder(new MatteBorder(10, 10, 10, 10, new Color(192, 192, 192)));
        InitialBoardPanel.setPreferredSize(new Dimension(350, 350));
        InitialBoardPanel.setBackground(new Color(119, 136, 153));
        InitialBoardPanel.setLayout(new BorderLayout(0, 0));
        SudokuBoardPanel.add(InitialBoardPanel, BorderLayout.WEST);
        
        JButton btnNewPuzzle = new JButton("New Puzzle");
        InitialBoardPanel.add(btnNewPuzzle, BorderLayout.SOUTH);
        
        JPanel panelInitial = new JPanel();
        InitialBoardPanel.add(panelInitial, BorderLayout.CENTER);
        
        displaySudokuBoard(panelInitial, nineByNineArrayOfZeros());
        
        btnNewPuzzle.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		b = new Board();
                solved = b.getNewGrid(b.grid);

                unsolved = b.removeNumbers(solved, MainApp.EASY);

                c = new Board();
                c.grid = unsolved;
                
                JPanel panelInitial = new JPanel();
                InitialBoardPanel.add(panelInitial, BorderLayout.CENTER);
        		displaySudokuBoard(panelInitial, unsolved);
        		
                
                panelInitial.revalidate();
                panelInitial.repaint();
                
                panelSolved = new JPanel();
                solvedBoardPanel.add(panelSolved);
                
                displaySudokuBoard(panelSolved, nineByNineArrayOfZeros());
        	}
        });
        
        

        return InitialBoardPanel;
    }
    
    private int[][] nineByNineArrayOfZeros()
    {
    	int[][] output = new int[9][9];
    	
    	for (int i = 0; i < 9; i++)
    	{
    		for (int j = 0; j < 9; j++)
    		{
    			output[i][j] = 0;
    		}
    	}
    	
    	return output;
    }

	private void displaySudokuBoard(JPanel panel, int[][] grid)
	{
		panel.setLayout(new GridLayout(0, 9, 0, 0));
		
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				JLabel lbl;
				if (grid[i][j] == 0)
					lbl = new JLabel("");
				else
					lbl = new JLabel("" + grid[i][j]);
				lbl.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				lbl.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(lbl);
			}
		}
	}

    private JPanel createSudokuBoardPanel(JPanel MainBackground) {
        JPanel SudokuBoardPanel = new JPanel();
        SudokuBoardPanel.setBorder(new MatteBorder(10, 10, 10, 10, new Color(192, 192, 192)));
        SudokuBoardPanel.setBackground(new Color(119, 136, 153));
        SudokuBoardPanel.setLayout(new BorderLayout(0, 0));
        MainBackground.add(SudokuBoardPanel, BorderLayout.CENTER);
        return SudokuBoardPanel;
    }

    private void createSudokuSolverLabel(JPanel TitleLabel) {
        JLabel SudokuSolverLabel = new JLabel("Sudoku Solver");
        SudokuSolverLabel.setForeground(Color.WHITE);
        SudokuSolverLabel.setBackground(Color.WHITE);
        SudokuSolverLabel.setFont(new Font("Mistral", Font.PLAIN, 52));
        TitleLabel.add(SudokuSolverLabel);
    }

    private JPanel createTitleLabel(JPanel MainBackground) {
        JPanel TitleLabel = new JPanel();
        TitleLabel.setBorder(new MatteBorder(10, 10, 10, 10, new Color(192, 192, 192)));
        TitleLabel.setPreferredSize(new Dimension(10, 85));
        TitleLabel.setBackground(new Color(119, 136, 153));
        MainBackground.add(TitleLabel, BorderLayout.NORTH);
        return TitleLabel;
    }

    private JPanel createMainBackground() {
        JPanel MainBackground = new JPanel();
        MainBackground.setBackground(new Color(176, 196, 222));
        MainPanel.add(MainBackground, BorderLayout.CENTER);
        MainBackground.setLayout(new BorderLayout(0, 0));
        return MainBackground;
    }
}
