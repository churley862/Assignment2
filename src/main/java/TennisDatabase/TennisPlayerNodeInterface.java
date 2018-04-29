


package TennisDatabase;

// Interface (package-private) providing the specifications for the TennisDatabase.TennisPlayerNode class.
interface TennisPlayerNodeInterface {
   
   // Accessors (getters).
   public TennisPlayer getPlayer();

   // return values changed to interface, to avoid tying
   // to a single class
   public TennisPlayerNodeInterface getPrev();
   public TennisPlayerNodeInterface getNext();
   
   // Modifiers (setters).
   // parameter values changed to interface, to avoid tying
   // to a single class
   public void setPrev( TennisPlayerNodeInterface p );
   public void setNext( TennisPlayerNodeInterface n );
   
   // Desc.: Insert a TennisMatch object (reference) into this node.
   // Input: A TennisMatch object (reference).
   // Output: Throws an exception if match cannot be inserted in this list.
   public void insertMatch( TennisMatch m ) throws TennisDatabaseRuntimeException;
   
   // Desc.: Prints all tennis matches in the list of this player to the console.
   // Output: Throws an exception if there are no matches in this list.
   public void printMatches() throws TennisDatabaseRuntimeException;
   
}


