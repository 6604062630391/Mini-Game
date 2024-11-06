import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Win extends JPanel {
    private final JFrame frame;
    private final Image backgroundImage;
    private Image restartButtonImage;
    private final MusicThread musicThread;

    public Win(JFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(800, 390));
        setLayout(null);

        backgroundImage = new ImageIcon("D:\\game\\src\\win.jpg").getImage();

        restartButtonImage = new ImageIcon("D:\\game\\src\\restart01.png").getImage();
        Image exitButtonImage = new ImageIcon("D:\\game\\src\\no01.png").getImage();

        musicThread = new MusicThread();
        musicThread.playMusic("D:\\game\\src\\win.wav",true);

        // Create Restart button
        JButton restartButton = new JButton(new ImageIcon(restartButtonImage));
        restartButton.setBounds(300, 200, 200, 50);
        restartButton.setContentAreaFilled(false);
        restartButton.setBorderPainted(false);
        restartButton.setFocusPainted(false);
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });

        // Create Exit button
        JButton exitButton = new JButton(new ImageIcon(exitButtonImage));
        exitButton.setBounds(300, 270, 200, 50);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        add(restartButton);
        add(exitButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        g.drawImage(backgroundImage, 0, 0, 800, 390, this);
    }

    private void restartGame() {
        musicThread.stopMusic();
        frame.getContentPane().removeAll();
        LostinWonderland gamePanel = new LostinWonderland();
        frame.add(gamePanel);
        frame.revalidate();
        frame.repaint();
        gamePanel.requestFocusInWindow();
    }
}