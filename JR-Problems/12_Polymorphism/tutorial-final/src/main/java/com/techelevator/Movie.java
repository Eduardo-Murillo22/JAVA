package com.techelevator;

public class Movie extends MediaItem {
    private String rating;
    private int runLength;

    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public int getRunLength() {
        return runLength;
    }
    public void setRunLength(int runLength) {
        this.runLength = runLength;
    }

    public Movie(String title, String rating, int runLength, double price) {
        super(title, price);
        this.rating = rating;
        this.runLength = runLength;
    }

    @Override
    public String toString() {
        return "Title: " + this.getTitle() + ", Rating: " + rating + ", Time: " + runLength + " minutes, Price: $" + this.getPrice();
    }
}
