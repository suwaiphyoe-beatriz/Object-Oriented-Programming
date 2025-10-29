package Task1;

public class Book {
    private String title;
    private String author;
    private int publicationyear;

    //constructor
    public Book(String title, String author, int publicationyear) {
        this.title = title;
        this.author = author;
        this.publicationyear = publicationyear;
    }


    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getPublicationyear() {
        return publicationyear;
    }

    @Override
    public String toString() {
        return "Title: \"" + title + "\", Author: \"" + author + "\", Year: " + publicationyear;
    }

}
