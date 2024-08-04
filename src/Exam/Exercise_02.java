package Exam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class Exercise_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        int lines = Integer.parseInt(sc.nextLine());

        String regex ="\\|(?<name>[A-Z]{4,})\\|:#(?<title>[a-zA-Z]+ [a-zA-Z]+)#";

        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < lines; i++) {
            String currentLine = sc.nextLine();
            Matcher matcher = pattern.matcher(currentLine);
            if (matcher.find()) {
                System.out.printf("%s, The %s\n",matcher.group("name"),matcher.group("title"));
                System.out.printf(">> Strength: %d\n", matcher.group("name").length());
                System.out.printf(">> Armor: %d\n", matcher.group("title").length());
            }else {
                System.out.println("Access denied!");
            }
        }

    }
}
