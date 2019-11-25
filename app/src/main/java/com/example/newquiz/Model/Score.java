package com.example.newquiz.Model;

public class Score   implements Comparable<Score>{

    private Integer score = 0;

    private String name;

    public void increaseScore(){
        score++;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void resetScore(){
        score = 0;
    }


    @Override
    public int compareTo(Score score) {
        return this.getScore() > score.getScore() ? -1 : this.getScore().equals(score.getScore()) ? 0 : 1 ;

    }
}
