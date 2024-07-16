package TextProcessing.ExtractFile;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        String[] input = sc.nextLine().split("\\\\");
        String file = input[input.length - 1];
        String name = file.split("\\.")[0];
        String type = file.split("\\.")[1];

        System.out.printf("File name: %s\n", name);
        System.out.printf("File extension: %s\n", type);
    }
}
