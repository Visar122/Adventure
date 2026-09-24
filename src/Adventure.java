public class Adventure {
    private Map map=new Map();
    private Player player=new Player(map.getStartRoom());
    private UserInterface ui=new UserInterface();

    public void Start(){
        ui.welcome();
        look();
        boolean run=true;

        while (run){

            String input=ui.getInput();

            switch (input){

                case "go east", "east", "e" -> move(player.getCurrentRoom().getEast());
                case "go west","west","w"->move(player.getCurrentRoom().getWest());
                case "go south","south","s"->move(player.getCurrentRoom().getSouth());
                case "go north","north","n"->move(player.getCurrentRoom().getNorth());
                case "look","l"->look();
                case "exit","x"->run=false;
                default -> {
                    ui.wrongCommand();
                    look();
                }
            }

        }
        ui.goodbye();
    }

    private void move(Room nextRoom){
        if (!player.move(nextRoom)) {
            ui.cannotGo();
        }
        look();
    }

    private void look(){
        ui.look(player.getCurrentRoom());
    }
}