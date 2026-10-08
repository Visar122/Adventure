import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory=new ArrayList<>();

    public int health=100;

    private  Weapon eqquipedWeapon;

    public Player(Room startRoom){
        currentRoom=startRoom;
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public boolean move(Room nextRoom){
        if (nextRoom == null) {
            return false;
        }
        currentRoom=nextRoom;
        return true;
    }

    public ArrayList<Item> getInventory(){
        return inventory;
    }



    public Item findItem(String shortName){
        for (Item item : inventory) {
            if (item.getShortName().equalsIgnoreCase(shortName)) {
                return item;
            }
        }
        return null;
    }

    public Item takeItem(String shortName){
        Item item=currentRoom.findItem(shortName);
        if (item == null) {
            return null;
        }
        currentRoom.removeItem(item);
        inventory.add(item);
        return item;
    }

    public Item dropItem(String shortName){
        Item item=findItem(shortName);
        if (item == null) {
            return null;
        }
        if(item==eqquipedWeapon){
            eqquipedWeapon=null;
        }
        inventory.remove(item);
        currentRoom.addItem(item);
        return item;
    }

    public int getHealth(){
        return  health;
    }

    public EatOutcome eat(String shortName){
        Item item=findItem(shortName);
        boolean inInventory=item!=null; //so det betyder hvis den er ikke null så  findItem fandt noget
        if (item==null){
            item=currentRoom.findItem(shortName);
        }
        if (item==null){
            return new EatOutcome(EatResult.NOT_FOUND, shortName, 0);
        }
        if(!(item instanceof Food food)){ // instance of tjekker om det er item eller food
            return new EatOutcome(EatResult.NOT_FOOD, item.getLongName(), 0);
        }
        if(inInventory){
            inventory.remove(food);   // hvis food er i inventory så   fjerner den det
        }
        else {
            currentRoom.removeItem(food);
        }
        health+=food.getHealthpoints();
        if(health>100){
            health=100;
        }
        return new EatOutcome(EatResult.EATEN,food.getLongName(),food.getHealthpoints());

    }



    public  Weapon getEqquipedWeapon(){
        return eqquipedWeapon;
    }
    public  EquipResult equip(String shortname){
        Item item=findItem(shortname);
        if(item==null){
           return EquipResult.NOT_FOUND;
        }
        if(!(item instanceof Weapon weapon)){
            return  EquipResult.NOT_WEAPON;
        }
        eqquipedWeapon=weapon;
        return  EquipResult.EQUIPPED;
    }
    public AttackOutcome attack(String enemyName){

        if (eqquipedWeapon==null){
            return new AttackOutcome(AttackResult.NO_WEAPON,null);
        }

        // find fjenden - intet navn betyder den første fjende i rummet (eller ingen)
        Enemy enemy=null;
        if (enemyName.isEmpty()){
            if (!currentRoom.getEnemies().isEmpty()){
                enemy=currentRoom.getEnemies().get(0);
            }
        } else {
            enemy=currentRoom.findEnemy(enemyName);
            if (enemy==null){
                return new AttackOutcome(AttackResult.ENEMY_NOT_FOUND,null); // forkert navn - ingen ammo brugt
            }
        }

        if(!eqquipedWeapon.canUse()){
            return new AttackOutcome(AttackResult.NO_AMMO,enemy);
        }
        eqquipedWeapon.use();



        if (enemy==null){
            return new AttackOutcome(AttackResult.ATTACKED_AIR,null);
        }


        enemy.hit(eqquipedWeapon.getDamage());
        if (enemy.isDead()){
            return new AttackOutcome(AttackResult.ENEMY_KILLED,enemy);
        }

        // fjenden overlevede  den slår igen
        if (!enemy.attack(this)){
            return new AttackOutcome(AttackResult.ENEMY_NO_AMMO,enemy);
        }
        return new AttackOutcome(AttackResult.ENEMY_COUNTERATTACKED,enemy);
    }

    public void takeDamage(int damage){
        health-=damage;
    }

    public boolean isDead(){
        return health<=0;
    }
}
