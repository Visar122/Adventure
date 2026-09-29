import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory=new ArrayList<>();

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
        inventory.remove(item);
        currentRoom.addItem(item);
        return item;
    }
}
