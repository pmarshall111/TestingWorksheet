package com.petermarshall;

public class Game {
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getGameScore(){

        switch(findGameState()){
            case 'g': return player1.getScore().toString() + " " + player2.getScore().toString(); //Regular Game
            case 'e': return player1.getScore().toString() + " all"; //Regular Game
            case 'd': return "Deuce"; //Deuce
            case 'a': return player1HasHigherScore() ? "Advantage " + player1.getName(): "Advantage " + player2.getName(); // Advantage
            case 'w': return player1HasHigherScore() ? player1.getName() + " wins" : player2.getName() + " wins"; //There is a winner
            default : break;
        }
        return "Error in retrieving game score!";
    }

    boolean hasWinner(){
        return (anyPlayerScoredAtLeastFourPoints() && (pointDifferenceBetweenPlayers() >= 2));
    }

    boolean isDeuce(){
        return (bothPlayersScoredAtLeastThreePoints() && playersHaveEqualPoints());
    }

    boolean isAdvantage(){
        return (bothPlayersScoredAtLeastThreePoints() && pointDifferenceBetweenPlayers() == 1);
    }

    private boolean anyPlayerScoredAtLeastFourPoints() {
        return player1.getScore().getPoints() > 3 || player2.getScore().getPoints() > 3;
    }

    private boolean bothPlayersScoredAtLeastThreePoints() {
        return player1.getScore().getPoints() >= 3 && player2.getScore().getPoints() >= 3;
    }

    private boolean playersHaveEqualPoints() {
        return pointDifferenceBetweenPlayers() == 0;
    }

    private boolean player1HasHigherScore() {
        return player1.getScore().getPoints() > player2.getScore().getPoints();
    }

    private int pointDifferenceBetweenPlayers() {
        return Math.abs(player1.getScore().getPoints() - player2.getScore().getPoints());
    }

    private char findGameState() {
        if(hasWinner())
            return 'w'; //There is a winner
        if(isDeuce())
            return 'd'; //Deuce
        if(isAdvantage())
            return 'a'; //Advantage

        return playersHaveEqualPoints()? 'e':'g';//'e'qual points in regular game or just a regular 'g'ame
    }

    public Player getPlayer1() {
        return this.player1;
    }

    public Player getPlayer2() {
        return this.player2;
    }

    public Player getWinner() {
        if (findGameState() == 'w') {
            if (player1HasHigherScore()) {
                return player1;
            } else {
                return player2;
            }
        } else {
            return null;
        }
    }
}
