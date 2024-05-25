import java.util.Scanner;

public class DataTypesAndVariables {
    public static void main(String[] args) {
        //integerOperations();
        //sumDigits();
        //elevator();
        sumOfChars();

    }

    public static void integerOperations() {
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        int num4 = scanner.nextInt();

        System.out.println((num1 + num2) / num3 * num4);
    }

    public static void sumDigits() {
        Scanner scanner = new Scanner(System.in);

        short inputNum = scanner.nextShort();
        byte sum = 0;
        while (inputNum > 0) {
            sum += inputNum % 10;
            inputNum /= 10;
        }
        System.out.println(sum);
    }

    public static void elevator() {
        Scanner scanner = new Scanner(System.in);

        byte peopleWaiting = scanner.nextByte();
        byte capacity = scanner.nextByte();

        int courses = peopleWaiting / capacity;
        if (peopleWaiting % capacity != 0) {
            courses++;
        }
        System.out.println(courses);
    }

    public static void sumOfChars() {
        Scanner scanner = new Scanner(System.in);

        byte lineCount = scanner.nextByte();
        short sum = 0;
        for (byte i = 0; i < lineCount; i++) {
            char symbol = scanner.next().charAt(0);
            sum += (short) symbol;
        }

        System.out.printf("The sum equals: %d", sum);

    }


}

