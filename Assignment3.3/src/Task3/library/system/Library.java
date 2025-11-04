package system;

import model.Book;
import model.LibraryMember;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<LibraryMember> members;

    public Library(List<Book> books, List<LibraryMember> members) {
        this.books = books;
        this.members = members;
    }

    public void reserveBook(LibraryMember member, Book book) {
        if (!book.isReserved()) {
            book.reserve();
            member.addReservedBook(book);
            System.out.println(member.getName() + " reserved the book: " + book.getTitle());
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    public void cancelReservation(LibraryMember member, Book book) {
        if (member.hasReservedBook(book)) {
            book.cancelReservation();
            member.removeReservedBook(book);
            System.out.println(member.getName() + " canceled reservation for: " + book.getTitle());
        } else {
            System.out.println("No reservation found for this book.");
        }
    }

    public void displayReservedBooks(LibraryMember member) {
        System.out.println("Reserved books for " + member.getName() + ":");
        for (Book b : member.getReservedBooks()) {
            System.out.println(" - " + b.getTitle());
        }
    }
}
