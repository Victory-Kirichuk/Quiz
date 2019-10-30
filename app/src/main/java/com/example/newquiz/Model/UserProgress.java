package com.example.newquiz.Model;

public class UserProgress {
    private String name;
    public int score;

    public UserProgress() {
    }

    public UserProgress(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
