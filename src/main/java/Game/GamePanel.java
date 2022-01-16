package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable{

    private Thread gameThread;
    private BufferedImage bufferedImage;
    private Graphics2D graphics2D;

    private int gameWidth;
    private int gameHeight;

    private boolean isRunning = false;

    public GamePanel(int setWidth,int setHeight) {

        gameWidth = setWidth;
        gameHeight = setHeight;

        setPreferredSize(new Dimension(setWidth,setHeight));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify() {
        super.addNotify();

        if (gameThread == null) {
            gameThread = new Thread(this,"GameThread");
            gameThread.start();
        }
    }

    public void initializePanel() {
        isRunning = true;

        bufferedImage = new BufferedImage(gameWidth,gameHeight,BufferedImage.TYPE_INT_ARGB);

        graphics2D = (Graphics2D) bufferedImage.getGraphics();
    }

    @Override
    public void run() {
        initializePanel();

        while(isRunning) {
            updatePanel();
            renderPanel();
            drawPanel();
        }
    }

    public void updatePanel() {

    }

    public void renderPanel() {

    }

    public void drawPanel() {

    }
}
