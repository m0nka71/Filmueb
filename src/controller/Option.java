package controller;

import controller.exception.OptionNotExistsException;

enum Option {
    ADD_MOVIE(0, "Dodanie filmu"),
    ADD_TV(1, "Dodanie serialu"),
    ADD_ACTOR(2, "Dodanie aktora"),
    PRINT_ALL(3, "Wyświetl wszytko"),
    EXIT(4, "Koniec programu");

    private final int value;
    private final String description;

    Option(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }

    static Option convert(int option) throws OptionNotExistsException {
        try {
            return Option.values()[option];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new OptionNotExistsException();
        }
    }
}
