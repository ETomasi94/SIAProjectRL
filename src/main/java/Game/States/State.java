package Game.States;

import javax.swing.table.TableRowSorter;
import java.awt.*;

public abstract class State {

    protected StateManager stateManager;

    public State(StateManager gameStateManager) {
        stateManager = gameStateManager;
    }

    public abstract void update();

    public abstract void input();

    public abstract void render(Graphics2D graphics2D);

}
