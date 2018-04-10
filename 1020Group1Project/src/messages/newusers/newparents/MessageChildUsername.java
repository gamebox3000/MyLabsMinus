/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.newusers.newparents;
import app.*;
import java.util.ArrayList;
import messages.Message;
/**
 *
 * @author StephenAHyberger
 */
//Parent specific prompt that loops until all children are entered.
public class MessageChildUsername extends Message{
    //tracks user data position
    private int userCoordinates;
    public MessageChildUsername(MyLabsMinusApp app) {
        //predefined text.
        super ("Enter your student's username", app);
    }
    //returns user data position
    public int getUserCoordinates() {
        return userCoordinates;
    }
    //sets user data position
    public void setUserCoordinates(int newUserCoordinates) {
        userCoordinates = newUserCoordinates;
    }
    @Override
    public boolean runOverride() {
        //empty String validation
        if (!getCurrentInput().isEmpty()) {
            
            /**Needs Anthony's code**/
            //will loop through the number of children and prompt x number of times and enter array of children into temporary user data.
            ArrayList<String> childUsernames = new ArrayList<>();
            /*for (int i = ((Parent)app.getUserArray()[2].get(userCoordinates)).getNumOfChildren(); i > 0; i--) {
                printMessage(11, true);
                childUsernames.add(messageArray.get(11).getCurrentInput());
            }
            ((Parent)app.getUserArray()[2].get(userCoordinates)).setChildArray(getCurrentInput();
            */
            
            //triggers end of account creation.
            app.printMessage(12, true);
            return true;
        } else {
            return false;
        }
    }
}
