package com.company;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Room (String name, String description)
        Room room1 = new Room("room 1", "Du er gået ind i klædeskabet");
        Room room2 = new Room("room 2", "Du er gået ind i klædeskabet");
        Room room3 = new Room("room 3", "Du er gået ind i klædeskabet");
        Room room4 = new Room("room 4", "Du er gået ind i klædeskabet");
        Room room5 = new Room("room 5", "Du er gået ind i klædeskabet");
        Room room6 = new Room("room 6", "Du er gået ind i klædeskabet");
        Room room7 = new Room("room 7", "Du er gået ind i klædeskabet");
        Room room8 = new Room("room 8", "Du er gået ind i klædeskabet");
        Room room9 = new Room("room 9", "Du er gået ind i klædeskabet");


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

