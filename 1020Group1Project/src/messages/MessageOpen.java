package messages;
import app.MyLabsMinusApp;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Class MessageOpen is a subclass of Message that implements the opening menu
 * @author Stephen Hybeger
 */
//Opening menu component
public class MessageOpen extends Message {
    /**
     * A constructor that initializes the pre-defined messages and binds the message to the application class.
     * @param app The MyLabsMinusApp object that the message dialogue is to be bound to.
     */
    public MessageOpen(MyLabsMinusApp app) {
        //Creates predefined message
        super("Welcome to MyLabsMinus\nFrom here you can either login or create a new account.\nPlease indicate your choice by entering the corresponding number:\n1. Login\n2. New User", "Please enter either a 1 or 2, indicating your choice.", app);
    }
    //has user pick between two options. Must be number. String triggers validation
    /**
     * An override of the runOverride method of the Message class. Gets the user's input, which can either be a 1 (taking the user to the login message) or 2 (taking the user to the wizard or new user message) using the printMessage method of the MyLabsPlus application.
     * @return Whether or not the program ran properly with valid input. 
     */
    @Override
    public boolean runOverride() throws NumberFormatException{
        String cPut = getCurrentInput();
        if (!cPut.isEmpty()) {
            try {
                switch (Integer.parseInt(cPut)) {
                    //Branches to login 
                    case 1: {
                    try {
                        app.printMessage(1, true);
                    } catch (IOException ex) {
                        Logger.getLogger(MessageOpen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    return true;
                    //Branches to account creation
                    case 2: {
                    try {
                        app.printMessage(2, true);
                    } catch (IOException ex) {
                        Logger.getLogger(MessageOpen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    return true;
                    default: return false;
                }
            } catch (NumberFormatException ex) {
                return false;
            }
        } else {
            return false;
        }
    }
}
