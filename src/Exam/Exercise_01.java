package Exam;

import java.util.Scanner;

import static java.lang.System.in;

public class Exercise_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        StringBuilder input = new StringBuilder(sc.nextLine());

        String[] command = sc.nextLine().split(" ");


        while (!command[0].equals("Finish")) {

            switch (command[0]) {
                case "Replace" -> {
                    String oldChar = command[1];
                    String newChar = command[2];
                    String replaced = input.toString().replaceAll(oldChar, newChar);
                    input.setLength(0);
                    input.append(replaced);
                    System.out.println(input);
                }
                case "Cut" -> {
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);
                    if (startIndex > -1 && endIndex < input.length()) {
                        input.delete(startIndex, endIndex + 1);
                        System.out.println(input);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                }
                case "Make" -> {
                    String type = command[1];
                    if (type.equals("Upper")) {
                        input.replace(0, input.length(), input.toString().toUpperCase());
                    } else {
                        input.replace(0, input.length(), input.toString().toLowerCase());
                    }
                    System.out.println(input);
                }

                case "Check" -> {
                    String message = command[1];
                    if (!input.toString().contains(message)) {
                        System.out.printf("Message doesn't contain %s\n", message);
                    } else {
                        System.out.printf("Message contains %s\n", message);
                    }
                }

                case "Sum" -> {
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);

                    if (startIndex > -1 && endIndex < input.length()) {
                        String substring = input.substring(startIndex, endIndex + 1);
                        int sum = 0;
                        for (int i = 0; i < substring.length(); i++) {
                            sum += substring.charAt(i);
                        }
                        System.out.println(sum);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                }
            }

            command = sc.nextLine().split(" ");
        }

    }
}
