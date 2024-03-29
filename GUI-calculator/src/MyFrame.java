import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class MyFrame extends JFrame implements ActionListener {
    JPanel containerPanel, numberPanel, commandPanel;
    JLabel label;
    JButton button;

    String operation;

    String n1 = "";
    String n2 = "";

    Integer result;

    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 1, 0, 5));
        this.setResizable(false);

        label = new JLabel("");
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        label.setFont(new Font("Consolas", Font.BOLD, 35));

        button = new JButton("=");
        button.addActionListener(this);

        InputMap inputMap = button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = button.getActionMap();

        addKeyBinding(inputMap, actionMap, KeyEvent.VK_ENTER, "Button0");

        containerPanel = new JPanel();
        containerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

        numberPanel = new NumberPanel(this);
        commandPanel = new CommandPanel(this);

        containerPanel.add(numberPanel);
        containerPanel.add(commandPanel);

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

    private void addKeyBinding(InputMap inputMap, ActionMap actionMap, int keyCode, String actionName) {
        KeyStroke keyStroke = KeyStroke.getKeyStroke(keyCode, 0);
        inputMap.put(keyStroke, actionName);

        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("Button0".equals(actionName)) {
                    button.doClick();
                }
            }
        };

        actionMap.put(actionName, action);
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
