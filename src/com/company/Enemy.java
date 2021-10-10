package com.company;

public class Enemy {
    private final String description;
    private final String name;
    private final Weapon weapon;
    private int distance;

    private boolean isAlive;
    private final int maxHealth;
    private int currentHealth;


    public Enemy(String description, Weapon weapon, int distance) {
        this.description = description;
        this.weapon = weapon;
        this.maxHealth = 100;
        this.currentHealth = 100;
        this.name = description.substring(description.lastIndexOf(' ') + 1);
        this.isAlive = true;
        this.distance = distance;
    }
/*
    public String checkWeaponType(Weapon weapon) {
        String result = null;
        if (weapon instanceof MeleeWeapon) {
            result = "MeleeWeapon";
        } else if (weapon instanceof RangedWeapon) {
            result = "RangedWeapon";
        }
        return result;
    }
 */

    public int attack() {
        int damage = 0;
        if (weapon.ammoLeft() == -1) {
            damage = weapon.getDamage();
        } else if (weapon.ammoLeft() > 0) {
            int ammo = weapon.ammoLeft();
            ammo = weapon.ammoLeft();
            ammo = ammo - 1;
            ((RangedWeapon)weapon).setAmmo(ammo);
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

    public boolean died(){
        if(this.currentHealth <= 0){
            this.isAlive = false;
            return true;
        }
        else {
            return false;
        }
    }

    public int getDistance() {
        return distance;
    }
}