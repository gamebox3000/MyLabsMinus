package messages.newusers.newparents;
import app.*;
import java.io.IOException;
import messages.Message;
import users.Parent;
/**
 * Class MessageConfirmParent is a subclass of Message that implements the prompt for confirmation from the parent user that the entered details are correct.
 * @author Stephen Hybeger
 */
//component that checks with the user at the end to make sure everything was entered correctly.
public class MessageConfirmParent extends Message{
    /**
     * This constructor enables the setting of initial values for fields, messsage, needs, and the app.
     * @param app //A link to the MyLabsMinusApp
     */
    public MessageConfirmParent (MyLabsMinusApp app) {
        //predefined message
        super("", "Please enter a \'yes\' or a \'no\'.", app);
    }
    /**
     * An override of the runOverride method of the Message class. If yes is entered the account creation ends and the user is sent back to the opening menu. If no is entered then the account creation process starts over again.
     * @return Whether or not the program ran properly with valid input. 
     */
    @Override
    public boolean runOverride() {
        //If yes, returns to openning message
        switch (getCurrentInput()) {
            case "Yes":
            case "yes":
                setCurrentInput("true");
                return true;
                //If no, returns to start of account creation chain
            case "No":
            case "no":
                setCurrentInput("false");
                return true;
            default:
                return false;
        }
    }
    /**
     * An override of the printMessage method of Message. The only modification is the mechanism that gets the given information form the user creation process and displays it all to the user.
     * @throws IOException 
     */
    @Override
    public void printMessage() throws IOException {
        //holds the content of the message in originalMessage in case validation is triggered later on.
        String enrolledStudents = "";
        for (int i = 0; i < Integer.parseInt(((Parent)app.getUserArray()[2].get(app.getUserArray()[2].size() - 1)).getNumberOfChildren()); i++) {
            if (i == 0) {
                enrolledStudents += ((Parent)app.getUserArray()[2].get(app.getUserArray()[2].size() - 1)).getArrayOfChildren().get(i).getFirstName() + " " + ((Parent)app.getUserArray()[2].get(app.getUserArray()[2].size() - 1)).getArrayOfChildren().get(i).getLastName();
            } else {
                enrolledStudents += "\n" + ((Parent)app.getUserArray()[2].get(app.getUserArray()[2].size() - 1)).getArrayOfChildren().get(i).getFirstName() + " " + ((Parent)app.getUserArray()[2].get(app.getUserArray()[2].size() - 1)).getArrayOfChildren().get(i).getLastName();
            }
        }
        String originalMessage = getMessage();
        setMessage("Are the following details correct?" 
              + "\nUsername: " + ((Parent)app.getUserArray()[2].get(app.getUserArray()[2].size() - 1)).getUserName()
              + "\nName: " + ((Parent)app.getUserArray()[2].get(app.getUserArray()[2].size() - 1)).getFirstName() + " " + ((Parent)app.getUserArray()[2].get(app.getUserArray()[2].size() - 1)).getLastName()
              + "\nEmail: " + ((Parent)app.getUserArray()[2].get(app.getUserArray()[2].size() - 1)).getEMail()
              + "\nStudents Enrolled:\n" + enrolledStudents);
        //success will track if the input from the user passes validation. 
        boolean success = false;
        //implements validation 
        while (!success) {
            //prints message content
            System.out.print(getMessage() + "\n\n>>>");
            //waits for input from user.
            setCurrentInput(input.nextLine());
            //moves cursor down line.
            System.out.println();
            //checks if command was given
            if (getCurrentInput().startsWith("\\")) {
                //detects if unrecognized command was given if not input is validated.
                if (!executeCommand()) {
                    //replaces original message with validation message
                    setMessage("Command not recognized. Enter \\help for a list of valid commands");
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
        setMessage(originalMessage);
    }
}