package Game.World;

import Tools.ImageLoader;

import java.awt.image.BufferedImage;

public enum TileType {

    Grass("Grass16",true),
    Dirt("Dirt16",true),
    Spikes("Spikes16",true),
    Cloud("Cloud16",true),
    Sky("Sky16",true);

    String textureName;
    boolean buildableProperty;
    BufferedImage image;
    ImageLoader imageLoader = new ImageLoader();

    TileType(String nameOfTexture,boolean isBuildable) {
        this.textureName = nameOfTexture;
        this.buildableProperty = isBuildable;
        this.image = imageLoader.Load(nameOfTexture);
    }
}
