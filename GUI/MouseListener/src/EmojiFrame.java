import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EmojiFrame extends JFrame implements MouseListener {
    JLabel label;

    ImageIcon smile;
    ImageIcon nervous;
    ImageIcon pain;
    ImageIcon dizzy;

    EmojiFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);

        smile = new ImageIcon("smile.png");
        nervous = new ImageIcon("nervous.png");
        pain = new ImageIcon("pain.png");
        dizzy = new ImageIcon("dizzy.png");

        label = new JLabel();
        label.addMouseListener(this);
        label.setBounds(0, 0, 160, 160);

        label.setIcon(smile);

        this.add(label);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        label.setIcon(pain);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        label.setIcon(pain);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        label.setIcon(dizzy);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        label.setIcon(nervous);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        label.setIcon(smile);
    }
}
