package TennisDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TennisMatchesContainer implements TennisMatchesContainerInterface {
    private List<TennisMatch> matches = new ArrayList<TennisMatch>();

    // Need to ask about self contained insert and sort
    @Override
    public void insertMatch(TennisMatch tennisMatch) throws TennisDatabaseRuntimeException {
        int insert_point = 0;
        while (insert_point < matches.size() && matches.get(insert_point).compareTo(tennisMatch) > 0) {
            insert_point++;
        }
        matches.add(insert_point,tennisMatch);
      }

    @Override
    public void printAllMatches() throws TennisDatabaseRuntimeException {
        for (TennisMatch match : matches) {
            match.print();
        }
    }

    public String returnAllMatches() throws TennisDatabaseRuntimeException {
        String allMatches ="";
        for (TennisMatch match : matches) {
            if (!allMatches.isEmpty()){
                allMatches = allMatches + "\n" + match.toString();
            }else{
                allMatches = match.toString();
            }
        }
        return allMatches;
    }
}
