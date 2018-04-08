
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
            addPlayer(new TennisPlayer(sc.next(),sc.next(),sc.next(),sc.next(),sc.next()));
        }else if (lineType.equalsIgnoreCase("Match")){
            addMatch(new TennisMatch(sc.next(),sc.next(),sc.next(),sc.next(),sc.next()));
        }

    }

    private void addPlayer(TennisPlayer tennisPlayer) {
        tennisPlayer.print();
    }

    private void addMatch(TennisMatch tennisMatch) {
        tennisMatch.print();
    }
}
