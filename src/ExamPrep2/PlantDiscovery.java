package ExamPrep2;

import java.util.*;

import static java.lang.System.in;
import static java.lang.System.setOut;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int size = Integer.parseInt(sc.nextLine());

        Map<String, List<Integer>> plantsAndRarity = new LinkedHashMap<>();// name of plant and list of its rarity values
        Map<String, List<Integer>> rating = new LinkedHashMap<>();// name of plant and list of its rating values
        for (int i = 0; i < size; i++) {
            String[] curPlant = sc.nextLine().split("<->");
            String plantName = curPlant[0];
            int plantRarity = Integer.parseInt(curPlant[1]);
            if (!plantsAndRarity.containsKey(plantName)) {
                plantsAndRarity.put(plantName, new ArrayList<>());
                plantsAndRarity.get(plantName).add(plantRarity);
            } else {
                plantsAndRarity.get(plantName).remove(0);
                plantsAndRarity.get(plantName).add(plantRarity);
            }
            rating.putIfAbsent(plantName, new ArrayList<>());

        }

        String[] command = sc.nextLine().split(": ");
        while (!command[0].equals("Exhibition")) {
            switch (command[0]) {
                case "Rate" -> rate(command[1], rating);
                case "Update" -> updates(command[1], plantsAndRarity);
                case "Reset" -> reset(command[1], rating);
                default -> System.out.println("error");
            }
            command = sc.nextLine().split(": ");
        }

        printOutput(rating, plantsAndRarity);


    }

    private static void printOutput(Map<String, List<Integer>> rating, Map<String, List<Integer>> plantsAndRarity) {
        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, List<Integer>> entry : plantsAndRarity.entrySet()) {
            String plantName = entry.getKey();
            int rarity = entry.getValue().get(0);
            List<Integer> ratingsList = rating.get(plantName);

            double averageRating = 0.0;
            if (ratingsList != null && !ratingsList.isEmpty()) {
                double sum = 0.0;
                for (int rate : ratingsList) {
                    sum += rate;
                }
                averageRating = sum / ratingsList.size();
            }
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", plantName, rarity, averageRating);
        }
    }

    private static void reset(String plantData, Map<String, List<Integer>> rating) {
        String[] plantInfo = plantData.split(" - ");
        String plantName = plantInfo[0];
        if (!rating.containsKey(plantName)) {
            System.out.println("error");
        } else {
            rating.get(plantName).clear();
        }
    }

    private static void updates(String plantData, Map<String, List<Integer>> plantsAndRarity) {
        String[] plantInfo = plantData.split(" - ");
        String plantName = plantInfo[0];
        int plantRarity = Integer.parseInt(plantInfo[1]);
        if (!plantsAndRarity.containsKey(plantName)) {
            System.out.println("error");
        } else {
            plantsAndRarity.get(plantName).remove(0);
            plantsAndRarity.get(plantName).add(plantRarity);
        }

    }

    private static void rate(String plantData, Map<String, List<Integer>> rating) {
        String[] plantInfo = plantData.split(" - ");
        String plantName = plantInfo[0];
        int plantRating = Integer.parseInt(plantInfo[1]);
        if (!rating.containsKey(plantName)) {
            System.out.println("error");
        } else {
            rating.get(plantName).add(plantRating);
        }
    }


}
