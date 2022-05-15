package Game.FSM.States;

import Game.Elements.MainCharacter;
import Game.FSM.State;
import Game.FSM.StateManager;
import Game.Handlers.KeyboardHandler;
import Game.Handlers.MouseHandler;
import Game.World.Sprite;
import Tools.ImageLoader;
import org.newdawn.slick.geom.Vector2f;

import java.awt.*;

public class ExecState extends State {

    private Game.World.Font font;

    private MainCharacter mainCharacter;

    public ExecState(StateManager stateManager) {
        super(stateManager);
        font = new Game.World.Font("Fonts/galaxyfont.png",16,16);
        mainCharacter = new MainCharacter(new Sprite("Elements/Idle.png",16,16),new Vector2f(300,300),32);
    }

    @Override
    public void update() {
        mainCharacter.update();
    }

    @Override
    public void input(MouseHandler mouseHandler, KeyboardHandler keyboardHandler) {
        mainCharacter.input(mouseHandler,keyboardHandler);
    }

    @Override
    public void render(Graphics2D graphics2D){
        mainCharacter.render(graphics2D);
    }
}
