/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.usermenus.parentmenu;

import app.MyLabsMinusApp;
import messages.Message;

/**
 * Class MessagePrintReport is a subclass of Message that implements the display of student information to the parent.
 * @author Stephen Hybeger
 */
public class MessagePrintReport extends Message{
    /**
     * This constructor enables the setting of initial values for fields, messsage, needs, and the app.
     * @param app //A link to the MyLabsMinusApp
     */
    public MessagePrintReport(MyLabsMinusApp app) {
        super("", "Opps. Something went wrong. Please reach out to your admin for assistance.", app);
    }
    /**
     * An override of the runOverride method of the Message class. This class prints out a report of the parent's student(s)' scores.
     * @return Whether or not the program ran properly with valid input.
     */
    @Override
    public boolean runOverride() {
        /**Needs Storage Code**/
        return true;
    }
}
