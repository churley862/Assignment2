package TennisDatabase;

public class TennisPlayerNode implements TennisPlayerNodeInterface {
    private TennisPlayer player;
    private TennisPlayerNodeInterface next, prev;
    private TennisMatchesList list;

    public TennisPlayerNode(TennisPlayer player) {
        this.player = player;
        list = new TennisMatchesList();

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
        list.printMatches();
    }

    @Override
    public void insertMatch(TennisMatch m) throws TennisDatabaseRuntimeException {
        list.insertMatch(m);
        if (m.getWinnerId().equals(player.getId())) {
            player.addWin();
        } else {
            player.addLoss();
        }
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
