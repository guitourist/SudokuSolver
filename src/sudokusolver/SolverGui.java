package sudokusolver;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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

public class SolverGui extends JFrame {

    private JPanel MainPanel;
    private static final long serialVersionUID = 2L;

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

        //To Print Initial Board
        JLabel lblNewLabel_1 = new JLabel("Print Initial Here");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        InitialBoardPanel.add(lblNewLabel_1, BorderLayout.SOUTH);

        //To Print Solved Board
        JLabel lblNewLabel_2 = new JLabel("Print Solved Here");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        SolvedBoardPanel.add(lblNewLabel_2, BorderLayout.SOUTH);

    }

    private void createSolvedBoardLabel(JPanel SolvedBoardPanel) {
        JLabel SolvedBoardLabel = new JLabel("Solved Board");
        SolvedBoardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        SolvedBoardLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 22));
        SolvedBoardLabel.setHorizontalAlignment(0);
        SolvedBoardPanel.add(SolvedBoardLabel, BorderLayout.NORTH);
    }

    private JPanel createSolvedBoardPanel(JPanel SudokuBoardPanel) {
        JPanel SolvedBoardPanel = new JPanel();
        SolvedBoardPanel.setBorder(new MatteBorder(10, 10, 10, 10, new Color(192, 192, 192)));
        SolvedBoardPanel.setPreferredSize(new Dimension(350, 10));
        SolvedBoardPanel.setBackground(new Color(119, 136, 153));
        SudokuBoardPanel.add(SolvedBoardPanel, BorderLayout.EAST);
        SolvedBoardPanel.setLayout(new BorderLayout(0, 0));
        
     // this 2d array is only for testing
        int[][] testGrid = new int[9][9];
        for (int i = 0; i < 9; i++)
        {
        	for (int j = 0; j < 9; j++)
        	{
        		testGrid[i][j] = Integer.parseInt("" + i + j);
        	}
        }
        
        JPanel panelSolved = new JPanel();
        displaySudokuBoard(panelSolved, testGrid);
        SolvedBoardPanel.add(panelSolved, BorderLayout.CENTER);
        
        return SolvedBoardPanel;
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
        
        // this 2d array is only for testing
        int[][] testGrid = new int[9][9];
        for (int i = 0; i < 9; i++)
        {
        	for (int j = 0; j < 9; j++)
        	{
        		testGrid[i][j] = Integer.parseInt("" + i + j);
        	}
        }
        
        JPanel panelInitial = new JPanel();
        displaySudokuBoard(panelInitial, testGrid);
        InitialBoardPanel.add(panelInitial, BorderLayout.CENTER);

        return InitialBoardPanel;
    }

	private void displaySudokuBoard(JPanel panel, int[][] grid)
	{
		panel.setLayout(new GridLayout(0, 9, 0, 0));
		
		JLabel lbl00 = new JLabel("" + grid[0][0]);
		lbl00.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl00.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl00);
		JLabel lbl01 = new JLabel("" + grid[0][1]);
		lbl01.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl01.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl01);
		JLabel lbl02 = new JLabel("" + grid[0][2]);
		lbl02.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl02.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl02);
		JLabel lbl03 = new JLabel("" + grid[0][3]);
		lbl03.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl03.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl03);
		JLabel lbl04 = new JLabel("" + grid[0][4]);
		lbl04.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl04.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl04);
		JLabel lbl05 = new JLabel("" + grid[0][5]);
		lbl05.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl05.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl05);
		JLabel lbl06 = new JLabel("" + grid[0][6]);
		lbl06.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl06.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl06);
		JLabel lbl07 = new JLabel("" + grid[0][7]);
		lbl07.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl07.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl07);
		JLabel lbl08 = new JLabel("" + grid[0][8]);
		lbl08.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl08.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl08);
		
		JLabel lbl10 = new JLabel("" + grid[1][0]);
		lbl10.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl10.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl10);
		JLabel lbl11 = new JLabel("" + grid[1][1]);
		lbl11.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl11.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl11);
		JLabel lbl12 = new JLabel("" + grid[1][2]);
		lbl12.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl12.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl12);
		JLabel lbl13 = new JLabel("" + grid[1][3]);
		lbl13.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl13.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl13);
		JLabel lbl14 = new JLabel("" + grid[1][4]);
		lbl14.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl14.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl14);
		JLabel lbl15 = new JLabel("" + grid[1][5]);
		lbl15.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl15.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl15);
		JLabel lbl16 = new JLabel("" + grid[1][6]);
		lbl16.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl16.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl16);
		JLabel lbl17 = new JLabel("" + grid[1][7]);
		lbl17.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl17.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl17);
		JLabel lbl18 = new JLabel("" + grid[1][8]);
		lbl18.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl18.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl18);
		
		JLabel lbl20 = new JLabel("" + grid[2][0]);
		lbl20.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl20.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl20);
		JLabel lbl21 = new JLabel("" + grid[2][1]);
		lbl21.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl21.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl21);
		JLabel lbl22 = new JLabel("" + grid[2][2]);
		lbl22.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl22.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl22);
		JLabel lbl23 = new JLabel("" + grid[2][3]);
		lbl23.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl23.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl23);
		JLabel lbl24 = new JLabel("" + grid[2][4]);
		lbl24.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl24.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl24);
		JLabel lbl25 = new JLabel("" + grid[2][5]);
		lbl25.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl25.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl25);
		JLabel lbl26 = new JLabel("" + grid[2][6]);
		lbl26.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl26.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl26);
		JLabel lbl27 = new JLabel("" + grid[2][7]);
		lbl27.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl27.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl27);
		JLabel lbl28 = new JLabel("" + grid[2][8]);
		lbl28.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl28.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl28);
		
		JLabel lbl30 = new JLabel("" + grid[3][0]);
		lbl30.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl30.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl30);
		JLabel lbl31 = new JLabel("" + grid[3][1]);
		lbl31.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl31.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl31);
		JLabel lbl32 = new JLabel("" + grid[3][2]);
		lbl32.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl32.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl32);
		JLabel lbl33 = new JLabel("" + grid[3][3]);
		lbl33.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl33.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl33);
		JLabel lbl34 = new JLabel("" + grid[3][4]);
		lbl34.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl34.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl34);
		JLabel lbl35 = new JLabel("" + grid[3][5]);
		lbl35.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl35.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl35);
		JLabel lbl36 = new JLabel("" + grid[3][6]);
		lbl36.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl36.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl36);
		JLabel lbl37 = new JLabel("" + grid[3][7]);
		lbl37.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl37.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl37);
		JLabel lbl38 = new JLabel("" + grid[3][8]);
		lbl38.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl38.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl38);
		
		JLabel lbl40 = new JLabel("" + grid[4][0]);
		lbl40.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl40.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl40);
		JLabel lbl41 = new JLabel("" + grid[4][1]);
		lbl41.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl41.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl41);
		JLabel lbl42 = new JLabel("" + grid[4][2]);
		lbl42.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl42.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl42);
		JLabel lbl43 = new JLabel("" + grid[4][3]);
		lbl43.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl43.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl43);
		JLabel lbl44 = new JLabel("" + grid[4][4]);
		lbl44.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl44.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl44);
		JLabel lbl45 = new JLabel("" + grid[4][5]);
		lbl45.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl45.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl45);
		JLabel lbl46 = new JLabel("" + grid[4][6]);
		lbl46.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl46.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl46);
		JLabel lbl47 = new JLabel("" + grid[4][7]);
		lbl47.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl47.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl47);
		JLabel lbl48 = new JLabel("" + grid[4][8]);
		lbl48.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl48.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl48);
		
		JLabel lbl50 = new JLabel("" + grid[5][0]);
		lbl50.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl50.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl50);
		JLabel lbl51 = new JLabel("" + grid[5][1]);
		lbl51.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl51.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl51);
		JLabel lbl52 = new JLabel("" + grid[5][2]);
		lbl52.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl52.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl52);
		JLabel lbl53 = new JLabel("" + grid[5][3]);
		lbl53.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl53.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl53);
		JLabel lbl54 = new JLabel("" + grid[5][4]);
		lbl54.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl54.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl54);
		JLabel lbl55 = new JLabel("" + grid[5][5]);
		lbl55.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl55.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl55);
		JLabel lbl56 = new JLabel("" + grid[5][6]);
		lbl56.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl56.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl56);
		JLabel lbl57 = new JLabel("" + grid[5][7]);
		lbl57.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl57.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl57);
		JLabel lbl58 = new JLabel("" + grid[5][8]);
		lbl58.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl58.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl58);
		
		JLabel lbl60 = new JLabel("" + grid[6][0]);
		lbl60.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl60.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl60);
		JLabel lbl61 = new JLabel("" + grid[6][1]);
		lbl61.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl61.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl61);
		JLabel lbl62 = new JLabel("" + grid[6][2]);
		lbl62.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl62.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl62);
		JLabel lbl63 = new JLabel("" + grid[6][3]);
		lbl63.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl63.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl63);
		JLabel lbl64 = new JLabel("" + grid[6][4]);
		lbl64.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl64.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl64);
		JLabel lbl65 = new JLabel("" + grid[6][5]);
		lbl65.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl65.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl65);
		JLabel lbl66 = new JLabel("" + grid[6][6]);
		lbl66.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl66.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl66);
		JLabel lbl67 = new JLabel("" + grid[6][7]);
		lbl67.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl67.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl67);
		JLabel lbl68 = new JLabel("" + grid[6][8]);
		lbl68.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl68.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl68);
		
		JLabel lbl70 = new JLabel("" + grid[7][0]);
		lbl70.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl70.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl70);
		JLabel lbl71 = new JLabel("" + grid[7][1]);
		lbl71.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl71.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl71);
		JLabel lbl72 = new JLabel("" + grid[7][2]);
		lbl72.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl72.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl72);
		JLabel lbl73 = new JLabel("" + grid[7][3]);
		lbl73.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl73.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl73);
		JLabel lbl74 = new JLabel("" + grid[7][4]);
		lbl74.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl74.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl74);
		JLabel lbl75 = new JLabel("" + grid[7][5]);
		lbl75.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl75.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl75);
		JLabel lbl76 = new JLabel("" + grid[7][6]);
		lbl76.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl76.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl76);
		JLabel lbl77 = new JLabel("" + grid[7][7]);
		lbl77.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl77.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl77);
		JLabel lbl78 = new JLabel("" + grid[7][8]);
		lbl78.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl78.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl78);
		
		JLabel lbl80 = new JLabel("" + grid[8][0]);
		lbl80.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl80.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl80);
		JLabel lbl81 = new JLabel("" + grid[8][1]);
		lbl81.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl81.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl81);
		JLabel lbl82 = new JLabel("" + grid[8][2]);
		lbl82.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl82.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl82);
		JLabel lbl83 = new JLabel("" + grid[8][3]);
		lbl83.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl83.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl83);
		JLabel lbl84 = new JLabel("" + grid[8][4]);
		lbl84.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl84.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl84);
		JLabel lbl85 = new JLabel("" + grid[8][5]);
		lbl85.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl85.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl85);
		JLabel lbl86 = new JLabel("" + grid[8][6]);
		lbl86.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl86.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl86);
		JLabel lbl87 = new JLabel("" + grid[8][7]);
		lbl87.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl87.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl87);
		JLabel lbl88 = new JLabel("" + grid[8][8]);
		lbl88.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		lbl88.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl88);
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
