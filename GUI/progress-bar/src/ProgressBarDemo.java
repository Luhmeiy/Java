import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBarDemo {
    JFrame frame;
    JProgressBar bar;

    ProgressBarDemo() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);

        bar = new JProgressBar();
        bar.setValue(0);
        bar.setBounds(0, 0, 420, 50);
        bar.setStringPainted(true);

        bar.setFont(new Font("Consolas", Font.BOLD, 15));
        bar.setForeground(Color.red);
        bar.setBackground(Color.black);

        frame.add(bar);
        frame.setVisible(true);

        fill();
    }

    public void fill() {
        for (int i = 0; i <= 100; i++) {
            bar.setValue(i);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        bar.setString("Done! :)");
    }
}
