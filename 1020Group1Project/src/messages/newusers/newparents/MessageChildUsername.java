/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.newusers.newparents;
import app.*;
import java.util.ArrayList;
import messages.Message;
import users.Parent;
import users.Student;
/**
 *
 * @author StephenAHyberger
 */
//Parent specific prompt that loops until all children are entered.
public class MessageChildUserName extends Message{
    //tracks user data position
    private int userCoordinates;
    public MessageChildUserName(MyLabsMinusApp app) {
        //predefined text.
        super ("Enter your student's username.", "Username not found. Please try agian.", app);
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
        boolean found = false;
        for (int i = 0; i < app.getUserArray()[0].size(); i++) {
            if (((Student) app.getUserArray()[0].get(i)).getUserName().equals(getCurrentInput())) {
                ((Parent) app.getUserArray()[2].get(userCoordinates)).addChild(((Student) app.getUserArray()[0].get(i)));
                found = true;
            }
        }
        return found;
    }
}
