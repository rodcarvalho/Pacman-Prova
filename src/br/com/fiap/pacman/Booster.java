public class Booster extends Item {
    private int duration;

    public Booster(){

    }

    public Booster(int positionX, int positionY, int duration){
        super(positionX, positionY);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if(isPositive(duration))
        this.duration = duration;
    }

    
}
