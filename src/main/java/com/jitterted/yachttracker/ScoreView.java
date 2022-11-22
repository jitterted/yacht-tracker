package com.jitterted.yachttracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This is the view model for display in the HTML template
 */
public class ScoreView {
    private Long id;

    private String score;
    private String category;
    private String roll;
    private String receivedOn;

    public ScoreView(ScoredEvent scoredEvent) {
        receivedOn = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getReceivedOn() {
        return receivedOn;
    }

    public void setReceivedOn(String receivedOn) {
        this.receivedOn = receivedOn;
    }
}
