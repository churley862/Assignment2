package TennisDatabase;

import java.util.Scanner;


public class TennisMatch implements TennisMatchInterface {
    @Override
    public  String getPlayer1Id() {
        return player1.getId();
    }

    @Override
    public String getPlayer2Id() {
        return player2.getId();
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
        return recursiveGetWinner();
    }


    public void print(){
        System.out.println("" + year + "/" + month + "/" + day + " " + player1.getId() + "-" + player2.getId() +
        " "+ event + " " + scores);
    }

    private TennisPlayer player1;
    private TennisPlayer player2;
    private int day;
    private int month;
    private int year;
    private String event;
    private String scores;

    TennisMatch(TennisPlayer player1, TennisPlayer player2, int year, int month, int day, String event, String scores) {
        this.player1 = player1;
        this.player2 = player2;
        this.day = day;
        this.month = month;
        this.year = year;
        this.event = event;
        this.scores = scores;
    }

    private int dateAsInt() {
        return (year *10000) + (month * 100) + day;
    }

    public int compareTo(TennisMatch o) {
        // arbitrary value to calculate date is older
        int dateVal = o.dateAsInt();
        int newDateVal = dateAsInt();
        if (dateVal > newDateVal)
        { return -1; }
        else if (dateVal == newDateVal)
        { return 0; }
        else
        { return 1; }
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

    public String getWinnerId() {
        if (getWinner() == 1) {
            return player1.getId();
        } else {
            return player2.getId();

        }
    }
}