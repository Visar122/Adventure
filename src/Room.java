import java.util.ArrayList;

public class Room {
     private String Name;
     private String Description;
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private ArrayList<Item> items=new ArrayList<>();
    private ArrayList<Enemy> enemies=new ArrayList<>();




     public Room(String name,String description){
         this.Name=name;
         this.Description=description;
     }

     public String GetName(){return Name;}

    public String GetDescription(){return Description;}

    public void setNorth(Room room){this.north=room;}

    public Room getNorth(){
         return  north;
    }

    public void setEast(Room room){this.east=room;}

    public Room getEast(){return  east;}


    public void setSouth(Room room){this.south=room;}

    public Room getSouth(){return  south;}

    public void setWest(Room room){this.west=room;}

    public Room getWest(){return  west;}



    public void addItem(Item item){items.add(item);}

    public void removeItem(Item item){items.remove(item);}

    public ArrayList<Item> getItems(){return items;}

    public Item findItem(String shortName){
        for (Item item : items) {
            if (item.getShortName().equalsIgnoreCase(shortName)) {
                return item;
            }
        }
        return null;
    }

    public void addEnemy(Enemy enemy){enemies.add(enemy);}

    public void removeEnemy(Enemy enemy){enemies.remove(enemy);}

    public ArrayList<Enemy> getEnemies(){return enemies;}

    public Enemy findEnemy(String shortName){
        for (Enemy enemy : enemies) {
            if (enemy.getShortName().equalsIgnoreCase(shortName)) {
                return enemy;
            }
        }
        return null;
    }
}
