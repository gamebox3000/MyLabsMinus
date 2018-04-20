package messages.newusers.newparents;
import app.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.Message;
import users.Parent;
/**
 * Class MessageNumChildren is a subclass of Message that implements the prompt for the number of children that the parent user has registered.
 * @author Stephen Hybeger
 */
//prompts parent for number of children before starting loop
public class MessageNumChildren extends Message{
    //tracks user data coordinates.
    private int userCoordinates;
    /**
     * This constructor enables the setting of initial values for fields, messsage, needs, and the app.
     * @param app A link to the MyLabsMinusApp
     */
    public MessageNumChildren(MyLabsMinusApp app) {
        //pre-defined text.
        super ("How many students are you registering or have registered to use this program?", "Please enter a non-negative integer.", app);
    }
    //returns user data coordinates.
    /**
     * Returns the user coordinates given by the application class in order to allow the class to specify which User in the userArray to modify.
     * @return The coordinates of the User in the userArray to be modified.
     */
    public int getUserCoordinates() {
        return userCoordinates;
    }
    /**
     * Sets the user coordinates to correspond with the index of that user in parent sub-array (y-coordinate only since we already know that the user is a parent).
     * @param newUserCoordinates The index of the parent being modified in the parent sub-array of the userArray.
     */
    public void setUserCoordinates(int newUserCoordinates) {
        userCoordinates = newUserCoordinates;
    }
    /**
     * An override of the runOverride method of the Message class. This class prompts the parent for the number of children and then initiates a loop of the child user name prompt that fills the childArray of the parent and then triggers the confirmation once it finishes.
     * @return Whether or not the program ran properly with valid input. 
     * @throws NumberFormatException 
     */
    @Override
    public boolean runOverride() throws NumberFormatException{
        //will set the numOfChildren in the parent data.
        try {
            if (Integer.parseInt(getCurrentInput()) >= 0) {
                ((Parent) app.getUserArray()[2].get(userCoordinates)).setNumberOfChildren(getCurrentInput()); 
                int loops = Integer.parseInt(getCurrentInput());
                //passes onto child username looping
                for (int i = 0; i < loops; i++) {
                    try { 
                        app.printMessage(11, true);
                    } catch (IOException ex) {
                        Logger.getLogger(MessageNumChildren.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                try {
                    //passes onto confirmation
                    app.printMessage(14, true);
                } catch (IOException ex) {
                    Logger.getLogger(MessageNumChildren.class.getName()).log(Level.SEVERE, null, ex);
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
