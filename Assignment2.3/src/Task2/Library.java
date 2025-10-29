package Task2;


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

    public boolean borrowBook(String title) { // void so yin book gho remove pe brmha return ma lok loh but boolean ka kya r true,false
        for (Book book : books) {
            if (book.getTitle().trim().equalsIgnoreCase(title.trim())) {
                books.remove(book); // remove it from library
                System.out.println("You borrowed: " + book.getTitle());
                return true;
            }
        }
        System.out.println("Books not found"+ title);
        return false;
    }

    public void returnBook(Book book) {
        books.add(book);
        System.out.println("You returned: " + book.getTitle());
    }
}
