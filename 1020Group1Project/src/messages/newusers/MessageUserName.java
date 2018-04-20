package messages.newusers;
import app.MyLabsMinusApp;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.Message;
import users.User;
/**
 * Class MessageUserName is a subclass of Message that implements the prompt for a username during account creation.
 * @author Stephen Hybeger
 */
//prompts user for username
public class MessageUserName extends Message{
    //tracks user data position
    private int[] userCoordinates = new int[2];
    /**
     * This constructor enables the setting of initial values for fields, messsage, needs, and the app.
     * @param app //A link to the MyLabsMinusApp
     */
    public MessageUserName(MyLabsMinusApp app) {
        //predefined text
        super("Please enter a unique username", "Username is already taken. Try another one.", app);
    }
    //returns user data position
    /**
     * Returns the user coordinates given by the application class in order to allow the class to specify which User in the userArray to modify.
     * @return The coordinates of the User in the userArray to be modified.
     */
    public int[] getUserCoordinates() {
        return userCoordinates;
    }
    //sets user data position
    /**
     * Sets the user coordinates to correspond with a specific kind of user (x-coordinate) and the index of that user in that type (y-coordinate).
     * @param userType The type of user, Student = 0, Teacher = 1, Parent = 2, as an x-coordinate.
     * @param position The position of the user in the sub-array of the user's type (y-coordinate).
     */
    public void setUserCoordinates(int userType, int position) {
        userCoordinates[0] = userType;
        userCoordinates[1] = position;
    }
    /**
     * An override of the runOverride method of the Message class. After the user input and setting of the username field it calls the printMessage method of the application and passes the first name dialogue's index.
     * @return Whether or not the program ran properly with valid input. 
     */
    @Override
    public boolean runOverride() {
        if (!app.isMatching(getCurrentInput())) {
            ((User)app.getUserArray()[userCoordinates[0]].get(userCoordinates[1])).setUserName(getCurrentInput());
            try {
                app.printMessage(4, true);
            } catch (IOException ex) {
                Logger.getLogger(MessageUserName.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        } else {
            return false;
        }
    }
}
