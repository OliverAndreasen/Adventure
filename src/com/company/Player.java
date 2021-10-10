package com.company;

import java.util.ArrayList;

public class Player {
    private final ArrayList<Item> playerItems = new ArrayList<>();
    private final int maxHealth;
    String[] letters;
    Room[] locations;
    private int maxInventoryWeight;
    private Room currentRoom;
    private int currentInventoryWeight;
    private int currentHealth;
    private String equippedWeapon;


    public Player() {
        letters = new String[4];
        locations = new Room[4];
        letters[0] = "n";
        letters[1] = "e";
        letters[2] = "s";
        letters[3] = "w";

        this.maxInventoryWeight = 5;
        this.currentInventoryWeight = 0;
        this.maxHealth = 100;
        this.currentHealth = 100;
        this.equippedWeapon = null;
    }

    public String getEquippedWeapon() {
        return equippedWeapon;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setPlayerItem(Item itemName) {
        playerItems.add(itemName);
    }

    public Room currentRoom(Room currentRoom) {
        return this.currentRoom = currentRoom;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxInventoryWeight() {
        return maxInventoryWeight;
    }

    public int changeMaxInventoryWeight(int amount) {
        return maxInventoryWeight = maxInventoryWeight + amount;
    }

    public int getCurrentInventoryWeight() {
        return this.currentInventoryWeight;
    }

    // Checks if you can go in a specific direction from the room you are in
    public boolean checkDirection(String direction) {
        boolean blDirection = false;
        locations[0] = currentRoom.getNorth();
        locations[1] = currentRoom.getEast();
        locations[2] = currentRoom.getSouth();
        locations[3] = currentRoom.getWest();

        for (int i = 0; i < letters.length; i++) {
            if (direction.equals(letters[i]) && locations[i] != null) {
                blDirection = true;
                break;
            }
        }
        return blDirection;
    }

    //moves the player to a new room
    public Room move(String nextRoom) {
        locations[0] = currentRoom.getNorth();
        locations[1] = currentRoom.getEast();
        locations[2] = currentRoom.getSouth();
        locations[3] = currentRoom.getWest();
        for (int i = 0; i < letters.length; i++) {
            if (nextRoom.equals(letters[i])) {
                return locations[i];
            }
        }
        return null;
    }

    public String takeItem(String itemName) {
        String result = "";
        Item item = currentRoom.findItem(itemName, currentRoom);
        int itemWeight = item.getItemWeight();

        if (canCarryMore(itemWeight)) {
            playerItems.add(item);
            currentInventoryWeight += itemWeight;
            currentRoom.removeItem(item);
            result += ("You picked up " + itemName + "\n");
            result += (itemName + " are now in your inventory");
        } else {
            result = ("You are over encumbered.\nYou have to drop something, before you can pick up the " + itemName + "!");
        }
        return result;
    }

    public String dropItem(String itemName) {
        Item item = findItemInventory(itemName);
        String result = "You dropped " + item + "\n";
        currentRoom.setRoomItem(item);
        // Adds weight after picking up the item
        currentInventoryWeight = currentInventoryWeight - item.getItemWeight();
        playerItems.remove(item);
        return result;
    }

    public String getInventory() {
        StringBuilder result = new StringBuilder();
        result.append("Your current inventory weight is: ").append(currentInventoryWeight).append(" out of ").append(maxInventoryWeight).append("\n");
        result.append("In your inventory you have:\n");

        int length = playerItems.size();
        for (int i = 0; i < length; i++) {
            String itemName = playerItems.get(i).getName();
            // check if not the last item in Arraylist
            if (i != length - 1) {
                result.append(itemName).append("\n");
            } else {
                result.append(itemName);
            }
        }
        return result.toString();
    }

    public Item findItemInventory(String itemName) {
        for (int i = 0; i < playerItems.size(); i++) {
            if (playerItems.get(i).getName().equals(itemName)) {
                return playerItems.get(i);
            }
        }
        return null;
    }

    public boolean canCarryMore(int itemWeight) {
        return (currentInventoryWeight + itemWeight) <= maxInventoryWeight;
    }

    public int eat(String itemName) {
        int foodHealth = 0;
        int healed = 0;
        Item food;
        if (findItemInventory(itemName) == null) {
            food = currentRoom.findItem(itemName, currentRoom);
            this.currentRoom.removeItem(food);
        } else {
            food = findItemInventory(itemName);
            playerItems.remove(food);
        }
        if (food instanceof Food) {
            foodHealth = ((Food) food).getHealth();
            currentHealth = this.currentHealth + foodHealth;

            if (currentHealth >= maxHealth) {
                healed = maxHealth - currentHealth;
                healed = healed + foodHealth;
                currentHealth = maxHealth;
            } else {
                healed = foodHealth;
            }
            return healed;
        } else {
            System.out.println("You can not eat this");
        }
        return -1;
    }

    public boolean checkIfEquipped() {
        return this.equippedWeapon != null;
    }

    public String equip(String itemName) {
        if (!checkIfEquipped()) {
            Item weapon = findItemInventory(itemName);
            if (weapon instanceof Weapon) {
                this.equippedWeapon = weapon.getName();
                return "you have equipped: " + itemName;
            } else
                return "You cant equip an " + itemName;
        } else {
            return "You already have " + getEquippedWeapon() + " equipped";
        }
    }

    public void unEquipWeapon() {
        System.out.println("You unequipped " + this.equippedWeapon);
        this.equippedWeapon = null;
    }

    public String checkWeaponType(String equippedWeapon) {
        Item weapon = findItemInventory(equippedWeapon);
        String result = null;
        if (weapon instanceof MeleeWeapon) {
            result = "MeleeWeapon";
        } else if (weapon instanceof RangedWeapon) {
            result = "RangedWeapon";
        }
        return result;
    }

    public int attack() {
        Item item = findItemInventory(this.equippedWeapon);
        Weapon weapon = ((Weapon) item);
        int damage = 0;
        if (weapon.ammoLeft() == -1) {
            damage = weapon.getDamage();
        } else if (weapon.ammoLeft() > 0) {
            int ammo = weapon.ammoLeft();
            ammo = ammo - 1;
            ((RangedWeapon) weapon).setAmmo(ammo);
            damage = weapon.getDamage();
        }
        return damage;
    }

    public Weapon isWeapon(Item item) {
        Weapon weapon = null;
        if (item instanceof Weapon) {
            weapon = ((Weapon) item);

        }
        return weapon;
    }
}
