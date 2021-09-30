package com.company;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private String description;
    private Room north;
    private Room east;
    private Room south;
    private Room west;

    private ArrayList<Item> roomItems = new ArrayList<>();
    
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
        String result = "You are in " + getName() + " \nDescription: " + description + "\n";
        return result;
    }

    public void setRoomItem(Item itemName) {
        roomItems.add(itemName);
    }

    public void roomItemStatus(){
        for (int i = 0; i < roomItems.size(); i++) {
            System.out.println(roomItems.get(i));
        }
        
    }

    public void removeRoomItem (Item itemName) {
        roomItems.remove(itemName);
        }

        public ArrayList getRoomItems() {
        return roomItems;
    }


    public String getAllItems(){
        int count = 0;
        String result = "";
        for (int i = 0; i < roomItems.size(); i++) {
            if (roomItems.get(i) != null) {
                if (count == 0) {
                    result = "Items in this room: ";
                    count ++;
                }
                if (i != (roomItems.size()-1)){
                    result += roomItems.get(i) + ", ";
                } else {
                    result += roomItems.get(i);
                }
            }
        }
        if (roomItems.size() == 0) {
            result = "The room has no items";
        }
        return result;
    }

    public Item findItemRoom(String itemName, Room playerLocation) {
        for (int i = 0; i < playerLocation.roomItems.size(); i++) {
            if (playerLocation.roomItems.get(i).getName().equals(itemName)) {
                return playerLocation.roomItems.get(i);
            }
        }
        return null;
    }



}