package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //     public void Room(int id, boolean north, boolean east, boolean south, boolean west)
        /*
        Room room1 = new Room(1,false,true,true,false);
        Room room2 = new Room(2, false, true, false, true);
        Room room3 = new Room(3, false, false, true, true);
        Room room4 = new Room(4, true, false, true, false);
        Room room5 = new Room(5, false, false, true, false);
        Room room6 = new Room(6, true, false, true, false);
        Room room7 = new Room(7, true, true, false, false);
        Room room8 = new Room(8, true, true, false, true);
        Room room9 = new Room(9, true, false, false, true);

         */

        Room[] rooms = new Room[9];
        rooms[0] = new Room(0,false,true,true,false);
        rooms[1] = new Room(1, false, true, false, true);
        rooms[2] = new Room(2, false, false, true, true);
        rooms[3] = new Room(3, true, false, true, false);
        rooms[4] = new Room(4, false, false, true, false);
        rooms[5] = new Room(5, true, false, true, false);
        rooms[6] = new Room(6, true, true, false, false);
        rooms[7] = new Room(7, true, true, false, true);
        rooms[8] = new Room(8, true, false, false, true);

        int currentRoom = rooms[0].whichRoom();



        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Velkommen til Adventure-Spillet!");
        System.out.println("Du skal vælge en vej at gå");
        System.out.println("Du kan vælge ");
        System.out.println("Du kan skrive 'go north', 'go east', 'go south' eller 'go west");
        System.out.println("Hvilken vej vil du gå");
        //String direction = sc.nextLine();  // Read user input


            for (int i = 0; i < rooms.length; i++) {
                if (currentRoom == i) {
                    System.out.println("DU ER I RUM " + (rooms[i].whichRoom() + 1));
                    System.out.println("Hvilken vej vil du gå");
                    String direction = sc.nextLine();  // Read user input

                   if(rooms[i].direction(direction)) {


                   }


                }
            }

    }
}

