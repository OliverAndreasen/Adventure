package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Game {

    public void go(){
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

            // parser.passInput(input);

            input = input.toLowerCase(Locale.ROOT);
            String command = parser.getFirstWord(input);
            //String itemName = parser.getSecondWord(input);
            String direction = parser.validateDirection(input);

            String itemName = parser.passItemNameInput(input);

            System.out.println(itemName);
            parser.passPlayer(player);
            parser.passCurrentRoom(currentRoom);

            // checks if the direction input is available
            if (parser.checkRoomDirection(direction)) {
                //changes current room to the new room
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
                System.out.println(parser.take());
            } else if (command.equals("drop")) {
                System.out.println(parser.drop());
            } else if (command.equals("inv")) {
                System.out.println(parser.getPlayerInventory());
            } else if (command.equals("u")) {
                System.out.println(currentRoom.getAllItems());
                System.out.println(player.getInventory());
            } else {
                System.out.println("You cant go that way, try again!");
            }
        }

    }
}
