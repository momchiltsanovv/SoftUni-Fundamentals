package MidExamPrep_1;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;


public class MidExamPrep_1 {
    public static void main(String[] args) {
        movingTarget();
    }

    public static void computerStore() {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        double sum = 0;
        while (!command.equals("regular") && !command.equals("special")) {
            double curPrice = Double.parseDouble(command);
            if (curPrice < 0) {
                System.out.println("Invalid price!");
                command = scanner.nextLine();
                continue;
            }
            sum += curPrice;
            command = scanner.nextLine();
        }

        double tax = 0.2 * sum;
        double total = sum + tax;
        if (command.equals("special")) {
            total -= 0.1 * total;
        }
        if (sum == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.print("Congratulations you've just bought a new computer!\n");
            System.out.printf("Price without taxes: %.2f$\n", sum);
            System.out.printf("Taxes: %.2f$\n", tax);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", total);
        }
    }

    public static void muOnline() {
        Scanner scanner = new Scanner(System.in);


        int health = 100;
        int bitcoins = 0;

        String[] rooms = scanner.nextLine().split("\\|");

        int length = rooms.length;
        int roomCounter = 0;
        for (int i = 0; i < rooms.length; ++i) {
            String[] currentRoom = rooms[i].split(" ");

            switch (currentRoom[0]) {
                case "potion" -> {
                    int healed = Integer.parseInt(currentRoom[1]);
                    int newHealth = health + healed;
                    if (newHealth >= 100) {
                        healed = 100 - health;
                        health = 100;
                    } else {
                        health = newHealth;
                    }
                    System.out.printf("You healed for %d hp.\n", healed);
                    System.out.printf("Current health: %d hp.\n", health);
                }
                case "chest" -> {
                    int foundBitcoins = Integer.parseInt(currentRoom[1]);
                    bitcoins += foundBitcoins;
                    System.out.printf("You found %d bitcoins.\n", foundBitcoins);
                }
                default -> {
                    int attack = Integer.parseInt(currentRoom[1]);
                    health -= attack;
                    if (health <= 0) {
                        System.out.printf("You died! Killed by %s.\n", currentRoom[0]);
                        roomCounter++;
                        System.out.printf("Best room: %d\n", roomCounter);
                        return;
                    } else {
                        System.out.printf("You slayed %s.\n", currentRoom[0]);
                    }
                }
            }
            roomCounter++;
        }

        if (roomCounter == rooms.length && health > 0) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d\n", bitcoins);
            System.out.printf("Health: %d", health);
        }
    }

    public static void movingTarget() {
        Scanner scanner = new Scanner(System.in);


        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        String[] command = scanner.nextLine().split(" ");

        while (!command[0].equals("End")) {

            int idx = Integer.parseInt(command[1]);
            int value = Integer.parseInt(command[2]);

            switch (command[0]) {
                case "Shoot" -> {
                    if (idx >= 0 && idx < targets.size()) {
                        targets.set(idx, targets.get(idx) - value);
                        if (targets.get(idx) <= 0) {
                            targets.remove(idx);
                        }
                    }
                }
                case "Add" -> {
                    if (idx >= 0 && idx < targets.size()) {
                        targets.add(idx, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                }
                case "Strike" -> {
                    int startIndex = idx - value;
                    int endIndex = idx + value;
                    if (startIndex >= 0 && endIndex < targets.size()) {
                        targets.subList(startIndex, endIndex + 1).clear();
                    } else {
                        System.out.println("Strike missed!");
                    }
                }
            }
            command = scanner.nextLine().split(" ");
        }

        boolean first = true;
        for (int target : targets) {
            if (!first) {
                System.out.print("|");
            } else {
                first = false;
            }
            System.out.print(target);
        }


    }

}

