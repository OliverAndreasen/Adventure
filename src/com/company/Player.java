package com.company;

import java.util.ArrayList;

public class Player {
    private final int maxPlayerWeight;
    String[] letters;
    Room[] locations;
    private Room playerLocation;
    private int currentPlayerWeight;
    private final ArrayList<Item> playerItems = new ArrayList<>();


    public Player() {
        letters = new String[4];
        locations = new Room[4];
        letters[0] = "n";
        letters[1] = "e";
        letters[2] = "s";
        letters[3] = "w";
        this.maxPlayerWeight = 5;
        this.currentPlayerWeight = 0;
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

    public void takeItem(String itemName) {
        playerLocation.findItemRoom(itemName, playerLocation);
        Item item = playerLocation.findItemRoom(itemName, playerLocation);
        if (checkPlayerWeight(item.getItemWeight())) {
            playerItems.add(item);
            currentPlayerWeight += item.getItemWeight();
            System.out.println("You picked up " + itemName);
            playerLocation.removeRoomItem(item);
            System.out.println(itemName + " are now in your inventory");
        } else {
            System.out.println("you are over encumbered");
        }
    }


    public String getAllPlayerItems() {
        String result = "";
        result += "Your current inventory weight is: " + currentPlayerWeight + " out of " + maxPlayerWeight + "\n";
        result += "In your inventory you have:\n";
        int length = playerItems.size();
        for (int i = 0; i < length; i++) {
            if (i != length - 1) {
                result += playerItems.get(i) + "\n";
            } else {
                result += playerItems.get(i);
            }
        }
        return result;
    }

    public void dropItem(String itemName) {
        Item item = findItemPlayerInventory(itemName);
        System.out.println("you dropped " + item);
        currentPlayerWeight = currentPlayerWeight - item.getItemWeight();
        playerLocation.setRoomItem(item);
        playerItems.remove(item);
    }

    public Item findItemPlayerInventory(String itemName) {
        for (int i = 0; i < playerItems.size(); i++) {
            if (playerItems.get(i).getName().equals(itemName)) {
                return playerItems.get(i);
            }
        }
        return null;
    }

    public boolean checkPlayerWeight(int itemWeight) {
        return (currentPlayerWeight + itemWeight) <= maxPlayerWeight;
    }
}
