package AssociativeArrays.StudentAcademy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<Double>> studentsGrades = new LinkedHashMap<>();


        int rowPair = Integer.parseInt(sc.nextLine());


        for (int i = 0; i < rowPair; ++i) {
            String studentName = sc.nextLine();
            double grade = Double.parseDouble(sc.nextLine());

            if (!studentsGrades.containsKey(studentName)) {
                studentsGrades.put(studentName, new ArrayList<>());
            }
            studentsGrades.get(studentName).add(grade);
        }

        for (Map.Entry<String, List<Double>> entry : studentsGrades.entrySet()) {
            String studentName = entry.getKey();
            List<Double> grades = entry.getValue();
            double average = getAverageGrade(grades);

            if (average >= 4.5) {
                System.out.printf("%s -> %.2f\n", studentName, average);
            }
        }
    }

    private static double getAverageGrade(List<Double> grades) {
        double avg = 0;
        for (double grade : grades) {
            avg += grade;
        }
        return avg / grades.size();
    }
}
