package TennisDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TennisDatabase implements TennisDatabaseInterface {
    private TennisPlayersContainer players = new TennisPlayersContainer();
    private TennisMatchesContainer matches = new TennisMatchesContainer();
    public TennisPlayer searchTennisPlayer(String id){
        return null;
    }
    public void loadFromFile(String fName) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(fName));
        while (sc.hasNextLine()) {
            parseLine(sc.nextLine());
        }
        //
        // matches.printAll();
    }
// TODO check for bad data lines
    public void parseLine(String s) {
        Scanner sc = new Scanner(s).useDelimiter("/");
        String lineType = sc.next();
        if(lineType.equalsIgnoreCase("Player")){
            players.addPlayer(new TennisPlayer(sc.next(),sc.next(),sc.next(),sc.nextInt(),sc.next()));
        }
        else if (lineType.equalsIgnoreCase("Match")){
            matches.insertMatch(new TennisMatch(sc.next(),sc.next(),sc.next(),sc.next(),sc.next()));
        }else
        {
            System.out.println("The inputed data"+ s + "is invalid");
        }

    }


    @Override
    public void printAllPlayers() throws TennisDatabaseRuntimeException {
        players.print();
    }

    @Override
    public void printMatchesOfPlayer(String playerId) throws TennisDatabaseRuntimeException {

    }

    @Override
    public void printAllMatches() throws TennisDatabaseRuntimeException {
        matches.printAllMatches();
    }

    @Override
    public void insertPlayer(String id, String firstName, String lastName, int year, String country) throws TennisDatabaseRuntimeException {

    }

    @Override
    public void insertMatch(String idPlayer1, String idPlayer2, int year, int month, int day, String tournament, String score) throws TennisDatabaseRuntimeException {

    }
}
