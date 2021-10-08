package com.company;
import java.util.ArrayList;
import java.util.List;

public class Food extends Item{
    private int health;
    private List<Food> allFood = new ArrayList<>();

    public Food(String description, int itemWeight, int health) {
        super(description, itemWeight);
        this.health = health;
    }

    public int getHealth() {
        return health;
    }


}
