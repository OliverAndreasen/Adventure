package com.company;

public class Parser {

    public String validateDirection(String direction) {
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

    public String help() {

        String help = "";
        help += "if you want to turn the program off type 'off'\n";
        help += "to get a room description you can type 'look'\n";
        help += "to get help with directions you can type 'cheat'\n";
        help += "to pick up an item type 'take' followed by the name of the item\n";
        help += "to drop an item type 'drop' followed by the name of the item\n";
        return help;
    }

    public String cheat(Player player){
        String result = "";

        if (player.checkDirection("n")) {
            result += "you can go 'north'\n";
        }
        if (player.checkDirection("e")) {
            result += "you can go 'east'\n";
        }
        if (player.checkDirection("s")) {
            result += "you can go 'south'\n";
        }
        if (player.checkDirection("w")) {
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
        result += "Other functions: 'off', 'look', 'help', 'inv' 'cheat'";
        result += "\n";
        return result;
    }

    public String getFirstWord(String input) {
        int space = input.indexOf(" ");
        if (space == -1){
            int length = input.length();
            return input.substring(0,length);
        }
        else {
           return input.substring(0,space);
        }
    }

    public String getSecondWord(String input){
        int space = input.indexOf(" ");
        return input.substring(space + 1);
    }
}
