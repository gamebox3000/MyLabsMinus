package messages.newusers.newparents;
import app.*;
import java.util.ArrayList;
import messages.Message;
import users.Parent;
import users.Student;
/**
 * Class MessageChildUserName is a subclass of Message that implements the prompts the parent user for the username of a child.
 * @author Stephen Hybeger
 */
//Parent specific prompt that loops until all children are entered.
public class MessageChildUserName extends Message{
    //tracks user data position
    private int userCoordinates;
    /**
     * This constructor enables the setting of initial values for fields, messsage, needs, and the app.
     * @param app //A link to the MyLabsMinusApp
     */
    public MessageChildUserName(MyLabsMinusApp app) {
        //predefined text.
        super ("Enter your student's username.", "Username not found. Please try agian.", app);
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
     * Sets the user coordinates to correspond with the index of that user in parent sub-array (y-coordinate only since we already know that the user is a parent).
     * @param newUserCoordinates The index of the parent being modified in the parent sub-array of the userArray.
     */
    public void setUserCoordinates(int newUserCoordinates) {
        userCoordinates = newUserCoordinates;
    }
   /**
     * An override of the runOverride method of the Message class. Searches for student with specified username. If found adds student to childArray in the Parent class. If not triggers validation.
     * @return Whether or not the program ran properly with valid input. 
     */
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
