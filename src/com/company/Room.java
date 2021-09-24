package com.company;

public class Room {

    private int currentRoom;
    private boolean north;
    private boolean east;
    private boolean south;
    private boolean west;


    public Room(int id, boolean north, boolean east, boolean south, boolean west) {
        this.currentRoom = id;
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;

    }

    public int whichRoom() {
        return currentRoom;
    }

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
}
