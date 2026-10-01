public class EatOutcome {
    private EatResult result;
    private  String  longName;
    private int healthChange;

    public EatOutcome(EatResult result,String longName,int healthChange){
        this.result=result;
        this.longName=longName;
        this.healthChange=healthChange;
    }

    public EatResult getResult(){return result;}
    public String getLongName(){return longName;}
    public int GetHealthchange(){return healthChange;}
}
