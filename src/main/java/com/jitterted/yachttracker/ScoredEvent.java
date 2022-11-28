package com.jitterted.yachttracker;

/**
 * This is the inbound event sent to the API controller
 * It is our "domain" "Value Objects"
 */
public class ScoredEvent {
    private final int score;
    private final String category;
    private final String roll;

    public ScoredEvent(int score, String category, String roll) {
        this.score = score;
        this.category = category;
        this.roll = roll;
    }

    public int getScore() {
        return score;
    }

    public String getCategory() {
        return category;
    }

    public String getRoll() {
        return roll;
    }
}
