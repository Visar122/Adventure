import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner=new Scanner(System.in);

    public void welcome(){
        System.out.println("Welcome to the game !");
        System.out.println("To continoue type where you want to move : e = (east) | w = (west)  | s = (south) | n = (north)");
        System.out.println("Other  look | take <item> | drop <item> | inventory | exit");
        System.out.println("");
    }

    public String getInput(){
        System.out.print("> ");
        return scanner.nextLine().toLowerCase().trim();
    }

    public void look(Room currentRoom){
        System.out.println("You are currently in :" +currentRoom.GetName());
        System.out.println("You are currently in :" +currentRoom.GetDescription());
        if (!currentRoom.getItems().isEmpty()) {
            System.out.println("Here you see: " +itemList(currentRoom.getItems()));
        }
    }

    public void showInventory(ArrayList<Item> inventory){
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("You are carrying: " +itemList(inventory));
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
}
 