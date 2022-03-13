package org.launchcode.capstoneproject.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.awt.*;
import java.util.Objects;

@Entity
public class Mood {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Oops! You forgot to share how you're feeling today.")
    @Size(min = 3, max = 20, message = "Hey, it looks like you made a typo. Please try again.")
    private String name;

    @NotBlank(message = "Don't forget to choose a hue for your mood today!")
    @Size(min = 3, max = 20, message = "Oops! Are you sure that's the name of a color?")
    private String moodColor;

    private MoodType type;

    public Mood(String name, String moodColor, MoodType type) {
        this.name = name;
        this.moodColor = moodColor;
        this.type = type;
    }

    public Mood() {}

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

    public MoodType getType() {
        return type;
    }

    public void setType(MoodType type) {
        this.type = type;
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
