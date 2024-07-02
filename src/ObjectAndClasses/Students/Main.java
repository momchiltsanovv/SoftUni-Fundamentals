package ObjectAndClasses.Students;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        int studentsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < studentsCount; ++i) {
            String curStudentInfo = scanner.nextLine();
            String curStudentFirstName = curStudentInfo.split(" ")[0];
            String curStudentLastName = curStudentInfo.split(" ")[1];
            double curStudentGrade = Double.parseDouble(curStudentInfo.split(" ")[2]);
            Student curStudent = new Student(curStudentFirstName, curStudentLastName, curStudentGrade);
            students.add(curStudent);
        }


        students.sort((s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade()));
        for (Student student : students) {
            System.out.printf("%s %s: %.2f%n", student.getFirstName(), student.getLastName(), student.getGrade());
        }


    }

}
