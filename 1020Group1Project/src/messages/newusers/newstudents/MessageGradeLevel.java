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
//Student-specific component that prompts for grade level
public class MessageGradeLevel extends Message{
    //tracks user data coordinates.
    private int userCoordinates; 
    public MessageGradeLevel(MyLabsMinusApp app) {
        //pre-defined text
        super ("Please enter your grade level", app);
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
        /**Needs Anthony's code**/
        //will set student grade level
        if (!getCurrentInput().isEmpty()) {
            /*try {
                ((Student)app.getUserArray()[0].get(userCoordinates)).setGradeLevel(Integer.parseInt(getCurrentInput()));
            } catch (NumberFormatException ex) {
                return false;
            }
            */
            
            //passes onto teacher selection
            app.printMessage(8, true);
            return true;
        } else {
            return false;
        }
    }
}
