package Regex.ExtractEmail;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        String inputLine = sc.nextLine();

        String regexUser = "[a-zA-Z0-9]+[-._]?[a-zA-Z0-9]+";
        //String regexHost = "[a-zA-Z]+[.-]+[a-z]+";
        String regexHost = "[A-Za-z]+-?[A-Za-z]+(\\.[A-Za-z]+)+";

        String regexEmail = regexUser + "@" + regexHost;

        Pattern pattern = Pattern.compile(regexEmail);
        Matcher matcher = pattern.matcher(inputLine);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }


    }
}
