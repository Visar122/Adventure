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


            String[] parts=input.split(" ", 2);  //deler den til 2 så   fx take lamp parts[0] = "take" parts[1] = "lamp"
            String command=parts[0]; // tager command så den tager  hvad den skal gør fx tage kun  command = "take" eller "drop",  handling (what to do).
            String argument=parts.length > 1 ? parts[1].trim() : "";  //hvis  parts den er større end 1 så er  argument == fx lamp eller så er det "" string fx brugeren ønsker look

            switch (command){

                case "go" -> {
                    switch (argument){
                        case "east" -> move(player.getCurrentRoom().getEast());
                        case "west" -> move(player.getCurrentRoom().getWest());
                        case "south" -> move(player.getCurrentRoom().getSouth());
                        case "north" -> move(player.getCurrentRoom().getNorth());
                        default -> ui.wrongCommand();
                    }
                }
                case "east", "e" -> move(player.getCurrentRoom().getEast());
                case "west","w"->move(player.getCurrentRoom().getWest());
                case "south","s"->move(player.getCurrentRoom().getSouth());
                case "north","n"->move(player.getCurrentRoom().getNorth());
                case "look","l"->look();
                case "inventory","inv","invent"->ui.showInventory(player.getInventory(),player.getEqquipedWeapon());
                case "take","t"->take(argument);
                case "drop","d"->drop(argument);
                case "health","h"->ui.Showhealth(player.getHealth());
                case "eat"->ui.eatResult(player.eat(argument),player.getHealth());
                case "equip"->ui.equipResult(player.equip(argument),argument);
                case "attack","a"->ui.attackResult(player.attack(argument),player.getEqquipedWeapon(), player.getHealth());
                case "exit","x"->run=false;
                default -> {
                    ui.wrongCommand();
                    look();
                }
            }

            // spillet slutter hvis spilleren dør (fra en fjende eller giftig mad)
            if (player.isDead()){
                ui.gameOver();
                run=false;
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
        ui.look(player.getCurrentRoom(),player.getHealth());
    }

    private void take(String shortName){
        Item item=player.takeItem(shortName);
        if (item == null) {
            ui.nothingToTake(shortName);
        } else {
            ui.taken(item);
        }
    }

    private void drop(String shortName){
        Item item=player.dropItem(shortName);
        if (item == null) {
            ui.notInInventory(shortName);
        } else {
            ui.dropped(item);
        }
    }



}
