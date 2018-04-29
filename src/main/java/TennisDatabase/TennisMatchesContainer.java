package TennisDatabase;

public class TennisMatchesContainer implements TennisMatchesContainerInterface {
    private final int INITIALSIZE = 2;
    private int matchCount = 0;
    private TennisMatch[] matches = new TennisMatch[INITIALSIZE];

    @Override
    public void insertMatch(TennisMatch tennisMatch) throws TennisDatabaseRuntimeException {

        if (matchCount >= matches.length) {
            TennisMatch[] newMatches = new TennisMatch[matches.length * 2];
            for (int i = 0; i < matches.length; i++) {
                newMatches[i] = matches[i];
            }
            matches = newMatches;
        }
//TODO change to sort upon insert
        matches[matchCount] = tennisMatch;
        matchCount++;
    }

    @Override
    public void printAllMatches() throws TennisDatabaseRuntimeException {
        for(int i =0; i< matchCount;i++){
            matches[i].print();
        }
    }
}
