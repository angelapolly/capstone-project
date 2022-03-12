package org.launchcode.capstoneproject.models;

import java.awt.*;

public class Mood {

    private String name;
    private String moodColor;

    public Mood(String name, String moodColor) {
        this.name = name;
        this.moodColor = moodColor;
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

    @Override
    public String toString() {
        return name;
    }
}
