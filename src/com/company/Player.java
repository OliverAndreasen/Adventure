package com.company;

import java.util.ArrayList;

public class Player {
    private int maxInventoryWeight;
    String[] letters;
    Room[] locations;
    private Room currentRoom;
    private int currentInventoryWeight;
    private final ArrayList<Item> playerItems = new ArrayList<>();


    public Player() {
        letters = new String[4];
        locations = new Room[4];
        letters[0] = "n";
        letters[1] = "e";
        letters[2] = "s";
        letters[3] = "w";
        this.maxInventoryWeight = 5;
        this.currentInventoryWeight = 0;
    }

    public Room currentRoom(Room currentRoom) {
        return this.currentRoom = currentRoom;
    }

    public int getMaxInventoryWeight() {
        return maxInventoryWeight;
    }
    public int changeMaxInventoryWeight(int amount) {
       return maxInventoryWeight = maxInventoryWeight + amount;
    }

    public int getCurrentInventoryWeight() {
        return this.currentInventoryWeight;
    }

    // Checks if you can go in a specific direction from the room you are in
    public boolean checkDirection(String direction) {
        boolean blDirection = false;
        locations[0] = currentRoom.getNorth();
        locations[1] = currentRoom.getEast();
        locations[2] = currentRoom.getSouth();
        locations[3] = currentRoom.getWest();

        for (int i = 0; i < letters.length; i++) {
            if (direction.equals(letters[i]) && locations[i] != null) {
                blDirection = true;
            }
        }
        return blDirection;
    }


    //moves the player to a new room
    public Room move(String nextRoom) {
        locations[0] = currentRoom.getNorth();
        locations[1] = currentRoom.getEast();
        locations[2] = currentRoom.getSouth();
        locations[3] = currentRoom.getWest();

        for (int i = 0; i < letters.length; i++) {
            if (nextRoom.equals(letters[i])) {
                return locations[i];
            }
        }
        return null;
    }

    public String takeItem(String itemName) {
        String result = "";
        Item item = currentRoom.findItem(itemName, currentRoom);
        int itemWeight = item.getItemWeight();

        if (canCarryMore(itemWeight)) {
            playerItems.add(item);
            currentInventoryWeight += itemWeight;
            currentRoom.removeRoomItem(item);
            result += ("You picked up " + itemName + "\n");
            result += (itemName + " are now in your inventory");
        } else {
            result = ("You are over encumbered.\nYou have to drop something, before you can pick up the " + itemName + "!");
        }
        return result;
    }

    public String dropItem(String itemName) {
        String result = "";
        Item item = findItemInventory(itemName);
        result = "You dropped " + item + "\n";
        currentRoom.setRoomItem(item);
        // Adds weight after picking up the item
        currentInventoryWeight = currentInventoryWeight - item.getItemWeight();
        playerItems.remove(item);
        return result;
    }

    public String getInventory() {
        String result = "";
        result += "Your current inventory weight is: " + currentInventoryWeight + " out of " + maxInventoryWeight + "\n";
        result += "In your inventory you have:\n";

        int length = playerItems.size();
        for (int i = 0; i < length; i++) {
            String itemName = playerItems.get(i).getName();
            // check if not the last item in Arraylist
            if (i != length - 1) {
                result += itemName + "\n";
            } else {
                result += itemName;
            }
        }
        return result;
    }

    public Item findItemInventory(String itemName) {
        for (int i = 0; i < playerItems.size(); i++) {
            if (playerItems.get(i).getName().equals(itemName)) {
                return playerItems.get(i);
            }
        }
        return null;
    }

    public boolean canCarryMore(int itemWeight) {
            return (currentInventoryWeight + itemWeight) <= maxInventoryWeight;
    }
}
