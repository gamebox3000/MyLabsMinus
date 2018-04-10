/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.newusers.newparents;
import app.*;
import messages.Message;
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
                
                /**Needs Anthony's code**/
                //app.getUserArray()[2].get(userCoordinates).setNumOfChildren(Integer.parseInt(getCurrentInput())); 
                
                //passes onto child username looping 
                app.printMessage(11, true);
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
