package Game.World;

import org.newdawn.slick.geom.Vector2f;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Sprite {
    private BufferedImage spriteSheet = null;
    private BufferedImage[][] spriteArray;
    private final int TILE_SIZE = 32;

    public BufferedImage image;

    private int[] pixels;
    private int[] ogpixels;

    private int w;
    private int h;
    private int wSprite;
    private int hSprite;

    private float[][] id = {{1.0f, 0.0f, 0.0f},
            {0.0f, 1.0f, 0.0f},
            {0.0f, 0.0f, 1.0f},
            {0.0f, 0.0f, 0.0f}};

    private float[][] negative = {{1.0f, 0.0f, 0.0f},
            {0.0f, 1.0f, 0.0f},
            {0.0f, 0.0f, 1.0f},
            {0.0f, 0.0f, 0.0f}};

    private float[][] decay = {{0.000f, 0.333f, 0.333f},
            {0.333f, 0.000f, 0.333f},
            {0.333f, 0.333f, 0.000f},
            {0.000f, 0.000f, 0.000f}};

    private float[][] sepia = {{0.393f, 0.349f, 0.272f},
            {0.769f, 0.686f, 0.534f},
            {0.189f, 0.168f, 0.131f},
            {0.000f, 0.000f, 0.000f}};

    private float[][] redish = {{1.0f, 0.0f, 0.0f},
            {0.0f, 0.3f, 0.0f},
            {0.0f, 0.0f, 0.3f},
            {0.0f, 0.0f, 0.0f}};

    private float[][] grayscale = {{0.333f, 0.333f, 0.333f},
            {0.333f, 0.333f, 0.333f},
            {0.333f, 0.333f, 0.333f},
            {0.000f, 0.000f, 0.000f}};

    private float[][] currentEffect = id;

    public Sprite(String spriteFile) {
        w = TILE_SIZE;
        h = TILE_SIZE;

        spriteSheet = loadSprite(spriteFile);

        wSprite = spriteSheet.getWidth() / w;
        hSprite = spriteSheet.getHeight() / h;

        loadSpriteArray();
    }

    public Sprite(String spriteFile, int spriteWidth, int spriteHeight) {
        this.w = spriteWidth;
        this.h = spriteHeight;

        spriteSheet = loadSprite(spriteFile);

        wSprite = spriteSheet.getWidth() / w;
        hSprite = spriteSheet.getHeight() / h;

        loadSpriteArray();
    }

    public void setSize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    private void setHeight(int height) {
        this.h = height;
        wSprite = spriteSheet.getWidth() / w;
    }

    private void setWidth(int width) {
        this.w = width;
        hSprite = spriteSheet.getHeight() / h;
    }

    public int getWidth() {
        return w;
    }

    public int getHeight() {
        return h;
    }

    private BufferedImage loadSprite(String spriteFile) {
        BufferedImage currentSprite = null;

        try {
            currentSprite = ImageIO.read(getClass().getClassLoader().getResourceAsStream(spriteFile));
        } catch (IOException e) {
            System.out.println("ERROR: Impossible loading file" + spriteFile);
        }

        return currentSprite;
    }

    public void loadSpriteArray() {
        spriteArray = new BufferedImage[wSprite][hSprite];

        for (int i = 0; i < wSprite; i++) {
            for (int j = 0; j < hSprite; j++) {
                spriteArray[i][j] = getSprite(i, j);
            }
        }
    }

    public BufferedImage getSpriteSheet() {
        return spriteSheet;
    }

    public BufferedImage getSprite(int i, int j) {
        return spriteSheet.getSubimage(i * w, j * h, w, h);
    }

    public BufferedImage[] getSpriteArray(int i) {
        return spriteArray[i];
    }

    public BufferedImage[][] getAllSpriteArray(int i) {
        return spriteArray;
    }

    public static void drawArray(Graphics2D graphics2D, ArrayList<BufferedImage> spriteImages, Vector2f position, int width, int height, int xOffset, int yOffset) {
        float x = position.x;
        float y = position.y;


        for (int i = 0; i < spriteImages.size(); i++) {
            graphics2D.drawImage(spriteImages.get(i), (int) x, (int) y, width, height, null);
        }

        x += xOffset;
        y += yOffset;
    }

    public static void drawArray(Graphics2D graphics2D, Font f, String word, Vector2f position, int width, int height, int xOffset, int yOffset) {
        float x = position.x;
        float y = position.y;

        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != 32) {
                graphics2D.drawImage(f.getLetter(word.charAt(i)), (int) x,(int) y, width, height, null);
            }

            x += xOffset;
            y += yOffset;
        }
    }
}
