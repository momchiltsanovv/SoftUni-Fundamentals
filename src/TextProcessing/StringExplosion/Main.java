package TextProcessing.StringExplosion;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        String input = sc.nextLine();
        StringBuilder textBuilder = new StringBuilder(input);

        int totalStrength = 0;

        for (int position = 0; position < textBuilder.length(); position++) {

            char curSymbol = textBuilder.charAt(position);

            if (curSymbol == '>') {
                int explosionStrength = Integer.parseInt(textBuilder.charAt(position + 1) + "");
                totalStrength += explosionStrength;
            } else if (totalStrength > 0) {
                textBuilder.deleteCharAt(position);
                totalStrength--;
                position--;
            }
        }

        System.out.println(textBuilder);
    }
}

