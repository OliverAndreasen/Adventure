package com.company;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Room (String name, String description)
        Room room1 = new Room("room 1", "You are very tired and cold in a big dark forest, you need to find a place to rest for the night.\n" +
                "Even though it is very dark and horrible weather, you catch a glimpse of what looks like a cave.\n" +
                "which way do you choose?");
        Room room2 = new Room("room 2", "You are in the entrance of a dark cave, the floor of the entrance is full of jagged rocks, you can not sleep here. \n" +
                "You need to move on to find a place to rest.\n" +
                "which way do you choose?");
        Room room3 = new Room("room 3", "You arrive in a curved corridor, as you move through the corridor \n" +
                "you step into knee-deep puddles of water. \n" +
                "which way do you choose?");
        Room room4 = new Room("room 4", "You found an entrance to a cave, dare to go deeper?\n" +
                "Which way do you choose?");
        Room room5 = new Room("room 5", "You found a nice place to sleep with a bed, firewood and a ladder to exit the cave.\n" +
                "Sleep tight.");
        Room room6 = new Room("room 6", "You are at a mossy rockformation, it is very slippery, be careful.\n" +
                "which way do you choose?");
        Room room7 = new Room("room 7", "You are in a curved corridor.\n" +
                "Which way do you choose?");
        Room room8 = new Room("room 8", "You can sense the comfort of a safe place nearby.\n" +
                "Which way do you choose?");
        Room room9 = new Room("room 9", "You are in a curved corridor.\n" +
                "Which way do you choose?. ");


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


        Player player = new Player();
        Parser parser = new Parser();



        Room currentRoom = room1;
        System.out.println(parser.welcome(room1));
        Scanner sc = new Scanner(System.in);


        boolean con = true;

        while (con) {

            currentRoom = player.playerLocation(currentRoom);
            String input = sc.nextLine();
            input = input.toLowerCase(Locale.ROOT);
            String validation = parser.validation(input);
            // checks if the direction input is available
            if (player.direction(validation)) {
                // changes current room to the new room
                currentRoom = player.movePlayer(validation);
                System.out.println(currentRoom.getDescription());
            } else if (input.equals("exit")) {
                parser.exit();
            } else if (input.equals("help")) {
                System.out.println(parser.help(player));
            } else if (input.equals("look")) {
                System.out.println(parser.look(currentRoom));
            } else {
                System.out.println("You cant go that way, try again!");
            }
        }
    }
}

