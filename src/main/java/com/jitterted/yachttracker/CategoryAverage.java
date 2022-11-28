package com.jitterted.yachttracker;

/*
 {
   "category": "SIXES",
   "average": 27.55
 }
 */
public class CategoryAverage {
    private final String category;
    private final double average;

    public CategoryAverage(String category, double average) {
        this.category = category;
        this.average = average;
    }

    public String getCategory() {
        return category;
    }

    public double getAverage() {
        return average;
    }
}
