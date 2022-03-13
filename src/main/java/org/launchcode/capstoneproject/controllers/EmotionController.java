package org.launchcode.capstoneproject.controllers;

import org.launchcode.capstoneproject.data.EmotionRepository;
import org.launchcode.capstoneproject.models.Emotion;
import org.launchcode.capstoneproject.models.Mood;
import org.launchcode.capstoneproject.models.MoodType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("emotions")
public class EmotionController {

    @Autowired
    EmotionRepository emotionRepository;

    //Lives at /emotions
    @GetMapping
    public String displayAllEmotions(Model model) {
        model.addAttribute("emotions", emotionRepository.findAll());
        return "emotions/index.html";
    }

    //Lives at emotions/create
    @GetMapping("create")
    public String displayCreateEmotionForm(Model model) {
        model.addAttribute("title", "Create Emotion");
        model.addAttribute("emotion", new Emotion());
        return "emotions/create.html";
    }

    //Lives at emotions/create
    @PostMapping("create")
    public String processCreateEmotionForm(@ModelAttribute @Valid Emotion newEmotion,
                                        Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Emotion");
            return "emotions/create.html";
        }
        emotionRepository.save(newEmotion);
        return "redirect:";
    }

    //Lives at emotions/delete
    @GetMapping("delete")
    public String displayDeleteEmotionForm(Model model) {
        model.addAttribute("title", "Delete Emotion");
        model.addAttribute("emotions", emotionRepository.findAll());
        return "emotions/delete.html";
    }

    //Lives at emotions/delete
    @PostMapping("delete")
    public String processDeleteEmotionForm(@RequestParam(required= false) int[] emotionIds) {
        if (emotionIds != null) {
            for (int id : emotionIds) {
                emotionRepository.deleteById(id);
            }
        }
        return "redirect:";
    }
}
