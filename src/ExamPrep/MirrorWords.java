package ExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        String input = sc.nextLine();
        String regex = "(?<signs>[@#])[a-zA-Z]{3,}\\1{2}[a-zA-Z]+\\1";
        Pattern regexPattern = Pattern.compile(regex);
        Matcher matcher = regexPattern.matcher(input);
        int pairsCount = 0;
        int mirrorWords = 0;

        List<String> pairs = new ArrayList<>();

        while (matcher.find()) {
            String[] current = matcher.group().split("[#@]"); //array looks like this ["", "poOl", "", "lOop"]
            pairsCount++;
            // we take indexes 1 and 3 of the array
            String first = current[1];
            String second = current[3];
            StringBuilder reversingFirst = new StringBuilder(first);
            reversingFirst.reverse();// getting the reverse of first word to see if it equals the second
            if (reversingFirst.toString().equals(second)) {
                mirrorWords++;
                pairs.add(first + " <=> " + second);
            }
        }

        printMirrorWords(pairs, mirrorWords, pairsCount);

    }

    public static void printMirrorWords(List<String> pairs, int mirrorWords, int pairsCount) {
        if(pairsCount > 0){
            System.out.printf("%d word pairs found!\n", pairsCount);
            if(mirrorWords > 0){
                System.out.println("The mirror words are:");
                StringJoiner printedResult = new StringJoiner(", ");
                for (String pair : pairs) {
                    printedResult.add(pair);
                }
                System.out.println(printedResult);
            } else {
                System.out.println("No mirror words!");
            }
        } else {
            System.out.print("No word pairs found!\n");
            System.out.println("No mirror words!");

        }
    }

}
