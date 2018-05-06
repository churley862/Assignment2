package TennisDatabase;

public class TennisMatchesList implements TennisMatchesListInterface {
    private TennisMatchesNode head = null;

    @Override
    public void insertMatch(TennisMatch m) throws TennisDatabaseRuntimeException {
        TennisMatchesNode node = new TennisMatchesNode(m);

        if (head == null) {
            head = node;
            node.setNext(node);
            node.setPrev(node);
        } else {

            TennisMatchesNode insertPoint = head;
            while (insertPoint.getMatch().compareTo(m) < 0) {
                insertPoint = insertPoint.getNext();

                if (insertPoint == head) break;
            }

            node.setNext(insertPoint);
            node.setPrev(insertPoint.getPrev());
            insertPoint.setPrev(node);
            node.getPrev().setNext(node);

            // handle special case inserting at front of list
            if (head == insertPoint && insertPoint.getMatch().compareTo(m) > 0) {
                head = node;
            }
        }
    }

    @Override
    public void printMatches() throws TennisDatabaseRuntimeException {
        TennisMatchesNode node = head;
        if (node != null) {
            do {
                node.getMatch().print();
                node = node.getNext();
            } while (node != head);
        }else{
            System.out.println("There are no matches for this player");
        }
    }
}
