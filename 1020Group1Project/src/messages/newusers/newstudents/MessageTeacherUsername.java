/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.newusers.newstudents;

import app.*;
import messages.Message;

/**
 *
 * @author StephenAHyberger
 */
//Prompts student for teacher selection
public class MessageTeacherUsername extends Message{
    //Tracks user data
    private int userCoordinates;
    public MessageTeacherUsername(MyLabsMinusApp app) {
        /**Needs Aaron**/
        //Will print out prompt with dynamic list of available teachers 
        super ("PLACEHOLDER", app);
        /*
        String fullMessage = "Please select between the available teachers below:";
        for (int i = 1; i <= app.getUserArray()[1].size(); i++) {
            fullMessage += "\n" + i + "." + app.getUserArray()[1].get(i);
        }
        */
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
    public boolean runOverride() {
        //Empty String validation
        if (!getCurrentInput().isEmpty()) {
            
            /**Needs Anthony's code**/
            //((Student)app.getUserArray()[0].get(userCoordinates)).setTeacherUsername(getCurrentInput());
            
            //starts end of account creation chain.
            app.printMessage(12, true);
            return true;
        } else {
            return false;
        }
    }
}
