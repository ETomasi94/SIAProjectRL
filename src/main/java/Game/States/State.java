package Game.States;

import Game.Handlers.KeyboardHandler;
import Game.Handlers.MouseHandler;
import java.awt.*;

public abstract class State {

    protected StateManager stateManager;

    public State(StateManager gameStateManager) {
        stateManager = gameStateManager;
    }

    public abstract void update();
    public abstract void input(MouseHandler mouseHandler, KeyboardHandler keyboardHandler);
    public abstract void render(Graphics2D graphics2D);

}
