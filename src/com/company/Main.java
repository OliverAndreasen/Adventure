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
                currentRoom = player.move(direction);
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
                if (currentRoom.findItem(itemName, currentRoom) != null) {
                    Item item = currentRoom.findItem(itemName, currentRoom);
                    if (item.checkIfBackpack(itemName)){
                        player.takeItem(itemName);
                        player.changeMaxInventoryWeight(5);
                        System.out.println("Your max capacity increased to " + player.getMaxInventoryWeight());
                    }else{
                        player.takeItem(itemName);
                    }
                } else {
                    System.out.println("there is no such item");
                }
            } else if (command.equals("drop")) {
                if (player.findItemInventory(itemName) != null) {
                    Item item = player.findItemInventory(itemName);
                    if (item.checkIfBackpack(itemName)) {
                        if (player.getCurrentInventoryWeight() > 5) {
                            System.out.println("You cannot drop the backpack! Drop one or more items before you can remove the backpack");
                        }else {
                            player.changeMaxInventoryWeight(-5);
                            player.dropItem(itemName);
                            System.out.println("Your max capacity decreased to " + player.getMaxInventoryWeight());
                        }
                    }else {
                        player.dropItem(itemName);
                    }
                } else {
                    System.out.println("you dont have such item");
                }
            } else if (command.equals("inv")) {
                System.out.println(player.getInventory());
            } else if (command.equals("u")) {
                System.out.println(currentRoom.getAllItems());
                System.out.println(player.getInventory());
            } else {
                System.out.println("You cant go that way, try again!");
            }
        }
    }
}

