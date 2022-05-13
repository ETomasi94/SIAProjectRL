package Tools;

import Game.Elements.Character;
import org.newdawn.slick.geom.Vector2f;

public class Collision {

    private Vector2f Position;
    private float xOffset = 0;
    private float yOffset = 0;
    private float width;
    private float heigth;
    private float radius;
    private int size;
    private Character character;

    public Collision(Vector2f p, int w, int h) {
        Position = p;
        width = w;
        heigth = h;

        size = (int) Math.max(width,heigth);
    }

    public Collision(Vector2f pos, int r, Character c) {
        Position = pos;
        radius = r;
        character = c;

        size = (int) (radius * radius);
    }

    public Vector2f getPosition() {
        return Position;
    }

    public float getRadius() { return  radius;}
    public float getWidth() { return width; }
    public float getHeight() { return heigth; }

    public void setBox(Vector2f pos, int w, int h) {
        Position = pos;
        width = w;
        heigth = h;

        size = (int) Math.max(width,heigth);
    }

    public void setCircle(Vector2f pos, int r ) {
        Position = pos;
        radius = r;
        size = (int) (radius * radius);
    }

    public void setHeight(float h) { heigth = h;}
    public void setWidth(float w) {width = w;}
    public void setRadius(float r) { radius = r;}
    public void setXOffset(float xOf) { xOffset = xOf;}
    public void setYOffset(float yOf) { yOffset = yOf;}

    public boolean isColliding(Collision collision) {
        float dX = ((Position.getX() + xOffset)) + (width/2);
        float dY = ((Position.getY() + yOffset) + (heigth/2));

        float cX = ((collision.Position.getX())+(collision.xOffset/2)+(width/2));
        float cY = ((collision.Position.getY())+(collision.yOffset/2)+(heigth/2));

        if (Math.abs(dX - cX)  < (width / 2) + (collision.width / 2)) {
            if(Math.abs(dY - cY) < (heigth/2) + (collision.heigth / 2)) {
                return true;
            }
        }

        return false;
    }

    public boolean isCircleColliding(Collision collision) {
        float cX = (float) (Position.getX() + radius / Math.sqrt(2) - character.getSize() / Math.sqrt(2));
        float cY = (float) (Position.getY() + radius / Math.sqrt(2) - character.getSize() / Math.sqrt(2));

        float deltaX = cX - Math.max(collision.getPosition().getX() + (collision.getWidth() / 2),Math.min(cX,collision.Position.getX()));
        float deltaY = cY - Math.max(collision.getPosition().getY() + (collision.getHeight() / 2),Math.min(cY,collision.Position.getY()));

        if((deltaX * deltaX + deltaY * deltaY) < ((radius / Math.sqrt(2)) * (radius / Math.sqrt(2)))) {
            return true;
        }


        return false;
    }
}
