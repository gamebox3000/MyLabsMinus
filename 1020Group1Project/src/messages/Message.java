package messages;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sahyberger
 */

import app.*;
import java.io.IOException;
import java.util.Scanner;

//An archetypal message that handles all the common behavior of the message oomponents. 
public class Message {
    protected MyLabsMinusApp app; //reference to the application object in main
    protected Scanner input; //a Scanner for input 
    private String message; //a message field that holds the prompt content of the message.
    
    /**Needs Aaron**/
    private String needs; //fine for this class, but needs to be implemented in subclasses
    
    //current input is the result of the scanner.
    private String currentInput;
    
    //empty constuctor.
    public Message() {
        message = "";
        needs = "";
        input = new Scanner(System.in);
        app = new MyLabsMinusApp();
    }
    //constructor that allows user to specify the message content and the receiving application object.
    public Message(String message, String needs, MyLabsMinusApp app) {
        this.message = message;
        this.needs = needs;
        input = new Scanner(System.in);
        this.app = app;
    }
    //A method that the subclasses override to implement their individual behavior.
    public boolean runOverride() {
        //default code detects empty string and triggers validation process.
        return !getCurrentInput().isEmpty();
    }
    //Prints the message content (prompt) to the screen.
    public void printMessage() throws IOException {
        //holds the content of the message in originalMessage in case validation is triggered later on.
        String originalMessage = message;
        //success will track if the input from the user passes validation. 
        boolean success = false;
        //implements validation 
        while (!success) {
            //prints message content
            System.out.print(message + "\n\n>>>");
            //waits for input from user.
            currentInput = input.nextLine();
            //moves cursor down line.
            System.out.println();
            //checks if command was given
            if (currentInput.startsWith("\\")) {
                //detects if unrecognized command was given if not input is validated.
                if (!executeCommand()) {
                    //replaces original message with validation message
                    message = "Command not recognized. Enter \\help for a list of valid commands";
                } else {
                    success = true;
                }
                //runs for non-command input if runOverride returns that the input was validated.
            } else if (runOverride()) {
                success = true;
                //runs if input does not pass validation
            } else {
                printNeeds(); //prints error and reprompts
            }
        }
        //reloads original message 
        message = originalMessage;
    }
    //Executes commands.
    public boolean executeCommand() throws IOException {
        switch (currentInput) {
            //Back command takes user to the previous message in the message history.
            case "\\Back":
            case "\\back":
                if (app.getMessageHistory().isEmpty()) {
                    System.out.println("Cannot run \back commmand: there is no menu to go back to");
                } else {
                    app.printMessage(app.getLastMessage(true), false);
                }
                return true;
                
            /**Aaron needed**/
            //Help command prints list of valid commands to the user and reprints message.
            case "\\Help":
            case "\\help":
                System.out.println("List of commands:\n\n1. \\help - Prints out a list of all the available commands.\n\n2. \\back - returns to the last visted menu.\n\n3. \\exit - terminates program.\n\nPress enter to continue.");
                System.in.read();
                app.printMessage(app.getCurrentMessage(), false);
                return true;
                
            //Exit command terminates program.    
            case "\\Exit":
            case "\\exit":
                System.out.println("\nThank you for using MyLabMinus");
                System.exit(0);
                return true;
            
            /**Aaron needed**/
            //Handles unrecognized commands and reprints message.
            default:
                System.out.println("Recognized command. Please consult the list of recognized commands with \\help");
                return false;
        }
    }
    //sets the text content of the message.
    public void setMessage(String newMessage) {
        message = newMessage;
    }
    //returns the text content of the message.
    public String getMessage() {
        return message;
    }
    //sets the currentInput of the message.
    public void setCurrentInput(String newCurrentInput) {
        currentInput = newCurrentInput;
    }
    //returns the currentInput of the message.
    public String getCurrentInput() {
        return currentInput;
    }
    //Returns the list of needs used in the validation process
    public String getNeeds() {
        return needs;
    }
    public void setNeeds(String newNeeds) {
        needs = newNeeds;
    }
    public void printNeeds() {
        System.out.println(needs + "\n");
    }
}
