package Game.World;

public class Tile {
    private float x,y,width,height;
    private TileType tileType;

    public Tile(float tileX,float tileY,float tileWidth,float tileHeight,TileType type) {
        x = tileX;
        y = tileY;
        width = tileWidth;
        height = tileHeight;
        tileType = type;
    }
}
