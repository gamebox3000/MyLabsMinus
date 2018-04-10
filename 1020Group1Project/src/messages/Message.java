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
import java.util.Scanner;

//An archetypal message that handles all the common behavior of the message oomponents. 
public class Message {
    protected MyLabsMinusApp app; //reference to the application object in main
    protected Scanner input; //a Scanner for input 
    private String message; //a message field that holds the prompt content of the message.
    
    /**Needs Aaron**/
    private static final String NEEDS = "PLACEHOLDER"; //fine for this class, but needs to be implemented in subclasses
    
    //current input is the result of the scanner.
    private String currentInput;
    
    //empty constuctor.
    public Message() {
        message = "";
        input = new Scanner(System.in);
        app = new MyLabsMinusApp();
    }
    //constructor that allows user to specify the message content and the receiving application object.
    public Message(String message, MyLabsMinusApp app) {
        this.message = message;
        input = new Scanner(System.in);
        this.app = app;
    }
    //A method that the subclasses override to implement their individual behavior.
    public boolean runOverride() {
        //default code detects empty string and triggers validation process.
        if (!getCurrentInput().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    /**Needs Aaron**/
    //Code needs to be corrected. Primitive value needs to stored not references as is now.
    //Prints the message content (prompt) to the screen.
    public void printMessage() {
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
            if (currentInput.charAt(0) == '\\') {
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
                
                /**Needs Aaron**/
                message = "Invalid input. Required: " + NEEDS; //implementation needed elsewhere in subclasses
            }
        }
        //reloads original message 
        message = originalMessage;
    }
    //Executes commands.
    public boolean executeCommand() {
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
        return NEEDS;
    }
}
