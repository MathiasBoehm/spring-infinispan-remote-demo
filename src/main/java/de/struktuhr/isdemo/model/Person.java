package de.struktuhr.isdemo.model;

import java.time.LocalDateTime;

public class Person {
    public final String name;
    public final LocalDateTime created;

    public Person(String name, LocalDateTime created) {
        this.name = name;
        this.created = created;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", created=" + created +
                '}';
    }
}
