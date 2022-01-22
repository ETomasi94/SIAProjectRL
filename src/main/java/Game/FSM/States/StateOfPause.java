package Game.FSM.States;

import Game.FSM.State;
import Game.FSM.StateManager;
import Game.Handlers.KeyboardHandler;
import Game.Handlers.MouseHandler;

import java.awt.*;

public class StateOfPause extends State {
    public StateOfPause(StateManager stateManager) {
        super(stateManager);
    }

    @Override
    public void update() {

    }

    @Override
    public void input(MouseHandler mouseHandler, KeyboardHandler keyboardHandler) {

    }

    @Override
    public void render(Graphics2D graphics2D) {

    }
}
