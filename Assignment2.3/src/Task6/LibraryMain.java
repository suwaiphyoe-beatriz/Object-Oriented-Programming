package Task6;

public class LibraryMain {
    public static void main(String[] args) {
        Library mylibrary = new Library(); // create library

        //create some books
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        // Create users
        User u1 = new User("Alice", 25);
        User u2 = new User("Bob", 30);


        mylibrary.addBook(book1);
        mylibrary.addBook(book2);
        mylibrary.addBook(book3);

        mylibrary.addUser(u1);
        mylibrary.addUser(u2);

        //rating
        book1.setRating(4.5);
        book2.setRating(5);
        book3.setRating(3);

        //review
        book1.addReview("Great book for beginners!");
        book3.addReview("Easy to follow examples.");
        book2.addReview("Excellent explanations of algorithms.");
        book2.addReview("Comprehensive and detailed");

        // Display available books
        mylibrary.displayBooks();

        // Alice borrows a book
        mylibrary.borrowBook(u1, "Introduction to Java Programming");

        // Bob tries to borrow same book
        mylibrary.borrowBook(u2, "Introduction to Java Programming"); // should fail

        // Display library after borrowing
        mylibrary.displayBooks();

        // Alice returns the book
        mylibrary.returnBook(u1, book1);

        // Display library after return
        mylibrary.displayBooks();
    }
}