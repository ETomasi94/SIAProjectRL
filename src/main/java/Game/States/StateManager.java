package Game.States;

import Game.Handlers.KeyboardHandler;
import Game.Handlers.MouseHandler;

import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;

public class StateManager {

    private ArrayList<State> gameStates;

    public StateManager() {
        gameStates = new ArrayList<>();

        gameStates.add(new ExecState(this));
    }


    public void updateAllStates() {
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
