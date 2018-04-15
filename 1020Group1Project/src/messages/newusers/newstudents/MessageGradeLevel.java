/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.newusers.newstudents;
import app.*;
import users.Student;
import messages.Message;

/**
 *
 * @author StephenAHyberger
 */
//Student-specific component that prompts for grade level
public class MessageGradeLevel extends Message{
    //tracks user data coordinates.
    private int userCoordinates; 
    public MessageGradeLevel(MyLabsMinusApp app) {
        //pre-defined text
        super ("Please enter your grade level", "Please enter a K/0, 1, 2, 3, 4, or 5, indicating your current grade level.", app);
    }
    //returns user data coordinates
    public int getUserCoordinates() {
        return userCoordinates;
    }
    //returns user data coordinates
    public void setUserCoordinates(int newUserCoordinates) {
        userCoordinates = newUserCoordinates;
    }
    //sets student grade level. Integer only. String will trigger validation
    @Override
    public boolean runOverride() throws NumberFormatException{
        //will set student grade level
        if (!getCurrentInput().isEmpty()) {
            if (getCurrentInput().equals("k") || getCurrentInput().equals("K")) {
                app.printMessage(8, true);
                ((Student)app.getUserArray()[0].get(userCoordinates)).setGradeLevel(0);
            } else {
                try {
                    if (Integer.parseInt(getCurrentInput()) >= 0) {
                        ((Student)app.getUserArray()[0].get(userCoordinates)).setGradeLevel(Integer.parseInt(getCurrentInput()));
                    } else {
                        return false;
                    }
                } catch (NumberFormatException ex) {
                    return false;
                }
            }
            //passes onto teacher selection
            app.printMessage(8, true);
            return true;
        } else {
            return false;
        }
    }
}
