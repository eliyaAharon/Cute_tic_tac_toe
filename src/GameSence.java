import javax.swing.*;
import java.awt.*;

public class GameSence extends JPanel {

    public static int counter = 0;

    public GameSence() {
        this.setBounds(0, 0, 400, 400);
        this.setLayout(new GridLayout(3, 3));
        this.setBackground(Color.BLACK);

        Font myFont = new Font("Arial", Font.BOLD, 45);
        JButton[] buttons = new JButton[9];

        for (int i = 0; i < buttons.length; i++) {
            JButton temp = new JButton();
            temp.setFont(myFont);
            temp.setBackground(Color.YELLOW);

            //button affect:
            temp.addActionListener((e -> {
                if (counter % 2 == 0) {
                    if (temp.getText() == "") {
                        temp.setText("X");
                        counter++;
                    }
                } else {
                    if (temp.getText() == "") {
                        temp.setText("O");
                        counter++;
                    }
                }

            }));
            buttons[i] = temp;
            this.add(buttons[i]);
        }

        // win or draw section:
        Thread t = new Thread(() -> {
            while (true) {
                if (win(buttons)) {
                    if (counter % 2 == 0)
                        JOptionPane.showMessageDialog(null, "X won the game");
                    else
                        JOptionPane.showMessageDialog(null, "O won the game");
                    break;
                }

                if (isDraw(buttons)) {
                    JOptionPane.showMessageDialog(null, "Draw, try again:)");
                    break;
                }

            }
        });
        t.start();


    }

    public boolean isDraw(JButton[] buttons) {
        int counter = 0;
        for (JButton button : buttons) {
            if (button.getText() != "")
                counter++;
        }
        return counter == buttons.length;
    }
    
    public boolean win(JButton[] buttons) {
        if (buttons[0].getText() != "" && buttons[0].getText() == buttons[1].getText() && buttons[0].getText() == buttons[2].getText())
            return true;
        if (buttons[0].getText() != "" && buttons[0].getText() == buttons[4].getText() && buttons[0].getText() == buttons[8].getText())
            return true;
        if (buttons[0].getText() != "" && buttons[0].getText() == buttons[3].getText() && buttons[0].getText() == buttons[6].getText())
            return true;
        if (buttons[1].getText() != "" && buttons[1].getText() == buttons[4].getText() && buttons[1].getText() == buttons[7].getText())
            return true;
        if (buttons[2].getText() != "" && buttons[2].getText() == buttons[5].getText() && buttons[2].getText() == buttons[8].getText())
            return true;
        if (buttons[2].getText() != "" && buttons[2].getText() == buttons[4].getText() && buttons[2].getText() == buttons[6].getText())
            return true;
        if (buttons[3].getText() != "" && buttons[3].getText() == buttons[4].getText() && buttons[3].getText() == buttons[5].getText())
            return true;
        if (buttons[6].getText() != "" && buttons[6].getText() == buttons[7].getText() && buttons[6].getText() == buttons[8].getText())
            return true;
        return false;
    }
}



