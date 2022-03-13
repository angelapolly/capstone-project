package org.launchcode.capstoneproject.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Emotion extends AbstractEntity {

    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    public Emotion(String name) {
        this.name = name;
    }

    public Emotion() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
