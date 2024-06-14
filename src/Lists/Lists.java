package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lists {
    public static void main(String[] args) {
        train();
    }


    public static void train() {
        Scanner scanner = new Scanner(System.in);
        List<Short> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Short::parseShort).collect(Collectors.toList());

        short wagonCapacity = Short.parseShort(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            String[] commandType = command.split(" ");
            if (commandType[0].equals("Add")) {
                short adding = Short.parseShort(commandType[1]);
                wagons.add(adding);
            } else {
                Short passengersToAdd = Short.parseShort(commandType[0]);
                for (short i = 0; i < wagons.size(); i++) {
                    if (wagons.get(i) + passengersToAdd <= wagonCapacity) {
                        wagons.set(i, (short) (wagons.get(i) + passengersToAdd));
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }
        for(short wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }

}
