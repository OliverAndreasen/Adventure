package com.company;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // creates array to all the rooms.
        Room[] rooms = new Room[9];

        //Room (int id, boolean north, boolean east, boolean south, boolean west)
        // TODO: Change room ids to 1,2,3,4,5,6,7,8,9
        /*
        rooms[0] = new Room(0, false, true, true, false);
        rooms[1] = new Room(1, false, true, false, true);
        rooms[2] = new Room(2, false, false, true, true);
        rooms[3] = new Room(3, true, false, true, false);
        rooms[4] = new Room(4, false, false, true, false);
        rooms[5] = new Room(5, true, false, true, false);
        rooms[6] = new Room(6, true, true, false, false);
        rooms[7] = new Room(7, true, true, false, true);
        rooms[8] = new Room(8, true, false, false, true);

         */

        Room room1 = new Room("room1", null);
        Room room2 = new Room("room2", null);
        Room room3 = new Room("room3", null);
        Room room4 = new Room("room4", null);
        Room room5 = new Room("room5", null);
        Room room6 = new Room("room6", null);
        Room room7 = new Room("room7", null);
        Room room8 = new Room("room8", null);
        Room room9 = new Room("room9", null);

        // Room1
        room1.setEast(room1);
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
















        // Start room is room 1
        Room currentRoom = room1;

        System.out.println("Welcome to the Adventure game!");
        System.out.println("You have to choose a direction, you want to walk in");
        System.out.println("You can type 'north', 'east', 'south' or 'west");
        System.out.println("You are in room " + currentRoom.getName());

        Scanner sc = new Scanner(System.in);

        while (true) {
                    System.out.println("Which direction do you want to go ?");
                    String input = sc.nextLine();
                    input = input.toLowerCase(Locale.ROOT);
                    if (input.equals("go north") || input.equals("n")){
                        input = "north";
                    }
                    if (input.equals("go east") || input.equals("e")){
                        input = "east";
                    }
                    if (input.equals("go south") || input.equals("s")){
                        input = "south";
                    }
                    if (input.equals("go west") || input.equals("w")){
                        input = "west";
                    }

                    // checks if the direction input is available
                    if (currentRoom.direction(input)) {
                        // changes current room to the new room
                        currentRoom = currentRoom.nextRoom(input);
                        System.out.println("You walked into room " + currentRoom.getName());

                    } else if (input.equals("exit")){
                        System.exit(0);

                    } else if (input.equals("help")){
                        String help = "";

                        if (currentRoom.direction("north")){
                            help += "you can go 'north'\n";
                        }
                        if (currentRoom.direction("east")){
                            help += "you can go 'east'\n";
                        }
                        if (currentRoom.direction("south")){
                            help += "you can go 'south'\n";
                        }
                        if (currentRoom.direction("west")){
                            help += "you can go 'west'\n";
                        }
                        help += "if you want to exit the program type 'exit'\n";
                        help += "to get a room description you can type 'look'\n";
                        System.out.println(help);

                    } else if (input.equals("look")){
                        System.out.println("You are in room " + currentRoom.getName());
                    }
                    else {
                        System.out.println("You cant go that way, try again!");
                    }
                }
            }
}

