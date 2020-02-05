package com.petermarshall;

public class Score {

    private int points;

    public Score() {
        this.points = 0;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int point) {
        this.points = point;
    }

    public void addPoint(){
        this.points++;
    }

    public String toString(){
        switch(this.points){
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            case 3: return "Forty";
            default: return "Illegal Score";
        }

    }
}