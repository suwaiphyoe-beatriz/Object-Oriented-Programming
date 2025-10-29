package Task6;


import java.util.ArrayList;

public class Library {
    // book thane phot
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }
    public void addUser(User user) {
        users.add(user);
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

    public boolean borrowBook(User user, String title) {
        for (Book book : books) {
            if (book.getTitle().trim().equalsIgnoreCase(title.trim())) {
                books.remove(book);
                user.borrowBook(book);
                System.out.println(user.getName() + " borrowed: " + book.getTitle());
                return true;
            }
        }
        System.out.println("Book not found: " + title);
        return false;
    }

    public void returnBook(User user, Book book) {
        if (user.getBorrowedBooks().contains(book)) {
            user.returnBook(book);  // remove from user's borrowed books
            books.add(book);        // add back to library
            System.out.println(user.getName() + " returned: " + book.getTitle());
        } else {
            System.out.println(user.getName() + " has not borrowed: " + book.getTitle());
        }
    }

    public boolean isBookAvailable(String title) {
        for (Book book : books) {
            if (book.getTitle().trim().equalsIgnoreCase(title.trim())) {
                return true;
            }
        }
        return false;
    }

    public double getAverageBookRating() {
        if (books.isEmpty())
            return 0;

        double sum = 0.0;
        int count = 0;
        for (Book book : books) {
            sum += book.getRating(); // add each book rating to sum
            count++; //count hm book
        }
        return sum / count;
    }

    public Book getMostReviewedBook() {
        if (books.isEmpty())
            return null;

        Book mostReviewed = books.get(0);//1st book gho most reviewd so pe assume lok
        for (Book book : books) {
            if (book.getReviews().size() > mostReviewed.getReviews().size()) {
                mostReviewed = book;
            }
        }
        return mostReviewed;
    }
}
