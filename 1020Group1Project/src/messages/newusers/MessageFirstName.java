/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.newusers;
import app.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.Message;
import users.User;
/**
 * Class MessageFirstName is a subclass of Message that implements the prompt for the first name of the user during account creation.
 * @author Stephen Hybeger
 */
//Prompts user for first name
public class MessageFirstName extends Message{
    //tracks user data position
    private int[] userCoordinates = new int[2];
    /**
     * This constructor enables the setting of initial values for fields, messsage, needs, and the app.
     * @param app //A link to the MyLabsMinusApp
     */
    public MessageFirstName(MyLabsMinusApp app) {
        //predefined message
        super ("Please enter your first name", "", app);
    }
    //returns user data position
    /**
     * Returns the user coordinates given by the application class in order to allow the class to specify which User in the userArray to modify.
     * @return The coordinates of the User in the userArray to be modified.
     */
    public int[] getUserCoordinates() {
        return userCoordinates;
    }
    //sets user data position
    /**
     * Sets the user coordinates to correspond with a specific kind of user (x-coordinate) and the index of that user in that type (y-coordinate).
     * @param userType The type of user, Student = 0, Teacher = 1, Parent = 2, as an x-coordinate.
     * @param position The position of the user in the sub-array of the user's type (y-coordinate).
     */
    public void setUserCoordinates(int userType, int position) {
        userCoordinates[0] = userType;
        userCoordinates[1] = position;
    }
    /**
     * An override of the runOverride method of the Message class. After the user input and setting of the first name field it calls the printMessage method of the application and passes the last name dialogue's index.
     * @return Whether or not the program ran properly with valid input. 
     */
    @Override
    public boolean runOverride() {
        //Validation for empty string.
        ((User)app.getUserArray()[userCoordinates[0]].get(userCoordinates[1])).setFirstName(getCurrentInput());
        try {
            app.printMessage(5, true);
        } catch (IOException ex) {
            Logger.getLogger(MessageFirstName.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
