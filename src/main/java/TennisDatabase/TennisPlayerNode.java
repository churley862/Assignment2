package TennisDatabase;

public class TennisPlayerNode implements TennisPlayerNodeInterface {
    private TennisPlayer player;
    private TennisPlayerNodeInterface next, prev;

    public TennisPlayerNode(TennisPlayer player) {
        this.player = player;
        next = null;
        prev = null;
    }

    @Override
    public TennisPlayer getPlayer() {
        return player;
    }

    @Override
    public TennisPlayerNodeInterface getPrev() {
        return prev;
    }

    @Override
    public TennisPlayerNodeInterface getNext() {
        return next;
    }

    @Override
    public void printMatches() throws TennisDatabaseRuntimeException {
    }

    @Override
    public void insertMatch(TennisMatch m) throws TennisDatabaseRuntimeException {
    }

    @Override
    public void setNext(TennisPlayerNodeInterface n) {
        next = n;
    }

    @Override
    public void setPrev(TennisPlayerNodeInterface p) {
        prev = p;
    }
}
