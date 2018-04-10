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
//Component that prompts user for email
public class MessageEmail extends Message{
    //used to track the user data's position in the user array
    public int[] userCoordinates = new int[2];
    public MessageEmail(MyLabsMinusApp app) {
        //predefined content
        super ("Please enter your email", "", app);
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
        if (!getCurrentInput().isEmpty()) {
            //app.getUserArray()[userCoordinates[0]].get(userCoordinates[1]).setEmail(getCurrentInput());
            switch (userCoordinates[1]) {
                case 0: //starts student-specific messages
                    app.printMessage(7, true);
                    break;
                case 1: //starts teacher-specific messages
                    app.printMessage(9, true);
                    break;
                case 2: //starts parent-specific messages
                    app.printMessage(10, true);
                    break;
                default:
                    break;
            }
            return true;
        } else {
            return false;
        }
    }
}
