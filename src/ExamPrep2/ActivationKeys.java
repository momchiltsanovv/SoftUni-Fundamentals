package ExamPrep2;

import java.util.Scanner;

import static java.lang.System.in;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        StringBuilder input = new StringBuilder(sc.nextLine());
        String[] command = sc.nextLine().split(">>>");

        while (!command[0].equals("Generate")) {
            switch (command[0]) {
                case "Contains" -> contains(command, input);
                case "Flip" -> {
                    flip(command, input);
                    System.out.println(input);
                }
                case "Slice" -> {
                    slice(command, input);
                    System.out.println(input);
                }
            }
            command = sc.nextLine().split(">>>");
        }
        System.out.printf("Your activation key is: %s\n", input);
    }

    private static void slice(String[] command, StringBuilder input) {
        int startIdx = Integer.parseInt(command[1]);
        int endIdx = Integer.parseInt(command[2]);
        input.delete(startIdx, endIdx);
    }

    private static void flip(String[] command, StringBuilder input) {
        String type = command[1];
        int startIdx = Integer.parseInt(command[2]);
        int endIdx = Integer.parseInt(command[3]);
        String temp = input.substring(startIdx, endIdx);
        input.delete(startIdx, endIdx);
        if (type.equals("Upper")) {
            temp = temp.toUpperCase();
        } else {
            temp = temp.toLowerCase();
        }
        input.insert(startIdx, temp);
    }

    public static void contains(String[] command, StringBuilder input) {
        String word = command[1];
        if (input.toString().contains(word)) {
            System.out.printf("%s contains %s\n", input, word);
        } else {
            System.out.println("Substring not found!");
        }
    }
}
