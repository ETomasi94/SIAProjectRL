package Game.FSM;

import Game.FSM.States.EndState;
import Game.FSM.States.ExecState;
import Game.FSM.States.MenuState;
import Game.FSM.States.StateOfPause;
import Game.GamePanel;
import Game.Handlers.KeyboardHandler;
import Game.Handlers.MouseHandler;
import Game.Mechanics.Movement.MovementVector;

import java.awt.*;
import java.util.ArrayList;

public class StateManager {

    private final ArrayList<State> gameStates;

    public static MovementVector movementMap;

    public static final int EXEC = 0;
    public static final int MENU = 1;
    public static final int PAUSE = 2;
    public static final int END = 3;

    public StateManager() {
        movementMap = new MovementVector(GamePanel.gameWidth,GamePanel.gameHeight);

        MovementVector.setGlobal(movementMap.xPosition, movementMap.yPosition);

        gameStates = new ArrayList<>();

        gameStates.add(new ExecState(this));
    }

    public void removeState(int state) {
        gameStates.remove(state);
    }

    public void addState(int state) {
        if (state == EXEC) {
           gameStates.add(new ExecState(this));
        }
        if (state == MENU) {
            gameStates.add(new MenuState(this));
        }
        if(state == PAUSE) {
            gameStates.add(new StateOfPause(this));
        }
        if(state == END) {
            gameStates.add(new EndState(this));
        }
    }

    public void newStatePut(int state) {
        gameStates.remove(0);
        addState(state);
    }

    public void updateAllStates() {
        MovementVector.setGlobal(movementMap.xPosition, movementMap.yPosition);

        for (State s : gameStates) {
            s.update();
        }
    }

    public void getInputFromAllStates(MouseHandler mouseHandler,KeyboardHandler keyboardHandler) {
        for (State s : gameStates) {
            s.input(mouseHandler,keyboardHandler);
        }
    }

    public void renderAllStates(Graphics2D graphics2D) {
        for (State s : gameStates) {
            s.render(graphics2D);
        }
    }

    public void update() {
        updateAllStates();
    }

    public void input(MouseHandler mouseHandler, KeyboardHandler keyboardHandler) {
        getInputFromAllStates(mouseHandler,keyboardHandler);
    }

    public void render(Graphics2D graphics2D) {
        renderAllStates(graphics2D);
    }
}
