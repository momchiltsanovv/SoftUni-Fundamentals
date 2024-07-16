package TextProcessing.MultiplyBigNumbers;

import java.math.BigInteger;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        BigInteger number = new BigInteger(sc.nextLine());
        BigInteger secondNum = new BigInteger(sc.nextLine());
        System.out.println(number.multiply(secondNum));

    }
}
