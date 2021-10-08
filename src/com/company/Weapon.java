package com.company;

public class Weapon extends Item {
    private int damage;

    public Weapon(String description, int itemWeight, int damage) {
        super(description, itemWeight);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}


