package Tools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ImageLoader {

    public ImageLoader(){

    }

    public BufferedImage Load(String name) {
        BufferedImage result = null;

        try {
            result = ImageIO.read(Objects
                    .requireNonNull(getClass().getResourceAsStream("src/main/resources/Textures " + name)));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
