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
        Room3.addItem(new Food("mushroom", "a suspicious mushroom", -100));
        Room1.addItem(new MeleeWeapon("knife","a sharp knife",10));
        Room2.addItem(new RangedWeapon("Pistol" ,"a silver pistol",30,5));


        Enemy goblin=new Enemy("goblin","a sneaky goblin","A small green goblin grins at you, holding a rusty dagger.",
                20,new MeleeWeapon("dagger","a rusty dagger",8),Room1);
        Room1.addEnemy(goblin);

        Enemy archer=new Enemy("archer","a skeleton archer","A rattling skeleton aims a bow at you.",
                40,new RangedWeapon("bow","an old bow",12,2),Room3);
        Room3.addEnemy(archer);

        Enemy troll=new Enemy("Monster","a big Monster","A huge, Monster guards the room, gripping a heavy wooden club.",
                60,new MeleeWeapon("club","a heavy wooden club",30),Room6);
        Room6.addEnemy(troll);


    }

    public Room getStartRoom(){
        return startRoom;
    }
}