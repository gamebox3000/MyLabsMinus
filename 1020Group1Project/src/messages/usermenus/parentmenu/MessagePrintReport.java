/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.usermenus.parentmenu;

import app.MyLabsMinusApp;
import messages.Message;

/**
 *
 * @author sahyberger
 */
public class MessagePrintReport extends Message{
    public MessagePrintReport(MyLabsMinusApp app) {
        super("", "Opps. Something went wrong. Please reach out to your admin for assistance.", app);
    }
    @Override
    public boolean runOverride() {
        /**Needs Storage Code**/
        return true;
    }
}
