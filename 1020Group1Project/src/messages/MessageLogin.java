package messages;
import app.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import users.*;
//Login component. Prompts user for username
/**
 * Class MessageLogin is a subclass of Message that implements the user login.
 * @author Stephen Hybeger
 */
public class MessageLogin extends Message{
    //Creates predefined message.
    /**
     * A constructor that initializes the pre-defined messages and binds the message to the application class.
     * @param app The MyLabsMinusApp object that the message dialogue is to be bound to.
     */
    public MessageLogin(MyLabsMinusApp app) {
        super("Please enter your username to login", "Username not found.", app);
    }
    /**
     * An override of the runOverride method of the Message class. Checks the username provided by the user using the isMatching method of MyLabsMinusApp, if match is found it accesses the match and identifies if the selected user is a student, teacher, or a parent and chooses the appropriate message to run based on the instanceof result, which it in turn runs using the printMessage method of the application class.
     * @return Whether or not the program ran properly with valid input. 
     */
    @Override
    public boolean runOverride() {
        //will track if username search was sucessful or not
        if (app.isMatching(getCurrentInput())) {
            for (int i = 0; i < app.getUserArray().length; i++) {
                for (int e = 0; e < app.getUserArray()[i].size(); e++) {
                    String currentName = ((User) app.getUserArray()[i].get(e)).getUserName();
                    if (currentName.equals(getCurrentInput())) {
                        app.setCurrentUser((User) app.getUserArray()[i].get(e));
                    } 
                }
            }
            if (app.getCurrentUser() instanceof Student) {
                try {
                    app.printMessage(15, false);
                } catch (IOException ex) {
                    Logger.getLogger(MessageLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                app.getMessageHistory().clear();
            } else if (app.getCurrentUser() instanceof Teacher) {
                try {
                    app.printMessage(16, false);
                } catch (IOException ex) {
                    Logger.getLogger(MessageLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                app.getMessageHistory().clear();
            } else if (app.getCurrentUser() instanceof Parent) {
                try {
                    app.printMessage(17, false);
                } catch (IOException ex) {
                    Logger.getLogger(MessageLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                app.getMessageHistory().clear();
            } else {
                System.out.println("Error: unknown user.");
            }
            return true;
        } else {
            return false;
        }
    }
}
