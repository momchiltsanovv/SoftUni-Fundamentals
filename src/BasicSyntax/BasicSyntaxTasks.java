package BasicSyntax;
import java.util.Scanner;
import java.lang.Math;

public class BasicSyntaxTasks {
    public static void main(String[] args) {

        //ages();
        //division();
        //vacation();
        //printAndSum();
        //Login();
        //strongNumber();
        vendingMachine();
        //triangleOfNumbers();
        //orders();
        //padawanEquipment();


    }

    private static void ages() {   //exercise 1
        Scanner scanner = new Scanner(System.in);

        int age = scanner.nextInt();
        String section;

        if (age >= 0 && age <= 2)
            section = "baby";
        else if (age >= 3 && age <= 13)
            section = "child";
        else if (age >= 14 && age <= 19)
            section = "teenager";
        else if (age >= 20 && age <= 65)
            section = "adult";
        else
            section = "elder";

        System.out.println(section);

    }

    public static void division() {

        Scanner scanner = new Scanner(System.in);

        int division = scanner.nextInt();

        if (division % 10 == 0)
            System.out.printf("The number is divisible by %d", 10);
        else if (division % 7 == 0)
            System.out.printf("The number is divisible by %d", 7);
        else if (division % 6 == 0)
            System.out.printf("The number is divisible by %d", 6);
        else if (division % 3 == 0)
            System.out.printf("The number is divisible by %d", 3);
        else if (division % 2 == 0)
            System.out.printf("The number is divisible by %d", 2);
        else
            System.out.print("Not divisible");
    }

    public static void vacation() {
        Scanner scanner = new Scanner(System.in);

        int groupSize = scanner.nextInt();
        scanner.nextLine();
        String type = scanner.nextLine();
        String day = scanner.nextLine();

        double price = 0;

        switch (type) {
            case "Students" -> {
                switch (day) {
                    case "Friday" -> price += 8.45 * groupSize;
                    case "Saturday" -> price += 9.80 * groupSize;
                    case "Sunday" -> price += 10.46 * groupSize;
                }
                if (groupSize >= 30) {
                    price -= 15.0 / 100.0 * price;
                }
            }
            case "Business" -> {
                if (groupSize >= 100) {
                    groupSize -= 10;
                }
                switch (day) {
                    case "Friday" -> price += 10.90 * groupSize;
                    case "Saturday" -> price += 15.60 * groupSize;
                    case "Sunday" -> price += 16 * groupSize;
                }
            }
            case "Regular" -> {
                switch (day) {
                    case "Friday" -> price += 15.0 * groupSize;
                    case "Saturday" -> price += 20.0 * groupSize;
                    case "Sunday" -> price += 22.50 * groupSize;
                }
                if (groupSize >= 10 && groupSize <= 20) {
                    price -= 5.0 / 100.0 * price;
                }
            }
        }

        System.out.printf("Total price: %.2f", price);
    }

    public static void printAndSum() {
        Scanner scanner = new Scanner(System.in);

        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int sum = 0;

        for (int i = start; i <= end; i++) {
            System.out.printf("%d ", i);
            sum += i;
        }

        System.out.println();
        System.out.printf("Sum: %d", sum);
    }

    public static void Login() {
        Scanner scanner = new Scanner(System.in);

        final int maxAttemps = 4;

        String username = scanner.nextLine();
        StringBuilder correctPassword = new StringBuilder(); // making stringBuilder so its easier to reverse it with the function

        correctPassword.append(username);
        correctPassword.reverse();

        String password = scanner.nextLine();
        int counter = 1; // counting from 1 because we have first input before the loop

        boolean flagAttemps = false;
        while (!correctPassword.toString().equals(password)) {

            if (counter == maxAttemps) {
                flagAttemps = true;
                break;
            }

            System.out.println("Incorrect password. Try again.");
            password = scanner.nextLine();
            counter++;
        }

        if (flagAttemps)
            System.out.printf("User %s blocked!", username);
        else
            System.out.printf("User %s logged in.", username);
    }

    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

    public static void strongNumber() {
        Scanner scanner = new Scanner(System.in);

        int inputNum = scanner.nextInt();
        int sum = 0;
        int number = inputNum;

        while (inputNum > 0) {
            sum += factorial(inputNum % 10);
            inputNum /= 10;
        }

        if (sum == number)
            System.out.print("yes");
        else
            System.out.print("no");

    }

    //TODO: finish this
    public static void vendingMachine() {
        Scanner scanner = new Scanner(System.in);
        double sumCoins = 0;

        String input = scanner.nextLine();
        while (!input.equals("Start")) {

            double coin = Double.parseDouble(input);

            //checking if coin is valid
            //0.1, 0.2, 0.5, 1, and 2
            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2) {
                //2. sum all coins
                sumCoins += coin;
            } else {
                System.out.printf("Cannot accept %.2f\n", coin);
            }

            input = scanner.nextLine();
        }

        String product = scanner.nextLine();
        while (!product.equals("End")) {

            switch (product) {
                case "Nuts":
                    if (sumCoins >= 2.00) {
                        System.out.println("Purchased " + product);
                        sumCoins -= 2.00;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    if (sumCoins >= 0.70) {
                        System.out.println("Purchased " + product);
                        sumCoins -= 0.70;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if (sumCoins >= 1.50) {
                        System.out.println("Purchased " + product);
                        sumCoins -= 1.50;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if (sumCoins >= 0.80) {
                        System.out.println("Purchased " + product);
                        sumCoins -= 0.80;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if (sumCoins >= 1.00) {
                        System.out.println("Purchased " + product);
                        sumCoins -= 1.00;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            product = scanner.nextLine();
        }

        System.out.printf("Change: %.2f", sumCoins);
    }


    public static void triangleOfNumbers() {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();


        for (int i = 1; i <= input; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d ", i);
            }
            System.out.println(); //asdas
        }
    }

    public static void orders() {
        Scanner scanner = new Scanner(System.in);

        short countOfOrders = scanner.nextShort();
        double totalSum = 0;
        for (int i = 0; i < countOfOrders; i++) {
            double sum = 0;
            double pricePerCapsule = scanner.nextDouble();
            byte days = scanner.nextByte();
            int capsulesCount = scanner.nextInt();
            sum += days * capsulesCount * pricePerCapsule;
            totalSum += sum;
            System.out.printf("The price for the coffee is: $%.2f", sum);
            System.out.println();
        }

        System.out.printf("Total: $%.2f", totalSum);
    }

    public static void padawanEquipment() {
        Scanner scanner = new Scanner(System.in);

        double moneyAvailable = scanner.nextDouble();
        short students = scanner.nextByte();
        double lightSaberPrice = scanner.nextDouble(); //need 10% more
        double ropePrice = scanner.nextDouble();
        double beltPrice = scanner.nextDouble(); //every sixth belt is free

        int freeBelts = students / 6; // using integer division by 6, so we get every 6th free belt

        double moneyNeeded = lightSaberPrice * (Math.ceil(students + 0.1 * students)) +
                ropePrice * students + beltPrice * (students - freeBelts);

        if (moneyAvailable >= moneyNeeded)
            System.out.printf("The money is enough - it would cost %.2flv.", moneyNeeded);
        else
            System.out.printf("George Lucas will need %.2flv more.", moneyNeeded - moneyAvailable);
    }


}
