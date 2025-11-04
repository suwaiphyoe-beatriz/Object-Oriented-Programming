import model.Book;
import model.LibraryMember;
import system.Library;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        List<LibraryMember> members = new ArrayList<>();

        Library library = new Library(books, members);

        Book b1 = new Book("The Hobbit", "J.R.R. Tolkien", "12345");
        Book b2 = new Book("1984", "George Orwell", "67890");

        LibraryMember m1 = new LibraryMember("Alice", 1);
        LibraryMember m2 = new LibraryMember("Bob", 2);

        books.add(b1);
        books.add(b2);
        members.add(m1);
        members.add(m2);

        // Reserve, cancel & display reserved books
        library.reserveBook(m1, b1);
        library.reserveBook(m2, b2);
        library.displayReservedBooks(m1);

        library.cancelReservation(m1, b1);
        library.displayReservedBooks(m1);
    }
}

