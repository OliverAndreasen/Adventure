package com.company;

import java.util.ArrayList;

public class Player {
    private int maxPlayerWeight;
    String[] letters;
    Room[] locations;
    private Room currentRoom;
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

    public Room currentRoom(Room currentRoom) {
        return this.currentRoom = currentRoom;
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

    public void takeItem(String itemName) {
        Item item = currentRoom.findItem(itemName, currentRoom);
        int itemWeight = item.getItemWeight();

        if (canCarryMore(itemWeight)) {
            playerItems.add(item);
            currentPlayerWeight += itemWeight;
            System.out.println("You picked up " + itemName);
            currentRoom.removeRoomItem(item);
            System.out.println(itemName + " are now in your inventory");

            if (itemName.equals("backpack")) {
                this.maxPlayerWeight = maxPlayerWeight + 5;
            }
        } else {
            System.out.println("You are over encumbered.\nYou have to drop something, before you can pick up the " + itemName + "!");
        }
    }


    public String getInventory() {
        String result = "";
        result += "Your current inventory weight is: " + currentPlayerWeight + " out of " + maxPlayerWeight + "\n";
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

    public void dropItem(String itemName) {
        Item item = findItemInventory(itemName);
        System.out.println("you dropped " + item);
        currentRoom.setRoomItem(item);
        // Adds weight after picking up the item
        currentPlayerWeight = currentPlayerWeight - item.getItemWeight();
        if (itemName.equals("backpack")) {
            this.maxPlayerWeight = maxPlayerWeight - 5;
        }
        playerItems.remove(item);
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
        return (currentPlayerWeight + itemWeight) <= maxPlayerWeight;
    }
}
