public class TennisPlayer {
    public void print(){
        System.out.println("id " + id);
        System.out.println("first name " + fName);
        System.out.println("last name " + lName);
        System.out.println("year " + year);
        System.out.println("country" + country);
    }
    public void getWinLossRecord(){

    }
    private String id;
    private String fName;
    private String lName;
    private String year;
    private String country;

    public TennisPlayer(String id,String fName, String lName, String year, String country){
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.year = year;
        this.country = country;
    }


}
