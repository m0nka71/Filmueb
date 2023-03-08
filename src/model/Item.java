package model;

import java.io.Serializable;
import java.util.Objects;

abstract class Item implements Serializable {
    private String title;
    private String description;
    private int rating;

    private String genre;

    public Item(String title, String description, int rating, String genre) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public abstract String toCsv();

    @Override
    public String toString() {
        return title + ", gatunek: " + genre + ", opis: " + description + ", ocena: " + rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return rating == item.rating && Objects.equals(title, item.title) && Objects.equals(description, item.description) && Objects.equals(genre, item.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, rating, genre);
    }
}
