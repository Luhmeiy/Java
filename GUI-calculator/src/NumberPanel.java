import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class NumberPanel extends JPanel implements ActionListener {
    private MyFrame frame;

    Map<String, JButton> buttonMap = new HashMap<>();
    JButton[] buttons;
    JLabel emptyLabel;

    NumberPanel(MyFrame frame) {
        this.setLayout(new GridLayout(0, 3));

        this.frame = frame;

        buttons = new JButton[10];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(String.valueOf(i));
            buttons[i].addActionListener(this);
            buttonMap.put("Button" + i, buttons[i]);
        }

        InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.getActionMap();

        addKeyBinding(inputMap, actionMap, KeyEvent.VK_0, "Button0");
        addKeyBinding(inputMap, actionMap, KeyEvent.VK_1, "Button1");
        addKeyBinding(inputMap, actionMap, KeyEvent.VK_2, "Button2");
        addKeyBinding(inputMap, actionMap, KeyEvent.VK_3, "Button3");
        addKeyBinding(inputMap, actionMap, KeyEvent.VK_4, "Button4");
        addKeyBinding(inputMap, actionMap, KeyEvent.VK_5, "Button5");
        addKeyBinding(inputMap, actionMap, KeyEvent.VK_6, "Button6");
        addKeyBinding(inputMap, actionMap, KeyEvent.VK_7, "Button7");
        addKeyBinding(inputMap, actionMap, KeyEvent.VK_8, "Button8");
        addKeyBinding(inputMap, actionMap, KeyEvent.VK_9, "Button9");

        emptyLabel = new JLabel();

        for (int i = 9; i >= 1; i--) {
            this.add(buttons[i]);
        }

        this.add(emptyLabel);
        this.add(buttons[0]);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        frame.updateNumber(button.getText());
    }

    private void addKeyBinding(InputMap inputMap, ActionMap actionMap, int keyCode, String actionName) {
        KeyStroke keyStroke = KeyStroke.getKeyStroke(keyCode, 0);
        inputMap.put(keyStroke, actionName);

        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = buttonMap.get(actionName);

                if (button != null) {
                    button.doClick();
                }
            }
        };

        actionMap.put(actionName, action);
    }
}
