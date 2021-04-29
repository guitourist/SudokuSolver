package sudokusolver;

import java.io.Serial;
import java.util.Arrays;
import javax.swing.JFrame;

public class MainApp extends JFrame {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 1L;

    private static final int EASY = 20;
    private static final int MEDIUM = 35;
    private static final int HARD = 50;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    IntroGui frame = new IntroGui();
//                    frame.setVisible(true);
//                    SolverGui sudoku = new SolverGui();
//                    sudoku.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
        Board b = new Board();
        int[][] solved = b.getNewGrid(b.grid);
        b.printGrid(solved);

        System.out.println();

        int[][] unsolved = b.removeNumbers(solved, EASY);
        b.printGrid(unsolved);

    }
}
