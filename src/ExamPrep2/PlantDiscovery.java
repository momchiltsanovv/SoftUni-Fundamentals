package ExamPrep2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int size = Integer.parseInt(sc.nextLine());

        Map<String, Integer> plants = getPlants(size);

        String command = sc.nextLine().split(":")[0];
        while (!command.equals("Exhibition")) {




            command = sc.nextLine();
        }




    }



    public static Map<String, Integer> getPlants(int size) {
        Scanner sc = new Scanner(in);
        Map<String, Integer> plants = new LinkedHashMap<>();
        for (int i = 0; i < size; ++i) {
            String[] currentPlant = sc.nextLine().split("<->");
            String plantName = currentPlant[0];
            int plantRarity = Integer.parseInt(currentPlant[1]);
            plants.put(plantName, plantRarity);
        }

        return plants;
    }

}
