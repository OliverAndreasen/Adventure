package com.company;
import java.util.ArrayList;

public class Player {
    private int maxInventoryWeight;
    String[] letters;
    Room[] locations;
    private Room currentRoom;
    private int currentInventoryWeight;
    private final ArrayList<Item> playerItems = new ArrayList<>();
    private final int maxHealth;
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
            currentRoom.removeRoomItem(item);
            result += ("You picked up " + itemName + "\n");
            result += (itemName + " are now in your inventory");
        } else {
            result = ("You are over encumbered.\nYou have to drop something, before you can pick up the " + itemName + "!");
        }
        return result;
    }

    public String dropItem(String itemName) {
        String result = "";
        Item item = findItemInventory(itemName);
        result = "You dropped " + item + "\n";
        currentRoom.setRoomItem(item);
        // Adds weight after picking up the item
        currentInventoryWeight = currentInventoryWeight - item.getItemWeight();
        playerItems.remove(item);
        return result;
    }



    public String getInventory() {
        String result = "";
        result += "Your current inventory weight is: " + currentInventoryWeight + " out of " + maxInventoryWeight + "\n";
        result += "In your inventory you have:\n";

        int length = playerItems.size();
        for (int i = 0; i < length; i++) {
            String itemName = playerItems.get(i).getName();
            // check if not the last item in Arraylist
            if (i != length - 1) {
                result += itemName + "\n";
            } else {
                result += itemName;
            }
        }
        return result;
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
        Item food;
        if (findItemInventory(itemName) == null) {
             food = currentRoom.findItem(itemName, currentRoom);
             this.currentRoom.removeRoomItem(food);
        }
        else {
             food = findItemInventory(itemName);
             playerItems.remove(food);
        }
        if (food instanceof Food) {
            int healed = 0;
            foodHealth = ((Food) food).getHealth();
            currentHealth = this.currentHealth + foodHealth;

            if(currentHealth >= maxHealth) {
                healed = maxHealth - currentHealth;
                healed = healed + foodHealth;
                currentHealth = maxHealth;
            }
            else {
                healed = foodHealth;
            }
            return healed;
        }
        else {
            System.out.println("You can not eat this");
        }
        return -1;
    }

    public boolean checkIfEquipped() {
        if (this.equippedWeapon == null) {
            return false;
        }
        else {
            return true;
        }
    }

    public String equip (String itemName) {
        if (!checkIfEquipped()) {
            Item weapon = findItemInventory(itemName);
            if (weapon instanceof Weapon) {
                this.equippedWeapon = weapon.getName();
                return "ItemEquip";
            } else
            return "NotAWeapon";
        }
        else{
            return "WeaponAlreadyEquipped";
        }
    }

    public void unEquipWeapon(){
        System.out.println("you unequipped " + this.equippedWeapon);
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

    public int attack(Enemy enemy){
        Item weapon = findItemInventory(this.equippedWeapon);

        int damage = 0;

        if (weapon instanceof MeleeWeapon)
        {
            MeleeWeapon meleeWeapon = ((MeleeWeapon)weapon);
            damage = meleeWeapon.getDamage();
        }
        else if(weapon instanceof RangedWeapon){
            int ammo = 0;
            RangedWeapon rangedWeapon = ((RangedWeapon) weapon);
            ammo = rangedWeapon.getAmmo();
            ammo = ammo -1;
            rangedWeapon.setAmmo(ammo);
            damage = rangedWeapon.getDamage();
        }
        return damage;
    }

    public Weapon isWeapon (Item item){
        Weapon weapon = null;

        if(item instanceof Weapon){
            weapon =  ((Weapon)item);

        }
        return weapon;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
}
