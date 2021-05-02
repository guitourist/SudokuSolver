package sudokusolver;

import java.awt.*;
import java.io.IOException;
import java.io.Serial;
import javax.swing.JFrame;

public class MainApp extends JFrame {

    public static SolvablePuzzles s;
    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Launch the application.
     */
    public static void main(String[] args) throws IOException {
    	
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IntroGui frame = new IntroGui();
                    frame.setVisible(true);
                    s = new SolvablePuzzles();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
