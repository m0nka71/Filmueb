package model;

public class TvSeries extends Item  {

    public static final String TYPE = "Serial";
    private int seasons;
    private int episodes;
    private String producer;

    public TvSeries(String title, String description, int rating, String genre, int seasons, int episodes, String producer) {
        super(title, description, rating, genre);
        this.seasons = seasons;
        this.episodes = episodes;
        this.producer = producer;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toCsv() {
        return TYPE + getTitle() + ";" +
                getDescription() + ";" +
                getRating() + ";" +
                getGenre() + ";" +
                seasons + ";" + episodes + ";" + producer;
    }

    @Override
    public String toString() {
        return super.toString() + ", liczba sezonów: " + seasons +
                ", liczba odcinków: " + episodes + ", producent:"
                + producer;
    }
}
