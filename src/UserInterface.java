import java.util.Scanner;

public class UserInterface {
    private Scanner scanner=new Scanner(System.in);

    public void welcome(){
        System.out.println("Welcome to the game !");
        System.out.println("To continoue type where you want to move : e = (east) | w = (west)  | s = (south) | n = (north)");
        System.out.println("");
    }

    public String getInput(){
        System.out.print("> ");
        return scanner.nextLine().toLowerCase().trim();
    }

    public void look(Room currentRoom){
        System.out.println("You are currently in :" +currentRoom.GetName());
        System.out.println("You are currently in :" +currentRoom.GetDescription());
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
 