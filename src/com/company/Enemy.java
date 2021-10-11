package com.company;

public class Enemy {
    private final String name;
    private final Weapon weapon;
    private final int distance;
    private boolean isAlive;
    private int currentHealth;


    public Enemy(String description, Weapon weapon, int distance, int currentHealth) {
        this.weapon = weapon;
        this.currentHealth = currentHealth;
        this.name = description.substring(description.lastIndexOf(' ') + 1);
        this.isAlive = true;
        this.distance = distance;
    }

    public int attack() {
        int damage = 0;
        if (weapon.ammoLeft() == -1) {
            damage = weapon.getDamage();
        } else if (weapon.ammoLeft() > 0) {
            int ammo;
            ammo = weapon.ammoLeft();
            ammo = ammo - 1;
            ((RangedWeapon) weapon).setAmmo(ammo);
            damage = weapon.getDamage();
        }
        return damage;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public String getName() {
        return name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public boolean died() {
        if (this.currentHealth <= 0) {
            this.isAlive = false;
            return true;
        } else {
            return false;
        }
    }

    public int getDistance() {
        return distance;
    }
}