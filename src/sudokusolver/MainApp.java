package sudokusolver;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class MainApp extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IntroGui frame = new IntroGui();
                    frame.setVisible(true);
                    SolverGui sudoku = new SolverGui();
                    sudoku.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainApp() {

    }
}
