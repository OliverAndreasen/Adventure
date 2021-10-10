package com.company;

public class Item {
    private final String itemName;
    private final String description;
    private final int itemWeight;
    //private final ArrayList<Item> allItems = new ArrayList<>();

    public Item(String description, int itemWeight) {
        this.itemName = description.substring(description.lastIndexOf(' ') + 1);
        this.description = description;
        this.itemWeight = itemWeight;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return itemName;
    }

    public String toString() {
        return itemName;
    }

    public int getItemWeight() {
        return itemWeight;
    }

    public boolean checkIfBackpack() {
        return this.itemName.equals("backpack");
    }
}




