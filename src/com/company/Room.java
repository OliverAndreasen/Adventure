package com.company;

public class Room {

    private String name;
    String description;
    
    private Room north;
    private Room east;
    private Room south;
    private Room west;

    // Constructor
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.north = null;
        this.east = null;
        this.south = null;
        this.west = null;
    }

    public void setNorth(Room north) {
        this.north = north;
    }
    public void setEast(Room east) {
        this.east = east;
    }
    public void setSouth(Room south) {
        this.south = south;
    }
    public void setWest(Room west) {
        this.west = west;
    }
    public Room getNorth () {
        return north;
    }
    public Room getEast () {
        return east;
    }
    public Room getSouth () {
        return south;
    }
    public Room getWest () {
        return west;
    }

    public String getName() {
        return name;
    }
    
    // Checks if you can go in a specific direction from the room you are in

    public boolean direction(String direction) {

        boolean blDirection = false;

        if (direction.equals("north") && north != null) {
            blDirection = true;
        }
        if (direction.equals("east") && east != null) {
            blDirection = true;
        }
        if (direction.equals("south") && south != null) {
            blDirection = true;
        }
        if (direction.equals("west") && west != null) {
            blDirection = true;
        }
        return blDirection;
    }

    public Room nextRoom(String nextRoom) {

        if (nextRoom.equals("north")) {
            return north;
        }
        if (nextRoom.equals("east")) {
            return east;
        }
        if (nextRoom.equals("south")) {
            return south;
        }
        if (nextRoom.equals("west")) {
            return west;
        }
        return null;
    }

}
