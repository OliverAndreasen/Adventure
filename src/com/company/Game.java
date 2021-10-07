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
            input = input.toLowerCase(Locale.ROOT);
            String command = parser.getFirstWord(input);
            String direction = parser.validateDirection(parser.getSecondWord(input));
            String itemName = parser.passItemNameInput(input);
            parser.passPlayer(player);
            parser.passCurrentRoom(currentRoom);

            // checks if the direction input is available
            switch (command) {

                case "go":
                    if(!direction.isEmpty()) {
                        if (parser.checkRoomDirection(direction)) {
                            //changes current room to the new room
                            currentRoom = player.move(direction);
                            System.out.println(currentRoom.getDescription());
                        } else {
                            System.out.println("You cant go that way, try again!");
                        }
                    }
                    else {
                        System.out.println("write a direction you want to go");
                    }
                    break;

                case "open", "o":
                    System.out.println(parser.use());
                    break;

                case "help", "h":
                    System.out.println(parser.help());
                    break;

                case "cheat", "c":
                    System.out.println(parser.cheat(player));
                    break;

                case "look", "l":
                    System.out.println(parser.look(currentRoom));
                    break;

                case "take", "t":
                    System.out.println(parser.take());
                    break;

                case "drop", "d":
                    System.out.println(parser.drop());
                    break;

                case "inventory", "inv", "i":
                    System.out.println(parser.getPlayerInventory());
                    break;

                case "exit", "x":
                    parser.exit();
                    con = false;
                    break;

                default:
                    System.out.println("invalid command");
            }
        }
    }
}
