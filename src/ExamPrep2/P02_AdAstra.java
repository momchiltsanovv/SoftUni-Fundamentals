package ExamPrep2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "([#|])(?<item>[A-Za-z\\s]+)\\1(?<expirationDate>[0-9]{2}/[0-9]{2}/[0-9]{2})\\1(?<kcal>[0-9]{1,5})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        Map<String, List<String>> foodMap = new LinkedHashMap<>();

        int totalKcal = 0;

        while(matcher.find()){
            String item = matcher.group("item");
            String expirationDate = matcher.group("expirationDate");
            String calories = matcher.group("kcal");

            List<String> expDateAndKcal = new ArrayList<>();

            expDateAndKcal.add(expirationDate);
            expDateAndKcal.add(calories);

            foodMap.put(item, expDateAndKcal);

            totalKcal+= Integer.parseInt(calories);
        }

        int daysToLast = totalKcal / 2000;
        System.out.printf("You have food to last you for: %d days!%n", daysToLast);

        for (Map.Entry<String, List<String>> entry : foodMap.entrySet()){

            String item = entry.getKey();
            String expDate = entry.getValue().get(0);
            int kcal = Integer.parseInt(entry.getValue().get(1));

            System.out.printf("Item: %s, Best before: %s, Nutrition: %d\n", item, expDate, kcal);
        }

    }
}
