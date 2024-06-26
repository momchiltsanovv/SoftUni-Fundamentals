package MidExam;

import java.util.Scanner;

public class Exercise_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(">>");
        calculateTax(input);
    }

    public static void calculateTax(String[] vehicles) {
        double totalTaxCollected = 0.0;

        for (String vehicle : vehicles) {
            String[] vehicleDetails = vehicle.split(" ");
            if (vehicleDetails.length != 3) {
                System.out.println("Invalid car type.");
                continue;
            }

            String carType = vehicleDetails[0];
            int years = Integer.parseInt(vehicleDetails[1]);
            int kilometers = Integer.parseInt(vehicleDetails[2]);

            int initialTax;
            int taxDecreasePerYear;
            int taxIncreasePerKm;

            switch (carType) {
                case "family" -> {
                    initialTax = 50;
                    taxDecreasePerYear = 5;
                    taxIncreasePerKm = kilometers / 3000 * 12;
                }
                case "heavyDuty" -> {
                    initialTax = 80;
                    taxDecreasePerYear = 8;
                    taxIncreasePerKm = kilometers / 9000 * 14;
                }
                case "sports" -> {
                    initialTax = 100;
                    taxDecreasePerYear = 9;
                    taxIncreasePerKm = kilometers / 2000 * 18;
                }
                default -> {
                    System.out.println("Invalid car type.");
                    continue;
                }
            }

            double totalTax = (initialTax - taxDecreasePerYear * years) + taxIncreasePerKm;
            if (totalTax < 0) {
                totalTax = 0;
            }
            System.out.printf("A %s car will pay %.2f euros in taxes.%n", carType, totalTax);
            totalTaxCollected += totalTax;
        }
        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.%n", totalTaxCollected);
    }
}
