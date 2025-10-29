package Task1;

import java.util.ArrayList;

public class Library {
    // book thane phot
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }
    public void displayBooks() {
        System .out.println("\n Library Catalog:: \n");
        int i=1; // no pr chin loh output shae mhr
        for (Book book : books) {
            System.out.println(i++ + ". " + book.getTitle());
        }
    }
    public void findBooksByAuthor(String author) {
        System .out.println("\n Books by Author: \n");
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found by this author");
        }
    }
}
