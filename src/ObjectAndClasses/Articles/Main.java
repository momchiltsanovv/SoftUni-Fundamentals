package ObjectAndClasses.Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String articleData = scanner.nextLine();
        String title = articleData.split(", ")[0];
        String content = articleData.split(", ")[1];
        String author = articleData.split(", ")[2];

        Article article = new Article(title, content, author);

        int commandCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < commandCount; ++i) {
            String command = scanner.nextLine();
            String commandType = command.split(": ")[0];
            String parameter = command.split(": ")[1];

            switch (commandType) {
                case "Edit" -> article.edit(parameter);
                case "ChangeAuthor" -> article.changeAuthor(parameter);
                case "Rename" -> article.rename(parameter);
            }
        }

        System.out.println(article);



    }
}
