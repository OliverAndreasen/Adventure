package com.company;

public class MeleeWeapon extends Weapon{
    public MeleeWeapon(String description, int itemWeight, int damage) {
        super(description, itemWeight, damage);
    }

    @Override
    int ammoLeft() {
        return -1;
    }
}
