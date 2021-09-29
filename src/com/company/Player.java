package com.company;

import java.util.ArrayList;

public class Player {
    private Room playerLocation;

    String letters[];
    Room locations[];
    private ArrayList<Item> plyerItems = new ArrayList<>();



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

    public boolean checkItemInventory(String itemName){
        Item item = playerLocation.findItem(itemName, playerLocation);
        if (item != null){
            return true;
        }

    }

    public void takeItems(String itemName){
        playerLocation.findItem(itemName, playerLocation);
        Item item = playerLocation.findItem(itemName, playerLocation);
        plyerItems.add(item);
    }

    public String getAllPlayerItems(){
        String result = "";
        for (int i = 0; i < plyerItems.size(); i++) {
            result += plyerItems.get(i);
        }
        return result;
    }
}
