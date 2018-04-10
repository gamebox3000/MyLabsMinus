/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.newusers.newteachers;
import app.*;
import messages.Message;

/**
 *
 * @author StephenAHyberger
 */
//Teacher-specific component that allows new teachers to specify the number of students he/she is willing to supervise.
public class MessageNumStudents extends Message{
    //tracks user data.
    private int userCoordinates;
    public MessageNumStudents(MyLabsMinusApp app) {
        //pre-defined text
        super ("How many students are you going to supervise?", "Please enter a non-negative number.",app);
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
    public boolean runOverride() throws NumberFormatException{
            
        //will set the number of student slots available for the user
        try {
            if (Integer.parseInt(getCurrentInput()) >= 0) {
                
                /**Needs Anthony's code**/
                //((Teachers)app.getUserArray()[1].get(userCoordinates)).setNumOfStudents(Integer.parseInt(getCurrentInput());
                
                app.printMessage(12, true);
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
