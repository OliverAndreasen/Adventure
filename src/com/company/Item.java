package com.company;

import java.util.ArrayList;

public class Item {



    private String itemName;
    private String description;
    private ArrayList <Item> allItems = new ArrayList<>();

    public Item(String itemName, String description){
        this.itemName = itemName;
        this.description = description;


    }

    public void itemToList(Item itemName){
        allItems.add(itemName);
        System.out.println(itemName + " added to the list");
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return itemName;
    }

   /* public void deleteItem(String description) {
        String currentItem;
        for (int i = 0; i < roomItems.size(); i++) {
            currentItem = roomItems.get(i);
            if (currentItem.equals(description)) {
                roomItems.remove(i);
            }*/

    public Item findItem(String itemName) {
        for (int i = 0; i < allItems.size(); i++) {
            if (allItems.get(i).getName().equals(itemName)) {
                return allItems.get(i);
            }
        }
        return null;
    }

    }




