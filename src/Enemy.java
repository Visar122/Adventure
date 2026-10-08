public class Enemy {
    private String shortName;
    private String longName;
    private String description;
    private  int health;
    private Weapon weapon;
    private Room room;

    public Enemy(String shortName,String longName,String description,int health,Weapon weapon,Room room){
        this.shortName=shortName;
        this.longName=longName;
        this.description=description;
        this.health=health;
        this.weapon=weapon;
        this.room=room;
    }

    public String getShortName(){return shortName;}
    public String getLongName(){return longName;}
    public String getDescription(){return description;}
    public int getHealth(){
        if (health<0){health=0;}
        return health;}
    public Weapon getWeapon(){return weapon;}

    public boolean isDead(){
        return health<=0;
    }

    // fjenden mister liv - hvis den dør, fjerner den sig selv fra rummet og taber sit våben
    public void hit(int damage){
        health-=damage;
        if (isDead()){
            room.removeEnemy(this);
            room.addItem(weapon);
        }
    }

    // fjenden angriber spilleren - returnerer false hvis våbnet er tomt
    public boolean attack(Player player){
        if (!weapon.canUse()){
            return false;
        }
        weapon.use();
        player.takeDamage(weapon.getDamage());
        return true;
    }
}
