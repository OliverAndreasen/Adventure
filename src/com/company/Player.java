package com.company;

import java.util.ArrayList;

public class Player {
    private Room playerLocation;

    String letters[];
    Room locations[];
    private ArrayList<Item> playerItems = new ArrayList<>();



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
        boolean result;
        Item item = playerLocation.findItem(itemName, playerLocation);
        if (playerItems.contains(item)){
            return true;
        }else {
            result = false;
        }
        return result;
    }

    public void takeItem(String itemName){
        if (!checkItemInventory(itemName)) {
            playerLocation.findItem(itemName, playerLocation);
            Item item = playerLocation.findItem(itemName, playerLocation);
            playerItems.add(item);
            System.out.println("Du har taget " + itemName);
            playerLocation.removeRoomItem(item);
        }else {
            System.out.println(itemName + " are in your inventory");
        }
    }

    public String getAllPlayerItems(){
        String result = "In your inventory you have:\n";

        int length = playerItems.size();
        for (int i = 0; i < length; i++) {
            if (i != length-1) {
                result += playerItems.get(i) + "\n";
            }
            else {
                result += playerItems.get(i);
            }
        }
        return result;
    }

    public void removeItem(String itemName)
    {
        Item item = playerLocation.findItem(itemName, this.playerLocation);
        playerItems.remove(item);
    }
 }
