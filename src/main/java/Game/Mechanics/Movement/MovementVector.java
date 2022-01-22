package Game.Mechanics.Movement;

public class MovementVector {
    public float xPosition;
    public float yPosition;

    public static float globalX;
    public static float globalY;

    public MovementVector() {
        xPosition = 0;
        yPosition = 0;
    }

    public MovementVector(float xPos,float yPos) {
        xPosition = xPos;
        yPosition = yPos;
    }

    public MovementVector(MovementVector movementVector) {
        new MovementVector(movementVector.xPosition,movementVector.yPosition);
    }

    public void moveX(float movementQuantity) {
        xPosition += movementQuantity;
    }

    public void moveY(float movementQuantity) {
        yPosition += movementQuantity;
    }

    public void setX(float establishedPosition) {
        xPosition = establishedPosition;
    }

    public void setY(float establishedPosition) {
        yPosition = establishedPosition;
    }

    public void setVector(MovementVector movementVector) {
        xPosition = movementVector.xPosition;
        yPosition = movementVector.yPosition;
    }

    public void setVector(float xPos,float yPos) {
        xPosition = xPos;
        yPosition = yPos;
    }

    public static void setGlobal(float X, float Y) {
        globalX = X;
        globalY = Y;
    }

    public MovementVector getGlobalRelVector() {
        return new MovementVector(xPosition - globalX, yPosition - globalY);
    }

    public String coordToString() {
        return xPosition + "," + yPosition;
    }

}
