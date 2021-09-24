package com.company;

public class Room {

    private int currentRoom;
    private boolean north;
    private boolean east;
    private boolean south;
    private boolean west;
    private final String northRoom = "north";
    private final String eastRoom = "east";
    private final String southRoom = "south";
    private final String westRoom = "west";


    public Room(int id, boolean north, boolean east, boolean south, boolean west) {
        this.currentRoom = id;
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }

    public int whichRoom() {

        currentRoom = currentRoom;
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


    public int nextRoom(String nextRoom){

        if (northRoom == nextRoom) {
            currentRoom -= 3;
            System.out.println(currentRoom);
        }
        if (eastRoom == nextRoom) {
            currentRoom += 1;
            System.out.println(currentRoom);

        }
        if (southRoom.equals("south")) {
            currentRoom = currentRoom + 3;
            System.out.println(currentRoom);

        }
        if (westRoom == nextRoom) {
            currentRoom = currentRoom + 1;
            System.out.println(currentRoom);

        }

        return currentRoom;

    }



}
