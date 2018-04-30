package TennisDatabase;

public class TennisPlayer  implements TennisPlayerInterface {
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

    public String getFirstName() {
        return fName;
    }

    public String getLastName() {
        return lName;
    }

    public int getBirthYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    private String fName;
    private String lName;
    private int year;
    private String country;

    public String getId() {
        return id;
    }

    public TennisPlayer(String id, String fName, String lName, int year, String country){
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.year = year;
        this.country = country;
    }


    public int compareTo(TennisPlayer o) {
        return 0;
    }
}
