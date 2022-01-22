package Game.States;

import Game.Handlers.KeyboardHandler;
import Game.Handlers.MouseHandler;

import java.awt.*;

public class ExecState extends State {

    public ExecState(StateManager stateManager) {
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
        graphics2D.setColor(Color.RED);
        graphics2D.fillRect(100,100,64,64);
    }
}
