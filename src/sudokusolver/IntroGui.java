package sudokusolver;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroGui extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel MainPanel;

    /**
     * Create the frame.
     */
    public IntroGui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 382, 468);
        MainPanel = new JPanel();
        MainPanel.setBackground(new Color(176, 196, 222));
        MainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        MainPanel.setLayout(new BorderLayout(0, 0));
        setContentPane(MainPanel);

        //Container Creation
        JPanel TitlePanel = createTitlePanel();
        createTitleLabel(TitlePanel);
        JPanel buttonPanel = createButtonPanel();
        createEasyButton(buttonPanel);
        createMediumButton(buttonPanel);
        createHardButton(buttonPanel);
        createInfoButton(buttonPanel);
    }

    private void createInfoButton(JPanel buttonPanel) {
        JButton btnInfo = new JButton("Info");
        btnInfo.setForeground(Color.WHITE);
        btnInfo.setFont(new Font("Segoe UI Light", Font.PLAIN, 29));
        btnInfo.setBorderPainted(false);
        btnInfo.setBackground(SystemColor.controlDkShadow);
        btnInfo.setBounds(33, 227, 271, 48);
        buttonPanel.add(btnInfo);
    }

    private void createHardButton(JPanel buttonPanel) {
        JButton btnHard = new JButton("Hard");
        btnHard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SolverGui s = new SolverGui();
                s.setDifficulty(22);
                s.setVisible(true);
            }
        });
        btnHard.setForeground(Color.WHITE);
        btnHard.setFont(new Font("Segoe UI Light", Font.PLAIN, 29));
        btnHard.setBorderPainted(false);
        btnHard.setBackground(SystemColor.controlDkShadow);
        btnHard.setBounds(33, 163, 271, 48);
        buttonPanel.add(btnHard);
    }

    private void createMediumButton(JPanel buttonPanel) {
        JButton btnMedium = new JButton("Medium");
        btnMedium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SolverGui s = new SolverGui();
                s.setDifficulty(16);
                s.setVisible(true);
            }
        });
        btnMedium.setForeground(Color.WHITE);
        btnMedium.setFont(new Font("Segoe UI Light", Font.PLAIN, 29));
        btnMedium.setBorderPainted(false);
        btnMedium.setBackground(SystemColor.controlDkShadow);
        btnMedium.setBounds(33, 99, 271, 48);
        buttonPanel.add(btnMedium);
    }

    private void createEasyButton(JPanel buttonPanel) {
        JButton btnEasy = new JButton("Easy");
        btnEasy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SolverGui s = new SolverGui();
                s.setDifficulty(10);
                s.setVisible(true);
            }
        });
        btnEasy.setForeground(new Color(255, 255, 255));
        btnEasy.setBorderPainted(false);
        btnEasy.setBackground(new Color(105, 105, 105));
        btnEasy.setFont(new Font("Segoe UI Light", Font.PLAIN, 29));
        btnEasy.setBounds(33, 34, 271, 48);
        buttonPanel.add(btnEasy);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = 	new JPanel();
        buttonPanel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(192, 192, 192)));
        buttonPanel.setBackground(new Color(112, 128, 144));
        MainPanel.add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(null);
        return buttonPanel;
    }

    private void createTitleLabel(JPanel TitlePanel) {
        JLabel LabelTitle = new JLabel("Sudoku Solver\r\n");
        LabelTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        LabelTitle.setFont(new Font("Mistral", Font.PLAIN, 52));
        LabelTitle.setForeground(new Color(240, 248, 255));
        TitlePanel.add(LabelTitle);
    }

    private JPanel createTitlePanel() {
        JPanel TitlePanel = new JPanel();
        TitlePanel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(192, 192, 192)));
        TitlePanel.setBackground(new Color(119, 136, 153));
        TitlePanel.setPreferredSize(new Dimension(10, 85));
        MainPanel.add(TitlePanel, BorderLayout.NORTH);
        TitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 17));
        return TitlePanel;
    }
}
