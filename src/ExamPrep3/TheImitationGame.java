package ExamPrep3;

import java.util.Scanner;

import static java.lang.System.in;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        StringBuilder encrypted = new StringBuilder(sc.nextLine());
        String[] command = sc.nextLine().split("\\|");

        while (!command[0].equals("Decode")) {
            switch (command[0]) {
                case "Move" -> move(command, encrypted);
                case "Insert" ->  insert(command, encrypted);
                case "ChangeAll" -> changeAll(command, encrypted);
            }
            command = sc.nextLine().split("\\|");
        }
        System.out.printf("The decrypted message is: %s", encrypted);
    }

    public static void move(String[] command, StringBuilder encrypted) {
        int timesToMove = Integer.parseInt(command[1]);
        String sub = encrypted.substring(0, timesToMove);
        encrypted.delete(0, timesToMove);
        encrypted.append(sub);
    }

    public static void insert(String[] command, StringBuilder encrypted) {
        int idx = Integer.parseInt(command[1]);
        String symbol = command[2];
        encrypted.insert(idx, symbol);
    }

    public static void changeAll(String[] command, StringBuilder encrypted){
        String substring = command[1];
        String replaceWith = command[2];
        int index = encrypted.indexOf(substring);
        while (index != -1) {
            encrypted.replace(index, index + substring.length(), replaceWith);
            index = encrypted.indexOf(substring, index);
        }
    }
    
}
