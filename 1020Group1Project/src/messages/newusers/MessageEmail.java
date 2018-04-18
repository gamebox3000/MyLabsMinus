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
        ((User)app.getUserArray()[userCoordinates[0]].get(userCoordinates[1])).setEMail(getCurrentInput());
        switch (userCoordinates[0]) {
            case 0: {
            try {
                //starts student-specific messages
                app.printMessage(7, true);
            } catch (IOException ex) {
                Logger.getLogger(MessageEmail.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case 1: {
            try {
                //starts teacher-specific messages
                app.printMessage(9, true);
            } catch (IOException ex) {
                Logger.getLogger(MessageEmail.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case 2: {
            try {
                //starts parent-specific messages
                app.printMessage(10, true);
            } catch (IOException ex) {
                Logger.getLogger(MessageEmail.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            default:
                System.out.println("System error.");
                return false;
        }
        return true;
    }
}
