import javax.xml.crypto.KeySelector.Purpose;

public class Player extends GameObject{
    private int direction;
    private int life;
    private boolean godMode;


    public Player() {
    }

    public Player(int x, int y, int direction) {
        
    }

    private boolean canMove(){
        return false;
    }

    public void move(){

    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public boolean isGodMode() {
        return godMode;
    }

    public void setGodMode(boolean godMode) {
        this.godMode = godMode;
    }

    
}
