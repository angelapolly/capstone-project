package org.launchcode.capstoneproject.controllers;

import org.launchcode.capstoneproject.data.MoodData;
import org.launchcode.capstoneproject.models.Mood;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("moods")
public class MoodController {

    //Lives at /moods
    @GetMapping
    public String displayAllMoods(Model model) {
        model.addAttribute("moods", MoodData.getAll());
        return "moods/index.html";
    }

    //Lives at moods/create
    @GetMapping("create")
    public String renderCreateMoodForm() {
        return "moods/create.html";
    }

    //Lives at moods/create
    @PostMapping("create")
    public String createMood(@RequestParam String moodName,
                             @RequestParam String moodColor) {
        MoodData.add(new Mood(moodName, moodColor));
        return "redirect:";
    }
}
