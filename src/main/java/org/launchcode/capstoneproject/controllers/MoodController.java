package org.launchcode.capstoneproject.controllers;

import org.launchcode.capstoneproject.data.MoodData;
import org.launchcode.capstoneproject.models.Mood;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String displayCreateMoodForm(Model model) {
        model.addAttribute("title", "Create Mood");
        model.addAttribute("mood", new Mood());
        return "moods/create.html";
    }

    //Lives at moods/create
    @PostMapping("create")
    public String processCreateMoodForm(@ModelAttribute @Valid Mood newMood,
                                        Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Mood");
            return "moods/create.html";
        }
        MoodData.add(newMood);
        return "redirect:";
    }

    //Lives at moods/delete
    @GetMapping("delete")
    public String displayDeleteMoodForm(Model model) {
        model.addAttribute("title", "Delete Mood");
        model.addAttribute("moods", MoodData.getAll());
        return "moods/delete.html";
    }

    //Lives at moods/delete
    @PostMapping("delete")
    public String processDeleteMoodForm(@RequestParam(required= false) int[] moodIds) {
        if (moodIds != null) {
            for (int id : moodIds) {
                MoodData.remove(id);
            }
        }
        return "redirect:";
    }
}
