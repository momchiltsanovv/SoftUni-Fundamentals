package Methods;

import java.util.Scanner;

public class Methods {
    public static void main(String[] args) {

        palindromeIntegers();
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
        if (password.length() < 6 || password.length() > 10) {
            System.out.println("Password must be between 6 and 10 characters");
            isValid = false;
        }
        if (!password.matches("[a-zA-Z0-9]+")) {
            System.out.println("Password must consist only of letters and digits");
            isValid = false;
        }
        int digits = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                digits++;
            }
        }
        if (digits < 2) {
            System.out.println("Password must have at least 2 digits");
            isValid = false;
        }
        if (isValid) {
            System.out.println("Password is valid");
        }
    }

    public static int calculationsAddAndSubtract(int num1, int num2, int num3) {
        return num1 + num2 - num3;
    }

    public static void addAndSubtract() {
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        System.out.println(calculationsAddAndSubtract(num1, num2, num3));
    }


    public static String inputMiddleChair(String word) {

        int idx = word.length() / 2;
        if (word.length() % 2 != 0) {
            return word.substring(idx, idx + 1);
        }

        return word.substring(idx - 1, idx + 1);
    }

    public static void middleChair() {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        System.out.println(inputMiddleChair(word));

    }

    public static void createAndPrintMatrix(int num) {

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.printf("%d ", num);
            }
            System.out.println();
        }
    }

    public static void nxnMatrix() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        createAndPrintMatrix(input);
    }

    public static double calculateFactorial(int num) {

        if (num == 0)
            return 1;

        return num * calculateFactorial(num - 1);
    }

    public static void factorialDivision() {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        double factorialFirstNum = calculateFactorial(num1);
        double factorialSecondNum = calculateFactorial(num2);
        System.out.printf("%.2f ", factorialFirstNum / factorialSecondNum);
    }

    public static boolean checkIfPalindrome(String num) {

        StringBuilder reversedNum = new StringBuilder();
        reversedNum.append(num);
        reversedNum.reverse();

        boolean isPalindrome = true;
        for (int i = reversedNum.length() - 1; i >= 0; i--) {
            if (reversedNum.charAt(i) != num.charAt(i)) {
                isPalindrome = false;
                return isPalindrome;
            }
        }

        return isPalindrome;
    }

    public static void palindromeIntegers() {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        while (!number.equals("END")) {
            System.out.println(checkIfPalindrome(number));
            number = scanner.nextLine();
        }

    }

    public static boolean containsOdd(int number) {
        while (number > 0) {
            if ((number % 10) % 2 != 0) {
                return true;
            }
            number /= 10;
        }
        return false;
    }

    public static boolean sumOfDigitsDivisibleByEight(int number) {
        int sumOfDigits = 0;
        while(number > 0) {
            sumOfDigits += number % 10;
            number /= 10;
        }

        return sumOfDigits % 8 == 0;
    }


    public static void topNumbers() {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        for (int curNum = 1; curNum <= input; ++curNum) {
            if (sumOfDigitsDivisibleByEight(curNum) && containsOdd(curNum)) {
                System.out.println(curNum);
            }
        }


    }


}



