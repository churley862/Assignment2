public class TennisMatch {
    public void print(){
        System.out.println("player1 " + player1);
        System.out.println("player2 " +player2);
        System.out.println("date " + date);
        System.out.println("title " + title);
        System.out.println("scores " + scores);
    }
    private String player1;
    private String player2;
    private String date;
    private String title;
    private String scores;
    public TennisMatch(String player1,String player2, String date, String title,String scores){
        this.player1 = player1;
        this.player2 = player2;
        this.date = date;
        this.title = title;
        this. scores = scores;
    }
}
