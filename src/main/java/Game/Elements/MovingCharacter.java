package Game.Elements;

public interface MovingCharacter {

    void startCharacter(int x,int y);

    void characterDeath(Score s);

    void moveUp();

    void moveDown();

    void moveLeft();

    void moveRight();

    void stopIfUp();

    void stopIfDown();

    void stopIfLeft();

    void stopIfRight();

    void physicalAttack();
}
