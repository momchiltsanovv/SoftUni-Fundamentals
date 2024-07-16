package TextProcessing.ReplaceRepeatingChars;

import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        String input = sc.nextLine();
        StringBuilder textEdit = new StringBuilder(input);
        for (int idx = 0; idx < textEdit.length() - 1; idx++) {
            if (textEdit.charAt(idx) == textEdit.charAt(idx + 1)) {
                textEdit.deleteCharAt(idx + 1);
                idx--;
            }

        }

        System.out.println(textEdit);
    }

}
