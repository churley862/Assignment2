package TennisDatabase;

public class TennisPlayersContainer implements TennisPlayersContainerInterface {
    TennisPlayerNode root;

    public TennisPlayersContainer() {
        root = null;
    }

    @Override
    public void insertPlayer(TennisPlayer player) throws TennisDatabaseRuntimeException {
        if (root == null) {
            insertFirstNode(player);
        } else {
            TennisPlayerNode insert_point = findInsertNode(root, player);
            if (insert_point.getPlayer().compareTo(player) < 0) {
                insert_point.setLeft(new TennisPlayerNode(player));
            } else {
                insert_point.setRight(new TennisPlayerNode(player));
            }
        }
    }

    private TennisPlayerNode findInsertNode(TennisPlayerNode node, TennisPlayer player) {
        if(node.getPlayer().compareTo(player) < 0) {
            if (node.getLeft() == null) return node;
            return findInsertNode(node.getLeft(), player);
        }
        else{
            if (node.getRight() == null) return node;
            return findInsertNode(node.getRight(), player);
        }
    }

    private void insertFirstNode(TennisPlayer player) {
        if (root != null) {
            throw new RuntimeException("tree already populated, cannot call insertFirstNode");
        }

        TennisPlayerNode node = new TennisPlayerNode(player);
        root = node;
    }



    // TODO dummy player stuff
    @Override
    public void insertMatch(TennisMatch match) throws TennisDatabaseRuntimeException {
       // check for both players in our list
        // if the player exists then

        TennisPlayerNode node = getPlayerById(match.getPlayer1Id());
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
        printAllPlayers(root);
    }

    private void printAllPlayers(TennisPlayerNode node) {
        if (node == null) {return;}

        printAllPlayers(node.getLeft());
        node.getPlayer().print();
        printAllPlayers(node.getRight());
    }

    @Override
    public void printMatchesOfPlayer(String playerId) throws TennisDatabaseRuntimeException {
        if(getPlayerById(playerId) != null)
            getPlayerById(playerId).printMatches();
        else {
            System.out.println("This player does not have any matches in the database.");
        }

    }

    public TennisPlayerNode getPlayerById(String id){
        return getPlayerById(root, id);


    }

    private TennisPlayerNode getPlayerById(TennisPlayerNode node, String id) {
        if (node == null){return null;}
        int comp = node.getPlayer().getId().compareTo(id);
        if (comp == 0) return node;
        if (comp < 0) return getPlayerById(node.getLeft(), id);
        return getPlayerById(node.getRight(), id);
    }
}
