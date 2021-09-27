package com.company;

public class Room {

    private int id;

    //true if the direction is available in a room
    private boolean north;
    private boolean east;
    private boolean south;
    private boolean west;

    // Constructor
    public Room(int id, boolean north, boolean east, boolean south, boolean west) {
        this.id = id;
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }

    public int getId() {
        return id;
        System.out.println();
    }



    // Checks if you can go in a specific direction from the room you are in
    public boolean direction(String direction) {

        boolean blDirection = false;

        if (direction.equals("north")) {
            blDirection = north;
        }
        if (direction.equals("east")) {
            blDirection = east;
        }
        if (direction.equals("south")) {
            blDirection = south;
        }
        if (direction.equals("west")) {
            blDirection = west;
        }
        return blDirection;
    }

    public int nextRoom(String nextRoom) {

        if (nextRoom.equals("north")) {
            return -3;
        }
        if (nextRoom.equals("east")) {
            return +1;
        }
        if (nextRoom.equals("south")) {
            return +3;
        }
        if (nextRoom.equals("west")) {
            return -1;
        }
        return 0;
    }
}
