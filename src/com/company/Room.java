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

    public boolean direction() {

        boolean result = false;

        if (north == true) {
            result = true;
        }
        else if (north != true) {
            result = false;
        }
        if (east == true) {
            result = true;
        }
        else if (east != true) {
            result = false;
        }
        if (south == true) {
            result = true;
        }
        else if (south != true) {
            result = false;
        }
        if (west == true) {
            result = true;
        }
        else if (west != true) {
            result = false;
        }

        return result;
    }
}
