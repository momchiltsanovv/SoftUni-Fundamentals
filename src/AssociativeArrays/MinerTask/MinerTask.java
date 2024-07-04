package AssociativeArrays.MinerTask;

import java.util.*;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Integer> storage = new LinkedHashMap<>();


        while (!command.equals("stop")) {
            storage.put(command, storage.getOrDefault(command, 0) + Integer.parseInt(scanner.nextLine()));
            command = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
