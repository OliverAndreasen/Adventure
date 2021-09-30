package com.company;

import java.util.ArrayList;

public class Item {
    private final String itemName;
    private final String description;
    private final int itemWeight;
    private final ArrayList<Item> allItems = new ArrayList<>();

    public Item(String itemName, String description, int itemWeight) {
        this.itemName = itemName;
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
}




