public class Player extends GameObject {
    private int direction;
    private int life;
    private boolean godMode;

    public Player() {
    }

    public Player(int positionX, int positionY, int direction) {
        super(positionX, positionY);
        if(isValid(direction, 360))
        this.direction = direction;
    }

    private boolean canMove(int direction) {
        int newPositionX = getPositionX();
        int newPositionY = getPositionY();
        switch (direction) {
            case 90:
                newPositionX += 10;
                break;
            case 0:
                newPositionY -= 10;
                break;

            case 270:
                newPositionX -= 10;
                break;

            case 180:
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
        if (canMove(direction)) {
            switch (direction) {
                case 90:
                    setPositionX(getPositionX() + 10);
                    break;
                case 0:
                    setPositionY(getPositionY() - 10);
                    break;

                case 270:
                    setPositionX(getPositionX() - 10);
                    break;

                case 180:
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
        if(isValid(direction, 360))
        this.direction = direction;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        if(isPositive(life))
        this.life = life;
    }

    public boolean isGodMode() {
        return godMode;
    }

    public void setGodMode(boolean godMode) {
        this.godMode = godMode;
    }


    

}
