/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.newusers.newstudents;

import users.Student;
import users.Teacher;
import app.*;
import java.util.ArrayList;
import messages.Message;
import users.User;

/**
 *
 * @author StephenAHyberger
 */
//Prompts student for teacher selection
public class MessageTeacherUserName extends Message{
    //An array that orders the available teachers 
    ArrayList<Teacher> available = new ArrayList<>();
    
    //Tracks user data
    private int userCoordinates;
    public MessageTeacherUserName(MyLabsMinusApp app) {
        //Will print out prompt with dynamic list of available teachers 
        super ("", "Please enter an positive integer indicating your choice out of those presented below.", app);
    }
    //Returns user data coordinates
    public int getUserCoordinates() {
        return userCoordinates;
    }
    //sets user data coordinates
    public void setUserCoordinates(int newUserCoordinates) {
        userCoordinates = newUserCoordinates;
    }
    @Override
    public boolean runOverride() throws NumberFormatException{
        try {
            int answer = Integer.parseInt(getCurrentInput());
            if (answer == 1) {
                ((Student)app.getUserArray()[0].get(userCoordinates)).setTeacherUserName("None");
                //starts end of account creation chain.
                app.printMessage(12, true);
                return true;
            } else if (answer > 0) {
                ((Student)app.getUserArray()[0].get(userCoordinates)).setTeacherUserName(available.get(answer - 2).getUserName());    
                available.get(answer -2).getArrayOfStudents().add(((Student)app.getUserArray()[0].get(userCoordinates)));
                //starts end of account creation chain.
                app.printMessage(12, true);
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex){
                return false;
        }
    }
    //Prints the message content (prompt) to the screen.
    @Override
    public void printMessage() {
        //holds the content of the message in originalMessage in case validation is triggered later on.
        String originalMessage = getMessage();
        //success will track if the input from the user passes validation. 
        boolean success = false;
        //implements validation 
        while (!success) {
            String availableMessage = "Please select between the available teachers below:\n1. None";
            for (int i = 0; i < app.getUserArray()[1].size(); i++) {
                Teacher currentTeacher = (Teacher)app.getUserArray()[1].get(i);
                //if (!currentTeacher.getArrayOfStudents().isEmpty()) {
                    if (currentTeacher.getNumberOfStudents() - currentTeacher.getArrayOfStudents().size() > 0) {
                        availableMessage += "\n" + (i + 2) + ". " + ((User)app.getUserArray()[1].get(i)).getUserName();
                        available.add(currentTeacher);
                    }
                //}
            }
            setMessage(availableMessage);
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
