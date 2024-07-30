package ExamPrep4;

import java.util.Scanner;

import static java.lang.System.in;

public class Resignation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        StringBuilder username = new StringBuilder(sc.nextLine());


        String[] command = sc.nextLine().split(" ");

        while (!command[0].equals("Registration")) {
            switch (command[0]) {
                case "Letters" -> letters(username, command);
                case "Reverse" -> reversed(username, command);
                case "Substring" -> substring(username, command);
                case "Replace" -> replaced(username, command);
                case "IsValid" -> isValid(username, command);
                }
            command = sc.nextLine().split(" ");
        }
    }

    private static void letters(StringBuilder username, String[] arrCommands) {
        String lowerOrUpper = arrCommands[1];
        if (lowerOrUpper.equals("Lower")) {
            for (int i = 0; i < username.length(); i++) {
                username.setCharAt(i, Character.toLowerCase(username.charAt(i)));
            }
        } else {
            for (int i = 0; i < username.length(); i++) {
                username.setCharAt(i, Character.toUpperCase(username.charAt(i)));
            }
        }
        System.out.println(username);
    }


    private static void reversed(StringBuilder username, String[] arrCommands) {
        int idx1 = Integer.parseInt(arrCommands[1]);
        int idx2 = Integer.parseInt(arrCommands[2]);
        if (idx1 > -1 && idx1 < username.length() && idx2 > -1 && idx2 < username.length()) {
            String reversed = username.substring(idx1, idx2 + 1);
            StringBuilder reverseBuilder = new StringBuilder(reversed);
            reversed = reverseBuilder.reverse().toString();
            System.out.println(reversed);
        }
    }

    private static void substring(StringBuilder username, String[] command) {
        String substring = command[1];
        if (username.toString().contains(substring)) {
            int startIndex = username.indexOf(substring);
            username.delete(startIndex, startIndex + substring.length());
            System.out.println(username);
        } else {
            System.out.printf("The username %s doesn't contain %s.%n", username, substring);
        }
    }

    private static void replaced(StringBuilder username, String[] command) {
        String toReplace = command[1];
        while (username.toString().contains(toReplace)) {
            int startIndex = username.indexOf(toReplace);
            username.replace(startIndex, startIndex + toReplace.length(), "-");
        }
        System.out.println(username);
    }

    private static void isValid(StringBuilder username, String[] command) {
        String checkFor = command[1];
        if (username.toString().contains(checkFor)) {
            System.out.println("Valid username.");
        } else {
            System.out.printf("%s must be contained in your username.%n", checkFor);
        }
    }

}
