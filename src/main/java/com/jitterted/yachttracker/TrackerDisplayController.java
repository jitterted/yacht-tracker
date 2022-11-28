package com.jitterted.yachttracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TrackerDisplayController {

    private final ScoreEventRepository scoreEventRepository;

    @Autowired
    public TrackerDisplayController(ScoreEventRepository scoreEventRepository) {
        this.scoreEventRepository = scoreEventRepository;
    }

    @GetMapping("/")
    public String viewScores(Model model) {
        List<ScoreView> scores = scoreEventRepository
                .findAll()
                .stream()
                .map(ScoreView::new)
                .collect(Collectors.toList());

        model.addAttribute("scores", scores);
        return "tracker";
    }

    @GetMapping("/clear")
    public String clearResults() {
        scoreEventRepository.clear();
        return "redirect:/";
    }

}
