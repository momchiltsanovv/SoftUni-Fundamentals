package AssociativeArrays.Courses;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<String>> studentsCourses = new LinkedHashMap<>();

        String command = sc.nextLine();

        while(!command.equals("end")) {
            String[] data = command.split(" : ");
            String courseName = data[0];
            String studentName = data[1];

            if(!studentsCourses.containsKey(courseName)) {
                studentsCourses.put(courseName, new ArrayList<>());
            }
            studentsCourses.get(courseName).add(studentName);
            command = sc.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : studentsCourses.entrySet()) {

            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue().size());

            for (String student : entry.getValue()) {
                System.out.printf("-- %s\n", student);
            }


        }



    }
}
