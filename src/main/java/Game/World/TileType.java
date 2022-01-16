package Game.World;

public enum TileType {

    Grass("Grass64",true),
    Dirt("Dirt64",true),
    Spikes("Spikes64",true),
    Cloud("Cloud64",true),
    Sky("Sky64",true);

    String textureName;
    boolean buildableProperty;

    TileType(String nameOfTexture,boolean isBuildable) {
        this.textureName = nameOfTexture;
        this.buildableProperty = isBuildable;
    }
}
