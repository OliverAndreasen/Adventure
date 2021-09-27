package com.company;

public class Player {
    private Room playerLocation;

    public Room playerLocation(Room currentLocation) {
        return this.playerLocation = currentLocation;
    }

    // Checks if you can go in a specific direction from the room you are in
    public boolean direction(String direction) {

        boolean blDirection = false;

        if (direction.equals("n") && playerLocation.getNorth() != null) {
            blDirection = true;
        }
        if (direction.equals("e") && playerLocation.getEast() != null) {
            blDirection = true;
        }
        if (direction.equals("s") && playerLocation.getSouth() != null) {
            blDirection = true;
        }
        if (direction.equals("w") && playerLocation.getWest() != null) {
            blDirection = true;
        }
        return blDirection;
    }

    //moves the player to a new room
    public Room movePlayer(String nextRoom) {

        if (nextRoom.equals("n")) {
            return playerLocation.getNorth();
        }
        if (nextRoom.equals("e")) {
            return playerLocation.getEast();
        }
        if (nextRoom.equals("s")) {
            return playerLocation.getSouth();
        }
        if (nextRoom.equals("w")) {
            return playerLocation.getWest();
        }
        return null;
    }
}
