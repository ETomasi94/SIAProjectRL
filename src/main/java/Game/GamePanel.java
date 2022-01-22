package Game;


import Game.Handlers.KeyboardHandler;
import Game.Handlers.MouseHandler;
import Game.States.StateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable{

    private Thread gameThread;
    private BufferedImage bufferedImage;
    private Graphics2D graphics2D;

    private int gameWidth;
    private int gameHeight;

    private StateManager gameStateManager;

    private boolean isRunning = false;
    private MouseHandler gameMouseHandler;
    private KeyboardHandler gameKeyboardHandler;

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

        gameMouseHandler = new MouseHandler(this);
        gameKeyboardHandler = new KeyboardHandler(this);

        gameStateManager = new StateManager();
    }

    @Override
    public void run() {
        initializePanel();

        final double gameFrequency = 60.0;
        final double timeBeforeUpdate = 100000 / gameFrequency;

        final int mustUpdateBeforeRender = 5;

        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;

        double targetFPS = 60;
        double totalTimeBeforeRender = 100000 / targetFPS;

        int frameCount = 0;
        int lastSecondTime = (int) lastUpdateTime / 100000;
        int oldFrameCount = 0;


        while(isRunning) {

            double now = System.nanoTime();
            int updateCount = 0;

            while(((now - lastUpdateTime) > timeBeforeUpdate) && ((updateCount < mustUpdateBeforeRender))) {
                updatePanel();
                input(gameMouseHandler,gameKeyboardHandler);

                lastUpdateTime += timeBeforeUpdate;

                updateCount++;
            }

             if ((now - lastUpdateTime) > timeBeforeUpdate) {
                lastUpdateTime = now - timeBeforeUpdate;
            }
             
             input(gameMouseHandler,gameKeyboardHandler);
            renderPanel();
            drawPanel();

            lastRenderTime = now;
            frameCount++;

            int thisSecond = (int) (lastUpdateTime / 100000);

            if (thisSecond > lastSecondTime) {
                if (frameCount != oldFrameCount) {
                    System.out.println("NEW SECOND " + thisSecond + " " + frameCount);
                    oldFrameCount = frameCount;
                }
                frameCount = 0;
                lastSecondTime = thisSecond;
            }

            while (now - lastRenderTime < totalTimeBeforeRender && now - lastUpdateTime < timeBeforeUpdate) {
                Thread.yield();

                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    System.out.println("ERROR: yielding thread");
                }

                now = System.nanoTime();
            }

        }

    }

    public void updatePanel() {
        gameStateManager.update();
    }

    public void renderPanel() {
        if (graphics2D != null) {
            graphics2D.setColor(new Color(142, 255, 251));
            graphics2D.fillRect(0,0,gameWidth,gameHeight);
            gameStateManager.render(graphics2D);
        }
    }

    public void drawPanel() {
        Graphics graphicsUpdated = this.getGraphics();

        graphicsUpdated.drawImage(bufferedImage,0,0,gameWidth,gameHeight,null);

        graphicsUpdated.dispose();
    }

    public void input(MouseHandler mouseHandler, KeyboardHandler keyboardHandler) {
        gameStateManager.input(mouseHandler,keyboardHandler);
    }
}
