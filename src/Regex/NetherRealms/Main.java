package Regex.NetherRealms;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        String[] input = sc.nextLine().split("\\s*,\\s+");

        for (String demon : input) {

            int health = getHealth(demon);
            double dmg = getDamage(demon);

            for (char ch : demon.toCharArray()) {
                if(ch == '*'){
                    dmg *= 2;
                } else if(ch == '/'){
                    dmg /= 2;
                }
            }
            print(demon, health, dmg);
        }
    }

    public static void print(String demon, int health, double dmg) {
        System.out.printf("%s - %d health, %.2f damage\n", demon, health, dmg);
    }

    private static double getDamage(String demon) {

        double demage = 0;
        String regex = "-?[0-9]+\\.*[0-9]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(demon);

        while (matcher.find()) {
            demage += Double.parseDouble(matcher.group());
        }
        return demage;
    }

    private static int getHealth(String demon) {
        int health = 0;
        for (char ch : demon.toCharArray()) {
            if (!(Character.isDigit(ch) || ch == '+' || ch == '-'
                    || ch == '*' || ch == '/' || ch == '.')) {
                health += ch;
            }
        }

        return health;
    }


}
