public abstract class GameObject {
    private int positionX;
    private int positionY;
    private int SCREENSIZE;

    public int getPositionX() {
        return positionX;
    }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public int getPositionY() {
        return positionY;
    }
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    public int getSCREENSIZE() {
        return SCREENSIZE;
    }
    public void setSCREENSIZE(int sCREENSIZE) {
        if(sCREENSIZE <0) return;
        SCREENSIZE = sCREENSIZE;
    }

    
}
