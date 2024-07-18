package Regex.BarIncome;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class Main  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);



        String input = sc.nextLine();
        /*
            valid order -> customer,product count  and price

            Valid customer's name should be surrounded by '%' and must start with a capital letter, followed by lower-case letters. DONE

            Valid product contains any word character and must be surrounded by '<' and '>'. DONE

            The valid count is an integer surrounded by '|'.

            The valid price is any real number followed by '$'.
         */

        String regex = "%(?<name>[A-Z][a-z]+)%<(?<product>[A-Za-z]+)>[a-z]*\\|(?<count>[0-9]+)\\|[a-z]*(?<price>[0-9]+.[0-9]*)\\$";

        Pattern pattern = Pattern.compile(regex);

        double total = 0;
        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                double curProductPrice = count * price;
                total += curProductPrice;
                System.out.printf("%s: %s - %.2f%n", name, product, curProductPrice);
            }


                input = sc.nextLine();
            }

        System.out.printf("Total income: %.2f", total);




    }
}
