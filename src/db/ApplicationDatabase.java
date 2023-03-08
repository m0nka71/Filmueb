package db;

import db.exception.DuplicateException;
import io.ApplicationIO;
import model.Actor;
import model.Movie;
import model.TvSeries;

public class ApplicationDatabase {
    private Movie[] movies = new Movie[20];
    private int numberOfMovies;
    private TvSeries[] tvSeries = new TvSeries[20];
    private int numberOfTvSeries;
    private Actor[] actors = new Actor[20];
    private int numberOfActors;
    private ApplicationIO reader = new ApplicationIO();

    public Movie[] getMovies() {
        Movie[] moviesWithoutNulls = new Movie[numberOfMovies];
        for (int i = 0; i < numberOfMovies; i++) {
            moviesWithoutNulls[i] = movies[i];
        }
        return moviesWithoutNulls;
    }

    public TvSeries[] getTvSeries() {
        TvSeries[] tvSeriesWithoutNulls = new TvSeries[numberOfTvSeries];
        for (int i = 0; i < numberOfTvSeries; i++) {
            tvSeriesWithoutNulls[i] = tvSeries[i];
        }
        return tvSeriesWithoutNulls;
    }

    public Actor[] getActors() {
        Actor[] actorsWithoutNulls = new Actor[numberOfActors];
        for (int i = 0; i < numberOfActors; i++) {
            actorsWithoutNulls[i] = actors[i];
        }
        return actorsWithoutNulls;
    }

    public Actor[] addActor(Actor actor) {
        try {
            if (isActorUnique(actor, actors)) {
                actors[numberOfActors] = actor;
                numberOfActors++;
            }
        } catch (DuplicateException e) {
            System.err.println("Taki aktor już istnieje!");
        }
        return this.actors;
    }

    public TvSeries[] addTvSeries(TvSeries tvSer) {
        try {
            if (isTvSeriesUnique(tvSer, tvSeries)) {
                this.tvSeries[numberOfTvSeries] = tvSer;
                numberOfTvSeries++;
            }
        } catch (DuplicateException e) {
            System.err.println("Taki serial już istnieje!");
        }
        return this.tvSeries;
    }

    public Movie[] addMovie(Movie movie) {
        try {
            if (isMovieUnique(movie, movies)) {
                movies[numberOfMovies] = movie;
                numberOfMovies++;
            }
        } catch (DuplicateException e) {
            System.err.println("Taki film już istnieje!");
        }
        return this.movies;
    }

    private boolean isMovieUnique(Movie movie, Movie[] movies) throws DuplicateException {
        for (Movie m : movies) {
            if (movie.equals(m)) {
                throw new DuplicateException();
            }
        }
        return true;
    }

    private boolean isTvSeriesUnique(TvSeries tvSer, TvSeries[] tvSeries) throws DuplicateException {
        for (TvSeries tvSery : tvSeries) {
            if (tvSer.equals(tvSery)) {
                throw new DuplicateException();
            }
        }
        return true;
    }

    private boolean isActorUnique(Actor actor, Actor[] actors) throws DuplicateException {
        for (Actor act : actors) {
            if (actor.equals(act)) {
                throw new DuplicateException();
            }
        }
        return true;
    }
}
