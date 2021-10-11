package com.company;

public abstract class Weapon extends Item {
    private final int damage;

    public Weapon(String description, int itemWeight, int damage) {
        super(description, itemWeight);
        this.damage = damage;
    }

    abstract int ammoLeft();

    public int getDamage() {
        return damage;
    }


}


