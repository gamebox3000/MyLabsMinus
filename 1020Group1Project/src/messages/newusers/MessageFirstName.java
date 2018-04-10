/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.newusers;
import app.*;
import messages.Message;
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
        super ("Please enter your first name", app);
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
        if (!getCurrentInput().isEmpty()) {
            //app.getUserArray()[userCoordinates[0]].get(userCoordinates[1]).setFirstName(getCurrentInput());
            app.printMessage(5, true);
            return true;
        } else {
            return false;
        }
    }
}
