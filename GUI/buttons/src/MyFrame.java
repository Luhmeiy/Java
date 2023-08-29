import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements ActionListener {
    JButton button;
    JLabel label;

    MyFrame() {
        label = new JLabel();
        label.setText("You found me!");
        label.setBounds(225, 150, 150, 150);
        label.setForeground(Color.black);
        label.setVisible(false);

        button = new JButton();
        button.setBounds(75, 100, 350, 100);
        button.setFocusable(false);

        // button.setEnabled(false);

        button.setForeground(Color.cyan);
        button.setBackground(Color.lightGray);

        button.setBorder(BorderFactory.createEtchedBorder());

        button.addActionListener(this);
        // button.addActionListener(e -> System.out.println("Hello"));

        button.setText("Click to reveal the text");
        button.setFont(new Font("Comic Sans", Font.BOLD, 25));

        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);

        this.add(button);
        this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            // System.out.println("Hello");
            // button.setEnabled(false);

            label.setVisible(true);
        }
    }
}
