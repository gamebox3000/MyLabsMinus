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
 *
 * @author StephenAHyberger
 */
//Prompts user for first name
public class MessageFirstName extends Message{
    //tracks user data position
    private int[] userCoordinates = new int[2];
    public MessageFirstName(MyLabsMinusApp app) {
        //predefined message
        super ("Please enter your first name", "", app);
    }
    //returns user data position
    public int[] getUserCoordinates() {
        return userCoordinates;
    }
    //sets user data position
    public void setUserCoordinates(int userType, int position) {
        userCoordinates[0] = userType;
        userCoordinates[1] = position;
    }
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
