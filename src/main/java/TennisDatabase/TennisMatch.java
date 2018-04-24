package TennisDatabase;

public class TennisMatch implements TennisMatchInterface{
    @Override
    public String getPlayer1Id() {
        return null;
    }

    @Override
    public String getPlayer2Id() {
        return null;
    }

    @Override
    public int getDateYear() {
        return 0;
    }

    @Override
    public int getDateMonth() {
        return 0;
    }

    @Override
    public int getDateDay() {
        return 0;
    }

    @Override
    public String getTournament() {
        return null;
    }

    @Override
    public String getScore() {
        return null;
    }

    @Override
    public int getWinner() {
        return 0;
    }

    public void print() {
        System.out.println("player1 " + player1);
        System.out.println("player2 " + player2);
        System.out.println("date " + date);
        System.out.println("title " + title);
        System.out.println("scores " + scores);
    }
    private String player1;
    private String player2;
    private String date;
    private String title;
    private String scores;
    TennisMatch(String player1, String player2, String date, String title, String scores){
        this.player1 = player1;
        this.player2 = player2;
        this.date = date;
        this.title = title;
        this. scores = scores;
    }
    public int compareTo(TennisMatch o) {
        return 0;
    }
}
