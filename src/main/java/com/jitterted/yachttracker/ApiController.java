package com.jitterted.yachttracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    private final ScoreEventRepository scoreEventRepository;

    @Autowired
    public ApiController(ScoreEventRepository scoreEventRepository) {
        this.scoreEventRepository = scoreEventRepository;
    }

    @PostMapping("/api/scores")
    public ResponseEntity<String> receiveScoredEvent(@RequestBody ScoredEvent scoredEvent) {
        scoreEventRepository.save(scoredEvent);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/api/averages")
    public ResponseEntity<CategoryAverage> averageForCategory(@RequestParam("scoreCategory") String scoreCategory) {
        double average = scoreEventRepository.findAll()
                                             .stream()
                                             .filter(scoredEvent -> scoredEvent.getCategory().equals(scoreCategory))
                                             .mapToInt(ScoredEvent::getScore)
                                             .average()
                                             .orElse(0.0);
        return ResponseEntity.ok(new CategoryAverage(scoreCategory, average));
    }

    @DeleteMapping("/api/scores")
    public ResponseEntity<String> clearResults() {
        scoreEventRepository.clear();

        return ResponseEntity.noContent().build();
    }

}
