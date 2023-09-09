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
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class CommandPanel extends JPanel implements ActionListener {
    private MyFrame frame;

    Map<String, JButton> buttonMap = new HashMap<>();
    JButton[] buttons;
    String[] buttonText = { "+", "-", "x", "\u00F7" };

    CommandPanel(MyFrame frame) {
        this.setLayout(new GridLayout(4, 0, 1, 1));

        this.frame = frame;

        buttons = new JButton[4];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonText[i]);
            buttons[i].addActionListener(this);
            buttonMap.put("Button" + i, buttons[i]);
            this.add(buttons[i]);
        }

        InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.getActionMap();

        addKeyBinding(inputMap, actionMap, KeyEvent.VK_EQUALS, "Button0");
        addKeyBinding(inputMap, actionMap, KeyEvent.VK_MINUS, "Button1");
        addKeyBinding(inputMap, actionMap, KeyEvent.VK_X, "Button2");
        addKeyBinding(inputMap, actionMap, KeyEvent.VK_SLASH, "Button3");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        frame.updateOperation(button.getText());
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
