import java.util.Scanner;


public class Arrays {
    public static void main(String[] args) {

        //train();
        commonElements();


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

    }
}
