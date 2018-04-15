/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.newusers.newparents;
import app.*;
import messages.Message;
import users.Parent;
/**
 *
 * @author StephenAHyberger
 */
//prompts parent for number of children before starting loop
public class MessageNumChildren extends Message{
    //tracks user data coordinates.
    private int userCoordinates;
    public MessageNumChildren(MyLabsMinusApp app) {
        //pre-defined text.
        super ("How many students are you registering or have registered to use this program?", "Please enter a non-negative integer.", app);
    }
    //returns user data coordinates.
    public int getUserCoordinates() {
        return userCoordinates;
    }
    //sets user data coordinates.
    public void setUserCoordinates(int newUserCoordinates) {
        userCoordinates = newUserCoordinates;
    }
    @Override
    public boolean runOverride() throws NumberFormatException{
        //will set the numOfChildren in the parent data.
        try {
            if (Integer.parseInt(getCurrentInput()) >= 0) {
                ((Parent) app.getUserArray()[2].get(userCoordinates)).setNumberOfChildren(Integer.parseInt(getCurrentInput())); 
                int loops = Integer.parseInt(getCurrentInput());
                //passes onto child username looping
                for (int i = 0; i < loops; i++) {
                   app.printMessage(11, true); 
                }
                //passes onto confirmation
                app.printMessage(14, true);
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
