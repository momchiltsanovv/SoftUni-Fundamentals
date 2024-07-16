package TextProcessing.ValidUsername;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        String[] input = sc.nextLine().split(", ");

        for (String word : input) {
            if(isValidLength(word) && isValidContent(word)) {
                System.out.println(word);
            }
        }
    }

    private static boolean isValidContent(String word) {
        for (char c : word.toCharArray()) {
            if(c != '-' && c != '_' && !Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidLength (String curUser) {
        return curUser.length() >= 3 && curUser.length() <= 16;
    }
}
