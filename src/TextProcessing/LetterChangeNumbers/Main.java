package TextProcessing.LetterChangeNumbers;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        String[] input = sc.nextLine().split("\\s+"); // regex to catch of there is more than one space between the inputs

        double sum = 0;
        for (String current : input) {
            int firstLetter, secondLetter;

            double number = Double.parseDouble(current.substring(1, current.length() - 1));
            if (Character.isLowerCase(current.charAt(0))) {
                firstLetter = current.charAt(0) - 'a' + 1;
                sum += number * firstLetter;
            } else {
                firstLetter = current.charAt(0) - 'A' + 1;
                sum += number / firstLetter;
            }
            if (Character.isLowerCase(current.charAt(current.length() - 1))) {
                secondLetter = current.charAt(current.length() - 1) - 'a' + 1;
                sum += secondLetter;
            } else {
                secondLetter = current.charAt(current.length() - 1) - 'A' + 1;
                sum -= secondLetter;
            }
        }
        System.out.printf("%.2f", sum);


    }
}
