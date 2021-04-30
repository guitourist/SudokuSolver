package sudokusolver;

import java.awt.*;
import java.io.IOException;
import java.io.Serial;
import javax.swing.JFrame;

public class MainApp extends JFrame {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 1L;

    static final int EASY = 20;
    static final int MEDIUM = 35;
    static final int HARD = 50;

    /**
     * Launch the application.
     */
    public static void main(String[] args) throws IOException {
    	
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IntroGui frame = new IntroGui();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    	/*
        //Create a board
        Board b = new Board();
        int[][] solved = b.getNewGrid(b.grid);
        b.printGrid(solved);

        System.out.println();

        int[][] unsolved = b.removeNumbers(solved, EASY);
        b.printGrid(unsolved);

        b.writeGridToFile(unsolved);

        System.out.println();

        Board c = new Board();
        c.grid = unsolved;
        c.printGrid(c.solveGrid(c.grid));
		*/
    }
}
