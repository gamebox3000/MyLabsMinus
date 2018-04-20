package messages.usermenus.teachermenu;
import app.MyLabsMinusApp;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.Message;
import messages.usermenus.parentmenu.MessageParentMenu;
/**
 * Class MessageTeacherMenu is a subclass of Message that implements the teacher menu that gives access to the search/sort function for his/her students and the option to log out. 
 * @author Stephen Hybeger
 */
public class MessageTeacherMenu extends Message{
    /**
     * This constructor enables the setting of initial values for fields, messsage, needs, and the app.
     * @param app //A link to the MyLabsMinusApp
     */
    public MessageTeacherMenu(MyLabsMinusApp app) {
        super("Please select one of the options below:\n1. Search Students\n2. Log out", "Please indicate your choice using either 1 or 2.", app);
    }
    /**
     * An override of the runOverride method of the Message class. This implements the access to the search and sort features of the teacher user menu (selected with 1) and the log out option which returns the user to the openning menu (selected with 2).
     * @return Whether or not the program ran properly with valid input.
     */
    @Override
    public boolean runOverride() {
        switch (getCurrentInput()) {
            case "1":
                try {
                    app.printMessage(19, true);
                } catch (IOException ex) {
                    Logger.getLogger(MessageParentMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                return true;
            case "2":
                System.out.println("\nThank you, " + app.getCurrentUser().getUserName() + ", for using MyLabsMinus. Please come again.\n");
                try {
                    app.setCurrentUser(MyLabsMinusApp.NULLUSER);
                    app.printMessage(0, false);
                    app.getMessageHistory().clear();
                } catch (IOException ex) {
                    Logger.getLogger(MessageParentMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                return true;
            default:
                return false;
        }
    }
}
