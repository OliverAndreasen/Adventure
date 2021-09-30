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
        String itemName = "";

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
            String letter = input.substring(0,1);
            int space = input.indexOf(" ");
            itemName = input.substring(space+1);
            String validation = parser.validation(input);
            // checks if the direction input is available
            if (player.direction(validation)) {
                // changes current room to the new room
                currentRoom = player.movePlayer(validation);
                System.out.println(currentRoom.getDescription());
            } else if (letter.equals("o")) {
                parser.exit();
            } else if (letter.equals("h")) {
                System.out.println(parser.help(player));
            } else if (letter.equals("l")) {
                System.out.println(parser.look(currentRoom));
            } else if (letter.equals("t")){
                if (currentRoom.findItemRoom(itemName, currentRoom) != null){
                    player.takeItem(itemName);
                } else {
                    System.out.println("there is no such item");
                }
            } else if (letter.equals("d")) {
                if (player.findItemPlayerInventory(itemName) != null){
                    player.dropItem(itemName);
                } else {
                    System.out.println("you dont have such item");
                }
            } else if (letter.equals("i")){
                System.out.println(player.getAllPlayerItems());
            } else if(letter.equals("u")) {
                System.out.println(currentRoom.getAllItems());
                System.out.println(player.getAllPlayerItems());
            } else {
                System.out.println(letter);
                System.out.println("You cant go that way, try again!");
            }
        }
    }
}

