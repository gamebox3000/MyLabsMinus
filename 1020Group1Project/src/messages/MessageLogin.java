package messages;


import app.*;
import users.User;

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
        boolean matched = false;
        for (int i = app.getUserArray().length; i > 0; i--) {
            for(int e = app.getUserArray()[i].size(); e > 0; e--) {
                if (getCurrentInput().equals(((User)app.getUserArray()[i].get(e)).getUserName())) {
                    matched = true;
                }
            }
        }
        if (matched) {
            return true;
        } else {
            return false;
        }
    }
}
