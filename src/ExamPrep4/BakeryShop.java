package ExamPrep4;

import java.util.*;

import static java.lang.System.in;


public class BakeryShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        String[] command = sc.nextLine().split(" ");
        Map<String, Integer> storage = new LinkedHashMap<>();
        Map<String, Integer> sold = new LinkedHashMap<>();
        while (!command[0].equals("Complete")) {

            if (command[0].equals("Receive")) {
                int quantity = Integer.parseInt(command[1]);
                String food = command[2];
                if (quantity > 0) {
                    storage.put(food, storage.getOrDefault(food, 0) + quantity);
                }
            } else { //command[0] -> Sell
                int quantityWanted = Integer.parseInt(command[1]);
                String foodWanted = command[2];
                if (!storage.containsKey(foodWanted)) {
                    System.out.printf("You do not have any %s.\n", foodWanted);
                    command = sc.nextLine().split(" ");
                    continue;
                }
                if (storage.get(foodWanted) < quantityWanted) {
                    System.out.printf("There aren't enough %s. You sold the last %d of them.\n", foodWanted, storage.get(foodWanted));
                    if (!sold.containsKey(foodWanted)) {
                        sold.put(foodWanted, storage.get(foodWanted));
                    }
                    storage.remove(foodWanted);
                } else {
                    storage.put(foodWanted, storage.get(foodWanted) - quantityWanted);
                    System.out.printf("You sold %d %s.\n", quantityWanted, foodWanted);
                    sold.put(foodWanted, quantityWanted);
                    if (storage.get(foodWanted) == 0) {
                        storage.remove(foodWanted);
                    }
                }

            }
            command = sc.nextLine().split(" ");
        }
        printStockLeft(storage);
        printSoldItems(sold);
    }

    public static void printStockLeft(Map<String, Integer> storage) {
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
    }

    public static void printSoldItems(Map<String, Integer> sold) {
        int itemsSold = 0;
        for (Map.Entry<String, Integer> entry : sold.entrySet()) {
            itemsSold += entry.getValue();
        }
        System.out.printf("All sold: %d goods\n", itemsSold);
    }
}


