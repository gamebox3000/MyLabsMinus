package messages.newusers;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import app.MyLabsMinusApp;
import messages.Message;


/**
 *
 * @author StephenAHyberger
 */
//prompts user for username
public class MessageUsername extends Message{
    //tracks user data position
    private int[] userCoordinates = new int[2];
    public MessageUsername(MyLabsMinusApp app) {
        //predefined text
        super("Please enter a unique username", "Username is already taken. Try another one.", app);
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
        //empty string validation
        if (!getCurrentInput().isEmpty()) {
            //app.getUserArray()[userCoordinates[0]].get(userCoordinates[1]).setUsername(getCurrentInput());
            app.printMessage(4, true);
            return true;
        } else {
            return false;
        }
        
    }
}
