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
        String result = "You are in " + getName() + " \nDescription: " + description;
        return result;
    }

    public void setRoomItems(Item itemName) {
        roomItems.add(itemName);
        System.out.println(itemName + " has been added");
    }
    public void roomItemStatus(){
        for (int i = 0; i < roomItems.size(); i++) {
            System.out.println(roomItems.get(i));
        }
        
    }
    public String getAllItems(){
        String result = "Items in this room: ";
        for (int i = 0; i < roomItems.size(); i++) {
            if (roomItems.size() != (roomItems.size()-1)){
                result += roomItems.get(i) + ", ";
            } else {
                result += roomItems.get(i);
            }
        }
        return result;
    }
    public Item findItem(String itemName, Room playerLocation) {
        for (int i = 0; i < playerLocation.roomItems.size(); i++) {
            if (playerLocation.roomItems.get(i).getName().equals(itemName)) {
                return playerLocation.roomItems.get(i);
            }
        }
        return null;
    }


}