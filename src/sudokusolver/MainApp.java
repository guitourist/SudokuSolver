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
    }
}
