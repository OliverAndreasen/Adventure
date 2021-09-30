package com.company;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        Player player = new Player();
        Parser parser = new Parser();
        Room currentRoom = player.currentRoom(map.getStartRoom());

        System.out.println(parser.welcome());
        Scanner sc = new Scanner(System.in);
        boolean con = true;
        int count = 0;
        while (con) {
            if (count == 0) {
                System.out.println(currentRoom.getDescription());
                count = count + 1;
            }
            currentRoom = player.currentRoom(currentRoom);
            String input = sc.nextLine();
            input = input.toLowerCase(Locale.ROOT);

            String command = parser.getFirstWord(input);
            String itemName = parser.getSecondWord(input);
            String direction = parser.validateDirection(input);
            // checks if the direction input is available
            if (player.checkDirection(direction)) {
                // changes current room to the new room
                currentRoom = player.movePlayer(direction);
                System.out.println(currentRoom.getDescription());
            } else if (command.equals("off")) {
                parser.exit();
                con = false;
            } else if (command.equals("help")) {
                System.out.println(parser.help());
            } else if (command.equals("cheat")){
                System.out.println(parser.cheat(player));
            } else if (command.equals("look")) {
                System.out.println(parser.look(currentRoom));
            } else if (command.equals("take")) {
                if (currentRoom.findRoomItem(itemName, currentRoom) != null) {
                    player.takeRoomItem(itemName);
                } else {
                    System.out.println("there is no such item");
                }
            } else if (command.equals("drop")) {
                if (player.findItemPlayerInventory(itemName) != null) {
                    player.dropPlayerItem(itemName);
                } else {
                    System.out.println("you dont have such item");
                }
            } else if (command.equals("inv")) {
                System.out.println(player.getPlayerInventory());
            } else if (command.equals("u")) {
                System.out.println(currentRoom.getALlRoomItems());
                System.out.println(player.getPlayerInventory());
            } else {
                System.out.println("You cant go that way, try again!");
            }
        }
    }
}

