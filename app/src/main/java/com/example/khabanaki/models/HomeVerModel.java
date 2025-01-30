package com.example.khabanaki.models;

public class HomeVerModel {

    private int image;
    private String name;
    private String timing;
    private String rating; // Changed to String for textual ratings
    private String price;

    // Constructor
    public HomeVerModel(int image, String name, String timing, String rating, String price) {
        this.image = image;
        this.name = name;
        this.timing = timing;
        this.rating = rating;
        this.price = price;
    }

    // Getters
    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getTiming() {
        return timing;
    }

    public String getRating() {
        return rating; // Getter for the textual rating
    }

    public String getPrice() {
        return price;
    }
}
