import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener {

    private JFrame frame = new JFrame();
    private JPanel titlePanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JLabel textField = new JLabel();
    private JButton[] buttons = new JButton[9];
    private boolean player1Turn = true;

    public TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setTitle("Tic-Tac-Toe");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(Color.LIGHT_GRAY);
        textField.setFont(new Font("Arial", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,600,100);

        buttonPanel.setLayout(new GridLayout(3,3));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }


        titlePanel.add(textField);

        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        turnCheck();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1Turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X");
                        player1Turn = false;
                        winCheck();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(Color.BLUE);
                        buttons[i].setText("O");
                        player1Turn = true;
                        winCheck();
                    }
                }
            }
        }
    }

    public void turnCheck() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (player1Turn) {
            textField.setText("X Turn");
        } else {
            textField.setText("O Turn");
        }
    }

    public void winCheck() {
        // Check X win conditions
        if (
                (buttons[0].getText().equals("X")) &&
                (buttons[1].getText().equals("X")) &&
                (buttons[2].getText().equals("X"))
           ) {
            xWin(0,1,2);
        }

        if (
                (buttons[3].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[5].getText().equals("X"))
           ) {
            xWin(3,4,5);
        }

        if (
                (buttons[6].getText().equals("X")) &&
                (buttons[7].getText().equals("X")) &&
                (buttons[8].getText().equals("X"))
           ) {
            xWin(6,7,8);
        }

        if (
                (buttons[0].getText().equals("X")) &&
                (buttons[3].getText().equals("X")) &&
                (buttons[6].getText().equals("X"))
           ) {
            xWin(0,3,6);
        }

        if (
                (buttons[1].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[7].getText().equals("X"))
           ) {
            xWin(1,4,7);
        }

        if (
                (buttons[2].getText().equals("X")) &&
                (buttons[5].getText().equals("X")) &&
                (buttons[8].getText().equals("X"))
           ) {
            xWin(2,5,8);
        }

        if (
                (buttons[0].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[8].getText().equals("X"))
           ) {
            xWin(0,4,8);
        }

        if (
                (buttons[2].getText().equals("X")) &&
                (buttons[4].getText().equals("X")) &&
                (buttons[6].getText().equals("X"))
           ) {
            xWin(2,4,6);
        }

        // Check O win conditions

        if (
                (buttons[0].getText().equals("O")) &&
                (buttons[1].getText().equals("O")) &&
                (buttons[2].getText().equals("O"))
           ) {
            oWin(0,1,2);
        }

        if (
                (buttons[3].getText().equals("O")) &&
                (buttons[4].getText().equals("O")) &&
                (buttons[5].getText().equals("O"))
           ) {
            oWin(3,4,5);
        }

        if (
                (buttons[6].getText().equals("O")) &&
                (buttons[7].getText().equals("O")) &&
                (buttons[8].getText().equals("O"))
           ) {
            oWin(6,7,8);
        }

        if (
                (buttons[0].getText().equals("O")) &&
                (buttons[3].getText().equals("O")) &&
                (buttons[6].getText().equals("O"))
           ) {
            oWin(0,3,6);
        }

        if (
                (buttons[1].getText().equals("O")) &&
                (buttons[4].getText().equals("O")) &&
                (buttons[7].getText().equals("O"))
           ) {
            oWin(1,4,7);
        }

        if (
                (buttons[2].getText().equals("O")) &&
                (buttons[5].getText().equals("O")) &&
                (buttons[8].getText().equals("O"))
           ) {
            oWin(2,5,8);
        }

        if (
                (buttons[0].getText().equals("O")) &&
                (buttons[4].getText().equals("O")) &&
                (buttons[8].getText().equals("O"))
           ) {
            oWin(0,4,8);
        }

        if (
                (buttons[2].getText().equals("O")) &&
                (buttons[4].getText().equals("O")) &&
                (buttons[6].getText().equals("O"))
           ) {
            oWin(2,4,6);
        }

    }

    public void xWin(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        textField.setText("X wins!");
    }

    public void oWin(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }

        textField.setText("O wins!");
    }
}
