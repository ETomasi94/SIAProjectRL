package Tools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ImageLoader {

    String texturesFolder = "src/main/resources/Textures/";
    String spritesFolder = "src/main/resources/Sprites/";

    public ImageLoader(){

    }

    public BufferedImage loadTexture(String name) {
        BufferedImage result = null;

        try {
            result = ImageIO.read(Objects
                    .requireNonNull(getClass().getResourceAsStream(texturesFolder + name)));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public BufferedImage loadSprite(String name) {
        BufferedImage result = null;

        try {
            result = ImageIO.read(Objects
                    .requireNonNull(getClass().getResourceAsStream(spritesFolder + name)));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
