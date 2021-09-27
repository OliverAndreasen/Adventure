package com.company;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // creates array to all the rooms.
        Room[] rooms = new Room[9];

        System.out.println("alex");

        System.out.println("Test");
        System.out.println("lol2");
        System.out.println("tesz");

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
        System.out.println("test alex");

        while (true) {
            for (int i = 0; i < length; i++) {

                if ((currentRoom) == i) {
                    System.out.println("Which direction do you want to go ?");
                    String input = sc.nextLine();
                    input = input.toLowerCase(Locale.ROOT);

                    // checks if the direction input is available
                    if (rooms[i].direction(input)) {
                        // changes current room to the new room
                        currentRoom += rooms[i].nextRoom(input);
                        System.out.println("You walked into room " + (currentRoom + 1));
                    }
                    else {
                        System.out.println("You cant go that way, try again!");
                    }
                }
            }
        }
    }
}

