package org.launchcode.capstoneproject.models;

import javax.validation.constraints.NotBlank;

public class MoodCategory extends AbstractEntity{

    @NotBlank
    private String name;

    public MoodCategory(String name) {
        this.name = name;
    }

    public MoodCategory() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
