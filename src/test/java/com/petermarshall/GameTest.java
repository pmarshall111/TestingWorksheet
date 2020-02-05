package com.petermarshall;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    private Game game;

    @Before
    public void setup() {
        game = new Game(new Player("Novak Djokovic"), new Player("Rafael Nadal"));
    }

    @Test
    public void canDetectDeuce() {
        game.getPlayer1().winPoints();
        game.getPlayer1().winPoints();
        game.getPlayer1().winPoints();
        game.getPlayer1().winPoints();
        game.getPlayer2().winPoints();
        game.getPlayer2().winPoints();
        game.getPlayer2().winPoints();
        assertFalse(game.isDeuce());
        game.getPlayer2().winPoints();
        assertTrue(game.isDeuce());
    }

    @Test
    public void canDetectAdvantage() {
        game.getPlayer1().winPoints();
        game.getPlayer1().winPoints();
        game.getPlayer1().winPoints();
        game.getPlayer1().winPoints();
        game.getPlayer2().winPoints();
        game.getPlayer2().winPoints();
        game.getPlayer2().winPoints();
        game.getPlayer2().winPoints();
        //40-40
        assertFalse(game.isAdvantage());
        game.getPlayer2().winPoints();
        assertTrue(game.isAdvantage());
        game.getPlayer1().winPoints();
        assertFalse(game.isAdvantage());
        game.getPlayer1().winPoints();
        assertTrue(game.isAdvantage());
    }

    @Test
    public void canDetectWinner() {
        game.getPlayer1().winPoints();
        game.getPlayer1().winPoints();
        game.getPlayer1().winPoints();
        game.getPlayer1().winPoints();
        game.getPlayer1().winPoints();
        assertTrue(game.hasWinner());
    }

    @Test
    public void canDetermineWinnerPlayer1() {
        game.getPlayer1().winPoints();
        game.getPlayer1().winPoints();
        game.getPlayer1().winPoints();
        game.getPlayer1().winPoints();
        game.getPlayer1().winPoints();
        assertEquals(game.getPlayer1(), game.getWinner());
    }

    @Test
    public void canDetermineWinnerPlayer2() {
        game.getPlayer2().winPoints();
        game.getPlayer2().winPoints();
        game.getPlayer2().winPoints();
        game.getPlayer2().winPoints();
        game.getPlayer2().winPoints();
        assertEquals(game.getPlayer2(), game.getWinner());
    }


    @Test
    public void canReportGameScoreFourNill() {
        String[] fourNillScores = {"Love all", "Fifteen Love", "Thirty Love", "Forty Love", game.getPlayer1().getName() + " wins"};
        int[] fourNillInstr = {1,1,1,1};
        testScoresOfGame(fourNillScores, fourNillInstr);
    }

    @Test
    public void canReportGameScoreFourOne() {
        String[] fourOneScores = {"Love all", "Love Fifteen", "Fifteen all", "Thirty Fifteen", "Forty Fifteen", game.getPlayer1().getName() + " wins"};
        int[] fourOneInstr = {2,1,1,1,1};
        testScoresOfGame(fourOneScores, fourOneInstr);
    }

    @Test
    public void canReportGameScoreFourTwo() {
        String[] fourTwoScores = {"Love all", "Love Fifteen", "Love Thirty", "Fifteen Thirty", "Thirty all", "Forty Thirty", game.getPlayer1().getName() + " wins"};
        int[] fourTwoInstr = {2,2,1,1,1,1};
        testScoresOfGame(fourTwoScores, fourTwoInstr);
    }

    @Test
    public void canReportGameScoreFiveThree() {
        String[] fiveThreeScores = {"Love all", "Love Fifteen", "Love Thirty", "Love Forty", "Fifteen Forty", "Thirty Forty", "Deuce", "Advantage "+game.getPlayer1().getName(), game.getPlayer1().getName() + " wins"};
        int[] fiveThreeInstr = {2,2,2,1,1,1,1,1};
        testScoresOfGame(fiveThreeScores, fiveThreeInstr);
    }

    @Test
    public void canReportGameScoreThreeFive() {
        String[] threeFiveScores = {"Love all", "Love Fifteen", "Love Thirty", "Love Forty", "Fifteen Forty", "Thirty Forty", "Deuce", "Advantage "+game.getPlayer2().getName(), game.getPlayer2().getName() + " wins"};
        int[] threeFiveInstr = {2,2,2,1,1,1,2,2};
        testScoresOfGame(threeFiveScores, threeFiveInstr);
    }

    private void testScoresOfGame(String[] scores, int[] instructions) {
        assertEquals(scores[0], game.getGameScore());
        for (int i = 1; i<scores.length; i++) {
            if (instructions[i-1] == 1) {
                game.getPlayer1().winPoints();
            } else if (instructions[i-1] == 2) {
                game.getPlayer2().winPoints();
            }
            assertEquals(scores[i], game.getGameScore());
        }
    }

}
