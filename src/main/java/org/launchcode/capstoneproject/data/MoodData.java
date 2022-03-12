package org.launchcode.capstoneproject.data;

import org.launchcode.capstoneproject.models.Mood;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MoodData {

    // need a place to put all moods
    public static final Map<Integer, Mood> moods = new HashMap<>();

    // add a mood
    public static void add(Mood mood) {
        moods.put(mood.getId(), mood);
    }

    // get a single mood
    public static Mood getById(int id) {
        return moods.get(id);
    }

    // get all moods
    public static Collection<Mood> getAll() {
        return moods.values();
    }

    // remove a mood
    public static void remove(int id) {
        moods.remove(id);
    }
}
