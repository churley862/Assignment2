import java.io.FileNotFoundException;
public class Assignment1 {
    private static TennisDatabase tennisDatabase;

    public static void main(String args[]){
        System.out.println("Assignment 1 ");
        tennisDatabase = new TennisDatabase();
        try {
            tennisDatabase.loadFromFile("src/test/data/test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
