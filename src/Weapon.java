public abstract class Weapon  extends Item{
    private int damage;
    public Weapon(String shortName,String longNamme,int damage){
        super(shortName,longNamme);
        this.damage=damage;
    }
    public  int getDamage(){return damage;};
    public abstract  boolean canUse();
    public abstract  void  use();
    public abstract String getAttackVerb();
    public abstract String getUsesLeftText();

}
