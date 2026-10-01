public class Food extends Item{
    private int healthPoints;

    public Food(String shortName,String longName,int healthpoints){
        super(shortName,longName);
        this.healthPoints=healthpoints;
    }
    public int getHealthpoints(){
        return healthPoints;
    }
}
