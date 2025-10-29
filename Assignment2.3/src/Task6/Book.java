package Task6;

import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private int publicationyear;
    private double rating;// decimal nk ma loh double gho thone dr
    private ArrayList<String> reviews= new ArrayList<>();


    //constructor
    public Book(String title, String author, int publicationyear) {
        this.title = title;
        this.author = author;
        this.publicationyear = publicationyear;
        this.rating = 0;//def
        this.reviews= new ArrayList();
    }


    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getPublicationyear() {
        return publicationyear;
    }
    public double getRating() {
        return rating;
    }
    public ArrayList<String> getReviews() {
        return reviews;
    }

    public void setRating(double rating) {
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        }
        else {
            System.out.println("RAting must be between 1 to 5");
        }
    }

    public void addReview(String review) {
        reviews.add(review);
    }

    @Override
    public String toString() {
        return "Title: \"" + title + "\", Author: \"" + author + "\", Year: " + publicationyear +
                ", Rating: " + rating + ", Reviews: " + reviews.size();
    }
}