package TennisDatabase;

import java.util.Scanner;


public class TennisMatch implements TennisMatchInterface {
    @Override
    public String getPlayer1Id() {
        return player1;
    }

    @Override
    public String getPlayer2Id() {
        return player2;
    }

    @Override
    public int getDateYear() {
        return year;
    }

    @Override
    public int getDateMonth() {
        return month;
    }

    @Override
    public int getDateDay() {
        return day;
    }

    @Override
    public String getTournament() {
        return event;
    }

    @Override
    public String getScore() {
        return scores;
    }

    @Override
    public int getWinner() {
        // TODO implement recursive match winner function that sets the winner
        return recursiveGetWinner();

    }

    public void print() {
        System.out.println("player1 " + player1);
        System.out.println("player2 " + player2);
        System.out.println("date: " + month + "/" + day + "/" + year);
        System.out.println("event " + event);
        System.out.println("scores " + scores);
        if (getWinner() == 1) {
            System.out.println("player 1 won the match");
        } else {
            System.out.println("player 2 won the match");

        }
    }

    private String player1;
    private String player2;
    private int day;
    private int month;
    private int year;
    private String event;
    private String scores;

    TennisMatch(String player1, String player2, int year, int month, int day, String event, String scores) {
        this.player1 = player1;
        this.player2 = player2;
        this.day = day;
        this.month = month;
        this.year = year;
        this.event = event;
        this.scores = scores;
    }

    public int compareTo(TennisMatch o) {
        return 0;
    }

    public int recursiveGetWinner() {
        Scanner sc = new Scanner(scores);
        return recursiveGetWinner(sc, 0);
    }

    public int recursiveGetWinner(Scanner scores, int win) {
        scores.useDelimiter("-");
        int score1 = scores.nextInt();
        scores.skip("-");
        scores.useDelimiter(",");
        int score2 = scores.nextInt();

        if (scores.hasNext()) {
            scores.skip(",");
            return recursiveGetWinner(scores, (score1 > score2) ? win + 1 : win - 1);
        } else {
            if (win == 0) return -1;
            return (win > 0) ? 1 : 2;
        }
    }
}