public class TennisMatchesContainer {
    private final int INITIALSIZE = 2;
    private int matchCount = 0;
    public void printAll(){
        for(int i =0; i< matchCount;i++){
            matches[i].print();
        }
    }
    private TennisMatch[] matches = new TennisMatch[INITIALSIZE];
    public void addMatch(TennisMatch tennisMatch) {

        if (matchCount >= matches.length) {
            TennisMatch[] newMatches = new TennisMatch[matches.length * 2];
            for (int i = 0; i < matches.length; i++) {
                newMatches[i] = matches[i];
            }
            matches = newMatches;
        }
//TODO change where the insert occurs
            matches[matchCount] = tennisMatch;
        matchCount++;
    }

}
