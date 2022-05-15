package Game.Elements;

import Game.Handlers.KeyboardHandler;
import Game.Handlers.MouseHandler;
import Game.World.Animation;
import Game.World.Sprite;
import Game.World.SpriteSheet;
import Tools.Collision;
import org.newdawn.slick.geom.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Character {

    private final int UP = 0;
    private final int DOWN = 1;
    private final int RIGHT = 2;
    private final int LEFT = 3;
    private final int FIRE = 4;

    protected Sprite characterSprite;
    protected Vector2f characterPosition;
    protected int characterSize;
    protected Animation characterAnimation;

    protected int currentCharacterAnimation;

    protected boolean up;
    protected boolean down;
    protected boolean right;
    protected boolean left;
    protected boolean fire;

    protected int attackSpeed;
    protected int attackDuration;

    protected float dx;
    protected float dy;

    protected float maxSpeed;
    protected float acceleration;
    protected float deacceleration;

    protected Collision hitBox;
    protected Collision collisionBounds;

    public Character(Sprite sprite, Vector2f origin, int size){
        this.characterSprite = sprite;
        this.characterPosition = origin;
        this.characterSize = size;

        collisionBounds = new Collision(origin,size,size);
        hitBox = new Collision(new Vector2f(origin.x + (size/2), origin.y),size,size);

        characterAnimation = new Animation();

    }

    public int getSize() {
        return characterSize;
    }

    public Animation getCharacterAnimation() {return characterAnimation;}

    public void setSprite(Sprite sprite) {
        this.characterSprite = sprite;
    }

    public void setSize(int i) {
        this.characterSize = i;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    public void setDeacceleration(float deacceleration) {
        this.deacceleration = deacceleration;
    }

    public Collision getBounds() {
        return collisionBounds;}

    public void setAnimation(int i, Sprite[] frames, int delay) {
        currentCharacterAnimation = i;
        characterAnimation.setFrames(frames);
        characterAnimation.setDelay(delay);
    }

    public void animateCharacter() {
        if(up) {
            if (currentCharacterAnimation != UP || characterAnimation.getDelay() == -1) {
                setAnimation(UP,characterSprite.getSpriteArray(UP),5);
            }
        } else if(down) {
            if (currentCharacterAnimation != DOWN || characterAnimation.getDelay() == -1) {
                setAnimation(DOWN,characterSprite.getSpriteArray(DOWN),5);
            }
        } else if(left) {
            if (currentCharacterAnimation != LEFT || characterAnimation.getDelay() == -1) {
                setAnimation(LEFT,characterSprite.getSpriteArray(LEFT),5);
            }
        } else if(right) {
            if (currentCharacterAnimation != RIGHT || characterAnimation.getDelay() == -1) {
                setAnimation(RIGHT,characterSprite.getSpriteArray(RIGHT),5);
            }
        } else if (fire) {
                if (currentCharacterAnimation != FIRE || characterAnimation.getDelay() == -1) {
                    setAnimation(FIRE, characterSprite.getSpriteArray(FIRE), 5);
                }
        } else {
            setAnimation(currentCharacterAnimation,characterSprite.getSpriteArray(currentCharacterAnimation),-1);
        }
    }

    private void setHitBoxDirection() {
        if(up) {
            collisionBounds.setYOffset(-characterSize/2);
            collisionBounds.setXOffset(-characterSize/2);
        }else if(down) {
            collisionBounds.setXOffset(-characterSize/2);
            collisionBounds.setYOffset(characterSize/2);
        } else if(left) {
            collisionBounds.setXOffset(-characterSize);
            collisionBounds.setYOffset(0);
        }else if(right) {
            collisionBounds.setXOffset(0);
            collisionBounds.setYOffset(0);
        }
    }

    protected void update() {
        animateCharacter();
        setHitBoxDirection();
        characterAnimation.update();;
    }

    public abstract void render(Graphics2D g);
    public void input(KeyboardHandler key, MouseHandler mouse) {}

}
