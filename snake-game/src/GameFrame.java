import javax.swing.JFrame;

public class GameFrame extends JFrame {
    GameFrame() {
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.add(new GamePanel());

        this.pack();
        this.setVisible(true);
    }
}
