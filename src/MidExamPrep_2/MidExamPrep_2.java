package MidExamPrep_2;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MidExamPrep_2 {
    public static void main(String[] args) {
        guineaPig();
    }

    public static void guineaPig() {
        Scanner scanner = new Scanner(System.in);


        double foodInKg = Double.parseDouble(scanner.nextLine());
        double hayInKg = Double.parseDouble(scanner.nextLine());
        double coverInKg = Double.parseDouble(scanner.nextLine());
        double pigWeightInKg = Double.parseDouble(scanner.nextLine());

        double foodInGram = foodInKg * 1000;
        double hayInGram = hayInKg * 1000;
        double coverInGram = coverInKg * 1000;
        double pigWeightInGram = pigWeightInKg * 1000;



        for (int i = 1; i <= 30; ++i) {

            foodInGram -= 300; //eats 300grams every day

            if (i % 2 == 0) { // every second day
                hayInGram -= 0.05 * foodInGram;
            }
            if (i % 3 == 0) { // every third day
                coverInGram -= ((1 / 3.0) * pigWeightInGram);
            }
            if (foodInGram <= 0 || hayInGram <= 0 || coverInGram <= 0) {
                System.out.println("Merry must go to the pet store!");
                return;
            }

        }

        System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",
                foodInGram / 1000 , hayInGram / 1000, coverInGram / 1000);

    }


    public static void shoppingList() {
        Scanner scanner = new Scanner(System.in);


        List<String> shoppingList = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Go Shopping!")) {
            String item = command.split(" ")[1];

            switch (command.split(" ")[0]) {
                case "Urgent" -> {
                    if (!shoppingList.contains(item)) {
                        shoppingList.add(0, item);
                    }
                }
                case "Unnecessary" -> shoppingList.remove(item);
                case "Correct" -> {
                    String newItem = command.split(" ")[2];
                    if (shoppingList.contains(item)) {
                        shoppingList.set(shoppingList.indexOf(item), newItem);
                    }
                }
                case "Rearrange" -> {
                    if (shoppingList.contains(item)) {
                        shoppingList.remove(item);
                        shoppingList.add(item);
                    }
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(String.join(", ", shoppingList));

    }
}
