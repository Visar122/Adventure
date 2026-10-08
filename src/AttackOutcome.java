public class AttackOutcome {
    private AttackResult result;
    private Enemy enemy;

    public AttackOutcome(AttackResult result,Enemy enemy){
        this.result=result;
        this.enemy=enemy;
    }

    public AttackResult getResult(){return result;}
    public Enemy getEnemy(){return enemy;}
}
