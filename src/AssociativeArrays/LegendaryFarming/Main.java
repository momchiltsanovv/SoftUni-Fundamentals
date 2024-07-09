package AssociativeArrays.LegendaryFarming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materials = new LinkedHashMap<>();
        Map<String, Integer> junks = new LinkedHashMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);

        boolean isLegendaryItemBought = false;

        while (!isLegendaryItemBought) {
            String input = scanner.nextLine();
            String[] inputData = input.split(" ");

            for (int idx = 0; idx < inputData.length; idx += 2) {

                int quantity = Integer.parseInt(inputData[idx]);
                String material = inputData[idx + 1].toLowerCase();

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    int existingQuantity = materials.get(material);
                    materials.replace(material, existingQuantity + quantity);
                } else {
                    if (junks.containsKey(material)) {
                        int existingQuantity = junks.get(material);
                        junks.replace(material, existingQuantity + quantity);
                    } else {
                        junks.put(material, quantity);
                    }
                }

                for (Map.Entry<String, Integer> entry : materials.entrySet()) {
                    if (entry.getValue() >= 250) {
                        isLegendaryItemBought = true;
                        switch (entry.getKey()) {
                            case "shards" -> System.out.println("Shadowmourne obtained!");
                            case "fragments" -> System.out.println("Valanyr obtained!");
                            case "motes" -> System.out.println("Dragonwrath obtained!");
                        }
                        int newQuantity = entry.getValue() - 250;
                        materials.put(material, newQuantity);
                    }
                }

                if (isLegendaryItemBought) {
                    break;
                }
            }
        }

        materials.forEach((key, value) -> System.out.printf("%s: %d\n", key, value));
        junks.forEach((key, value) -> System.out.printf("%s: %d\n", key, value));
    }
}
