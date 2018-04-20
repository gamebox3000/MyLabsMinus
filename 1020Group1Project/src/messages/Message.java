package messages;

import app.*;
import java.io.IOException;
import java.util.Scanner;

//An archetypal message that handles all the common behavior of the message oomponents.
/**
 * The Message class is the superclass for all the message dialogues and handles
 * default behavior.
 *
 * @author Stephen Hyberger
 */
public class Message {

    protected MyLabsMinusApp app; //reference to the application object in main
    protected Scanner input; //a Scanner for input 
    private String message; //a message field that holds the prompt content of the message.
    private String needs; //a message that prints to inform the user that he/she entered invalid input.
    private String currentInput; //current input is the result of the scanner.
    //empty constuctor.

    /**
     * This constructor initializes a Message dialogue with default values.
     */
    public Message() {
        message = "";
        needs = "";
        input = new Scanner(System.in);
        app = new MyLabsMinusApp();
    }

    //constructor that allows user to specify the message content and the receiving application object.
    /**
     * This constructor enables the setting of initial values for fields,
     * messsage, needs, and the app.
     *
     * @param message //The pre-defined message as a prompt for the user
     * @param needs //The pre-defined message that prints when the user inputs
     * invalid input
     * @param app //A link to the MyLabsMinusApp
     */
    public Message(String message, String needs, MyLabsMinusApp app) {
        this.message = message;
        this.needs = needs;
        input = new Scanner(System.in);
        this.app = app;
    }

    //A method that the subclasses override to implement their individual behavior.
    /**
     * The runOverride method is what all message subclasses implement to
     * customize their output and behavior.
     *
     * @return Whether or not the program ran properly with valid input.
     */
    public boolean runOverride() {
        //default code detects empty string and triggers validation process.
        if (!getCurrentInput().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    //Prints the message content (prompt) to the screen.
    /**
     * The printMessage method is what is called to print a message to the
     * screen. It does four things: prints the prompt for user input, checks for
     * a command inputed by the user by running the executeCommand method,
     * executes message dialogue behavior by running the runOverride method, and
     * runs the validation code if the user makes mistakes at any point in the
     * process.
     *
     * @throws IOException
     */
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
    /**
     * The executeCommand checks for a command entered by a user and executes
     * one of the commands it implements if it is given as input.
     *
     * @return Whether the user entered a command. Returned to the printMessage
     * method.
     * @throws IOException
     */
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

            /**
             * Aaron needed*
             */
            //Handles unrecognized commands and reprints message.
            default:
                System.out.println("Recognized command. Please consult the list of recognized commands with \\help");
                return false;
        }
    }

    //sets the text content of the message.
    /**
     * Sets the prompt message.
     *
     * @param newMessage The String to which the prompt message is to be set.
     */
    public void setMessage(String newMessage) {
        message = newMessage;
    }

    //returns the text content of the message.
    /**
     * Returns the prompt message.
     *
     * @return The prompt message.
     */
    public String getMessage() {
        return message;
    }

    //sets the currentInput of the message.
    /**
     * Sets the currentInput. Used by the input Scanner to feed the currentInput
     * into the currentInput field.
     *
     * @param newCurrentInput The new input supplied by the User to this
     * dialogue.
     */
    public void setCurrentInput(String newCurrentInput) {
        currentInput = newCurrentInput;
    }

    //returns the currentInput of the message.
    /**
     * Returns the currentInput.
     *
     * @return The input last supplied to this message dialogue.
     */
    public String getCurrentInput() {
        return currentInput;
    }

    //Returns the list of needs used in the validation process
    /**
     * Returns the pre-defined validation-triggered message printed when the
     * user enters invalid input.
     *
     * @return The pre-defined validation message.
     */
    public String getNeeds() {
        return needs;
    }

    /**
     * Sets the validation message.
     *
     * @param newNeeds The new validation message.
     */
    public void setNeeds(String newNeeds) {
        needs = newNeeds;
    }

    /**
     * Prints the needs String for the validation message. Used only when the
     * user enters invalid input.
     */
    public void printNeeds() {
        System.out.println(needs + "\n");
    }
}
