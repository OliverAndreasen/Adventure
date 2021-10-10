package com.company;

public class Food extends Item{
    private int health;

    public Food(String description, int itemWeight, int health) {
        super(description, itemWeight);
        this.health = health;
    }

    public int getHealth() {
        return health;
    }


}
