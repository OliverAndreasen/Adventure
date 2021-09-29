package com.company;

import java.util.ArrayList;

public class Room {

    private String name;
    private String description;

    private Room north;
    private Room east;
    private Room south;
    private Room west;

    private ArrayList<String> roomItems = new ArrayList<>();
    
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

    public void setRoomItems(String itemName) {
        roomItems.add(itemName);
        System.out.println(itemName + " has been added");
    }
    public void roomItemStatus(){
        for (int i = 0; i < roomItems.size(); i++) {
            System.out.println(roomItems.get(i));
        }
        
    }

}