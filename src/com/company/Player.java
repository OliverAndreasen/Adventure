package com.company;

public class Player {
    private Room playerLocation;

    public String playerLocation(Room currentLocation){
        this.playerLocation = currentLocation;
        return currentLocation.getName();
    }

    // Checks if you can go in a specific direction from the room you are in
    public boolean direction(String direction) {

        boolean blDirection = false;

        if (direction.equals("north") && playerLocation.getNorth() != null) {
            blDirection = true;
        }
        if (direction.equals("east") && playerLocation.getEast() != null) {
            blDirection = true;
        }
        if (direction.equals("south") && playerLocation.getSouth() != null) {
            blDirection = true;
        }
        if (direction.equals("west") && playerLocation.getWest() != null) {
            blDirection = true;
        }
        return blDirection;
    }

    //moves the player to a new room
    public Room movePlayer(String nextRoom) {

        if (nextRoom.equals("north")) {
            return playerLocation.getNorth();
        }
        if (nextRoom.equals("east")) {
            return playerLocation.getEast();
        }
        if (nextRoom.equals("south")) {
            return playerLocation.getSouth();
        }
        if (nextRoom.equals("west")) {
            return playerLocation.getWest();
        }
        return null;
    }
}
