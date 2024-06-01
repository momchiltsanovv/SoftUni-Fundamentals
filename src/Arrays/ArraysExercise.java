package Arrays;

import java.util.Scanner;
import java.util.Arrays;



public class ArraysExercise {
    public static void main(String[] args) {

        //train();
        //commonElements();
        //zigZagArrays();
        //arrayRotation();
        topIntegers();

    }


    public static void train() {
        Scanner scanner = new Scanner(System.in);

        byte size = scanner.nextByte();
        short[] arr = new short[size];

        int sum = 0;
        for (byte i = 0; i < size; i++) {
            arr[i] = scanner.nextShort();
            sum += arr[i];
        }

        for (short i : arr) {
            System.out.print(i + " ");
        }
        System.out.printf("%n%d", sum);

    }

    public static void commonElements() {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String[] input2 = scanner.nextLine().split(" ");

        for (String s : input2) {
            for (String string : input) {
                if (s.equals(string)) {
                    System.out.print(string + " ");
                }
            }
        }
    }

    public static void zigZagArrays() {
        Scanner scanner = new Scanner(System.in);

        byte size = scanner.nextByte();

        short[] arr = new short[size];
        short[] arr2 = new short[size];

        for (int i = 0; i < size; ++i) {
            short number = scanner.nextShort();
            short number2 = scanner.nextShort();
            if (i % 2 == 0) {
                arr[i] = number2;
                arr2[i] = number;
            } else {
                arr[i] = number;
                arr2[i] = number2;
            }
        }
        for (short i : arr2) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (short i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void arrayRotation() {
        Scanner scanner = new Scanner(System.in);

        short[] arr = new short[10];

        for (short i = 0; i < arr.length; ++i) {
            arr[i] = scanner.nextShort();
        }

        byte rotations = scanner.nextByte();
        for (short i = 0; i < rotations; ++i) {

        }

    }

    public static void topIntegers() {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .mapToInt(Integer::parseInt).toArray();





    }
}
