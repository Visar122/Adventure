import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner=new Scanner(System.in);

    public void welcome(){
        System.out.println("Welcome to the game !");
        System.out.println("To continoue type where you want to move : e = (east) | w = (west)  | s = (south) | n = (north)");
        System.out.println("Other  look | take <item> | drop <item> | eat <item> | equip <weapon> | attack <enemy> | health | inventory | exit");
        System.out.println("");
    }

    public String getInput(){
        System.out.print("> ");
        return scanner.nextLine().toLowerCase().trim();
    }

    public void look(Room currentRoom,int health){
        System.out.println("You are currently in :" +currentRoom.GetName());
        System.out.println("You are currently in :" +currentRoom.GetDescription());
        System.out.println("Your health: " +health +" %");
        if (!currentRoom.getItems().isEmpty()) {
            System.out.println("Here you see: " +itemList(currentRoom.getItems()));
        }
        for (Enemy enemy : currentRoom.getEnemies()) {
            System.out.println("Beware! There  is a : " +enemy.getDescription());

        }

    }

    public void showInventory(ArrayList<Item> inventory,Weapon equippedWeapon){
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("You are carrying: " +itemList(inventory));
        }
        if (equippedWeapon==null){
            System.out.println("You have no  weapon eqquiped ");
        }
        else {
            System.out.println("Eqquiped: " + equippedWeapon.getLongName());
        }
    }

    public void taken(Item item){
        System.out.println("You have taken " +item.getLongName());
    }

    public void dropped(Item item){
        System.out.println("You have dropped " +item.getLongName());
    }

    public void nothingToTake(String shortName){
        System.out.println("There is nothing like " +shortName+ " to take around here");
    }

    public void notInInventory(String shortName){
        System.out.println("You don't have anything like " +shortName+ " in your inventory");
    }

    private String itemList(ArrayList<Item> items){
        String result="";
        for (int i=0; i<items.size(); i++) {
            if (i > 0) {
                result+=", ";
            }
            result+=items.get(i).getLongName();
        }
        return result;
    }

    public void cannotGo(){
        System.out.println("You cannot go that way pick another way ");
    }

    public void wrongCommand(){
        System.out.println("Wrong coomman! Try again.");
    }

    public void goodbye(){
        System.out.println("Goodbye!");
    }


    public void Showhealth(int health){
        System.out.println("Your Health: " +health );
        if (health >=100) System.out.println("You have full health");
        else if (health >= 50) System.out.println("you are in good health, but avoid fighting right now");
        else if (health >= 25) System.out.println("you are wounded - find something healthy to eat");
        else if (health >= 1) System.out.println("you are barely alive");
        else System.out.println("you should be dead");
    }
    public void eatResult(EatOutcome eatOutcome,int health){
        switch (eatOutcome.getResult()){
            case NOT_FOUND -> System.out.println("There is nothing like" + eatOutcome.getLongName()+"to eat around here");
            case NOT_FOOD -> System.out.println("You cannot eat"+eatOutcome.getLongName());
            case EATEN -> System.out.println("You ate " + eatOutcome.getLongName()+ "(health: + " + eatOutcome.GetHealthchange()+ ") - health : " + health+"%");
        }
    }
    public void equipResult(EquipResult result,String shortName){
        switch (result){
            case NOT_FOUND -> System.out.println("You have nothing like   " + shortName + " in the inventory");
            case NOT_WEAPON -> System.out.println(  shortName + " Is not a Weapon");
            case EQUIPPED -> System.out.println("You have eqqupied a : " + shortName);
        }
    }
    public void  attackResult(AttackOutcome outcome,Weapon weapon,int health){
        Enemy enemy=outcome.getEnemy();
        switch (outcome.getResult()){
            case NO_WEAPON -> System.out.println("You have no weapon to attack with");
            case NO_AMMO -> System.out.println(weapon.getShortName() +" has "+ weapon.getUsesLeftText());
            case ENEMY_NOT_FOUND -> System.out.println("There is no enemy like that here");
            case ATTACKED_AIR -> System.out.println("You " +weapon.getAttackVerb()+ " your " +weapon.getLongName()+ " at the air " + weapon.getUsesLeftText());
            case ENEMY_KILLED -> {
                playerHits(enemy,weapon);
                System.out.println(enemy.getLongName()+ " dies, dropping " +enemy.getWeapon().getLongName()+ ".");
            }
            case ENEMY_COUNTERATTACKED -> {
                playerHits(enemy,weapon);
                Weapon enemyWeapon=enemy.getWeapon();
                System.out.println(enemy.getLongName()+ " " +enemyWeapon.getAttackVerb()+ "s " +enemyWeapon.getLongName()+
                        " at you - " +enemyWeapon.getDamage()+ " damage.");
                System.out.println("You are at: " + health + "% health");
                System.out.println(enemy.getLongName() +"is still learking around");

            }
            case ENEMY_NO_AMMO -> {
                playerHits(enemy,weapon);
                System.out.println(enemy.getLongName()+ " tries to fight back, but " +enemy.getWeapon().getLongName()+ " is empty!");
            }
        }
    }

    private void playerHits(Enemy enemy,Weapon weapon){
        System.out.println("You hit " +enemy.getLongName()+ " with " +weapon.getLongName()+
                " + " +weapon.getDamage()+ " damage. " +weapon.getUsesLeftText());
        System.out.println("Enemies health : " +enemy.getHealth() + "%");
    }

    public void gameOver(){
        System.out.println("Your health has reached 0. You have died - GAME OVER!");
    }
}
 