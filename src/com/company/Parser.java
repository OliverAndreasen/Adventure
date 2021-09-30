package com.company;

public class Parser {

    public String validation(String direction) {
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

    public void exit() {
        System.exit(0);
    }

    public String help(Player player) {

        String help = "";
        help += "if you want to turn the program off type 'off'\n";
        help += "to get a room description you can type 'look'\n";
        help += "to pick up an item type 'take' item name\n";
        help += "to drop an item type 'drop' item name\n";
        return help;
    }

    public String cheat(Player player){
        String result = "";

        if (player.direction("n")) {
            result += "you can go 'north'\n";
        }
        if (player.direction("e")) {
            result += "you can go 'east'\n";
        }
        if (player.direction("s")) {
            result += "you can go 'south'\n";
        }
        if (player.direction("w")) {
            result += "you can go 'west'\n";
        }
        return result;
    }

    public String look(Room currentRoom) {
        String result = "";
        result += currentRoom.getDescription() + "\n";
        result += currentRoom.getAllItems();
        return result;
    }

    public String welcome() {

        String result = "";
        result += "Welcome to the Adventure game!\n";
        result += "You have to choose a direction, you want to walk in\n";
        result += "You can type 'north', 'east', 'south' or 'west'\n";
        result += "you can also 'take' and 'drop' items for more instructions type 'help'\n";
        result += "Other functions: 'off', 'look', 'help', 'inv'";
        result += "\n";
        return result;
    }

    public String getFirstWord(String input) {
        String firstWord = "";
        String itemName = "";
        int space = input.indexOf(" ");
        if (space == -1){
            int length = input.length();
            return firstWord = input.substring(0,length);
        }
        else {
           return firstWord = input.substring(0,space);
        }
    }

    public String getSecoundWord(String input){
        int space = input.indexOf(" ");
        return input.substring(space + 1);
    }
}
