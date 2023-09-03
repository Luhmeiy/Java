import javax.swing.JFrame;

public class MyFrame extends JFrame {
    MyPanel panel;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new MyPanel();

        this.add(panel);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
