package TennisDatabase;

public class TennisPlayersContainer implements TennisPlayersContainerInterface {
    TennisPlayerNodeInterface head;

    public TennisPlayersContainer() {
        head = null;
    }

    @Override
    public void insertPlayer(TennisPlayer player) throws TennisDatabaseRuntimeException {
        if (head == null) {
            insertFirstNode(player);
        } else {
            TennisPlayerNodeInterface insert_point = head;

            // find correct insert point
            while (insert_point.getPlayer().compareTo(player) < 0) {
                insert_point = insert_point.getNext();
                if (insert_point == head) break;
            }

            if (insert_point.getPlayer().compareTo(player) == 0) {
                insert_point.getPlayer().updatePlayer(player);
            } else {
                insertBefore(player, insert_point);
            }
        }
    }

    private void insertFirstNode(TennisPlayer player) {
        if (head != null) {
            throw new RuntimeException("list already populated, cannot call insertFirstNode");
        }

        TennisPlayerNodeInterface node = new TennisPlayerNode(player);
        head = node;
        node.setNext(node);
        node.setPrev(node);
    }

    public void insertBefore(TennisPlayer player, TennisPlayerNodeInterface insert_point) {

        if (head == null) {
            insertFirstNode(player);
        } else {
            TennisPlayerNodeInterface node = new TennisPlayerNode(player);
            node.setNext(insert_point);
            node.setPrev(insert_point.getPrev());
            insert_point.setPrev(node);
            node.getPrev().setNext(node);

            // handle special case inserting at front of list
            if (head == insert_point && insert_point.getPlayer().compareTo(player) > 0) {
                head = node;
            }
        }
    }

    // TODO dummy player stuff
    @Override
    public void insertMatch(TennisMatch match) throws TennisDatabaseRuntimeException {
       // check for both players in our list
        // if the player exists then

        TennisPlayerNodeInterface node = getPlayerById(match.getPlayer1Id());
        if (node == null) {
            TennisPlayer player = new TennisPlayer(match.getPlayer1Id());
            insertPlayer(player);
            node = getPlayerById(match.getPlayer1Id());
        }
        node.insertMatch(match);

        node = getPlayerById(match.getPlayer2Id());
        if (node == null) {
            TennisPlayer player = new TennisPlayer(match.getPlayer2Id());
            insertPlayer(player);
            node = getPlayerById(match.getPlayer2Id());
        }
        node.insertMatch(match);
    }

    @Override
    public void printAllPlayers() throws TennisDatabaseRuntimeException {
        TennisPlayerNodeInterface node = head;

        if (node != null) {
            do {
                node.getPlayer().print();
                node = node.getNext();
            } while (node != head);
        }
    }

    @Override
    public void printMatchesOfPlayer(String playerId) throws TennisDatabaseRuntimeException {
        if(getPlayerById(playerId) != null)
            getPlayerById(playerId).printMatches();
        else {
            System.out.println("This player does not have any matches in the database.");
        }

    }

    public TennisPlayerNodeInterface getPlayerById(String id){
        // While the player ID is not our input id player = player.getNext()
        TennisPlayerNodeInterface node = head;

        if (node != null) {
            do {
                if (node.getPlayer().getId().equals(id))
                    return node;
                node = node.getNext();
            } while (node != head);
        }
        return null;
    }
}
