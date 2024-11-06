import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homegame extends JPanel {
    private final JFrame frame;
    private final Image backgroundImage;
    private final MusicThread musicThread;

    public Homegame(JFrame frame) {
        this.frame = frame;
        setPreferredSize(new Dimension(800, 390));
        setLayout(null);

        musicThread = new MusicThread();
        musicThread.playMusic("D:\\game\\src\\jungle.wav",true);
        backgroundImage = new ImageIcon("D:\\game\\src\\Home.jpg").getImage();


        JButton startButton = new JButton(new ImageIcon("D:\\game\\src\\play01.png"));
        startButton.setBounds(300, 200, 200, 80);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);

        JButton exitButton = new JButton(new ImageIcon("D:\\game\\src\\no01.png"));
        exitButton.setBounds(300, 270, 200, 80);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(startButton);
        add(exitButton);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        g.drawImage(backgroundImage, 0, 0, 800, 390, this);
    }

    private void startGame() {
        musicThread.stopMusic();
        frame.getContentPane().removeAll();
        LostinWonderland gamePanel = new LostinWonderland();
        frame.add(gamePanel);
        frame.revalidate();
        frame.repaint();
        gamePanel.requestFocusInWindow();
    }
}
