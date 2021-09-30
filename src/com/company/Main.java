package com.company;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map map = new Map();
        Player player = new Player();
        Parser parser = new Parser();
        Room currentRoom = map.getStartRoom();
        currentRoom = player.playerLocation(currentRoom);

        System.out.println(parser.welcome());
        Scanner sc = new Scanner(System.in);
        boolean con = true;
        int count = 0;
        while (con) {
            if (count == 0) {
                System.out.println(currentRoom.getDescription());
                count = count + 1;
            }
            currentRoom = player.playerLocation(currentRoom);
            String input = sc.nextLine();
            input = input.toLowerCase(Locale.ROOT);

            String firstWord = parser.getFirstWord(input);
            String itemName = parser.getSecoundWord(input);
            String validation = parser.validation(input);
            // checks if the direction input is available
            if (player.direction(validation)) {
                // changes current room to the new room
                currentRoom = player.movePlayer(validation);
                System.out.println(currentRoom.getDescription());
            } else if (firstWord.equals("off")) {
                parser.exit();
                con = false;
            } else if (firstWord.equals("help")) {
                System.out.println(parser.help());
            } else if (firstWord.equals("cheat")){
                System.out.println(parser.cheat(player));
            } else if (firstWord.equals("look")) {
                System.out.println(parser.look(currentRoom));
            } else if (firstWord.equals("take")) {
                if (currentRoom.findItemRoom(itemName, currentRoom) != null) {
                    player.takeItem(itemName);
                } else {
                    System.out.println("there is no such item");
                }
            } else if (firstWord.equals("drop")) {
                if (player.findItemPlayerInventory(itemName) != null) {
                    player.dropItem(itemName);
                } else {
                    System.out.println("you dont have such item");
                }
            } else if (firstWord.equals("inv")) {
                System.out.println(player.getAllPlayerItems());
            } else if (firstWord.equals("u")) {
                System.out.println(currentRoom.getAllItems());
                System.out.println(player.getAllPlayerItems());
            } else {
                System.out.println("You cant go that way, try again!");
            }
        }
    }
}

