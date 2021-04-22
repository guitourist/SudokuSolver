package sudokusolver;

import javax.swing.*;

public class GUI {

    private JPanel OptionPanel;
    private JButton OptionStartScratchButton;
    private JPanel OptionTitlePanel;
    private JLabel OptionTitle;
    private JPanel OptionButtonPanel;
    private JButton randomBoardButton;
    private JButton uploadBoardButton;
    private JButton infoButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().OptionPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


