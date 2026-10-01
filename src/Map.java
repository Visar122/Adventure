public class Map {
    private Room startRoom;

    public Map() {
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
        startRoom=Room1;

        Room1.addItem(new Item("lamp", "a shiny brass lamp"));
        Room2.addItem(new Item("coins", "some gold coins"));
        Room3.addItem(new Item("lightbulb", "a flickering lightbulb"));
        Room4.addItem(new Item("chair", "a wooden chair"));
        Room6.addItem(new Item("speaker", "a small speaker"));
        Room7.addItem(new Item("flashlight", "a bright flashlight"));
        Room8.addItem(new Item("key", "a rusty key"));


        Room1.addItem(new Food("apple", "a red apple", 20));
        Room5.addItem(new Food("bread", "a loaf of bread", 15));
        Room3.addItem(new Food("mushroom", "a suspicious mushroom", -30));


    }

    public Room getStartRoom(){
        return startRoom;
    }
}