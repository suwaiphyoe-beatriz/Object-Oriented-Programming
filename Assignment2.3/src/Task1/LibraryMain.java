package Task1;

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

        //display
        mylibrary.displayBooks();

        //search by author
        mylibrary.findBooksByAuthor("Jane Doe");
    }
}
