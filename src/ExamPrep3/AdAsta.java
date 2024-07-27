package ExamPrep3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAsta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "([#|])(?<itemName>[A-Za-z\\s]+)\\1(?<expirationDate>[0-9]{2}/[0-9]{2}/[0-9]{2})\\1(?<kcal>[0-9]{1,5})\\1";
        int totalCalories = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> foodList = new ArrayList<>();
        while (matcher.find()) {
            String name = matcher.group("itemName");
            String expirationDate = matcher.group("expirationDate");
            int calories = Integer.parseInt(matcher.group("kcal"));
            totalCalories += calories;
            foodList.add(String.format("Item: %s, Best before: %s, Nutrition: %d", name, expirationDate, calories));
        }

        int days = totalCalories / 2000;
        print(foodList, days);
    }

    public static void print(List<String> foodList, int days) {
        System.out.printf("You have food to last you for: %d days!\n", days);
        for (String food : foodList) {
            System.out.println(food);
        }
    }
}