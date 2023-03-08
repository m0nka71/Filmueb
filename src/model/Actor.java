package model;

import java.io.Serializable;
import java.util.Objects;

public class Actor implements Serializable {
    private String firstName;
    private String lastName;
    private String country;

    public Actor(String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }

    public String toCsv() {
        return firstName + ";" + lastName + ";" + country;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", pochodzenie: " + country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(firstName, actor.firstName) && Objects.equals(lastName, actor.lastName) && Objects.equals(country, actor.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, country);
    }
}
