package Regex.ValidPassword;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int inputs = sc.nextInt();



        for (int i = 0; i < inputs; i++) {
            String password = sc.next();
            String regex = "_\\.+[A-Z][a-zA-Z0-9]{4,}[A-Z]_\\.+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);

            StringBuilder group = new StringBuilder();
            if (matcher.find()) {
                for(char num : matcher.group().toCharArray()) {
                    if(Character.isDigit(num)) {
                        group.append(num);
                    }
                }
            } else {
                System.out.println("Invalid pass!");
                continue;
            }

            System.out.print("Group: ");
            if(group.isEmpty()) {
                System.out.println("default");
            }else{
                System.out.println(group);
            }


        }


    }
}
