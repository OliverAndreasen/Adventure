package com.company;

public class RangedWeapon extends Weapon{

    private int ammo;

    public RangedWeapon(String description, int itemWeight, int damage, int ammo) {
        super(description, itemWeight, damage);
        this.ammo = ammo;
    }

    public int ammoLeft() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }
}
