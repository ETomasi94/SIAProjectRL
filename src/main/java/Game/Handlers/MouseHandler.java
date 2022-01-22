package Game.Handlers;

import Game.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {

    private static int xPosition = -1;
    private static int yPosition = -1;
    private static int mouseButton = -1;

    public MouseHandler(GamePanel game) {
        game.addMouseListener(this);
        game.addMouseMotionListener(this);
    }

    public int getX() {
        return xPosition;
    }

    public int getY() {
        return yPosition;
    }

    public int getButton() {
        return mouseButton;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseButton = e.getButton();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseButton = -1;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        xPosition = e.getX();
        yPosition = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        xPosition = e.getX();
        yPosition = e.getY();
    }
}
