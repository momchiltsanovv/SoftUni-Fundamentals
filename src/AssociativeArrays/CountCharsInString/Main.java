package AssociativeArrays.CountCharsInString;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] chars = scanner.nextLine().toCharArray();
        Map<Character, Integer> counts = new LinkedHashMap<>();

        for (char ch : chars) {
            if (ch == ' ') {
                continue;
            }
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            System.out.printf("%c -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}
