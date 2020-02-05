package com.petermarshall;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreTest {
    private Score score;

    @Before
    public void setup() {
        score = new Score();
    }

    @Test
    public void initialPointsShouldBeZero() {
        assertEquals(0, score.getPoints());
    }

    @Test
    public void canIncrementPoints() {
        int initialPoints = score.getPoints();
        score.addPoint();
        assertEquals(initialPoints+1, score.getPoints());
        score.addPoint();
        assertEquals(initialPoints+2, score.getPoints());
    }

    @Test
    public void canTranslateScoresToNaturalLanguage() {
        String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};
        for (int i = 0; i<scores.length; i++) {
            score.setPoints(i);
            assertEquals(scores[i], score.toString());
        }
    }
}
