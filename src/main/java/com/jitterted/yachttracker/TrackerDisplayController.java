package com.jitterted.yachttracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TrackerDisplayController {

    private final ScoreViewRepository scoreViewRepository;

    @Autowired
    public TrackerDisplayController(ScoreViewRepository scoreViewRepository) {
        this.scoreViewRepository = scoreViewRepository;
    }

    @GetMapping("/")
    public String viewScores(Model model) {
        List<ScoreView> scores = scoreViewRepository.findAll();
        model.addAttribute("scores", scores);
        return "tracker";
    }

    @GetMapping("/clear")
    public String clearResults() {
        scoreViewRepository.clear();
        return "redirect:/";
    }

}
