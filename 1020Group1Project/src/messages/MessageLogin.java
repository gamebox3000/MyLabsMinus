package messages;


import app.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import users.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sahyberger
 */
/**Needs Aaron**/
//Quiz/main menu branch of program not implemented yet.
//Login component. Prompts user for username
public class MessageLogin extends Message{
    //Creates predefined message.
    public MessageLogin(MyLabsMinusApp app) {
        super("Please enter your username to login", "Username not found.", app);
    }
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
