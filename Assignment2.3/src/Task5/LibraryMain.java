package Task5;

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
        book3.addReview("Easy to follow examples.");
        book2.addReview("Excellent explanations of algorithms.");
        book2.addReview("Comprehensive and detailed");

        //display
        mylibrary.displayBooks();

        // Average rating
        System.out.println("\nAverage book rating: " + mylibrary.getAverageBookRating());

        // Most reviewed book
        Book mostReviewed = mylibrary.getMostReviewedBook();
        System.out.println("Most reviewed book: " + mostReviewed.getTitle() +
                " (" + mostReviewed.getReviews().size() + " reviews)");
    }
}