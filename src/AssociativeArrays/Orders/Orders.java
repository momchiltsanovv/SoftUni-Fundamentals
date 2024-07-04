package AssociativeArrays.Orders;

import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> orders = new LinkedHashMap<>();
        List<Integer> quantityOrders = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("buy")) {
            String item = input.split(" ")[0];
            double price = Double.parseDouble(input.split(" ")[1]);
            int quantity = Integer.parseInt(input.split(" ")[2]);
            quantityOrders.add(quantity);
            if (!orders.containsKey(item)) {
                orders.put(item, price);
            }
        }


    }
}
