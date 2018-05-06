package TennisDatabase;

public class TennisMatchesContainer implements TennisMatchesContainerInterface {
    private final int INITIALSIZE = 2;
    private int matchCount = 0;
    private TennisMatch[] matches = new TennisMatch[INITIALSIZE];

    @Override
    public void insertMatch(TennisMatch tennisMatch) throws TennisDatabaseRuntimeException {
        int insert_point = 0;
        if (matchCount >= matches.length) {
            TennisMatch[] newMatches = new TennisMatch[matches.length * 2];
            for (int i = 0; i < matches.length; i++) {
                newMatches[i] = matches[i];
            }
            matches = newMatches;
        }
//TODO fix explosion
        while (insert_point < matchCount && matches[insert_point].compareTo(tennisMatch) > 0) {
            insert_point++;
        }

        for (int i = matchCount; i > insert_point; --i) {
            matches[i] = matches[i - 1];
        }

        matches[insert_point] = tennisMatch;
        matchCount++;
    }

    @Override
    public void printAllMatches() throws TennisDatabaseRuntimeException {
        for(int i =0; i< matchCount;i++){
            matches[i].print();
        }
    }
}
