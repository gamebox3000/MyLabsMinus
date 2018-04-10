package messages;


import app.MyLabsMinusApp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sahyberger
 */
//Opening menu component
public class MessageOpen extends Message {
    public MessageOpen(MyLabsMinusApp app) {
        //Creates predefined message
        super("Welcome to MyLabsMinus\nFrom here you can either login or create a new account.\nPlease indicate your choice by entering the corresponding number:\n1. Login\n2. New User", "Please enter either a 1 or 2, indicating your choice.", app);
    }
    //has user pick between two options. Must be number. String triggers validation
    @Override
    public boolean runOverride() throws NumberFormatException{
        String cPut = getCurrentInput();
        if (!cPut.isEmpty()) {
            try {
                switch (Integer.parseInt(cPut)) {
                    //Branches to login 
                    case 1: app.printMessage(1, true);
                    return true;
                    //Branches to account creation
                    case 2: app.printMessage(2, true);
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
