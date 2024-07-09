package AssociativeArrays.SoftUniParking;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> carOwners = new LinkedHashMap<>();

        int numberOfCommands = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] curCarData = sc.nextLine().split(" ");
            String command = curCarData[0];
            String ownersName = curCarData[1];
            String carNumber = "";
            if(curCarData.length > 2){
                carNumber = curCarData[2];
            }

            if(command.equals("register")){
                if(!carOwners.containsKey(ownersName)){
                    carOwners.put(ownersName, carNumber);
                    System.out.printf("%s registered %s successfully\n", ownersName, carNumber);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s\n", carOwners.get(ownersName));
                }
            } else if(command.equals("unregister")){
                if(carOwners.containsKey(ownersName)){
                    carOwners.remove(ownersName);
                    System.out.printf("%s unregistered successfully\n", ownersName);
                } else {
                    System.out.printf("ERROR: user %s not found\n", ownersName);
                }
            }
        }

        for(Map.Entry<String, String> entry: carOwners.entrySet()){
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

    }
}
