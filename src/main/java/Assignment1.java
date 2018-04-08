import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Assignment1 {
    private static TennisDatabase tennisDatabase;

    public static void main(String args[]){
        System.out.println("Assignment 1 ");
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);
        tennisDatabase = new TennisDatabase();
        try {
            tennisDatabase.loadFromFile("src/test/data/test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
