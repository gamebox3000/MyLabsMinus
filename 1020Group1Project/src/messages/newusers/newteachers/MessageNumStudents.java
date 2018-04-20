package messages.newusers.newteachers;
import app.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.Message;
import users.Teacher;
/**
 * Class MessageNumStudents is a subclass of Message that implements the prompt for the max number of students for the teacher user.
 * @author Stephen Hybeger
 */
//Teacher-specific component that allows new teachers to specify the number of students he/she is willing to supervise.
public class MessageNumStudents extends Message{
    //tracks user data.
    private int userCoordinates;
    /**
     * This constructor enables the setting of initial values for fields, messsage, needs, and the app.
     * @param app //A link to the MyLabsMinusApp
     */
    public MessageNumStudents(MyLabsMinusApp app) {
        //pre-defined text
        super ("How many students are you going to supervise?", "Please enter a non-negative number.",app);
    }
    //returns user data position
    /**
     * Returns the user coordinates given by the application class in order to allow the class to specify which User in the userArray to modify.
     * @return The coordinates of the User in the userArray to be modified.
     */
    public int getUserCoordinates() {
        return userCoordinates;
    }
    //sets user data position
    /**
     * Sets the user coordinates to correspond with the index of that user in student sub-array (y-coordinate only since we already know that the user is a teacher).
     * @param newUserCoordinates The index of the teacher being modified in the teacher sub-array of the userArray.
     */
    public void setUserCoordinates(int newUserCoordinates) {
        userCoordinates = newUserCoordinates;
    }
    /**
     * An override of the runOverride method of the Message class. Sets the max number of students for the teacher and calls the confirmation for the teacher account creation.
     * @return Whether or not the program ran properly with valid input.
     * @throws NumberFormatException 
     */
    @Override
    public boolean runOverride() throws NumberFormatException{
            
        //will set the number of student slots available for the user
        try {
            if (Integer.parseInt(getCurrentInput()) >= 0) {
                
                ((Teacher)app.getUserArray()[1].get(userCoordinates)).setNumberOfStudents(getCurrentInput());
                
                try {
                    app.printMessage(13, true);
                } catch (IOException ex) {
                    Logger.getLogger(MessageNumStudents.class.getName()).log(Level.SEVERE, null, ex);
                }
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
