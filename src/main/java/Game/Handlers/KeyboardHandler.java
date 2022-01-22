package Game.Handlers;
import Game.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.ArrayList;

public class KeyboardHandler implements KeyListener{

    public static List<Key> keys = new ArrayList<>();

    public static class Key {
        public int timesPressed, timesAbsorbed;
        public boolean isDown, isClicked;

        public Key() {
            keys.add(this);
        }

        public void toggle(boolean pressed) {
            if(pressed != isDown) {
                isDown = pressed;
            }
            if(pressed) {
                timesPressed++;
            }
        }

        public void tick() {
            if(timesAbsorbed < timesPressed) {
                timesAbsorbed++;
                isClicked = true;
            } else {
                isClicked = false;
            }
        }
    }

    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();
    public Key attack = new Key();
    public Key menu = new Key();
    public Key enter = new Key();
    public Key escape = new Key();
    public Key shift = new Key();
    public Key f1 = new Key();

    public KeyboardHandler(GamePanel game) {
        game.addKeyListener(this);
    }

    public void releaseAll() {
        for (Key key : keys) {
            key.isDown = false;
        }
    }

    public void tick() {
        for (Key key : keys) {
            key.tick();
        }
    }

    public void toggleKey(KeyEvent keyEvent, boolean isPressed) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_W) up.toggle(isPressed);
        if(keyEvent.getKeyCode() == KeyEvent.VK_S) down.toggle(isPressed);
        if(keyEvent.getKeyCode() == KeyEvent.VK_A) left.toggle(isPressed);
        if(keyEvent.getKeyCode() == KeyEvent.VK_D) right.toggle(isPressed);
        if(keyEvent.getKeyCode() == KeyEvent.VK_SPACE) attack.toggle(isPressed);
        if(keyEvent.getKeyCode() == KeyEvent.VK_E) menu.toggle(isPressed);
        if(keyEvent.getKeyCode() == KeyEvent.VK_ENTER) enter.toggle(isPressed);
        if(keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) escape.toggle(isPressed);
        if(keyEvent.getKeyCode() == KeyEvent.VK_F1) f1.toggle(isPressed);
        if(keyEvent.getKeyCode() == KeyEvent.VK_SHIFT) shift.toggle(isPressed);
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {
        // do nothing
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        toggleKey(keyEvent, true);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        toggleKey(keyEvent, false);
    }
}