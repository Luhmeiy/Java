import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SettingsPanel extends JPanel implements ActionListener {
    private GameFrame frame;

    JLabel titleLabel, colorLabel, exitLabel;
    JPanel buttonPanel;
    JButton greenButton, blueButton, redButton, rainbowButton;

    SettingsPanel(GameFrame frame) {
        this.setLayout(new GridLayout(0, 1, 0, 10));
        this.setBackground(new Color(0, 0, 0));
        this.setBorder(new EmptyBorder(0, 50, 0, 50));

        this.frame = frame;

        // Labels
        titleLabel = new JLabel("Settings");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Ink Free", Font.BOLD, 75));
        titleLabel.setForeground(Color.green);

        colorLabel = new JLabel("Select the snake color: ");
        colorLabel.setFont(new Font("Ink Free", Font.BOLD, 35));
        colorLabel.setForeground(Color.white);

        exitLabel = new JLabel("Press 'Esc' to go back");
        exitLabel.setHorizontalAlignment(JLabel.CENTER);
        exitLabel.setFont(new Font("Ink Free", Font.BOLD, 25));
        exitLabel.setForeground(Color.lightGray);

        // Panel
        buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBackground(new Color(0, 0, 0));

        // Buttons
        greenButton = new JButton("Green");
        blueButton = new JButton("Blue");
        redButton = new JButton("Red");
        rainbowButton = new JButton("Rainbow");

        greenButton.addActionListener(this);
        blueButton.addActionListener(this);
        redButton.addActionListener(this);
        rainbowButton.addActionListener(this);

        greenButton.setFocusable(false);
        blueButton.setFocusable(false);
        redButton.setFocusable(false);
        rainbowButton.setFocusable(false);

        buttonPanel.add(greenButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);
        buttonPanel.add(rainbowButton);

        this.add(titleLabel);
        this.add(colorLabel);
        this.add(buttonPanel);
        this.add(exitLabel);
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
}
