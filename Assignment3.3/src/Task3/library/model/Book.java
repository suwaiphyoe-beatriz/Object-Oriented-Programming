package model;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;
    private boolean isReserved;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
        this.isReserved = false;
    }

    public String getTitle() { return title; }
    public boolean isBorrowed() { return isBorrowed; }
    public boolean isReserved() { return isReserved; }

    public void borrow() { this.isBorrowed = true; }
    public void returned() { this.isBorrowed = false; }
    public void reserve() { this.isReserved = true; }
    public void cancelReservation() { this.isReserved = false; }

    @Override
    public String toString() {
        return title + " (Reserved: " + isReserved + ", Borrowed: " + isBorrowed + ")";
    }
}
