import java.lang.Math;

public class Ghost extends GameObject {
    private int direction;

    public Ghost() {
    }

    public Ghost(int positionX, int positionY, int direction) {
        super(positionX, positionY);
        if(isValid(direction, 360))
        this.direction = direction;
    }

    private boolean canMove(int direction) {
        int newPositionX = getPositionX();
        int newPositionY = getPositionY();
        switch (direction) {
            case 0:
                newPositionX += 10;
                break;
            case 1:
                newPositionY -= 10;
                break;

            case 2:
                newPositionX -= 10;
                break;

            case 3:
                newPositionY += 10;
                break;

            default:
                break;
        }

        if (!isValid(newPositionX, getScreensize()) || !isValid(newPositionY, getScreensize()))
            return false;

        return true;
    }

    public void move() {
        setDirection((int)(Math.random() * 3 ));
        if (canMove(direction)) {
            switch (direction) {
                case 0:
                    setPositionX(getPositionX() + 10);
                    break;
                case 1:
                    setPositionY(getPositionY() - 10);
                    break;

                case 2:
                    setPositionX(getPositionX() - 10);
                    break;

                case 3:
                    setPositionY(getPositionY() + 10);
                    break;

                default:
                    break;
            }
        }
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        if(isValid(direction, getScreensize()))
        this.direction = direction;
    }

}
