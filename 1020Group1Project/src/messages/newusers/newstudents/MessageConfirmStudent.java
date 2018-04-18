/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.newusers.newstudents;
import app.*;
import java.io.IOException;
import messages.Message;
import users.Student;
/**
 *
 * @author StephenAHyberger
 */
//component that checks with the user at the end to make sure everything was entered correctly.
public class MessageConfirmStudent extends Message{
    public MessageConfirmStudent(MyLabsMinusApp app) {
        //predefined message
        super("", "Please enter a \'yes\' or a \'no\'.", app);
    }
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
    @Override
    public void printMessage() throws IOException {
        //holds the content of the message in originalMessage in case validation is triggered later on.
        String originalMessage = getMessage();
        setMessage("Are the following details correct?" 
              + "\nUsername: " + ((Student)app.getUserArray()[0].get(app.getUserArray()[0].size() - 1)).getUserName()
              + "\nName: " + ((Student)app.getUserArray()[0].get(app.getUserArray()[0].size() - 1)).getFirstName() + " " + ((Student)app.getUserArray()[0].get(app.getUserArray()[0].size() - 1)).getLastName()
              + "\nEmail: " + ((Student)app.getUserArray()[0].get(app.getUserArray()[0].size() - 1)).getEMail()
              + "\nGrade Level: " + ((Student)app.getUserArray()[0].get(app.getUserArray()[0].size() - 1)).getGradeLevel()
              + "\nTeacher: " + ((Student)app.getUserArray()[0].get(app.getUserArray()[0].size() - 1)).getTeacherUserName());
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
