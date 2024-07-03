package ObjectAndClasses.OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String name = command.split(" ")[0];
            String id = command.split(" ")[1];
            byte age = Byte.parseByte(command.split(" ")[2]);
             people.add(new Person(name, id, age));
             command = scanner.nextLine();
        }

        people.sort(Comparator.comparing(Person::getAge));

        for (Person person : people) {
            System.out.println(person);
        }




    }


}
