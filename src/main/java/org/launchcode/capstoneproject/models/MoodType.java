package org.launchcode.capstoneproject.models;

public enum MoodType {

    REALLY_GREAT("Really Great"),
    PRETTY_GOOD("Pretty Good"),
    JUST_OK("Just Ok"),
    COULD_BE_BETTER("Could be better"),
    BAD("Bad");

    private final String displayName;

    MoodType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
