package AssociativeArrays.ExamResults;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> userPoints = new LinkedHashMap<>();
        Map<String, Integer> languageCount = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("exam finished")) {
            String username = input.split("-")[0];
            if (input.contains("banned")) {
                userPoints.remove(username);
            } else {
                String language = input.split("-")[1];
                int points = Integer.parseInt(input.split("-")[2]);

                if (!userPoints.containsKey(username)) {
                    userPoints.put(username, points);
                } else {
                    int currentPoints = userPoints.get(username);
                    if (points > currentPoints) {
                        userPoints.put(username, points);
                    }
                }

                if (!languageCount.containsKey(language)) {
                    languageCount.put(language, 1);
                } else {
                    languageCount.put(language, languageCount.get(language) + 1);
                }
            }
            input = scanner.nextLine();
        }

        System.out.println("Results:");
        userPoints.forEach((key, value) -> System.out.println(key + " | " + value));

        System.out.println("Submissions:");
        languageCount.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}