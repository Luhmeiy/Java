import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame extends JFrame implements ActionListener {
    JPanel containerPanel, numberPanel, CommandPanel;
    JLabel label;
    JButton button;

    String operation;

    String n1 = "";
    String n2 = "";

    Integer result;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 0));
        this.setResizable(false);

        label = new JLabel("");
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        label.setFont(new Font("Consolas", Font.BOLD, 35));

        button = new JButton("=");
        button.addActionListener(this);

        containerPanel = new JPanel();
        containerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        numberPanel = new NumberPanel(this);
        CommandPanel = new CommandPanel(this);

        containerPanel.add(numberPanel);
        containerPanel.add(CommandPanel);

        this.add(label);
        this.add(containerPanel);
        this.add(button);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(n1 != null && n2 != null)) {
            updateLabel("Invalid");
        } else {
            updateResult();
            updateLabel(Integer.toString(result));
        }
    }

    public void updateLabel(String text) {
        label.setText(text);
    }

    public void updateOperation(String selectedOperation) {
        this.operation = selectedOperation;
    }

    public void updateNumber(String selectedNumber) {
        if (n1 == null || operation == null) {
            n1 += selectedNumber;
            this.updateLabel(n1);
        } else {
            n2 += selectedNumber;
            this.updateLabel(n2);
        }
    }

    public void updateResult() {
        try {
            int parsedN1 = Integer.parseInt(n1);
            int parsedN2 = Integer.parseInt(n2);

            switch (operation) {
                case "+":
                    result = parsedN1 + parsedN2;
                    break;
                case "-":
                    result = parsedN1 - parsedN2;
                    break;
                case "x":
                    result = parsedN1 * parsedN2;
                    break;
                case "\u00F7":
                    result = parsedN1 / parsedN2;
                    break;
            }

            n1 = Integer.toString(result);
            n2 = "";

            updateLabel(Integer.toString(result));
        } catch (Exception e) {
            this.updateLabel("Invalid");
        }
    }
}
