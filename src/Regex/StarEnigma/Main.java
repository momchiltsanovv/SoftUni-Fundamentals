package Regex.StarEnigma;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int inputLines = Integer.parseInt(sc.nextLine());
        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();

        for (int i = 0; i < inputLines; i++) {
            String line = sc.nextLine();
            String decrypted = decryption(line);
            String regex = "@(?<planetName>[A-Za-z]+)[^@!:>-]*:(?<population>[0-9]+)[^@!:>-]*!(?<attackType>[AD])![^@!:>-]*->(?<soldiersCount>[0-9]+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decrypted);

            if (matcher.find()) {
                String planetName = matcher.group("planetName");
                char attackType = matcher.group("attackType").charAt(0);

                if (attackType == 'A') {
                    attacked.add(planetName);
                } else {
                    destroyed.add(planetName);
                }
            }
        }

        print(attacked, destroyed);

    }

    public static int countSpecialChars(String line) {
        int specialCharsCount = 0;
        for (char c : line.toCharArray()) {
            c = Character.toLowerCase(c);
            if (c == 's' || c == 't' || c == 'a' || c == 'r') {
                specialCharsCount++;
            }
        }
        return specialCharsCount;
    }

    public static String decryption(String encrypted) {
        StringBuilder decrypted = new StringBuilder();

        int subtractBy = countSpecialChars(encrypted);

        for (char c : encrypted.toCharArray()) {
            char newChar = (char) (c - subtractBy);
            decrypted.append(newChar);
        }

        return decrypted.toString();
    }

    public static void print(List<String> attacked, List<String> destroyed) {

        System.out.println("Attacked planets: " + attacked.size());
        Collections.sort(attacked);
        attacked.forEach(planet -> System.out.println("-> " + planet));

        System.out.println("Destroyed planets: " + destroyed.size());
        Collections.sort(destroyed);
        destroyed.forEach(planet -> System.out.println("-> " + planet));
    }
}



