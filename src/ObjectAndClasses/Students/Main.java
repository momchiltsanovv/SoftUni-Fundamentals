package ObjectAndClasses.Students;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        int studentsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < studentsCount; ++i) {
            String studentInfo = scanner.nextLine();
            String firstName = studentInfo.split(" ")[0];
            String lastName = studentInfo.split(" ")[1];
            double grade = Double.parseDouble(studentInfo.split(" ")[2]);
            Student curStudent = new Student(firstName, lastName, grade);
            students.add(curStudent);
        }


        //students.sort((s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade()));

        students.sort(Comparator.comparingDouble(Student::getGrade)// sort in ascending order
                .reversed()); // reverse it to descending

        for (Student student : students) {
            System.out.println(student);
        }


    }

}
