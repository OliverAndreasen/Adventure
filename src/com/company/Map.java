package com.company;

public class Map {

    private final Room startRoom;

    public Map() {
        //Room (String name, String description)
        Room room1 = new Room("room 1", """
                You are very tired and cold in a big dark forest, you need to find a place to rest for the night.
                Even though it is very dark and horrible weather, you catch a glimpse of what looks like a cave.
                which way do you choose?""");
        Room room2 = new Room("room 2", """
                You are in the entrance of a dark cave, the floor of the entrance is full of jagged rocks, you can not sleep here.\s
                You need to move on to find a place to rest.
                which way do you choose?""");
        Room room3 = new Room("room 3", """
                You arrive in a curved corridor, as you move through the corridor\s
                you step into knee-deep puddles of water.\s
                which way do you choose?""");
        Room room4 = new Room("room 4", "You found an entrance to a cave, dare to go deeper?\n" +
                "Which way do you choose?");
        Room room5 = new Room("room 5", "You found a nice place to sleep with a bed, firewood and a ladder to exit the cave.\n" +
                "Sleep tight.");
        Room room6 = new Room("room 6", "You are at a mossy rockformation, it is very slippery, be careful.\n" +
                "which way do you choose?");
        Room room7 = new Room("room 7", "You are in a curved corridor.\n" +
                "Which way do you choose?");
        Room room8 = new Room("room 8", "You can sense the comfort of a safe place nearby.\n" +
                "Which way do you choose?");
        Room room9 = new Room("room 9", "You are in a curved corridor.\n" +
                "Which way do you choose?. ");


        // Enemy weapons
        MeleeWeapon knife = new MeleeWeapon("small knife", 1, 5);
        RangedWeapon bow = new RangedWeapon("long bow", 3, 50, 3);

        // Room1
        room1.setEast(room2);
        room1.setSouth(room4);


        // Room 2
        room2.setEast(room3);
        room2.setWest(room1);
        // Items
        Item key = new Item("there is a tiny key", 1);
        room2.setRoomItem(key);


        // Room 3
        room3.setWest(room2);
        room3.setSouth(room6);


        // Room 4
        room4.setNorth(room1);
        room4.setSouth(room7);

        // Room 5
        room5.setSouth(room8);

        // Room 6
        room6.setNorth(room3);
        room6.setSouth(room9);

        // Room 7
        room7.setNorth(room4);
        room7.setEast(room8);

        // Room 8
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);

        // Room 9
        room9.setNorth(room6);
        room9.setWest(room8);

        //Room 1
        // Items
        Food apple = new Food("Red apple", 1, 20);
        room1.setRoomItem(apple);
        // Weapons
        MeleeWeapon sword = new MeleeWeapon("there is a large sword", 3, 25);
        room1.setRoomItem(sword);
        // Enemies
        Enemy goblin = new Enemy("Peter the green goblin", knife, 1, 100);
        room1.setEnemy(goblin);
        Enemy jesus = new Enemy("Holy jesus", bow, 10, 200);
        room1.setEnemy(jesus);


        //Room 2
        // Items
        Item shovel = new Item("there is a broken shovel", 2);
        room2.setRoomItem(shovel);


        // Room 4
        // Items
        Food onion = new Food("Yellow onion", 1, 5);
        Item cape = new Item("a yellow cape", 1);
        Item shoe = new Item("an old shoe", 2);
        room4.setRoomItem(cape);
        room4.setRoomItem(shoe);
        room4.setRoomItem(onion);


        // Room 5
        // Items
        Item goldbar = new Item("a huge goldbar", 5);
        room5.setRoomItem(goldbar);
        Item chest = new Item("a locked chest", 6);
        room5.setRoomItem(chest);

        // Room 6
        // Items
        Food oreos = new Food("Roll of oreos", 1, 30);
        room6.setRoomItem(oreos);


        //Room 9
        // Items
        Item backpack = new Item("dusty backpack", 0);
        room9.setRoomItem(backpack);
        startRoom = room1;
    }

    public Room getStartRoom() {
        return startRoom;
    }

}
