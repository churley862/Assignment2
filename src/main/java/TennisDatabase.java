
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TennisDatabase {
    public TennisPlayer searchTennisPlayer(String id){
        return null;
    }
    public void printTennisPlayerMatches(String id){
        System.out.println("");
    }
    public void loadFromFile(String fName) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(fName));
        while (sc.hasNextLine()) {
            parseLine(sc.nextLine());
        }
    }

    private void parseLine(String s) {
        Scanner sc = new Scanner(s).useDelimiter("/");
        String lineType = sc.next();
        if(lineType.equalsIgnoreCase("Player")){
            addPlayer(sc.next(),sc.next(),sc.next(),sc.next(),sc.next());
        }else if (lineType.equalsIgnoreCase("Match")){
            addMatch(sc.next(),sc.next(),sc.next(),sc.next(),sc.next());
        }

    }

    private void addMatch(String player1, String player2, String date, String title, String scores) {
        System.out.println("player1 " + player1);
        System.out.println("player2 " +player2);
        System.out.println("date " + date);
        System.out.println("title " + title);
        System.out.println("scores " + scores);
    }

    private void addPlayer(String id, String fName, String lName, String year, String country) {
        System.out.println("id " + id);
        System.out.println("first name " + fName);
        System.out.println("last name " + lName);
        System.out.println("year " + year);
        System.out.println("country" + country);
    }

}
