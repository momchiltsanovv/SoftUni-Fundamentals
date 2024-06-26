package MidExam;

import java.util.Scanner;

public class Exercise_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        short numberOfBiscuitsPerDay = scanner.nextShort();
        short workersCount = scanner.nextShort();
        long competingFactoryProduction = scanner.nextLong();

        int produced = 0;
        double percentage;
        for (int i = 1; i < 31; i++) {

            if (i % 3 == 0) {
                produced += (int) Math.floor(0.75 * numberOfBiscuitsPerDay * workersCount);
            } else {
                produced += numberOfBiscuitsPerDay * workersCount;
            }


        }
        System.out.printf("You have produced %d biscuits for the past month.\n", produced);

        percentage = (double) (Math.abs(produced - competingFactoryProduction) * 100) / competingFactoryProduction;

        if(produced > competingFactoryProduction){
            System.out.printf("You produce %.2f percent more biscuits.", percentage);
        } else {
            System.out.printf("You produce %.2f percent less biscuits.", percentage);

        }

    }
}
