package ObjectAndClasses.Articles;

public class Article {

    private String title, content, author;

    public Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String edit(String newContent) {
        return this.content = newContent;
    }

    public String changeAuthor(String newAuthor) {
        return this.author = newAuthor;
    }

    public String rename(String newTitle) {
        return this.title = newTitle;
    }


}
