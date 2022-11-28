package com.jitterted.yachttracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This is the view model for display in the HTML template
 */
public class ScoreView {
    private String score;
    private String category;
    private String roll;
    private String receivedOn;

    public ScoreView(ScoredEvent scoredEvent) {
        score = String.valueOf(scoredEvent.getScore());
        category = scoredEvent.getCategory();
        roll = scoredEvent.getRoll();
        receivedOn = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
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
