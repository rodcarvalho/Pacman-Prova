public abstract class GameObject {
    private int positionX;
    private int positionY;
    private int SCREENSIZE;

    public GameObject() {
    }

    public GameObject(int positionX, int positionY) {
        if(isPositive(positionX))
        this.positionX = positionX;

        if(isPositive(positionY))
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        if (isValid(positionX, getScreensize()))
            this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        if (isValid(positionY, getScreensize()))
            this.positionY = positionY;
    }

    public int getScreensize() {
        return SCREENSIZE;
    }

    public void setScreenSize(int sCREENSIZE) {
        if (sCREENSIZE < 0)
            return;
        SCREENSIZE = sCREENSIZE;
    }

    public boolean isValid(int value, int maxValue) {
        if (!isPositive(value) || value > maxValue)
            return false;

        return true;
    }

    public boolean isPositive(int value) {
        if (value < 0)
            return false;

        return true;
    }
}
