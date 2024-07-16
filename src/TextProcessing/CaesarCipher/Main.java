package TextProcessing.CaesarCipher;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        String input = sc.nextLine();
        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (ch == ' ') {
                ch = '#';
            } else {
                ch += 3;
            }
            result.append(ch);
        }

        System.out.println(result);

    }
}
