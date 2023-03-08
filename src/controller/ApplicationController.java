package controller;

import controller.exception.OptionNotExistsException;
import db.ApplicationDatabase;
import io.ApplicationIO;
import io.exception.IncorrectDataException;
import model.Actor;
import model.Movie;
import model.TvSeries;
import model.exception.GenreNotExistsException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationController {

    private ApplicationDatabase database = new ApplicationDatabase();
    private ApplicationIO reader = new ApplicationIO();
    private Scanner scanner = new Scanner(System.in);

    public void mainLoop() {
        int userOption;
        do {
            printOptions();
            System.out.println("Wybierz opcję:");
            userOption = reader.readInt();
            try {
                chooseOption(userOption);
            } catch (OptionNotExistsException e) {
                System.err.println("Wybrana opcja: " + userOption + " jest nieprawidłowa");
            }
        } while (userOption != Option.EXIT.getValue());
    }

    private void chooseOption(int userOption) throws OptionNotExistsException {
        Option convertedUserOption = Option.convert(userOption);
        switch (convertedUserOption) {
            case ADD_MOVIE -> addMovie();
            case ADD_TV -> addTvSeries();
            case ADD_ACTOR -> addActor();
            case PRINT_ALL -> printAll();
            case EXIT -> exit();
            default -> System.out.println("Nie ma takiej opcji");
        }
    }

    private void addActor() {
        try {
            Actor actor = reader.createActor();
            database.addActor(actor);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Osiągnięto limit pojemności, nie można dodać kolejnego aktora");
        } catch (InputMismatchException e) {
            System.err.println("Podane dane są nieprawidłowe");
        }
    }

    private void addTvSeries() {
        TvSeries tvSeries;
        try {
            tvSeries = reader.createTvSeries();
            database.addTvSeries(tvSeries);
        } catch (IncorrectDataException e) {
            System.err.println("Podane dane są nieprawidłowe, nie udało się utworzyć serialu");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Osiągnięto limit pojemności, nie można dodać kolejnego serialu");
        } catch (InputMismatchException e) {
            System.err.println("Podane dane są nieprawidłowe");
        } catch (GenreNotExistsException e) {
            System.out.println("Podany gatunek jest nieprawidłowy");
        }
    }

    private void addMovie() {
        Movie movie;
        try {
            movie = reader.createMovie();
            database.addMovie(movie);
        } catch (IncorrectDataException e) {
            System.err.println("Podane dane są nieprawidłowe, nie udało się utworzyć filmu");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Osiągnięto limit pojemności, nie można dodać kolejnego filmu");
        } catch (InputMismatchException e) {
            System.err.println("Podane dane są nieprawidłowe");
        } catch (GenreNotExistsException e) {
            System.out.println("Podany gatunek jest nieprawidłowy");
            //throw new IncorrectDataException("Podany gatunek jest nieprawidłowy");
        }
    }

    private void printOptions() {
        for (Option value : Option.values()) {
            System.out.println(value);
        }
    }

    private void printAll() {
        System.out.println("Filmy: ");
        Movie[] movies = database.getMovies();
        for (Movie movie : movies) {
            System.out.println(movie.toString());
        }
        System.out.println("Seriale: ");
        TvSeries[] tvSeries = database.getTvSeries();
        for (TvSeries tvSery : tvSeries) {
            System.out.println(tvSery.toString());
        }
        System.out.println("Aktorzy: ");
        Actor[] actors = database.getActors();
        for (Actor actor : actors) {
            System.out.println(actor.toString());
        }
    }

    private void exit() {
        System.out.println("Koniec programu");
        reader.close();
    }
}

