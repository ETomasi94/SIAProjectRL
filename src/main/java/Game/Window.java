package Game;

import Game.World.Sprite;

import javax.swing.*;

public class Window extends JFrame {
    public Window() {
        setTitle("Antonelli's Legacy");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel(800,600));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
