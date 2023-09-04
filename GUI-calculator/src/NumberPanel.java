import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NumberPanel extends JPanel implements ActionListener {
    private MyFrame frame;

    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    JLabel emptyLabel;

    NumberPanel(MyFrame frame) {
        this.setLayout(new GridLayout(0, 3));

        this.frame = frame;

        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        emptyLabel = new JLabel();

        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);

        this.add(b9);
        this.add(b8);
        this.add(b7);
        this.add(b6);
        this.add(b5);
        this.add(b4);
        this.add(b3);
        this.add(b2);
        this.add(b1);
        this.add(emptyLabel);
        this.add(b0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        frame.updateNumber(button.getText());
    }
}
