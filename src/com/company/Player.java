package com.company;

public class Player {
    private Room playerLocation;

    String letters[];
    Room locations[];




    public Player() {
        letters = new String[4];
        locations = new Room[4];
        letters[0] = "n";
        letters[1] = "e";
        letters[2] = "s";
        letters[3] = "w";

    }

    public Room playerLocation(Room currentLocation) {
        return this.playerLocation = currentLocation;
    }

    // Checks if you can go in a specific direction from the room you are in
    public boolean direction(String direction) {
        locations[0] = playerLocation.getNorth();
        locations[1] = playerLocation.getEast();
        locations[2] = playerLocation.getSouth();
        locations[3] = playerLocation.getWest();
        
        boolean blDirection = false;

        for (int i = 0; i < letters.length; i++) {
            if (direction.equals(letters[i]) && locations[i] != null) {
                blDirection = true;
            }
        }
        return blDirection;
    }


    //moves the player to a new room
    public Room movePlayer(String nextRoom) {
        locations[0] = playerLocation.getNorth();
        locations[1] = playerLocation.getEast();
        locations[2] = playerLocation.getSouth();
        locations[3] = playerLocation.getWest();

        for (int i = 0; i < letters.length; i++) {
            if (nextRoom.equals(letters[i])) {
                return locations[i];
            }
        }
        return null;
    }
}
