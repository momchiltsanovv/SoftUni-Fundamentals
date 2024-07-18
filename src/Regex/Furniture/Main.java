package Regex.Furniture;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        String input = sc.nextLine();

        String regex = ">>(?<name>[A-Za-z]+)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quantity>[0-9]+)";

        List<String> bought = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);

        double sum = 0;
        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String name = matcher.group("name");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                bought.add(name);
                sum += price * quantity;

            }
            input = sc.nextLine();
        }

        System.out.println("Bought furniture:");
        bought.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", sum);

    }
}
