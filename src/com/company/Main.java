package com.company;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Room (String name, String description)
        Room room1 = new Room("room 1", null);
        Room room2 = new Room("room 2", null);
        Room room3 = new Room("room 3", null);
        Room room4 = new Room("room 4", "Du er gået ind i klædeskabet");
        Room room5 = new Room("room 5", null);
        Room room6 = new Room("room 6", null);
        Room room7 = new Room("room 7", null);
        Room room8 = new Room("room 8", null);
        Room room9 = new Room("room 9", null);


        // Room1
        room1.setEast(room2);
        room1.setSouth(room4);

        // Room 2
        room2.setEast(room3);
        room2.setWest(room1);

        // Room 3
        room3.setWest(room2);
        room3.setSouth(room6);

        // Room 4
        room4.setNorth(room1);
        room4.setSouth(room7);

        // Room 5
        room5.setSouth(room8);

        // Room 6
        room6.setNorth(room3);
        room6.setSouth(room9);

        // Room 7
        room7.setNorth(room4);
        room7.setEast(room8);

        // Room 8
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);

        // Room 9
        room9.setNorth(room6);
        room9.setWest(room8);

        Room currentRoom = room1;
        Player player = new Player();
        Parser parser = new Parser();
        /*
        // Start room is room 1

        Room previousRoom = currentRoom;
        if (currentRoom.getNorth() != null) {
            currentRoom = previousRoom.nextRoom("north");
            currentRoom.setSouth(previousRoom);
            System.out.println("Du kom fra " + previousRoom.getName() + " Du står nu i " + currentRoom.getName());
        }
        if (currentRoom.getEast() != null) {
            currentRoom = previousRoom.nextRoom("east");
            currentRoom.setWest(previousRoom);
            System.out.println("Du kom fra " + previousRoom.getName() + " Du står nu i " + currentRoom.getName());
        }

        if (currentRoom.getSouth() != null) {
            currentRoom = previousRoom.nextRoom("south");
            currentRoom.setNorth(previousRoom);
            System.out.println("Du kom fra " + previousRoom.getName() + " Du står nu i " + currentRoom.getName());
        }

        currentRoom = room1;
        if (currentRoom.getWest() != null) {
            currentRoom = previousRoom.nextRoom("west");
            currentRoom.setEast(previousRoom);
            System.out.println("Du kom fra " + previousRoom.getName() + "Du står nu i " + currentRoom.getName());
        }

         */
        System.out.println("Welcome to the Adventure game!");
        System.out.println("You have to choose a direction, you want to walk in");
        System.out.println("You can type 'north', 'east', 'south' or 'west");
        System.out.println("You are in room " + player.playerLocation(currentRoom));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Which direction do you want to go ?");
            String input = sc.nextLine();
            input = input.toLowerCase(Locale.ROOT);
            if (input.equals("direction")){
                input = parser.move(input);
            }
            /*if (input.equals("go north") || input.equals("n")) {
                input = "north";
            }
            if (input.equals("go east") || input.equals("e")) {
                input = "east";
            }
            if (input.equals("go south") || input.equals("s")) {
                input = "south";
            }
            if (input.equals("go west") || input.equals("w")) {
                input = "west";
            }*/

            // checks if the direction input is available
            if (player.direction(input)) {
                String description = "You are in ";
                // changes current room to the new room
                currentRoom = player.movePlayer(input);

                description += player.playerLocation(currentRoom) + "\n" + currentRoom.getDescription();
                System.out.println(description);

            } else if (input.equals("exit")) {
                parser.exit();

            } else if (true) {
                System.out.println(parser.help(player));
                /*String help = "";

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
                System.out.println(help);*/

            } else if (input.equals("look")) {
                System.out.println("You are in room " + currentRoom.getName());
            } else {
                System.out.println("You cant go that way, try again!");
            }
        }
    }
}

