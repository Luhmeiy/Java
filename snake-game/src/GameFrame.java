import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame implements KeyListener {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    private GamePanel gamePanel;
    private SettingsPanel settingsPanel;

    int selectedColor = 0;

    GameFrame() {
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        gamePanel = new GamePanel(this);
        gamePanel.addKeyListener(this);

        settingsPanel = new SettingsPanel(this);

        cardPanel.add(gamePanel);
        cardPanel.add(settingsPanel);

        this.add(cardPanel);

        this.addKeyListener(this);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setFocusable(true);
    }

    public void updateSelectedColor(int newSelectedColor) {
        selectedColor = newSelectedColor;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_S:
                if (!gamePanel.gameStarted)
                    cardLayout.next(cardPanel);
                break;
            case KeyEvent.VK_ESCAPE:
                if (!gamePanel.gameStarted) {
                    cardLayout.previous(cardPanel);
                } else if (!gamePanel.running) {
                    gamePanel.resetVariables();
                    gamePanel.gameStarted = false;
                    gamePanel.repaint();
                }
                break;
            case KeyEvent.VK_SPACE:
                if (!gamePanel.gameStarted)
                    gamePanel.startGame();
                break;
            case KeyEvent.VK_R:
                if (!gamePanel.running)
                    gamePanel.restartGame();
                break;
            case KeyEvent.VK_LEFT:
                if (gamePanel.direction != 'R')
                    gamePanel.direction = 'L';
                break;
            case KeyEvent.VK_RIGHT:
                if (gamePanel.direction != 'L')
                    gamePanel.direction = 'R';
                break;
            case KeyEvent.VK_UP:
                if (gamePanel.direction != 'D')
                    gamePanel.direction = 'U';
                break;
            case KeyEvent.VK_DOWN:
                if (gamePanel.direction != 'U')
                    gamePanel.direction = 'D';
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
