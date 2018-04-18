/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages.usermenus.studentmenu;

import app.MyLabsMinusApp;
import messages.Message;

/**
 *
 * @author StephenAHyberger
 */
public class MessageQuiz extends Message{
    public MessageQuiz(MyLabsMinusApp app) {
        super("", "", app);
    }
    @Override
    public boolean runOverride() {
        return true;
    }
} 
