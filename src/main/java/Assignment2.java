/*Collin Hurley
CS 102
Class: Assignment 1
The main function of the tennis database, implements the command window
Instances
tennisDatabase - is the instance of the tennis database class used for the majority of operations

*/
import TennisDatabase.TennisDatabase;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment2 {
    private static TennisDatabase tennisDatabase;

    //printMenu() method to print the menu, I just thought it was cleaner
    private static void printMenu() {
        System.out.println(
                "Current available commands:\n" +
                "1 --> Print all tennis players\n" +
                "2 --> Print all tennis matches of a player\n" +
                "3 --> Print print all tennis matches\n"+
                "4 --> Insert a new tennis match or player\n"+
                "5 --> Reset the database\n"+
                "9 --> Exit\n" +
                "Your choice? ");
    }
    // The main method of my code, should have 1 command line input argument
    // this argument should contain the file name of the initial data for
    // the database
    public static void main(String args[]){
        System.out.println("Welcome to the CS-102 Tennis Manager");

        //executing flag that shows the program status
        boolean executing = true;
        // A new scanner that allows the user to input values as prompted in the menu
        Scanner sc = new Scanner(System.in);
        // input - the value of the user input as recieved from the scanner
        String input;

        // A new instance of the tennis database used for the majority of operations
        tennisDatabase = new TennisDatabase();

        try {
            // TODO change to receive input from a command line arg
            // tennisDatabase.loadFromFile(args[0])
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
                    // case 1 is printing all players stored in the database
                    //
                    System.out.println("All players:");
                    tennisDatabase.printAllPlayers();
                    break;
                }
                case "2":{
                    System.out.println("All Tennis matches of a player:");
                    tennisDatabase.printMatchesOfPlayer(sc.nextLine());
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
                case "5":{
                    tennisDatabase.reset();
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
