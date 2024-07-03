package ObjectAndClasses.VehicleCatalogue;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> vehicles = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String type = command.split(" ")[0];
            String model = command.split(" ")[1];
            String color = command.split(" ")[2];
            short horsePower = Short.parseShort(command.split(" ")[3]);
            vehicles.add(new Vehicle(type, model, color, horsePower));

            command = scanner.nextLine();
        }

        String model = scanner.nextLine();
        while (!model.equals("Close the Catalogue")) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getModel().equals(model)) {
                    System.out.println(vehicle);
                }
            }
            model = scanner.nextLine();
        }

        double sumCarsHP = 0;
        double sumTrucksHP = 0;
        int countCars = 0;
        int countTrucks = 0;

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equals("car")) {
                sumCarsHP += vehicle.getHorsePower();
                countCars++;
            } else if (vehicle.getType().equals("truck")) {
                sumTrucksHP += vehicle.getHorsePower();
                countTrucks++;
            }
        }

        double averageCars = sumCarsHP / countCars;
        if (countCars == 0) {
            averageCars = 0;
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", averageCars);

        double averageTrucks = sumTrucksHP / countTrucks;
        if (countTrucks == 0) {
            averageTrucks = 0;
        }
        System.out.printf("Trucks have average horsepower of: %.2f.%n", averageTrucks);

    }
}
