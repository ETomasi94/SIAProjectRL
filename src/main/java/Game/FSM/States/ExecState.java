package Game.FSM.States;

import Game.FSM.State;
import Game.FSM.StateManager;
import Game.Handlers.KeyboardHandler;
import Game.Handlers.MouseHandler;

import java.awt.*;

public class ExecState extends State {

    private Game.World.Font font;

    public ExecState(StateManager stateManager) {
        super(stateManager);
        font = new Game.World.Font("Fonts/galaxyfont.png",16,16);
    }

    @Override
    public void update() {
    }

    @Override
    public void input(MouseHandler mouseHandler, KeyboardHandler keyboardHandler) {
        if (keyboardHandler.up.isDown) {
           System.out.println("UP KEY!");
        }
    }

    @Override
    public void render(Graphics2D graphics2D) {
        graphics2D.setColor(Color.RED);
        graphics2D.fillRect(100,100,64,64);
    }
}