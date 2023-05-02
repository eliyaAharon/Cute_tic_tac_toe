import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        this.setSize(400, 400);
        this.setLayout(null);
        this.setVisible(true);
        this.setTitle("Tik Tak Tue");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GameSence gameSence = new GameSence();
        this.add(gameSence);
        this.setVisible(true);

    }
}