package ExamPrep2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        int size = Integer.parseInt(sc.nextLine());
        String regex = "(?<surrounding>@#+)(?<text>[A-Z][a-zA-Z0-9]{4,}[A-Z])@#+";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < size; i++) {
            String curBarcode = sc.nextLine();
            Matcher matcher = pattern.matcher(curBarcode);
                matcherLogic(matcher);

        }
    }

    public static void matcherLogic(Matcher matcher){
        if (matcher.find()) {
            String text = matcher.group("text");
            StringBuilder group = new StringBuilder();
            for (char ch : text.toCharArray()) {
                if (Character.isDigit(ch)) {
                    group.append(ch);
                }
            }
            if (!group.isEmpty()) {
                System.out.printf("Product group: %s\n", group);
            } else {
                System.out.println("Product group: 00");
            }
        } else {
            System.out.println("Invalid barcode");
        }

    }
}
