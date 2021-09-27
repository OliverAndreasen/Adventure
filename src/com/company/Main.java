package com.company;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // creates array to all the rooms.
        Room[] rooms = new Room[9];

        //Room (int id, boolean north, boolean east, boolean south, boolean west)
        // TODO: Change room ids to 1,2,3,4,5,6,7,8,9
        rooms[0] = new Room(0, false, true, true, false);
        rooms[1] = new Room(1, false, true, false, true);
        rooms[2] = new Room(2, false, false, true, true);
        rooms[3] = new Room(3, true, false, true, false);
        rooms[4] = new Room(4, false, false, true, false);
        rooms[5] = new Room(5, true, false, true, false);
        rooms[6] = new Room(6, true, true, false, false);
        rooms[7] = new Room(7, true, true, false, true);
        rooms[8] = new Room(8, true, false, false, true);

        // Start room is room 1 (array[0])
        int currentRoom = (rooms[0].getId());

        System.out.println("Welcome to the Adventure game!");
        System.out.println("You have to choose a direction, you want to walk in");
        System.out.println("You can type 'north', 'east', 'south' or 'west");
        System.out.println("You are in room " + (currentRoom + 1));

        Scanner sc = new Scanner(System.in);
        int length = rooms.length;

        while (true) {
            for (int i = 0; i < length; i++) {

                if ((currentRoom) == i) {
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
                    if (rooms[i].direction(input)) {
                        // changes current room to the new room
                        currentRoom += rooms[i].nextRoom(input);
                        System.out.println("You walked into room " + (currentRoom + 1));

                    } else if (input.equals("exit")){
                        System.exit(0);

                    } else if (input.equals("help")){
                        String help = "";

                        if (rooms[i].direction("north")){
                            help += "you can go 'north'\n";
                        }
                        if (rooms[i].direction("east")){
                            help += "you can go 'east'\n";
                        }
                        if (rooms[i].direction("south")){
                            help += "you can go 'south'\n";
                        }
                        if (rooms[i].direction("west")){
                            help += "you can go 'west'\n";
                        }
                        help += "if you want to exit the program type 'exit'\n";
                        help += "to get a room description you can type 'look'\n";
                        System.out.println(help);

                    } else if (input.equals("look")){
                        System.out.println("You are in room " + (currentRoom + 1));
                    }
                    else {
                        System.out.println("You cant go that way, try again!");
                    }
                }
            }
        }
    }
}

