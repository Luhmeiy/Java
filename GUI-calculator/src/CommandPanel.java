import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CommandPanel extends JPanel implements ActionListener {
    private MyFrame frame;

    JButton plusButton;
    JButton minusButton;
    JButton timesButton;
    JButton divisionButton;

    CommandPanel(MyFrame frame) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.frame = frame;

        plusButton = new JButton("+");
        minusButton = new JButton("-");
        timesButton = new JButton("x");
        divisionButton = new JButton("\u00F7");

        plusButton.addActionListener(this);
        minusButton.addActionListener(this);
        timesButton.addActionListener(this);
        divisionButton.addActionListener(this);

        this.add(plusButton);
        this.add(minusButton);
        this.add(timesButton);
        this.add(divisionButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        frame.updateOperation(button.getText());
    }
}
