package TennisDatabase;

public class TennisMatchesList implements TennisMatchesListInterface {
    private TennisMatchesNode head = null;
    private TennisMatchesNode tail = null;

    @Override
    public void insertMatch(TennisMatch m) throws TennisDatabaseRuntimeException {
        TennisMatchesNode node = new TennisMatchesNode(m);

        if (head == null) {
            head = node;
            tail = node;
        } else {

            TennisMatchesNode insertPoint = head;
            while (insertPoint != null && insertPoint.getMatch().compareTo(m) < 0) {
                insertPoint = insertPoint.getNext();
            }

            if (insertPoint == null) {
                tail.setNext(node);
            } else {
                node.setNext(insertPoint.getNext());
                insertPoint.setNext(node);
            }

            if (node.getNext() == null) {
                tail = node;
            }
        }
        // search for the point to insert
        // create new node storing input tennis match
        // check if insertion point is at the front for a special case
        // if not then standard case
    }

    @Override
    public void printMatches() throws TennisDatabaseRuntimeException {
        TennisMatchesNode node = head;
        while (node != null) {
            node.getMatch().print();
            node = node.getNext();
        }
    }
}
