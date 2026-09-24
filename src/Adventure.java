import java.util.Scanner;

public class Adventure {
    private Room currentRoom;

    private Scanner scanner=new Scanner(System.in);

    public void Start(){

        Room Room1=new Room("Room 1", "A room with no distinct features, except two doors.");
        Room Room2=new Room("Room 2", "Water drips from the ceiling somewhere in the dark.");
        Room Room3=new Room("Room 3", "A   Room  with a lightbulp.");
        Room Room4=new Room("Room 4", "A  room with a chair .");
        Room Room5=new Room("Room 5", "A slippery room .");
        Room Room6=new Room("Room 6", "A loud room with speakers .");
        Room Room7=new Room("Room 7", "A  bright room with flashlight  .");
        Room Room8=new Room("Room 8", "A  room with a window with a garden view  .");
        Room Room9=new Room("Room 9", "Finish you won , You are in room9  .");

        Room1.setEast(Room2);
        Room1.setWest(Room2);
        Room1.setSouth(Room4);
        Room1.setNorth(Room4);

        Room2.setEast(Room3);
        Room2.setWest(Room3);

        Room3.setSouth(Room6);
        Room3.setNorth(Room6);

        Room4.setSouth(Room7);
        Room4.setNorth(Room7);

        Room5.setSouth(Room8);
        Room5.setNorth(Room8);

        Room6.setSouth(Room9);
        Room6.setNorth(Room9);

        Room7.setEast(Room8);
        Room7.setWest(Room8);

        Room8.setEast(Room9);
        Room8.setWest(Room9);

        currentRoom=Room1;
        System.out.println("Welcome to the game !");
        System.out.println("To continoue type where you want to move : e = (east) | w = (west)  | s = (south) | n = (north)");
        System.out.println("");
        look();
        boolean run=true;


        while (run){

            System.out.print("> ");
            String input=scanner.nextLine().toLowerCase().trim();

            switch (input){

                case "go east", "east", "e" -> move(currentRoom.getEast());
                case "go west","west","w"->move(currentRoom.getWest());
                case "go south","south","s"->move(currentRoom.getSouth());
                case "go north","north","n"->move(currentRoom.getNorth());
                case "look","l"->look();
                case "exit","x"->run=false;
                default -> {
                    System.out.println("Wrong coomman! Try again.");
                    look();
                }
            }

        }
        System.out.println("Goodbye!");
    }
    private void move(Room nextRoom){
        if (nextRoom == null) {
            System.out.println("You cannot go that way pick another way ");
            look();
            return;
        }
        currentRoom=nextRoom;
                look();
    }
    private void look(){
        System.out.println("You are currently in :" +currentRoom.GetName());
        System.out.println("You are currently in :" +currentRoom.GetDescription());
    }

}
