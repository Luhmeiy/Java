import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SettingsPanel extends JPanel implements ActionListener, ChangeListener {
    private GameFrame frame;

    JLabel titleLabel, colorLabel, speedLabel, exitLabel;
    JPanel buttonPanel;
    JSlider speedSlider;
    JButton greenButton, blueButton, redButton, rainbowButton;

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;

    Timer timer;
    TimerTask task;
    Random random;

    SettingsPanel(GameFrame frame) {
        this.setLayout(new GridLayout(0, 1, 0, 10));
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(new Color(0, 0, 0));
        this.setBorder(new EmptyBorder(0, 50, 0, 50));

        this.frame = frame;

        random = new Random();

        // Labels
        titleLabel = new JLabel("Settings", JLabel.CENTER);
        titleLabel.setFont(new Font("Ink Free", Font.BOLD, 50));
        titleLabel.setForeground(Color.green);

        colorLabel = new JLabel("Select the snake color: ");
        colorLabel.setFont(new Font("Ink Free", Font.BOLD, 25));
        colorLabel.setForeground(Color.white);

        speedLabel = new JLabel("Snake speed: " + frame.delay);
        speedLabel.setFont(new Font("Ink Free", Font.BOLD, 25));
        speedLabel.setForeground(Color.white);

        exitLabel = new JLabel("Press 'Esc' to go back", JLabel.CENTER);
        exitLabel.setFont(new Font("Ink Free", Font.BOLD, 25));
        exitLabel.setForeground(Color.lightGray);

        // Panel
        buttonPanel = new JPanel(new GridLayout(0, 4, 10, 10));
        buttonPanel.setBackground(new Color(0, 0, 0));

        // Slider
        speedSlider = new JSlider(0, 125, frame.delay);
        speedSlider.setFocusable(false);
        speedSlider.setBackground(Color.black);

        speedSlider.setPaintTicks(true);
        speedSlider.setMinorTickSpacing(5);

        speedSlider.setPaintTrack(true);
        speedSlider.setMajorTickSpacing(25);

        speedSlider.addChangeListener(this);

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
        this.add(speedLabel);
        this.add(speedSlider);
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

    @Override
    public void stateChanged(ChangeEvent e) {
        frame.updateDelay(speedSlider.getValue());
        speedLabel.setText("Snake speed: " + frame.delay);
    }

    public JButton createButton(Color color) {
        JButton button = new JButton();
        button.addActionListener(this);
        button.setFocusable(false);
        button.setLayout(new GridBagLayout());

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
