package messages.usermenus.parentmenu;

import app.MyLabsMinusApp;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.Message;

/**
 *
 * @author sahyberger
 */
public class MessageParentMenu extends Message{
    public MessageParentMenu(MyLabsMinusApp app) {
        super("Please select one of the options below:\n1. Print Report.\n2. Log out.", "Please indicate your choice using either 1 or 2.", app);
    }
    @Override
    public boolean runOverride() {
        switch (getCurrentInput()) {
            case "1":
                try {
                    app.printMessage(20, true);
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
