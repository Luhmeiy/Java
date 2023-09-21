import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
    private GameFrame frame;

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;

    int x[] = new int[GAME_UNITS];
    int y[] = new int[GAME_UNITS];

    int bodyParts = 6;

    int applesEaten;
    int highScore = 0;
    int appleX;
    int appleY;

    char direction = 'R';
    boolean gameStarted = false;
    boolean running = false;

    static final Color[] headColor = { Color.green, Color.blue, Color.red, Color.green };
    static final Color[] bodyColor = { new Color(45, 180, 0), new Color(44, 1, 255), new Color(244, 2, 64) };

    Timer timer;
    Random random;

    GamePanel(GameFrame frame) {
        this.requestFocusInWindow();

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);

        this.frame = frame;

        random = new Random();
    }

    public void startTitleScreen(Graphics g) {
        // Title text
        g.setColor(Color.green);
        g.setFont(new Font("Ink Free", Font.BOLD, 50));

        FontMetrics titleMetrics = getFontMetrics(g.getFont());

        g.drawString("SNAKE GAME", (SCREEN_WIDTH - titleMetrics.stringWidth("SNAKE GAME")) / 2,
                (SCREEN_HEIGHT / 2));

        // Start text
        g.setFont(new Font("Ink Free", Font.BOLD, 25));
        FontMetrics startMetrics = getFontMetrics(g.getFont());
        g.drawString("Press 'Space' to start", (SCREEN_WIDTH - startMetrics.stringWidth("Press 'Space' to start")) / 2,
                (SCREEN_HEIGHT / 2) + (g.getFont().getSize() * 2));

        // Settings text
        g.setColor(Color.red);
        g.drawString("Press 's' for settings", (SCREEN_WIDTH - startMetrics.stringWidth("Press 's' for settings")) / 2,
                (SCREEN_HEIGHT / 2) + (g.getFont().getSize() * 10));
    }

    public void startGame() {
        newApple();

        gameStarted = true;
        running = true;

        timer = new Timer(150 - frame.delay, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (gameStarted) {
            if (running) {
                for (int i = 0; i < (SCREEN_HEIGHT / UNIT_SIZE); i++) {
                    g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                    g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
                }

                g.setColor(Color.red);
                g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

                for (int i = 0; i < bodyParts; i++) {
                    if (i == 0) {
                        g.setColor(headColor[frame.selectedColor]);
                        g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    } else {
                        if (frame.selectedColor == 3) {
                            g.setColor(new Color(random.nextInt(255), random.nextInt(255),
                                    random.nextInt(255)));
                        } else {
                            g.setColor(bodyColor[frame.selectedColor]);
                        }

                        g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                }

                g.setColor(Color.red);
                g.setFont(new Font("Ink Free", Font.BOLD, 35));

                FontMetrics metrics = getFontMetrics(g.getFont());

                g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2,
                        g.getFont().getSize());
            } else {
                gameOver(g);
            }
        } else {
            startTitleScreen(g);
        }
    }

    public void newApple() {
        boolean appleOnSnake = true;

        while (appleOnSnake) {
            appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
            appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

            appleOnSnake = false;

            for (int i = 0; i < bodyParts; i++) {
                if (x[i] == appleX && y[i] == appleY) {
                    appleOnSnake = true;
                    break;
                }
            }
        }
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U':
                y[0] -= UNIT_SIZE;
                break;
            case 'D':
                y[0] += UNIT_SIZE;
                break;
            case 'L':
                x[0] -= UNIT_SIZE;
                break;
            case 'R':
                x[0] += UNIT_SIZE;
                break;
        }
    }

    public void checkApple() {
        if ((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }

    public void checkCollisions() {
        // Checks if head collides with body
        for (int i = bodyParts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }

        // Checks if head touches left border
        if (x[0] < 0)
            running = false;

        // Checks if head touches right border
        if (x[0] >= SCREEN_WIDTH)
            running = false;

        // Checks if head touches top border
        if (y[0] < 0)
            running = false;

        // Checks if head touches bottom border
        if (y[0] >= SCREEN_HEIGHT)
            running = false;

        if (!running)
            timer.stop();
    }

    public void gameOver(Graphics g) {
        boolean newHighScore = false;

        if (applesEaten > highScore) {
            highScore = applesEaten;
            newHighScore = true;
        }

        // Score text
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 35));

        FontMetrics scoreMetrics = getFontMetrics(g.getFont());

        g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - scoreMetrics.stringWidth("Score: " + applesEaten)) / 2,
                g.getFont().getSize());

        // Game Over text
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));

        FontMetrics gOMetrics = getFontMetrics(g.getFont());

        g.drawString("Game Over", (SCREEN_WIDTH - gOMetrics.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);

        // Retry text
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 25));

        FontMetrics retryMetrics = getFontMetrics(g.getFont());

        g.drawString("Press 'R' to retry", (SCREEN_WIDTH - retryMetrics.stringWidth("Press 'R' to retry")) / 2,
                (SCREEN_HEIGHT / 2) + (g.getFont().getSize() * 2));

        // Menu text
        g.drawString("Press 'Esc' to go back to menu",
                (SCREEN_WIDTH - retryMetrics.stringWidth("Press 'Esc' to go back to menu")) / 2,
                (SCREEN_HEIGHT / 2) + (g.getFont().getSize() * 4));

        // HighScore text
        g.drawString("HighScore: " + highScore,
                (SCREEN_WIDTH - retryMetrics.stringWidth("HighScore: " + highScore)) / 2,
                (SCREEN_HEIGHT) - (g.getFont().getSize()));

        if (newHighScore) {
            g.setColor(Color.green);
            g.setFont(new Font("Ink Free", Font.BOLD, 20));

            FontMetrics highScoreMetrics = getFontMetrics(g.getFont());

            g.drawString("New HighScore!",
                    (SCREEN_WIDTH - highScoreMetrics.stringWidth("New HighScore!")) / 2,
                    (SCREEN_HEIGHT) - (g.getFont().getSize() * 3));
        }
    }

    public void resetVariables() {
        x = new int[GAME_UNITS];
        y = new int[GAME_UNITS];

        bodyParts = 6;

        applesEaten = 0;
        appleX = 0;
        appleY = 0;

        direction = 'R';
    }

    public void restartGame() {
        resetVariables();
        startGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }

        repaint();
    }
}
