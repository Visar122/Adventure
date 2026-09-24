public class Player {
    private Room currentRoom;

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
}