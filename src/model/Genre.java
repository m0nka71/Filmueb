package model;

import model.exception.GenreNotExistsException;

public enum Genre {
    SCI_FI("Sci-fi"),
    ACTION("Akcja"),
    COMEDY("Komedia"),
    THRILLER("Thriller");

    private final String description;

    Genre(String description) {
        this.description = description;
    }

    public static void printGenres() {
        StringBuilder sb = new StringBuilder();
        Genre[] values = Genre.values();
        System.out.print("Podaj gatunek: ");
        for (Genre value : values) {
            sb.append(value.description).append(", ");
        }
        sb.setLength(sb.length() - 2);
        System.out.println(sb);
    }

    public static Genre convert(String genre) throws GenreNotExistsException {
        switch (genre) {
            case "Sci-fi" -> {
                return SCI_FI;
            }
            case "Akcja" -> {
                return ACTION;
            }
            case "Komedia" -> {
                return COMEDY;
            }
            case "Thriller" -> {
                return THRILLER;
            }
            default -> throw new GenreNotExistsException("Podany gatunek nie istnieje");
        }
    }
}
