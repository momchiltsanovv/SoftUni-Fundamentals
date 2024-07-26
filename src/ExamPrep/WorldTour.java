package ExamPrep;

import java.util.Scanner;

import static java.lang.System.in;

public class WorldTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        String mainText = sc.nextLine();
        String[] input = sc.nextLine().split(":");
        StringBuilder result = new StringBuilder(mainText);

        while (!input[0].equals("Travel")) {
            String command = input[0];
            switch (command) {

                case "Add Stop" -> {
                    int idx = Integer.parseInt(input[1]);
                    String toBeInserted = input[2];
                    if (idx >= 0 && idx < result.length()) {
                        result.insert(idx, toBeInserted);
                    }
                }

                case "Remove Stop" -> {
                    int fromIdx = Integer.parseInt(input[1]);
                    int endIdx = Integer.parseInt(input[2]) + 1;
                    if (fromIdx >= 0 && endIdx <= result.length()) {
                        result.replace(fromIdx, endIdx, "");
                    }
                }

                case "Switch" -> {

                    String old = input[1];
                    String newText = input[2];
                    int idx = result.indexOf(old);
                    int lastIdx = idx + old.length();

                    if(result.toString().contains(old)){
                        result.replace(idx, lastIdx, newText);
                    }

                }
            }

            System.out.println(result);
            input = sc.nextLine().split(":");
        }
        System.out.printf("Ready for world tour! Planned stops: %s\n", result);
    }

}

