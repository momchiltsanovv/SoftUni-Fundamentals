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
        //condenseArrayToNumber();
        //magicSum();
        //arrayModifier();
        theLift();


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

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

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

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

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

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        while (arr.length > 1) {
            int[] condensed = new int[arr.length - 1];

            for (int i = 0; i < condensed.length; i++) {
                condensed[i] = arr[i] + arr[i + 1];
            }
            arr = condensed;
        }
        System.out.println(arr[0]);
    }

    public static void magicSum() {
        Scanner scanner = new Scanner(System.in);

        int[] inputArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int target = scanner.nextInt();

        for (int i = 0; i < inputArr.length; ++i) {
            for (int j = i + 1; j < inputArr.length; ++j) {
                if (inputArr[i] + inputArr[j] == target) {
                    System.out.println(inputArr[i] + " " + inputArr[j] + " ");
                }
            }
        }
    }

    public static void arrayModifier() {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("end")) {
            switch (command[0]) {
                case "swap" -> {
                    int idx1 = Integer.parseInt(command[1]);
                    int idx2 = Integer.parseInt(command[2]);
                    int temp = arr[idx1];
                    arr[idx1] = arr[idx2];
                    arr[idx2] = temp;
                }
                case "multiply" -> {
                    int idx1 = Integer.parseInt(command[1]);
                    int idx2 = Integer.parseInt(command[2]);
                    arr[idx1] *= arr[idx2];
                }
                case "decrease" -> {
                    for (int i = 0; i < arr.length; ++i) {
                        arr[i]--;
                    }
                }
            }
            command = scanner.nextLine().split(" ");
        }
        for (int i = 0; i < arr.length; ++i) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }

    }

    public static void theLift() {
        Scanner scanner = new Scanner(System.in);


        int waitingPeople = Integer.parseInt(scanner.nextLine());
        int[] wagons = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt).toArray();


        boolean isLiftFull = true;
        for (int position = 0; position < wagons.length; position++) {

            int availableSpace = 4 - wagons[position];

            if (availableSpace > 0 && availableSpace > waitingPeople) {
                    wagons[position] += waitingPeople;
                    waitingPeople = 0;
                    isLiftFull = false;
            } else {
                wagons[position] = 4;
                waitingPeople -= availableSpace;
            }
        }

        if (!isLiftFull) {
            System.out.println("The lift has empty spots!");
        } else if (waitingPeople > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!\n", waitingPeople);
        }

        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
