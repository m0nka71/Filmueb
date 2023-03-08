package io;

import io.exception.IncorrectDataException;
import model.Actor;
import model.Genre;
import model.Movie;
import model.TvSeries;
import model.exception.GenreNotExistsException;

import java.util.Scanner;

public class ApplicationIO {
    private final Scanner scanner = new Scanner(System.in);

    public Movie createMovie() throws IncorrectDataException, GenreNotExistsException {
        System.out.println("Tworzenie nowego filmu");
        System.out.println("Podaj nazwę:");
        String title = scanner.nextLine();
        System.out.println("Podaj reżysera:");
        String director = scanner.nextLine();
        System.out.println("Podaj rok produkcji:");
        int year = readInt();
        Genre.printGenres();
        String genre = scanner.nextLine();
        Genre.convert(genre);
        System.out.println("Podaj opis:");
        String description = scanner.nextLine();
        System.out.println("Podaj ocenę:");
        int rating = readInt();

        if (year == 0 || rating <= 0 || rating > 10) {
            throw new IncorrectDataException("Podane dane są nieprawidłowe, nie udało się utworzyć filmu");
        } else {
            return new Movie(title, description, rating, genre, director, year);
        }
    }

    public TvSeries createTvSeries() throws IncorrectDataException, GenreNotExistsException {
        System.out.println("Tworzenie nowego serialu");
        System.out.println("Podaj nazwę:");
        String title = scanner.nextLine();
        System.out.println("Podaj liczbę sezonów:");
        int seasons = readInt();
        System.out.println("Podaj liczbę odcinków:");
        int episodes =  readInt();
        System.out.println("Podaj producenta:");
        String producer = scanner.nextLine();
        Genre.printGenres();
        String genre = scanner.nextLine();
        Genre.convert(genre);
        System.out.println("Podaj opis:");
        String description = scanner.nextLine();
        System.out.println("Podaj ocenę:");
        int rating = readInt();

        if (seasons == 0 || episodes == 0 || rating <= 0 || rating > 10) {
            throw new IncorrectDataException("Podane dane są nieprawidłowe, nie udało się utworzyć serialu");
        } else {
            return new TvSeries(title, description, rating, genre, seasons, episodes, producer);
        }
    }

    public Actor createActor() {
        System.out.println("Tworzenie nowego aktora");
        System.out.println("Podaj imię:");
        String firstName = scanner.nextLine();
        System.out.println("Podaj nazwisko:");
        String lastName = scanner.nextLine();
        System.out.println("Podaj kraj pochodzenia:");
        String country = scanner.nextLine();
        return new Actor(firstName, lastName, country);
    }

    public int readInt() {
        try {
            return scanner.nextInt();
        } finally {
            scanner.nextLine();
        }
    }

    public void close() {
        scanner.close();
    }
}
