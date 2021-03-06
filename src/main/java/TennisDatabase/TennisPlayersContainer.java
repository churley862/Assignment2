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
        }
        else {
            TennisPlayerNode insert_point = findInsertNode(root, player);
            if(insert_point.getPlayer().compareTo(player) == 0){
                insert_point.getPlayer().updatePlayer(player);
            } else if (insert_point.getPlayer().compareTo(player) < 0) {
                insert_point.setLeft(new TennisPlayerNode(player));
            } else {
                insert_point.setRight(new TennisPlayerNode(player));
            }
        }
    }

    private TennisPlayerNode findInsertNode(TennisPlayerNode node, TennisPlayer player) {
        if(node.getPlayer().compareTo(player) == 0) {
           return node;
        }else if(node.getPlayer().compareTo(player) < 0){
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
    public String toString(){
        String allPlayers = "";
        return toString(root);
    }
    private String toString(TennisPlayerNode node) {
        String allPlayers = "";
        if (node == null) {return allPlayers;}
        if (allPlayers.isEmpty()) {
            allPlayers = node.getLeft().getPlayer().toString();
        }else{
            allPlayers += "\n" + node.getLeft().getPlayer().toString();
        }
        if (allPlayers.isEmpty()){
            allPlayers = node.getRight().toString();
        }else{
            allPlayers += "\n" + node.getLeft().toString();
        }
        toString(node.getRight());
        return allPlayers;
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

    private TennisPlayerNode[] findNode(TennisPlayer p, TennisPlayerNode parent, TennisPlayerNode node) {
        if (parent == null || node == null) {
            TennisPlayerNode[] result = new TennisPlayerNode[2];
            return result;
        }
        if (node.getPlayer().equals(p)){
            TennisPlayerNode[] result = new TennisPlayerNode[2];
            result[0] = parent;
            result[1] = node;
            return result;
        }
        if (node.getPlayer().compareTo(p) < 0)
            return findNode(p, node, node.getLeft());
        else
            return findNode(p,node,node.getRight());
    }

    private TennisPlayerNode[] findNode(TennisPlayer p) {
        if (root == null) {
            TennisPlayerNode[] result = new TennisPlayerNode[2];
            return result;
        }

        if (root.getPlayer().equals(p)) {
            TennisPlayerNode[] result = new TennisPlayerNode[2];
            result[1] = root;
            return result;
        }

        if (root.getPlayer().compareTo(p) < 0)
            return findNode(p, root, root.getLeft());
        else
            return findNode(p,root,root.getRight());
    }

    private void setParentPointer(TennisPlayerNode parent, TennisPlayerNode old, TennisPlayerNode next) {
        if (parent.getLeft() == old) {
            parent.setLeft(next);
        } else {
            parent.setRight(next);
        }
    }

    private TennisPlayerNode findLowestNode(TennisPlayerNode node){
        if(node.getLeft() == null){
            return node;
        }else{
            return findLowestNode(node.getLeft());
        }
    }

    public boolean removeNode(TennisPlayer p) {
            TennisPlayerNode[] removePoint = findNode(p);
            TennisPlayerNode parent = removePoint[0];
            TennisPlayerNode node = removePoint[1];

            if (node == null)
                return false;

            if (node.getLeft() == null && node.getRight() == null) {
                if (parent == null) {
                    root = null;
                } else {
                    setParentPointer(parent, node, null);
                }
                return true;
            }

            if (node.getLeft() == null) {
                if (parent == null) {
                    root = node.getRight();
                } else {
                    setParentPointer(parent, node, node.getRight());
                }
            } else if (node.getRight() == null) {
                if (parent == null) {
                    root = node.getLeft();
                } else {
                    setParentPointer(parent, node, node.getLeft());
                }
            } else {
                TennisPlayerNode lowest = findLowestNode(node.getLeft());
                removeNode(lowest.getPlayer());
                node.setPlayer(lowest.getPlayer());
            }
            return true;
        }

}
