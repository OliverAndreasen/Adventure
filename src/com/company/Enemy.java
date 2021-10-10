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

    public String checkWeaponType(Weapon weapon) {
        String result = null;
        if (weapon instanceof MeleeWeapon) {
            result = "MeleeWeapon";
        } else if (weapon instanceof RangedWeapon) {
            result = "RangedWeapon";
        }
        return result;
    }

    public int attack() {
        String weaponType = checkWeaponType(weapon);
        int damage = 0;

        if (weaponType.equals("MeleeWeapon")) {
            damage = weapon.getDamage();
        } else if (weaponType.equals("RangedWeapon")) {
            int ammo = 0;
            RangedWeapon rangedWeapon = ((RangedWeapon) weapon);
            ammo = rangedWeapon.getAmmo();
            ammo = ammo - 1;
            rangedWeapon.setAmmo(ammo);
            damage = rangedWeapon.getDamage();
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