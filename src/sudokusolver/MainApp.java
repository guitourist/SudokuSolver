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
        
        
        b.fillGrid(b.grid);
        b.printGrid(b.grid);
        System.out.println();
        
        Solver s = new Solver(b);
        s.solveSudoku();
        b.printGrid(s.getGrid());
        System.out.println("Is valid: " + IsValid.isValidSudoku(b.grid));

    }

    public MainApp() {

    }
}
