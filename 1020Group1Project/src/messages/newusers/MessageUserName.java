package messages.newusers;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import app.MyLabsMinusApp;
import messages.Message;
import users.User;


/**
 *
 * @author StephenAHyberger
 */
//prompts user for username
public class MessageUserName extends Message{
    //tracks user data position
    private int[] userCoordinates = new int[2];
    public MessageUserName(MyLabsMinusApp app) {
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
        ((User)app.getUserArray()[userCoordinates[0]].get(userCoordinates[1])).setUserName(getCurrentInput());
        app.printMessage(4, true);
        return true;
    }
}