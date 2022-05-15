package Game.Elements;

import Game.Handlers.KeyboardHandler;
import Game.Handlers.MouseHandler;
import Game.World.Sprite;
import org.newdawn.slick.geom.Vector2f;

import java.awt.*;

public class MainCharacter extends Character implements FiringCharacter{

    int posX;
    int posY;
    int movementDirection;
    boolean isAlive;

    public MainCharacter(Sprite sprite, Vector2f position, int size) {
        super(sprite,position,size);
    }


    @Override
    public void fireBullet() {

    }

    @Override
    public void startCharacter(int x, int y) {

    }

    @Override
    public void characterDeath(Score s) {

    }

    @Override
    public void moveUp() {
        dy -= acceleration;

        if(dy < -maxSpeed) {
            dy = -maxSpeed;
        }
    }

    @Override
    public void moveDown() {
        dy += acceleration;

        if(dy < maxSpeed) {
            dy = maxSpeed;
        }
    }

    @Override
    public void moveLeft() {
        dx -= acceleration;

        if(dx < -maxSpeed) {
            dx = -maxSpeed;
        }
    }

    @Override
    public void moveRight() {
        dx += acceleration;

        if(dx > maxSpeed) {
            dx = maxSpeed;
        }
    }

    @Override
    public void stopIfUp() {
        if(dy < 0) {
            dy += deacceleration;
        }

        if(dy > 0) {
            dy = 0;
        }
    }

    @Override
    public void stopIfDown() {
        if(dy > 0) {
            dy -= deacceleration;
        }

        if(dy < 0) {
            dy = 0;
        }
    }

    @Override
    public void stopIfLeft() {
        if(dy < 0) {
            dx += deacceleration;
        }

        if(dx > 0) {
            dx = 0;
        }
    }

    @Override
    public void stopIfRight() {
        if(dx > 0) {
            dx -= deacceleration;
        }

        if(dx < 0) {
            dy = 0;
        }
    }

    @Override
    public void physicalAttack() {

    }

    public void update() {
        super.update();
        move();
        updatePosition();
    }

    public void updatePosition() {
        characterPosition.x += dx;
        characterPosition.y += dy;
    }

    public void move() {
        if(up) {
            moveUp();
        } else {
            stopIfUp();
        }

        if(down) {
            moveDown();
        } else {
            stopIfDown();
        }

        if(left) {
            moveLeft();
        } else {
           stopIfLeft();
        }

        if(right) {
            moveRight();
        } else {
          stopIfRight();
        }
    }

    public void input(MouseHandler mouseHandler, KeyboardHandler keyboardHandler) {
        if(mouseHandler.getButton() == 1) {
            fire = true;
            System.out.println("FIRE A BULLET!");
        } else {
            fire = false;
        }

        up = keyboardHandler.up.isDown;

        down = keyboardHandler.down.isDown;

        left = keyboardHandler.left.isDown;

        right = keyboardHandler.right.isDown;

        if(keyboardHandler.attack.isDown) {
            fire = true;;
        } else {
            fire = false;
        }
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(characterAnimation.getImage().image,(int) characterPosition.x, (int) characterPosition.y,characterSize,characterSize,null);
    }
}
