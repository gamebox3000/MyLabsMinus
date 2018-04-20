package messages.newusers.newstudents;
import app.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import users.Student;
import messages.Message;
/**
 * Class MessageGradeLevel is a subclass of Message that implements the prompt for the grade level of the student user.
 * @author Stephen Hybeger
 */
//Student-specific component that prompts for grade level
public class MessageGradeLevel extends Message{
    //tracks user data coordinates.
    private int userCoordinates; 
    /**
     * This constructor enables the setting of initial values for fields, messsage, needs, and the app.
     * @param app //A link to the MyLabsMinusApp
     */
    public MessageGradeLevel(MyLabsMinusApp app) {
        //pre-defined text
        super ("Please enter your grade level", "Please enter a K/0, 1, 2, 3, 4, or 5, indicating your current grade level.", app);
    }
    //returns user data coordinates
    /**
     * Returns the user coordinates given by the application class in order to allow the class to specify which User in the userArray to modify.
     * @return The coordinates of the User in the userArray to be modified.
     */
    public int getUserCoordinates() {
        return userCoordinates;
    }
    //returns user data coordinates
    /**
     * Sets the user coordinates to correspond with the index of that user in student sub-array (y-coordinate only since we already know that the user is a student).
     * @param newUserCoordinates The index of the student being modified in the student sub-array of the userArray.
     */
    public void setUserCoordinates(int newUserCoordinates) {
        userCoordinates = newUserCoordinates;
    }
    //sets student grade level. Integer only. String will trigger validation
    /**
     /**
     * An override of the runOverride method of the Message class. Sets the grade level of the student and passes onto the teacher selection dialogue.
     * @return Whether or not the program ran properly with valid input. 
     * @throws NumberFormatException 
     */
    @Override
    public boolean runOverride() throws NumberFormatException{
        //will set student grade level
        if (!getCurrentInput().isEmpty()) {
            if (getCurrentInput().equals("k") || getCurrentInput().equals("K")) {
                try {
                    app.printMessage(8, true);
                } catch (IOException ex) {
                    Logger.getLogger(MessageGradeLevel.class.getName()).log(Level.SEVERE, null, ex);
                }
                ((Student)app.getUserArray()[0].get(userCoordinates)).setGradeLevel("0");
            } else {
                try {
                    if (Integer.parseInt(getCurrentInput()) >= 0) {
                        ((Student)app.getUserArray()[0].get(userCoordinates)).setGradeLevel(getCurrentInput());
                    } else {
                        return false;
                    }
                } catch (NumberFormatException ex) {
                    return false;
                }
            }
            try {
                //passes onto teacher selection
                app.printMessage(8, true);
            } catch (IOException ex) {
                Logger.getLogger(MessageGradeLevel.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        } else {
            return false;
        }
    }
}
