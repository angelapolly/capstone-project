package org.launchcode.capstoneproject.controllers;

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

    private static List<Mood> moods = new ArrayList<>();

    //Lives at /moods
    @GetMapping
    public String displayAllMoods(Model model) {
        model.addAttribute("moods", moods);
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
        moods.add(new Mood(moodName, moodColor));
        return "redirect:";
    }
}
