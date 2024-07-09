package AssociativeArrays.Orders;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> productsQuantity = new LinkedHashMap<>();
        Map<String, Double> productsPrice = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("buy")) {
            String productName = input.split(" ")[0];
            double price = Double.parseDouble(input.split(" ")[1]);
            int quantity = Integer.parseInt(input.split(" ")[2]);

            if(!productsQuantity.containsKey(productName)){
                productsQuantity.put(productName, quantity);
            } else {
                productsQuantity.put(productName, productsQuantity.get(productName) + quantity);
            }

            //changes the price
            productsPrice.put(productName, price);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : productsQuantity.entrySet()) {
            String productName = entry.getKey();
            double finalSum = productsPrice.get(productName) * entry.getValue();

            System.out.printf("%s -> %.2f%n", productName, finalSum);

        }


    }
}
