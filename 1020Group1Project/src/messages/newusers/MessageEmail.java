package messages.newusers;
import app.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.Message;
import users.User;
//Component that prompts user for email
/**
 * Class MessageEmail is a subclass of Message that implements the prompt for the email of the user during account creation.
 * @author Stephen Hybeger
 */
public class MessageEmail extends Message{
    //used to track the user data's position in the user array
    public int[] userCoordinates = new int[2];
    /**
     * This constructor enables the setting of initial values for fields, messsage, needs, and the app.
     * @param app //A link to the MyLabsMinusApp
     */
    public MessageEmail(MyLabsMinusApp app) {
        //predefined content
        super ("Please enter your email", "", app);
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
     * An override of the runOverride method of the Message class. After the user input and setting of the email field it selects the appropriate message dialogue based on the type of the user (MessageGradeLevel for students, MessageNumStudents for teachers, and MessageNumChildren for parents).
     * @return Whether or not the program ran properly with valid input. 
     */
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
