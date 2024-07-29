package ExamPrep3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAsta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "(?<constraints>[#|])(?<name>[a-zA-Z]+\\s*[A-Za-z]*)\\1(?<date>\\d{2}/\\d{2}/\\d{2})\\1(?<kcal>\\d+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(scanner.nextLine());

        List<String> items = new ArrayList<>();
        int totalCalories = 0;
        while (matcher.find()) {
            String name = matcher.group("name");
            String date = matcher.group("date");
            int nutrition = Integer.parseInt(matcher.group("kcal"));
            items.add(String.format("Item: %s, Best before: %s, Nutrition: %d", name, date, nutrition));
            totalCalories += nutrition;
        }

        int daysToLast = totalCalories / 2000;

            System.out.printf("You have food to last you for: %d days!\n", daysToLast);

        for (String item : items) {
            System.out.println(item);
        }
    }
}