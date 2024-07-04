package AssociativeArrays.CountCharsInString;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        char[] chars = scanner.nextLine().toCharArray();
        Map<Character, Integer> counts = new LinkedHashMap<>();

        for (char ch : chars) {
            if (ch == ' ') {
                continue;
            }
            if(!counts.containsKey(ch)){
                counts.put(ch, 1);
            } else {
                counts.put(ch, counts.get(ch) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            System.out.printf("%c -> %d\n", entry.getKey(), entry.getValue());
        }


    }
}
