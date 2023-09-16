import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SettingsPanel extends JPanel implements ActionListener {
    private GameFrame frame;

    JLabel titleLabel, colorLabel, exitLabel;
    JPanel buttonPanel;
    JButton greenButton, blueButton, redButton, rainbowButton;

    Timer timer;
    TimerTask task;
    Random random;

    SettingsPanel(GameFrame frame) {
        this.setLayout(new GridLayout(0, 1, 0, 10));
        this.setBackground(new Color(0, 0, 0));
        this.setBorder(new EmptyBorder(0, 50, 0, 50));

        this.frame = frame;

        random = new Random();

        // Labels
        titleLabel = new JLabel("Settings", JLabel.CENTER);
        titleLabel.setFont(new Font("Ink Free", Font.BOLD, 75));
        titleLabel.setForeground(Color.green);

        colorLabel = new JLabel("Select the snake color: ");
        colorLabel.setFont(new Font("Ink Free", Font.BOLD, 35));
        colorLabel.setForeground(Color.white);

        exitLabel = new JLabel("Press 'Esc' to go back", JLabel.CENTER);
        exitLabel.setFont(new Font("Ink Free", Font.BOLD, 25));
        exitLabel.setForeground(Color.lightGray);

        // Panel
        buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBackground(new Color(0, 0, 0));

        // Buttons
        greenButton = createButton(Color.green);
        blueButton = createButton(Color.blue);
        redButton = createButton(Color.red);
        rainbowButton = createButton(Color.green);

        buttonPanel.add(greenButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);
        buttonPanel.add(rainbowButton);

        this.add(titleLabel);
        this.add(colorLabel);
        this.add(buttonPanel);
        this.add(exitLabel);

        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                rainbowButton.getComponent(0)
                        .setBackground(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            }
        };

        timer.scheduleAtFixedRate(task, 0, 150);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == greenButton) {
            frame.updateSelectedColor(0);
        } else if (e.getSource() == blueButton) {
            frame.updateSelectedColor(1);
        } else if (e.getSource() == redButton) {
            frame.updateSelectedColor(2);
        } else if (e.getSource() == rainbowButton) {
            frame.updateSelectedColor(3);
        }
    }

    public JButton createButton(Color color) {
        JButton button = new JButton();
        button.addActionListener(this);
        button.setFocusable(false);
        button.setLayout(new FlowLayout());

        JLabel icon = createColoredSquareLabel(color);
        button.add(icon);

        return button;
    }

    public JLabel createColoredSquareLabel(Color color) {
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(50, 50));
        label.setBackground(color);
        label.setOpaque(true);

        return label;
    }
}
