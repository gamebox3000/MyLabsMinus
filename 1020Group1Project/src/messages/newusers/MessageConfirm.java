/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.newusers;
import app.*;
import messages.Message;
/**
 *
 * @author StephenAHyberger
 */
//component that checks with the user at the end to make sure everything was entered correctly.
public class MessageConfirm extends Message{
    public MessageConfirm(MyLabsMinusApp app) {
        //predefined message
        super("Are the following details correct?", "Please enter a \'yes\' or a \'no\'.", app);
    }
    @Override
    public boolean runOverride() {
        //If yes, returns to openning message
        if (getCurrentInput().equals("Yes") || getCurrentInput().equals("yes")) {
            setCurrentInput("true");
            return true;
        //If no, returns to start of account creation chain
        } else if (getCurrentInput().equals("No") || getCurrentInput().equals("no")) {
            setCurrentInput("false");
            return true;
        } else {
            return false;
        }
    }
}
