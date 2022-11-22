package com.jitterted.yachttracker;

/**
 * This is the inbound event sent to the API controller
 */
public class ScoredEvent {
    private final String score;
    private final String category;
    private final String roll;

    public ScoredEvent(String score, String category, String roll) {
        this.score = score;
        this.category = category;
        this.roll = roll;
    }

    public String getScore() {
        return score;
    }

    public String getCategory() {
        return category;
    }

    public String getRoll() {
        return roll;
    }
}
