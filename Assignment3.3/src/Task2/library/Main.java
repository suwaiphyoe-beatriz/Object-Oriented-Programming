import model.Book;
import model.LibraryMember;
import system.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book b1 = new Book("The Hobbit", "J.R.R. Tolkien", "12345");
        Book b2 = new Book("1984", "George Orwell", "67890");

        library.addBook(b1);
        library.addBook(b2);

        LibraryMember m1 = new LibraryMember("Alice", 1);
        LibraryMember m2 = new LibraryMember("Bob", 2);

        library.addMember(m1);
        library.addMember(m2);

        library.borrowBook(m1, b1);
        library.borrowBook(m2, b2);

        library.returnBook(m1, b1);
    }
}