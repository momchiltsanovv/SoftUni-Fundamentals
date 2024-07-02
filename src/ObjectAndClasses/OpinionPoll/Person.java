package ObjectAndClasses.OpinionPoll;

import java.util.Scanner;

public class Person {
    Scanner scanner = new Scanner(System.in);

    private String name;
    private int age;

    public Person() {}


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
