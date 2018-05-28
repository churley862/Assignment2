package TennisDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TennisMatchesContainer implements TennisMatchesContainerInterface {
    private List<TennisMatch> matches = new ArrayList<TennisMatch>();

    // Need to ask about self contained insert and sort
    @Override
    public void insertMatch(TennisMatch tennisMatch) throws TennisDatabaseRuntimeException {
        matches.add(tennisMatch);
        //Collections.sort(matches,(TennisMatch m1, TennisMatch m2) -> m1.compareTo(m2));
    }

    @Override
    public void printAllMatches() throws TennisDatabaseRuntimeException {
        for (TennisMatch match : matches) {
            match.print();
        }
    }
}
