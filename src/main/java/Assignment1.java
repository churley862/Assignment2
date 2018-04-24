
import TennisDatabase.TennisDatabase;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment1 {
    private static TennisDatabase tennisDatabase;
    private static void printMenu() {
        System.out.println(
                "Current available commands:\n" +
                "1 --> Print all tennis players\n" +
                "2 --> Print all tennis matches of a player\n" +
                "3 --> Print print all tennis matches\n"+
                "4 --> Insert a new tennis match or player\n"+
                "9 --> Exit\n" +
                "Your choice? ");
    }
    public static void main(String args[]){
        System.out.println("Welcome to the CS-102 Tennis Manager");
        boolean executing = true;
        Scanner sc = new Scanner(System.in);
        String input;
        tennisDatabase = new TennisDatabase();

        try {
            tennisDatabase.loadFromFile("src/test/data/test.txt");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(executing){
            printMenu();
            input = sc.nextLine();
            switch(input){
                case "1":{
                    System.out.println("All players:");
                    tennisDatabase.printAllPlayers();
                    break;
                }
                case "2":{
                    System.out.println("All Tennis matches of a player:");
                    break;
                }
                case "3":{
                    System.out.println("All Tennis matches: ");
                    tennisDatabase.printAllMatches();
                    break;
                }
                case "4":{
                    System.out.println("Insert new Tennis player or match: ");
                    tennisDatabase.parseLine(sc.nextLine());
                    break;
                }
                case "9":{
                    executing = false;
                    System.out.println("Thanks for using the tennis database");
                    break;
                }
                default:{
                    System.out.println("This input is invalid please try again.");
                }

            }
        };
    }

}
