package ExamPrep4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        String input = sc.nextLine();
        String regex = "=([A-Z][a-zA-Z]{2,})=|/([A-Z][a-zA-Z]{2,})/";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> destinations = new ArrayList<>();
        int travelPoints = 0;
        while (matcher.find()) {
            String destination = matcher.group(1) != null ? matcher.group(1) : matcher.group(2);
            destinations.add(destination);
            travelPoints += destination.length();
        }

        System.out.println("Destinations: " + String.join(", ", destinations));
        System.out.println("Travel Points: " + travelPoints);


    }
}
