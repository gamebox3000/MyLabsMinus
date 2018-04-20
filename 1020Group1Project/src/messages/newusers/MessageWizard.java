package messages.newusers;
import app.MyLabsMinusApp;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.Message;
import messages.Message;
/**
 * Class MessageWizard is a subclass of Message that implements the prompts the user for the type of account he/she wants to create.
 * @author Stephen Hybeger
 */
//Account creation menu that has user specify what kind of new user.
public class MessageWizard extends Message {
    /**
     * This constructor enables the setting of initial values for fields, messsage, needs, and the app.
     * @param app //A link to the MyLabsMinusApp
     */
    public MessageWizard(MyLabsMinusApp app) {
        //predefined message
        super("Are you a:\n1. Student\n2. Teacher\n3. Parent", "Please enter a 1, 2, or 3, indicating your choice.", app);
    }
    /**
     * An override of the runOverride method of the Message class. The user may input 1, 2, or 3. 1 will send the user to the account creation process for students, 2 the account creation for teachers, and 3 for parents.
     * @return Whether or not the program ran properly with valid input. 
     */
    @Override
    public boolean runOverride() throws NumberFormatException {
        try {
            switch(Integer.parseInt(getCurrentInput())) {
                case 1: {
                try {
                    //starts new student message chain
                    app.createNewStudent();
                } catch (IOException ex) {
                    Logger.getLogger(MessageWizard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    return true;
                case 2: {
                try {
                    //starts new teacher message chain
                    app.createNewTeacher();
                } catch (IOException ex) {
                    Logger.getLogger(MessageWizard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    return true;
                case 3: {
                try {
                    //starts new parent message chain
                    app.createNewParent();
                } catch (IOException ex) {
                    Logger.getLogger(MessageWizard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    return true;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
        return false;
    }
}
