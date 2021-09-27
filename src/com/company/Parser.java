package com.company;

public class Parser {


    public String validation(String direction){
        String result = direction;

        if (direction.equals("go north") || direction.equals("north")) {
            result = "n";
        }
        if (direction.equals("go east") || direction.equals("east")) {
            result = "e";
        }
        if (direction.equals("go south") || direction.equals("south")) {
            result = "s";
        }
        if (direction.equals("go west") || direction.equals("west")) {
            result = "w";
        }
        return result;
    }

    public void exit(){
        System.exit(0);
    }

    public String help(Player player){

        String help = "";

        if (player.direction("north")) {
            help += "you can go 'north'\n";
        }
        if (player.direction("east")) {
            help += "you can go 'east'\n";
        }
        if (player.direction("south")) {
            help += "you can go 'south'\n";
        }
        if (player.direction("west")) {
            help += "you can go 'west'\n";
        }
        help += "if you want to exit the program type 'exit'\n";
        help += "to get a room description you can type 'look'\n";

        return help;
    }

    public String look(Room currentRoom){
        return "You are in room " + currentRoom.getName() + "\n" + "description " + currentRoom.getDescription();
    }

    public String welcome(Room currentRoom){

        String result = "";
        result += "Welcome to the Adventure game!\n";
        result += "You have to choose a direction, you want to walk in\n";
        result += "To go a direction type 'direction'\n";
        result += "You can type 'north', 'east', 'south' or 'west'\n";
        result += "Other functions: 'exit', 'look', 'help'\n";
        result += "You are in room " + currentRoom.getName();
        return result;
    }
}
