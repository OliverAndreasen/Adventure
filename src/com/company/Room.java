package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Room {

    private final String name;
    private final String description;
    private final ArrayList<Item> roomItems = new ArrayList<>();
    private final ArrayList<Enemy> enemyList = new ArrayList<>();
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

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return "You are in " + getName() + " \nDescription: " + description + "\n";
    }

    public void setRoomItem(Item itemName) {
        roomItems.add(itemName);
    }

    public void setEnemy(Enemy name) {
        enemyList.add(name);
    }

    public void roomItemStatus() {
        for (int i = 0; i < roomItems.size(); i++) {
            System.out.println(roomItems.get(i));
        }
    }

    public void removeItem(Item itemName) {
        roomItems.remove(itemName);
    }

    public void removeEnemy(Enemy name) {
        enemyList.remove(name);
    }

    public ArrayList getRoomItems() {
        return roomItems;
    }

    public String getAllItems() {
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < roomItems.size(); i++) {
            String itemDescription = roomItems.get(i).getDescription();

            if (roomItems.get(i) != null) {
                if (count == 0) {
                    result = new StringBuilder("Items in this room: ");
                    count++;
                }
                if (i != (roomItems.size() - 1)) {
                    result.append(itemDescription).append(", ");
                } else {
                    result.append(itemDescription);
                }
            }
        }
        if (roomItems.size() == 0) {
            result = new StringBuilder("The room has no items");
        }
        return result.toString();
    }

    public String getAllEnemies() {
        int count = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < enemyList.size(); i++) {
            String enemyName = enemyList.get(i).getName();

            if (enemyList.get(i) != null) {
                if (count == 0) {
                    result = new StringBuilder("Enemies in this room: ");
                    count++;
                }
                if (i != (enemyList.size() - 1)) {
                    result.append(enemyName).append(", ");
                } else {
                    result.append(enemyName);
                }
            }
        }
        if (enemyList.size() == 0) {
            result = new StringBuilder("The room has no enemies");
        }
        return result.toString();
    }

    public Item findItem(String itemName, Room currentRoom) {
        for (int i = 0; i < currentRoom.roomItems.size(); i++) {
            if (currentRoom.roomItems.get(i).getName().equals(itemName)) {
                return currentRoom.roomItems.get(i);
            }
        }
        return null;
    }

    public Enemy findEnemy(String enemyName, Room currentRoom) {
        for (int i = 0; i < currentRoom.enemyList.size(); i++) {
            if (currentRoom.enemyList.get(i).getName().equals(enemyName)) {
                return currentRoom.enemyList.get(i);
            }
        }
        return null;
    }

    public String closestEnemy(Room currentRoom) {
        ArrayList<Integer> enemyDistance = new ArrayList<>();
        if (currentRoom.enemyList.size() != 0) {
            for (int i = 0; i < currentRoom.enemyList.size(); i++) {
                enemyDistance.add(currentRoom.enemyList.get(i).getDistance());
            }
            int result = Collections.min(enemyDistance);
            int index = enemyDistance.indexOf(result);
            return currentRoom.enemyList.get(index).getName();
        } else {
            return null;
        }
    }
}