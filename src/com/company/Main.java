package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int id = 1;
        System.out.println("test med hest " + id);
        id = id + 4;
        System.out.println(id);

        //     public void Room(int id, boolean north, boolean east, boolean south, boolean west)
        Room[] rooms = new Room[9];
        rooms[0] = new Room(0, false, true, true, false);
        rooms[1] = new Room(1, false, true, false, true);
        rooms[2] = new Room(2, false, false, true, true);
        rooms[3] = new Room(3, true, false, true, false);
        rooms[4] = new Room(4, false, false, true, false);
        rooms[5] = new Room(5, true, false, true, false);
        rooms[6] = new Room(6, true, true, false, false);
        rooms[7] = new Room(7, true, true, false, true);
        rooms[8] = new Room(8, true, false, false, true);

        int currentRoom = (rooms[0].getId());

        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Velkommen til Adventure-Spillet!");
        System.out.println("Du skal vælge en vej at gå");
        System.out.println("Du kan vælge ");
        System.out.println("Du kan skrive 'go north', 'go east', 'go south' eller 'go west");
        //System.out.println("Hvilken vej vil du gå");
        //String direction = sc.nextLine();  // Read user input
        while (true) {
            for (int i = 0; i < rooms.length; i++) {
                if ((currentRoom) == i) {
                    System.out.println("DU ER I RUM " + (currentRoom + 1));
                    System.out.println("Hvilken vej vil du gå");
                    String input = sc.nextLine();  // Read user input

                    if (rooms[i].direction(input)) {
                        currentRoom += rooms[i].nextRoom(input);
                        System.out.println("Du er gået ind i rum " + (currentRoom + 1));
                    }
                }
            }
        }
    }
}

