package org.launchcode.capstoneproject.models;

import java.awt.*;
import java.util.Objects;

public class Mood {

    private int id;
    private static int nextId = 1;

    private String name;
    private String moodColor;

    public Mood(String name, String moodColor) {
        this.name = name;
        this.moodColor = moodColor;
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoodColor() {
        return moodColor;
    }

    public void setMoodColor(String moodColor) {
        this.moodColor = moodColor;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mood mood = (Mood) o;
        return id == mood.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name;
    }
}
