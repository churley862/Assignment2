package TennisDatabase;

public class TennisMatchesNode {
    public TennisMatch match;
    public TennisMatchesNode next;

    public TennisMatchesNode(TennisMatch match){
        this.match = match;
        next = null;
    }
    public TennisMatch getMatch() {
        return match;
    }

    public TennisMatchesNode getNext() {
        return next;
    }

    public void setNext(TennisMatchesNode n) {
        next = n;
    }

}
