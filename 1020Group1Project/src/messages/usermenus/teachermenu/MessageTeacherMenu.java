/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.usermenus.teachermenu;

import app.MyLabsMinusApp;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.Message;
import messages.usermenus.parentmenu.MessageParentMenu;

/**
 *
 * @author sahyberger
 */
public class MessageTeacherMenu extends Message{
    public MessageTeacherMenu(MyLabsMinusApp app) {
        super("Please select one of the options below:\n1. Search Students\n2. Log out", "Please indicate your choice using either 1 or 2.", app);
    }
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
