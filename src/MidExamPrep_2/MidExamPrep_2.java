package MidExamPrep_2;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MidExamPrep_2 {
    public static void main(String[] args) {
        shoppingList();
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
