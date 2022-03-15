package org.launchcode.capstoneproject.controllers;

import org.launchcode.capstoneproject.data.EmotionRepository;
import org.launchcode.capstoneproject.data.MoodRepository;
import org.launchcode.capstoneproject.models.Emotion;
import org.launchcode.capstoneproject.models.Mood;
import org.launchcode.capstoneproject.models.MoodType;
import org.launchcode.capstoneproject.models.dto.MoodEmotionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("moods")
public class MoodController {

    @Autowired
    private MoodRepository moodRepository;

    @Autowired
    private EmotionRepository emotionRepository;

    //Lives at /moods
    @GetMapping
    public String displayAllMoods(Model model) {
        model.addAttribute("moods", moodRepository.findAll());
        return "moods/index.html";
    }

    //Lives at moods/create
    @GetMapping("create")
    public String displayCreateMoodForm(Model model) {
        model.addAttribute("title", "Create Mood");
        model.addAttribute("mood", new Mood());
        model.addAttribute("types", MoodType.values());
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
        moodRepository.save(newMood);
        return "redirect:";
    }

    //Lives at moods/delete
    @GetMapping("delete")
    public String displayDeleteMoodForm(Model model) {
        model.addAttribute("title", "Delete Mood");
        model.addAttribute("moods", moodRepository.findAll());
        return "moods/delete.html";
    }

    //Lives at moods/delete
    @PostMapping("delete")
    public String processDeleteMoodForm(@RequestParam(required= false) int[] moodIds) {
        if (moodIds != null) {
            for (int id : moodIds) {
                moodRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

    //Lives at moods/detail
    @GetMapping("detail")
    public String displayMoodDetails(@RequestParam Integer moodId, Model model) {
        Optional<Mood> result = moodRepository.findById(moodId);

        if(result.isEmpty()) {
            model.addAttribute("title", "Invalid Event Id: " + moodId);
        } else {
            Mood mood = result.get();
            model.addAttribute("title", mood.getName() + " Details");
            model.addAttribute("mood", mood);
            model.addAttribute("emotions", mood.getEmotions());
        }
        return "moods/detail";
    }

    //Lives at moods/add-emotion?moodId=
    @GetMapping("add-emotion")
    public String displayAddEmotionForm(@RequestParam Integer moodId, Model model) {
        Optional<Mood> result = moodRepository.findById(moodId);
        Mood mood = result.get();
        model.addAttribute("title", "Add Emotion to " + mood.getName());
        model.addAttribute("Emotions", emotionRepository.findAll());
        MoodEmotionDTO moodEmotion = new MoodEmotionDTO();
        moodEmotion.setMood(mood);
        model.addAttribute("moodEmotion", moodEmotion);
        return "moods/add-emotion.html";
    }

    @PostMapping("add-emotion")
    public String processAddEmotionForm(@ModelAttribute @Valid MoodEmotionDTO moodEmotion,
                                        Errors errors,
                                        Model model) {
        if (!errors.hasErrors()) {
            Mood mood = moodEmotion.getMood();
            Emotion emotion = moodEmotion.getEmotion();
            if(!mood.getEmotions().contains(emotion)){
                mood.addEmotion(emotion);
                moodRepository.save(mood);
            }
            return "redirect:detail?moodId=" + mood.getId();
        }
        return "redirect:add-emotion.html";
    }
}
