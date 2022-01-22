package Game.Elements;

public class Score {
    int stepsTaken;
    int enemiesKilled;
    int difficultySet;
    double timeElapsed;

    /**
     * Inizializza un'istanza del punteggio per la partita corrente
     *
     * @param difficultySetByGame difficoltà impostata dal gioco
     */
    public Score(int difficultySetByGame) {
        stepsTaken = 0;
        enemiesKilled = 0;
        difficultySet = difficultySetByGame;
        timeElapsed = 0.0;
    }
}
