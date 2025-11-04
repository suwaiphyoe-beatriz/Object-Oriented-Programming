package system;

import model.Book;
import model.LibraryMember;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<LibraryMember> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book: " + book);
    }

    public void addMember(LibraryMember member) {
        members.add(member);
        System.out.println("Added member: " + member);
    }

    public void borrowBook(LibraryMember member, Book book) {
        if (!book.isBorrowed()) {
            book.borrow();
            member.borrowBook(book);
            System.out.println(member.getName() + " borrowed: " + book.getTitle());
        } else {
            System.out.println("Book already borrowed.");
        }
    }

    public void returnBook(LibraryMember member, Book book) {
        if (book.isBorrowed()) {
            book.returned();
            member.returnBook(book);
            System.out.println(member.getName() + " returned: " + book.getTitle());
        } else {
            System.out.println("Book was not borrowed.");
        }
    }
}

