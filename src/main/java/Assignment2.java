/*Collin Hurley
CS 102
Class: Assignment 1
The main function of the tennis database, implements the command window
Instances
tennisDatabase - is the instance of the tennis database class used for the majority of operations

*/
import TennisDatabase.TennisDatabase;
import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.desktop.AppForegroundListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Assignment2 extends Application {
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
                "6 --> Import a file \n" +
                "7 --> Export a file \n"+
                "8 --> Remove a player by ID\n"+
                "9 --> Exit\n" +
                "Your choice? ");
    }
        // The start method is the main entry point for all JavaFX applications.
        // Stage: The A JavaFX application defines the user interface container by means of a stage and a scene.
        //        The JavaFX Stage class is the top-level JavaFX containe
        @Override public void start(Stage primaryStage) {
            Button btn = new Button(); // Button control node.
            btn.setText( "Say 'Hello World'" ); // Button setup: button text.

            // Event handler for the button control node: print a message when the button is pressed.
            // setOnAction: Sets the value of the property onAction: the button's action, which is invoked whenever the button is fired.
            btn.setOnAction( new EventHandler<ActionEvent>() {
                // handle: method invoked when a specific event of the type for which this handler is registered happens.
                @Override
                public void handle( ActionEvent event ) { System.out.println("Hello World!"); } } );

            StackPane root = new StackPane(); // Root node of the scene graph: a resizeable layout node.
            root.getChildren().add( btn ); // Set the button control node as child of the root node (layout).
            // Scene: The A JavaFX application defines the user interface container by means of a stage and a scene.
            //        The JavaFX Scene class is the container for all content (hierarchical scene graph of nodes).
            Scene scene = new Scene( root, 500, 250 ); // Scene setup: root node, window width, and height.
            primaryStage.setTitle( "Hello World!" ); // Stage setup: window title.
            primaryStage.setScene(scene); // Stage setup: scene graph for the content.
            primaryStage.show(); // Show the window via the stage.
        }
    // The main method of my code, should have 1 command line input argument
    // this argument should contain the file name of the initial data for
    // the database
   // public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException {
     //   launch(args);
   // }
/*
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
           // launch(args);
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
                case "6":{
                    System.out.println("Input a filename");
                    try {
                        tennisDatabase.loadFromFile(sc.nextLine());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "7":{
                    System.out.println("Input a filename for export");
                    tennisDatabase.exportToFile(sc.nextLine());
                    break;
                }
                case "8":{
                    System.out.println("Input the player ID to be removed");

                    tennisDatabase.removePlayer(tennisDatabase.searchTennisPlayer(sc.nextLine()));
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
        };*/
    }