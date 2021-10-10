package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Game {

    public void go() {
        Map map = new Map();
        Player player = new Player();
        Parser parser = new Parser();
        Room currentRoom = player.currentRoom(map.getStartRoom());

        System.out.println(parser.welcome());
        Scanner sc = new Scanner(System.in);

        boolean con = true;
        int count = 0;

        while (con) {
            if (count == 0) {
                System.out.println(currentRoom.getDescription());
                count++;
            }
            String input = sc.nextLine();
            currentRoom = player.currentRoom(currentRoom);
            input = input.toLowerCase(Locale.ROOT);
            String command = parser.getFirstWord(input);
            String itemName = parser.passItemNameInput(input);
            parser.passPlayer(player);
            parser.passCurrentRoom(currentRoom);
            int playerHealth = player.getCurrentHealth();
            count = count + 1;

            // checks if the direction input is available
            switch (command) {
                case "go":
                    String direction = parser.validateDirection(parser.getSecondWord(input));
                    if (!direction.isEmpty()) {
                        if (parser.checkRoomDirection(direction)) {
                            //changes current room to the new room
                            currentRoom = player.move(direction);
                            System.out.println(currentRoom.getDescription());
                        } else {
                            System.out.println("You cant go that way, try again!");
                        }
                    } else {
                        System.out.println("write a direction you want to go");
                    }
                    break;
                case "open", "o":
                    System.out.println(parser.use());
                    break;

                case "help", "h":
                    System.out.println(parser.help());
                    break;

                case "cheat", "c":
                    System.out.println(parser.cheat(player));
                    break;

                case "look", "l":
                    System.out.println(parser.look(currentRoom));
                    break;

                case "take", "t":
                    System.out.println(itemName);
                    System.out.println(parser.take());
                    break;

                case "drop", "d":
                    System.out.println(parser.drop());
                    break;

                case "inventory", "inv", "i":
                    System.out.println(parser.getPlayerInventory());
                    break;

                case "exit", "x":
                    parser.exit();
                    con = false;
                    break;

                case "health":
                    System.out.println("Your health is: " + playerHealth);
                    break;

                case "eat":
                    int health = player.eat(itemName);
                    System.out.println("you ate an " + itemName + " you gained " + health + " hp");
                    System.out.println("your current hp is now " + player.getCurrentHealth() + " out of " + player.getMaxHealth());
                    break;

                case "equip":
                    String equip = player.equip(itemName);
                    switch (equip) {
                        case "ItemEquip" -> System.out.println("you have equipped: " + itemName);
                        case "NotAWeapon" -> System.out.println("You cant equip an " + itemName);
                        case "WeaponAlreadyEquipped" -> System.out.println("You already have " + player.getEquippedWeapon() + " equipped");
                    }
                    break;

                case "attack":
                    parser.passEnemyInput(input);
                    System.out.println(parser.attack());
                    /*
                    Enemy enemy;
                    if (player.checkIfEquipped()) {
                        if (enemyName == null) {
                            enemyName = currentRoom.closestEnemy(currentRoom);
                            enemy = currentRoom.findEnemy(enemyName, currentRoom);
                        }
                        enemy = currentRoom.findEnemy(enemyName, currentRoom);
                        if (enemy != null) {
                            if (enemy.getIsAlive()) {
                                Item item = player.findItemInventory(player.getEquippedWeapon());
                                Weapon weapon = player.isWeapon(item);
                                int damage = weapon.getDamage();
                                player.attack(enemy);
                                int enemyHealth = enemy.getCurrentHealth();
                                enemy.setCurrentHealth(enemyHealth - damage);
                                System.out.println("you attacked " + enemyName + "\nYou dealt " + damage + " damage");
                                System.out.println(enemyName + " current health is now " + enemy.getCurrentHealth());
                                Weapon enemyWeapon = enemy.getWeapon();
                                if (enemy.died()) {
                                    currentRoom.setRoomItem(enemyWeapon);
                                    System.out.println(enemyName + " died and dropped " + enemyWeapon.getName());
                                    currentRoom.removeEnemy(enemy);
                                } else if (enemyWeapon.ammoLeft() == 0) {
                                    System.out.println("The enemy tried to attack but has no ammo left");
                                    System.out.println("Your current health is now " + player.getCurrentHealth());
                                } else {
                                    enemy.attack();
                                    int enemyDamage = enemyWeapon.getDamage();
                                    playerHealth = player.getCurrentHealth() - enemyDamage;
                                    player.setCurrentHealth(playerHealth);
                                    System.out.println(enemyName + " attacked you with " + enemyWeapon.getName() + " and dealt " + enemyDamage + " damage");
                                    System.out.println("Your current health is now " + player.getCurrentHealth());
                                    if (enemy.died()) {
                                        currentRoom.setRoomItem(enemyWeapon);
                                        System.out.println(enemyName + " died and dropped " + enemyWeapon.getName());
                                        currentRoom.removeEnemy(enemy);
                                    }
                                }
                            }
                        } else {
                            System.out.println("you swung " + player.getEquippedWeapon() + " but hit nothing");
                        }
                    } else {
                        System.out.println("You have to equip a weapon to attack");
                    }

                     */
                    break;

                case "unequip":
                    player.unEquipWeapon();
                    break;

                case "enemies":
                    System.out.println(currentRoom.getAllEnemies());

                default:
                    System.out.println("invalid command");
            }
        }
    }
}
