package AssociativeArrays.CompanyUsers;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Same as Courses Task but with a small changes

        Map<String, List<String>> studentsCourses = new LinkedHashMap<>();

        String command = sc.nextLine();

        while(!command.equals("End")) {
            String[] data = command.split(" -> ");
            String companyName = data[0];
            String employeeId = data[1];

            if(!studentsCourses.containsKey(companyName)) {
                studentsCourses.put(companyName, new ArrayList<>());
            }
            if(!studentsCourses.get(companyName).contains(employeeId)) {
                studentsCourses.get(companyName).add(employeeId);
            }
            command = sc.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : studentsCourses.entrySet()) {
            System.out.printf("%s\n", entry.getKey());

            for (String student : entry.getValue()) {
                System.out.printf("-- %s\n", student);
            }


        }



    }
}
