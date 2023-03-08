package model;

public class Movie extends Item {
    public static final String TYPE = "Film";
    private String director;
    private int productionYear;

    public Movie(String title, String description, int rating, String genre, String director, int productionYear) {
        super(title, description, rating, genre);
        this.director = director;
        this.productionYear = productionYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    @Override
    public String toCsv() {
        return TYPE + getTitle() + ";" +
                getDescription() + ";" +
                getRating() + ";" +
                getGenre() + ";" +
                director + ";" + productionYear;
    }

    @Override
    public String toString() {
        return super.toString() + ", rok: " + productionYear + ", reżyser: " +
                director;
    }
}
