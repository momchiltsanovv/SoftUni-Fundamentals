package Arrays;

import java.util.Scanner;
import java.util.Arrays;


public class ArraysExercise {
    public static void main(String[] args) {

        //train();
        //commonElements();
        //zigZagArrays();
        //arrayRotation();
        //topIntegers();
        //equalSum();
        condenseArrayToNumber();

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

        String[] array = scanner.nextLine().split(" ");
        int rotations = Integer.parseInt(scanner.nextLine());

        for (int rotation = 0; rotation < rotations; rotation++) {
            // Taking the first element from the array
            String firstElement = array[0];

            // going through the whole array and shift it to the left element by element
            for (int position = 0; position < array.length - 1; position++) {
                array[position] = array[position + 1];
            }
            // Putting the first element on the last position after we shift the array
            array[array.length - 1] = firstElement;
        }
        for (String element : array) {
            System.out.print(element + " ");
        }
    }

    public static void topIntegers() {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int position = 0; position < arr.length; ++position) {
            if (position == arr.length - 1) { // check if we are on the last element of the array
                System.out.print(arr[position] + " ");
                break;
            }

            int curNumber = arr[position];
            boolean flag = true;
            for (int nextPosition = position + 1; nextPosition < arr.length; ++nextPosition) {
                int nextNumber = arr[nextPosition];

                if (curNumber <= nextNumber) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.printf("%d ", curNumber);
            }
        }
    }

    public static void equalSum() {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int mainPosition = 0; mainPosition < arr.length; mainPosition++) {

            int leftSum = 0;
            for (int leftPosition = 0; leftPosition < mainPosition; leftPosition++) {
                leftSum += arr[leftPosition];
            }

            int rightSum = 0;
            for (int rightPositon = mainPosition + 1; rightPositon < arr.length; ++rightPositon) {
                rightSum += arr[rightPositon];
            }

            if (leftSum == rightSum) {
                System.out.println(mainPosition);
                return;
            }
        }
        System.out.println("no");

    }

    public static void condenseArrayToNumber() {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

        while(arr.length > 1) {
            int[] condensed = new int[arr.length - 1];

            for (int i = 0; i < condensed.length; i++) {
                condensed[i] = arr[i] + arr[i + 1];
            }
            arr = condensed;
        }

        System.out.println(arr[0]);

    }


}
