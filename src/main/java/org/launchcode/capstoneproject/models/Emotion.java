package org.launchcode.capstoneproject.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Emotion extends AbstractEntity {

    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    @ManyToMany(mappedBy = "emotions")
    private List<Mood> moods = new ArrayList<>();

    public Emotion(String name) {
        this.name = name;
    }

    public Emotion() {}

    public String getName() {
        return name;
    }

    public String getDisplayName() {return "#" + name + " ";}


    public void setName(String name) {
        this.name = name;
    }

    public List<Mood> getMoods() {
        return moods;
    }
}