package com.company;

public class Parser {

    private String itemName;
    private Player player;
    private String input;
    private Room currentRoom;
    private Enemy enemy;
    private String enemyName = null;

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public String validateDirection(String direction) {
        String result = direction;

        if (direction.equals("n") || direction.equals("north")) {
            result = "n";
        }
        if (direction.equals("e") || direction.equals("east")) {
            result = "e";
        }
        if (direction.equals("s") || direction.equals("south")) {
            result = "s";
        }
        if (direction.equals("w") || direction.equals("west")) {
            result = "w";
        }
        return result;
    }

    public boolean checkRoomDirection(String direction) {
        if (player.checkDirection(direction)) {
            return true;
        }
        return false;
    }

    public void exit() {
        System.exit(0);
    }

    public String help() {
        String help = "";
        help += "if you want to turn the program off type 'off'\n";
        help += "to get a room description you can type 'look'\n";
        help += "to get help with directions you can type 'cheat'\n";
        help += "to pick up an item type 'take' followed by the name of the item\n";
        help += "to drop an item type 'drop' followed by the name of the item\n";
        return help;
    }

    public String cheat(Player player) {
        String result = "";

        if (player.checkDirection("n")) {
            result += "you can go 'north'\n";
        }
        if (player.checkDirection("e")) {
            result += "you can go 'east'\n";
        }
        if (player.checkDirection("s")) {
            result += "you can go 'south'\n";
        }
        if (player.checkDirection("w")) {
            result += "you can go 'west'\n";
        }
        return result;
    }

    public String look(Room currentRoom) {
        String result = "";
        result += currentRoom.getDescription() + "\n";
        result += currentRoom.getAllItems();
        return result;
    }

    public Player passPlayer(Player player) {
        return this.player = player;
    }

    public String passItemNameInput(String input) {
        return this.input = getSecondWord(input);
    }

    public String passEnemyInput(String input) {
        int space = input.indexOf(" ");
        if (space == -1) {
            return null;
        } else {
            enemyName = input.substring(space + 1);
            setEnemyName(enemyName);
            return enemyName;
        }
    }

    public Player getPlayer() {
        return this.player;
    }

    public Room passCurrentRoom(Room currentRoom) {
        return this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public String take() {
        String result = "";
        String itemName = passItemNameInput(input);
        currentRoom = getCurrentRoom();

        if (currentRoom.findItem(itemName, currentRoom) != null) {
            Item item = currentRoom.findItem(itemName, currentRoom);
            if (item.checkIfBackpack()) {
                result += player.takeItem(itemName);
                player.changeMaxInventoryWeight(5);
                result += "Your max inventory capacity increased to " + player.getMaxInventoryWeight();
            } else {
                System.out.println(player.takeItem(itemName));
            }
        } else {
            result = "there is no such item";
        }
        return result;
    }

    public String drop() {
        player = getPlayer();
        String result = "";
        itemName = passItemNameInput(input);
        if (player.findItemInventory(itemName) != null) {
            Item item = player.findItemInventory(itemName);
            if (item.checkIfBackpack()) {
                if (player.getCurrentInventoryWeight() <= 5) {
                    player.changeMaxInventoryWeight(-5);
                    result += player.dropItem(itemName);
                    result += "Your max inventory capacity decreased to "
                            + player.getMaxInventoryWeight();
                } else {
                    result += "You cannot drop the backpack! Drop one or more " +
                            "items before you can remove the backpack";
                }
            } else {
                result = player.dropItem(itemName);
            }
        } else {
            result = "you dont have such item";
        }
        return result;
    }

    public String use() {
        player = getPlayer();
        Item goldbar = new Item("goldbar", 5);
        String result = "";
        itemName = passItemNameInput(input);

        if (player.findItemInventory("key") == null && currentRoom.getAllItems().contains("chest")) {
            result += "you are missing a key";
        }
        if (!currentRoom.getAllItems().contains("chest")) {
            if (player.findItemInventory("key") != null) {
                result += "there is nothing to use the key on";
            } else {
                result += "use command invalid";
            }
        }
        if (currentRoom.getAllItems().contains("chest")) {
            if (player.findItemInventory("key") != null) {
                player.setPlayerItem(goldbar);
                result += "you opened the chest and found a goldbar";
            }
        }
        return result;
    }

    public String getPlayerInventory() {
        return player.getInventory();
    }

    public String welcome() {
        StringBuilder str = new StringBuilder();
        str.append("Welcome to the Adventure game!\n");
        str.append("You have to choose a direction, you want to walk in\n");
        str.append("You can type 'north', 'east', 'south' or 'west'\n");
        str.append("you can also 'take' and 'drop' items for more instructions type 'help'\n");
        str.append("Other functions: 'off', 'look', 'help', 'inv' 'cheat'");
        str.append("\n");

        String result = str.toString();
        return result;
    }

    public String getFirstWord(String input) {
        int space = input.indexOf(" ");
        if (space == -1) {
            int length = input.length();
            return input.substring(0, length);
        } else {
            return input.substring(0, space);
        }
    }

    public String getSecondWord(String input) {
        int space = input.indexOf(" ");
        return input.substring(space + 1);
    }


    public String attack() {
        StringBuilder str = new StringBuilder();
        if (player.checkIfEquipped()) {
            if (enemyName == null) {
                enemyName = currentRoom.closestEnemy(currentRoom);
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
                    str.append("you attacked " + enemyName + "\nYou dealt " + damage + " damage\n");
                    str.append(enemyName + " current health is now " + enemy.getCurrentHealth() + "\n");
                    Weapon enemyWeapon = enemy.getWeapon();
                    if (enemy.died()) {
                        currentRoom.setRoomItem(enemyWeapon);
                        str.append(enemyName + " died and dropped " + enemyWeapon.getName() + "\n");
                        currentRoom.removeEnemy(enemy);
                    } else if (enemyWeapon.ammoLeft() == 0) {
                        str.append("The enemy tried to attack but has no ammo left" + "\n");
                        str.append("Your current health is now " + player.getCurrentHealth() + "\n");
                    } else {
                        enemy.attack();
                        int enemyDamage = enemyWeapon.getDamage();
                        int playerHealth = player.getCurrentHealth() - enemyDamage;
                        player.setCurrentHealth(playerHealth);
                        str.append(enemyName + " attacked you with " + enemyWeapon.getName() + " and dealt " + enemyDamage + " damage" + "\n");
                        str.append("Your current health is now " + player.getCurrentHealth() + "\n");
                        if (enemy.died()) {
                            currentRoom.setRoomItem(enemyWeapon);
                            str.append(enemyName + " died and dropped " + enemyWeapon.getName() + "\n");
                            currentRoom.removeEnemy(enemy);
                        }
                    }
                }
            } else {
                str.append("you swung " + player.getEquippedWeapon() + " but hit nothing" + "\n");
            }
        } else {
            str.append("You have to equip a weapon to attack" + "\n");
        }

        setEnemyName(null);
        String result = str.toString();
        return result;
    }
}
