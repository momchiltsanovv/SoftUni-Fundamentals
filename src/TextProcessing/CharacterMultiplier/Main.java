package TextProcessing.CharacterMultiplier;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        String[] input = sc.nextLine().split(" ");
        String first = input[0];
        String second = input[1];

        int max = Math.max(first.length(), second.length());
        int min = Math.min(first.length(), second.length());

        int sum = 0;
        for (int i = 0; i < min; i++) {
            char c1 = first.charAt(i);
            char c2 = second.charAt(i);
            sum += c1 * c2;
        }

        if(first.length() > second.length()) {
            for(int i = min; i < max; i++) {
                sum += first.charAt(i);
            }
        }else {
            for(int i = min; i < max; i++) {
                sum += second.charAt(i);
            }
        }

        System.out.println(sum);
    }
}
