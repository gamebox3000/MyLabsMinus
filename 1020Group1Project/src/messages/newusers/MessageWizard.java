package messages.newusers;


import app.MyLabsMinusApp;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import messages.Message;
import messages.Message;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sahyberger
 */
//Account creation menu that has user specify what kind of new user.
public class MessageWizard extends Message {
    public MessageWizard(MyLabsMinusApp app) {
        //predefined message
        super("Are you a:\n1. Student\n2. Teacher\n3. Parent", "Please enter a 1, 2, or 3, indicating your choice.", app);
    }
    @Override
    //Only integers. Strings triger validation.
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
