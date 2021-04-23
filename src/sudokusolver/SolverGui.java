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
        InitialBoardPanel.add(lblNewLabel_1, BorderLayout.CENTER);

        //To Print Solved Board
        JLabel lblNewLabel_2 = new JLabel("Print Solved Here");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        SolvedBoardPanel.add(lblNewLabel_2, BorderLayout.CENTER);

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
        return InitialBoardPanel;
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


