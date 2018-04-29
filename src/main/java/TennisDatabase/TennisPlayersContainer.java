package TennisDatabase;

public class TennisPlayersContainer implements TennisPlayersContainerInterface {
//Todo impliment linked list sorting on insert
    TennisPlayerNodeInterface head;
    TennisPlayerNodeInterface tail;

    public TennisPlayersContainer() {
        head = null;
        tail = null;
    }

    @Override
    public void insertPlayer(TennisPlayer player) throws TennisDatabaseRuntimeException {
        TennisPlayerNodeInterface insert_point = head;

        // find correct insert point
        while (insert_point != null && insert_point.getPlayer().compareTo(player) < 0) {
            insert_point = insert_point.getNext();
        }

        insertBefore(player, insert_point);
    }

    public void insertBefore(TennisPlayer player, TennisPlayerNodeInterface insert_point) {
        TennisPlayerNodeInterface node = new TennisPlayerNode(player);

        if (head == null) {
            // special case first node
            head = node;
            tail = node;
        } else {
            if (insert_point == null) {
                // insert at end of list
                node.setPrev(tail);
                tail.setNext(node);
                tail = node;
            } else {
                node.setNext(insert_point);
                node.getNext().setPrev(node);
                node.setPrev(insert_point.getPrev());

                if (insert_point.getPrev() == null) {
                    head = node;
                } else {
                    node.getPrev().setNext(node);
                }
            }
        }
    }

    @Override
    public void insertMatch(TennisMatch match) throws TennisDatabaseRuntimeException {

    }

    @Override
    public void printAllPlayers() throws TennisDatabaseRuntimeException {
        TennisPlayerNodeInterface node = head;

        while (node != null) {
            node.getPlayer().print();
            node = node.getNext();
        }
    }

    @Override
    public void printMatchesOfPlayer(String playerId) throws TennisDatabaseRuntimeException {

    }
}
