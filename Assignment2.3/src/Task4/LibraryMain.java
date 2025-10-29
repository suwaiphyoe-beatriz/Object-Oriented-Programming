package Task4;

public class LibraryMain {
    public static void main(String[] args) {
        Library mylibrary = new Library(); // create library

        //create some books
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);


        mylibrary.addBook(book1);
        mylibrary.addBook(book2);
        mylibrary.addBook(book3);

        //rating
        book1.setRating(4.5);
        book2.setRating(5);
        book3.setRating(3);

        //review
        book1.addReview("Great book for beginners!");
        book1.addReview("Easy to follow examples.");
        book2.addReview("Excellent explanations of algorithms.");

        //display
        mylibrary.displayBooks();

        mylibrary.findBooksByAuthor("John Smith");
    }
}