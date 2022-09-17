public class Item extends GameObject{
    private boolean visible = true;

    public Item() {
    }

    public Item(int positionX, int positionY) {
        super(positionX, positionY);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    

    
}
