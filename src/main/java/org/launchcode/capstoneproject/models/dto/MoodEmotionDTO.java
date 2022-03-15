package org.launchcode.capstoneproject.models.dto;

import org.launchcode.capstoneproject.models.Emotion;
import org.launchcode.capstoneproject.models.Mood;

import javax.validation.constraints.NotNull;

public class MoodEmotionDTO {

    @NotNull
    private Mood mood;

    @NotNull
    private Emotion emotion;

    public MoodEmotionDTO() {}

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }
}
