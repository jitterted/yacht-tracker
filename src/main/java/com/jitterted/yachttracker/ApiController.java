package com.jitterted.yachttracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    private final ScoreViewRepository scoreViewRepository;

    @Autowired
    public ApiController(ScoreViewRepository scoreViewRepository) {
        this.scoreViewRepository = scoreViewRepository;
    }

    @PostMapping("/api/scores")
    public ResponseEntity<String> receiveScoredEvent(@RequestBody ScoredEvent scoredEvent) {
        ScoreView scoreView = new ScoreView(scoredEvent);
        scoreViewRepository.save(scoreView);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/scores")
    public ResponseEntity<String> clearResults() {
        scoreViewRepository.clear();

        return ResponseEntity.noContent().build();
    }

}
