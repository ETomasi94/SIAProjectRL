package Game.World;

import org.newdawn.slick.*;
import org.newdawn.slick.opengl.Texture;

import java.util.logging.Level;

public class LevelGrid {

    public Tile[][] levelMap;

    public LevelGrid() {
        levelMap = new Tile[15][15];

        for (int i=0; i<levelMap.length; i++) {
            for (int j=0; j<levelMap[i].length; j++) {
                levelMap[i][j] = new Tile(i*64,j*64,64,64,TileType.Grass);
            }
        }
    }
}
