package com.company;

import java.util.Locale;

public class Room {

    private int id;
    private boolean north;
    private boolean east;
    private boolean south;
    private boolean west;
    private final String northRoom = "north";
    private final String eastRoom = "east";
    private final String southRoom = "south";
    private final String westRoom = "west";


    public Room(int id, boolean north, boolean east, boolean south, boolean west) {
        this.id = id;
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }

    public int getId() {
        return id;
    }

    public boolean direction(String direction) {

        direction.toLowerCase(Locale.ROOT);

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


    public int nextRoom(String nextRoom){

        if (northRoom.equals(nextRoom)) {
            return -3;
        }
        if (eastRoom.equals(nextRoom)) {
            return +1;

        }
        if (southRoom.equals(nextRoom)) {
            return +3;
        }
        if (westRoom.equals(nextRoom)) {
            return -1;

        }
        return 0;
    }



}
