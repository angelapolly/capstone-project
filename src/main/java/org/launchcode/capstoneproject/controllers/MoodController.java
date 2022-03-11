package org.launchcode.capstoneproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("moods")
public class MoodController {

    private static List<String> moods = new ArrayList<>();

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
    public String createMood(@RequestParam String moodName) {
        moods.add(moodName);
        return "redirect:";
    }
}
