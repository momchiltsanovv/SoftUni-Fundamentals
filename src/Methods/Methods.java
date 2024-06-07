package Methods;

import java.util.Locale;
import java.util.Scanner;

public class Methods {
    public static void main(String[] args) {

        passwordValidator();
    }

    public static void smallestThreeNums() {
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        int min = Math.min(num3, Math.min(num1, num2));
        System.out.println(min);
    }


    public static void vowelsCount() {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a' || input.charAt(i) == 'e'
                    || input.charAt(i) == 'i' || input.charAt(i) == 'o' || input.charAt(i) == 'u') {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void characterInRange() {
        Scanner scanner = new Scanner(System.in);


        char firstChar = scanner.next().charAt(0);
        char secondChar = scanner.next().charAt(0);

        char bigger;
        char smaller;

        if (firstChar < secondChar) {
            bigger = secondChar;
            smaller = firstChar;
        } else {
            smaller = secondChar;
            bigger = firstChar;
        }


        for (int i = smaller + 1; i < bigger; i++) {
            System.out.printf("%c ", i);
        }

    }

    public static void passwordValidator() {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        boolean isValid = true;
        if(password.length() < 6 || password.length() > 10) {
            System.out.println("Password must be between 6 and 10 characters");
            isValid = false;
        }
        if(!password.matches("[a-zA-Z0-9]+")) {
            System.out.println("Password must consist only of letters and digits");
            isValid = false;
        }
        int digits = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                digits++;
            }
        }
        if(digits < 2) {
            System.out.println("Password must have at least 2 digits");
            isValid = false;
        }
        if(isValid) {
            System.out.println("Password is valid");
        }
    }

}



